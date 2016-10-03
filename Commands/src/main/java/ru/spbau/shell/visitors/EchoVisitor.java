package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.interfaces.IExecutable;
import ru.spbau.shell.manual.ManualItem;

/**
 * EchoVisitor class is a visitor class for Echo operation
 */
public class EchoVisitor extends CommandVisitor<ShellGrammarParser.EchoContext> implements IExecutable {
    public EchoVisitor() {
        super(1, ManualItem.ECHO_MAN);
    }

    @Override
    public boolean execute(Environment environment, Storage storage) {
        return storage.getSize() == argumentAmount;
    }
}
