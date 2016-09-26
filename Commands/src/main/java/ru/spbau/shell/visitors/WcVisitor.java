package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.utility.IExecutable;
import ru.spbau.shell.utility.IHelper;

/**
 * WcVisitor class is a visitor for Wc command
 */
public class WcVisitor extends CommandVisitor<ShellGrammarParser.WcContext> implements IExecutable, IHelper {

    public WcVisitor() {
        super(1);
    }

    @Override
    public String getHelp() {
        return "";
    }

    @Override
    public boolean execute(Environment environment, Storage storage) {
        return false;
    }
}
