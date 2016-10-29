package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;

import java.io.File;

/**
 * Created by Эдгар on 29.10.2016.
 */
public class CdVisitor extends CommandVisitor<ShellGrammarParser.CdContext> {
    private final static String DIRECTORY_PROPERTY = "user.dir";

    public CdVisitor() {
        super(1, ManualItem.CD_MAN);
    }

    @Override
    boolean execute(Environment environment, Storage storage) {
        if (storage.getSize() != argumentAmount) {
            return false;
        }

        String targetDirectoryName = storage.popArgument();
        File targetDirectory = new File(targetDirectoryName);
        if (!targetDirectory.exists() || !targetDirectory.isDirectory()) {
            return false;
        }

        System.setProperty(DIRECTORY_PROPERTY, targetDirectory.getAbsolutePath());

        return true;
    }
}
