package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.utility.IExecutable;
import ru.spbau.shell.utility.IHelper;

/**
 * CatVisitor class is a visitor for Cat command
 */
public class CatVisitor extends CommandVisitor<ShellGrammarParser.CatContext> implements IExecutable, IHelper {
    public CatVisitor() {
        super(1);
    }

    @Override
    public String getHelp() {
        return "";
    }

    @Override
    public boolean execute(Environment environment, Storage storage) {
        if (storage.getSize() != argumentAmount) {
            return false;
        }

        return true;
    }
}
