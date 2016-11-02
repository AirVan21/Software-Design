package ru.spbau.shell.visitors;

import org.antlr.v4.runtime.ParserRuleContext;
import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.exceptions.WrongArgumentsException;
import ru.spbau.shell.exceptions.WrongCommandException;
import ru.spbau.shell.grammar.antlr4.ShellGrammarBaseVisitor;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.utility.FileManager;
import ru.spbau.shell.utility.QuotingTransformer;

import java.security.InvalidParameterException;
import java.util.Optional;
import java.util.Set;


/**
 * ShellVisitor is a class where is written logic for Command-Tree-Nodes
 */
public class ShellVisitor extends ShellGrammarBaseVisitor {
    /**
     * Stores environment variables for a shell session
     */
    private static final Environment environment = new Environment();
    /**
     * Storage per command ling
     */
    private final Storage storage;

    public ShellVisitor(Storage storage) {
        super();
        this.storage = storage;
    }

    @Override
    public Object visitPipeCmd(ShellGrammarParser.PipeCmdContext ctx) {
        PipeVisitor pipeVisitor = new PipeVisitor();
        pipeVisitor.visit(this, ctx);

        return pipeVisitor;
    }

    @Override
    public Object visitAssignment(ShellGrammarParser.AssignmentContext ctx) throws InvalidParameterException {
        AssignmentVisitor assignmentVisitor = new AssignmentVisitor();
        visitCommand(assignmentVisitor, ctx);

        return assignmentVisitor;
    }

    @Override
    public Object visitCat(ShellGrammarParser.CatContext ctx) {
        CatVisitor catVisitor = new CatVisitor();
        visitCommand(catVisitor, ctx);

        return catVisitor;
    }

    @Override
    public Object visitWc(ShellGrammarParser.WcContext ctx) {
        WcVisitor wcVisitor = new WcVisitor();
        visitCommand(wcVisitor, ctx);

        return wcVisitor;
    }

    @Override
    public Object visitEcho(ShellGrammarParser.EchoContext ctx) {
        EchoVisitor echoVisitor = new EchoVisitor();
        visitCommand(echoVisitor, ctx);

        return echoVisitor;
    }


    @Override
    public Object visitPwd(ShellGrammarParser.PwdContext ctx) {
        PwdVisitor pwdVisitor = new PwdVisitor();
        visitCommand(pwdVisitor, ctx);

        return pwdVisitor;
    }

    @Override
    public Object visitExit(ShellGrammarParser.ExitContext ctx) {
        ExitVisitor exitVisitor = new ExitVisitor();
        visitCommand(exitVisitor, ctx);

        return exitVisitor;
    }

    @Override
    public Object visitProcess(ShellGrammarParser.ProcessContext ctx) throws WrongCommandException {
        final boolean nonRecursive = false;
        Set<String> fileNames = FileManager.listFiles(FileManager.getPath(), nonRecursive);
        if (ctx.getText() == null || !fileNames.contains(ctx.getText())) {
            throw new WrongCommandException("Wrong command!");
        }
        ProcessVisitor processVisitor = new ProcessVisitor();
        visitCommand(processVisitor, ctx);

        return null;
    }

    @Override
    public Object visitGrep(ShellGrammarParser.GrepContext ctx) {
        GrepVisitor grepVisitor = new GrepVisitor();
        visitCommand(grepVisitor, ctx);

        return grepVisitor;
    }

    @Override
    public Object visitId(ShellGrammarParser.IdContext ctx) {
        visitArgument(ctx.getText());

        return null;
    }

    @Override
    public Object visitVariable(ShellGrammarParser.VariableContext ctx) {
        if (ctx.getText() != null) {
            String variable = ctx.getText();
            String key = variable.substring(variable.indexOf("$") + 1);
            Optional<String> value = environment.getVariable(key);
            if (value.isPresent()) {
                storage.pushArgument(key);
            }
        }

        return null;
    }

    @Override
    public Object visitFullQuoting(ShellGrammarParser.FullQuotingContext ctx) {
        if (ctx.getText() != null) {
            Optional<String> result = QuotingTransformer.transformFullQuoting(ctx.getText());
            if (result.isPresent()) {
                storage.pushArgument(result.get());
            }
        }

        return null;
    }

    @Override
    public Object visitWeakQuoting(ShellGrammarParser.WeakQuotingContext ctx) {
        if (ctx.getText() != null) {
            Optional<String> result = QuotingTransformer.transformWeakQuoting(ctx.getText(), environment);
            if (result.isPresent()) {
                storage.pushArgument(result.get());
            }
        }

        return null;
    }

    /**
     * Adds all literal text to storage (called for arguments)
     * @param text - literal data
     */
    private void visitArgument(String text) {
        if (text != null) {
            storage.pushArgument(text);
        }
    }

    /**
     * Executes command handling scenario:
     *  1. visits subcommands
     *  2. executes command
     *  3. throws exception (if has invalid input arguments)
     *
     * @param visitor - visitors class for specific command
     * @param ctx - context for specific command
     */
    private <Context extends ParserRuleContext> void visitCommand(CommandVisitor<Context> visitor, Context ctx) throws WrongArgumentsException {
        visitor.visit(this, ctx);
        if (!visitor.execute(environment, storage)) {
            storage.clear();
            storage.pushArgument(visitor.getHelp());

            throw new WrongArgumentsException("Wrong arguments!");
        }
    }
}