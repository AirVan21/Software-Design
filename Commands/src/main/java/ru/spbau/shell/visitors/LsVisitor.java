package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;
import ru.spbau.shell.utility.FileManager;

import java.io.File;

/**
 * Created by Эдгар on 29.10.2016.
 * A LsVisitor is a visitor for ls command
 */
public class LsVisitor extends CommandVisitor<ShellGrammarParser.LsContext> {
    public LsVisitor() {
        super(1, ManualItem.LS_MAN);
    }

    @Override
    boolean execute(Environment environment, Storage storage) {
        if (storage.getSize() > argumentAmount) {
            return false;
        }

        String input = "";
        if (storage.getSize() == 1) {
            input = storage.popArgument();
        }

        File file;
        if (input.isEmpty()) {
            file = new File(FileManager.getPath());
        } else {
            file = new File(input);
        }

        String[] listFiles = new File(file.getAbsolutePath()).list();
        StringBuilder  result = new StringBuilder();
        //TODO: NPE?
        if (listFiles != null) {
            for (String filename : listFiles) {
                result.append(filename).append('\n');
            }
        } else {
            result.append(input).append(" is not a directory");
        }
        storage.pushArgument(result.toString());
        return true;
    }
}
