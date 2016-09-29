package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.interfaces.IExecutable;
import ru.spbau.shell.interfaces.IHelper;

/**
 * AssignmentVisitor class is a visitor class for Assignment operation
 */
public class AssignmentVisitor extends CommandVisitor<ShellGrammarParser.AssignmentContext> implements IExecutable, IHelper {

    public AssignmentVisitor() {
        super(2);
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

        String key = storage.popArgument();
        String value = storage.popArgument();
        environment.setVariable(key, value);

        return true;
    }
}
