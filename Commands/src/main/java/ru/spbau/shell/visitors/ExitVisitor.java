package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;


/**
 * ExitVisitor class is a visitor class for Exit operation
 */
public class ExitVisitor extends CommandVisitor<ShellGrammarParser.ExitContext> {
    private static final int EXIT_VALUE = 0;

    public ExitVisitor() {
        super(0, ManualItem.EXIT_MAN);
    }

    @Override
    public boolean execute(Environment environment, Storage storage) {
        if (storage.getSize() != argumentAmount) {
            return false;
        }
        System.exit(EXIT_VALUE);

        return true;
    }
}
