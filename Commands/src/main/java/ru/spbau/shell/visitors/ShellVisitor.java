package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarBaseVisitor;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;

import java.util.Optional;

/**
 * ShellVisitor is a class where is written logic for Command-Tree-Nodes
 */
public class ShellVisitor extends ShellGrammarBaseVisitor {
    private static final Environment environment = new Environment();
    private static final Storage     storage     = new Storage();

    @Override
    public Object visitPipeCmd(ShellGrammarParser.PipeCmdContext ctx) {
        System.out.println("visitPipeCmd");
        PipeVisitor pipeVisitor = new PipeVisitor();
        pipeVisitor.visit(this, ctx);

        return pipeVisitor;
    }

    @Override
    public Object visitAssignment(ShellGrammarParser.AssignmentContext ctx) {
        System.out.println("visitAssignment");
        AssignmentVisitor assignmentVisitor = new AssignmentVisitor();
        assignmentVisitor.visit(this, ctx);

        return assignmentVisitor;
    }

    @Override
    public Object visitCat(ShellGrammarParser.CatContext ctx) {
        System.out.println("visitCat");
        CatVisitor catVisitor = new CatVisitor();
        catVisitor.visit(this, ctx);
        catVisitor.execute(environment, storage);

        return catVisitor;
    }

    @Override
    public Object visitWc(ShellGrammarParser.WcContext ctx) {
        System.out.println("visitWc");
        WcVisitor wcVisitor = new WcVisitor();
        wcVisitor.visit(this, ctx);
        wcVisitor.execute(environment, storage);

        return wcVisitor;
    }

    @Override
    public Object visitEcho(ShellGrammarParser.EchoContext ctx) {
        System.out.println("visitEcho");
        EchoVisitor echoVisitor = new EchoVisitor();
        echoVisitor.visit(this, ctx);
        echoVisitor.execute(environment, storage);

        return echoVisitor;
    }

    @Override
    public Object visitPwd(ShellGrammarParser.PwdContext ctx) {
        System.out.println("visitPwd");
        PwdVisitor pwdVisitor = new PwdVisitor();
        pwdVisitor.visit(this, ctx);
        pwdVisitor.execute(environment, storage);

        return pwdVisitor;
    }

    @Override
    public Object visitExit(ShellGrammarParser.ExitContext ctx) {
        System.out.println("visitExit");
        ExitVisitor exitVisitor = new ExitVisitor();
        exitVisitor.visit(this, ctx);
        exitVisitor.execute(environment, storage);

        return exitVisitor;
    }

    @Override
    public Object visitId(ShellGrammarParser.IdContext ctx) {
        System.out.println("visitId");
        if (ctx.getText() != null) {
            storage.pushArgument(ctx.getText());
        }

        return null;
    }

    @Override
    public Object visitVariable(ShellGrammarParser.VariableContext ctx) {
        System.out.println("visitVariable");
        if (ctx.getText() != null) {
            String value = ctx.getText();
            String variable = value.substring(value.indexOf("$") + 1);
            // TODO: some logic with translation
            storage.pushArgument(variable);
        }

        return null;

    }

    @Override
    public Object visitFullQuoting(ShellGrammarParser.FullQuotingContext ctx) {
        System.out.println("visitFullQuoting");
        if (ctx.getText() != null) {
            storage.pushArgument(ctx.getText());
        }

        return null;
    }

    @Override
    public Object visitWeakQuoting(ShellGrammarParser.WeakQuotingContext ctx) {
        System.out.println("visitWeakQuoting");
        if (ctx.getText() != null) {
            storage.pushArgument(ctx.getText());
        }

        return null;
    }

    public static Optional<String> getResult() {
         return storage.isEmpty() ? Optional.empty() : Optional.of(storage.popArgument());
    }
}


