package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.interfaces.IExecutable;
import ru.spbau.shell.interfaces.IHelper;
import ru.spbau.shell.manual.ManualItem;

/**
 * AssignmentVisitor class is a visitor class for Assignment operation
 */
public class AssignmentVisitor extends CommandVisitor<ShellGrammarParser.AssignmentContext> implements IExecutable, IHelper {
    public AssignmentVisitor() {
        super(2, ManualItem.ASSIGNMENT_MAN);
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
