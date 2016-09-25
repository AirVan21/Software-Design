package ru.spbau.shell.visitors;

import ru.spbau.shell.grammar.antlr4.ShellGrammarBaseVisitor;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.utility.ContextTransformer;


/**
 * Created by airvan21 on 25.09.16.
 */
public class ShellVisitor extends ShellGrammarBaseVisitor {

    @Override
    public Object visitPipeCmd(ShellGrammarParser.PipeCmdContext ctx) {
        System.out.println("visitPipeCmd");
        this.visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitAssignment(ShellGrammarParser.AssignmentContext ctx) {
        System.out.println("visitAssignment");
        return null;
    }

    @Override
    public Object visitCat(ShellGrammarParser.CatContext ctx) {
        System.out.println("visitCat");
        System.out.println(ContextTransformer.transformContext(ctx.literal()));
        return null;
    }

    @Override
    public Object visitWc(ShellGrammarParser.WcContext ctx) {
        System.out.println("visitWc");
        return null;
    }

    @Override
    public Object visitEcho(ShellGrammarParser.EchoContext ctx) {
        System.out.println("visitEcho");
        return null;
    }

    @Override
    public Object visitPwd(ShellGrammarParser.PwdContext ctx) {
        System.out.println("visitPwd");
        return null;
    }

    @Override
    public Object visitExit(ShellGrammarParser.ExitContext ctx) {
        System.out.println("visitExit");
        return null;
    }

    @Override
    public Object visitId(ShellGrammarParser.IdContext ctx) {
        System.out.println("visitId");
        return null;
    }

    @Override
    public Object visitVariable(ShellGrammarParser.VariableContext ctx) {
        System.out.println("visitVariable");
        return null;
    }

    @Override
    public Object visitLiteral(ShellGrammarParser.LiteralContext ctx) {
        System.out.println("visitLiteral");
        return null;
    }

    @Override
    public Object visitFullQuoting(ShellGrammarParser.FullQuotingContext ctx) {
        System.out.println("visitFullQuoting");
        return null;
    }

    @Override
    public Object visitWeakQuoting(ShellGrammarParser.WeakQuotingContext ctx) {
        System.out.println("visitWeakQuoting");
        return null;
    }
}


