package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;

import java.io.File;

/**
 * Created by Эдгар on 29.10.2016.
 */
public class LsVisitor extends CommandVisitor<ShellGrammarParser.LsContext> {
    private final static String DIRECTORY_PROPERTY = "user.dir";

    public LsVisitor() {
        super(0, ManualItem.LS_MAN);
    }

    @Override
    boolean execute(Environment environment, Storage storage) {
        if (storage.getSize() != argumentAmount) {
            return false;
        }

        String currentDirectoryName = System.getProperty(DIRECTORY_PROPERTY);
        String[] listFiles = new File(currentDirectoryName).list();
        StringBuilder  result = new StringBuilder();
        //TODO: NPE?
        for (String filename : listFiles) {
            result.append(filename).append('\n');
        }
        storage.pushArgument(result.toString());
        return true;
    }
}
