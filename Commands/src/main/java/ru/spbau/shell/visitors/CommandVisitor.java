package ru.spbau.shell.visitors;

import org.antlr.v4.runtime.ParserRuleContext;
import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
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

    /**
     * Executes command logic
     * @param environment - set of environment variables
     * @param storage - result taker/saver object
     * @return true  - if command execution was successful
     *         false - otherwise
     */
    abstract boolean execute(Environment environment, Storage storage);

    /**
     * Visits subcommands (deeper in tree hierarchy)
     * @param visitor - visiting class
     * @param context - context, truly
     */
    public void visit(ShellGrammarVisitor visitor, Context context) {
        visitor.visitChildren(context);
    }

    @Override
    public String getHelp() {
        return description.toString();
    }
}
