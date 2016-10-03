package ru.spbau.shell.visitors;

import org.antlr.v4.runtime.ParserRuleContext;
import ru.spbau.shell.grammar.antlr4.ShellGrammarVisitor;
import ru.spbau.shell.interfaces.IHelper;
import ru.spbau.shell.manual.ManualItem;

/**
 * Recursive visitor class implements recursive visiting logic for supported commands
 */
abstract public class CommandVisitor<Context extends ParserRuleContext> implements IHelper {
    public static int argumentAmount;
    public final ManualItem description;

    public CommandVisitor(int numberOfArguments, ManualItem item) {
        argumentAmount = numberOfArguments;
        description = item;
    }

    public void visit(ShellGrammarVisitor visitor, Context context) {
        visitor.visitChildren(context);
    }

    @Override
    public String getHelp() {
        return description.toString();
    }
}
