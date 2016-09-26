package ru.spbau.shell.visitors;

import ru.spbau.shell.Shell;
import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.utility.IExecutable;
import ru.spbau.shell.utility.IHelper;

import java.io.ByteArrayInputStream;


/**
 * Created by airvan21 on 26.09.16.
 */
public class ExitVisitor extends CommandVisitor<ShellGrammarParser.ExitContext> implements IExecutable, IHelper {

    public ExitVisitor() {
        super(0);
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
