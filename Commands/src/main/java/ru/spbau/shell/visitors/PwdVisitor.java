package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;

/**
 * PwdVisitor class is a visitor for Pwd command
 */
public class PwdVisitor extends CommandVisitor<ShellGrammarParser.PwdContext> {
    private final static String FOLDER_PROPERTY = "user.dir";

    public PwdVisitor() {
        super(0, ManualItem.PWD_MAN);
    }

    @Override
    public boolean execute(Environment environment, Storage storage) {
        if (storage.getSize() != argumentAmount) {
            return false;
        }
        storage.pushArgument(System.getProperty(FOLDER_PROPERTY));

        return true;
    }
}
