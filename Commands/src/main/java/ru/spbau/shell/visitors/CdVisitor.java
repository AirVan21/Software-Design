package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Эдгар on 29.10.2016.
 * CdVisitor class is a visitor for cd command
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
        try {
            File targetDirectory = new File(targetDirectoryName).getCanonicalFile();
            if (!targetDirectory.exists() || !targetDirectory.isDirectory()) {
                return false;
            }
            System.setProperty(DIRECTORY_PROPERTY, targetDirectory.getAbsolutePath());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
