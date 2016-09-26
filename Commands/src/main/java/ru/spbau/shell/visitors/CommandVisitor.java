package ru.spbau.shell.visitors;

import org.antlr.v4.runtime.ParserRuleContext;
import ru.spbau.shell.grammar.antlr4.ShellGrammarVisitor;

/**
 * Recursive visitor class implements recursive visiting logic for supported commands
 */
abstract public class CommandVisitor<Context extends ParserRuleContext> {
    public static int argumentAmount;

    public CommandVisitor(int numberOfArguments) {
        argumentAmount = numberOfArguments;
    }

    public void visit(ShellGrammarVisitor visitor, Context context) {
        visitor.visitChildren(context);
    }
}
