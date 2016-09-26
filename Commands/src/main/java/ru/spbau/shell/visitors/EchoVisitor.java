package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.utility.IExecutable;
import ru.spbau.shell.utility.IHelper;

/**
 * EchoVisitor class is a visitor class for Echo operation
 */
public class EchoVisitor extends CommandVisitor<ShellGrammarParser.EchoContext> implements IExecutable, IHelper {

    public EchoVisitor() {
        super(1);
    }

    @Override
    public String getHelp() {
        return "";
    }

    @Override
    public boolean execute(Environment environment, Storage storage) {
        return storage.getSize() == argumentAmount;
    }
}
