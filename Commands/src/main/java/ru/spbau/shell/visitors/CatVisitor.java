package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;
import ru.spbau.shell.utility.FileManager;

import java.io.File;
import java.util.Optional;

/**
 * CatVisitor class is a visitor for Cat command
 */
public class CatVisitor extends CommandVisitor<ShellGrammarParser.CatContext> {
    public CatVisitor() {
        super(1, ManualItem.CAT_MAN);
    }

    @Override
    public boolean execute(Environment environment, Storage storage) {
        if (storage.getSize() != argumentAmount) {
            return false;
        }

        String fileName = storage.popArgument();
        Optional<File> file = FileManager.getFile(fileName);
        if (!file.isPresent()) {
            return false;
        }

        Optional<String> text = FileManager.readFile(file.get());
        if (!text.isPresent()) {
            return false;
        }
        storage.pushArgument(text.get());

        return true;
    }
}
