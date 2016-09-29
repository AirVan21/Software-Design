package ru.spbau.shell;

import org.antlr.v4.runtime.tree.ParseTree;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.parser.Parser;
import ru.spbau.shell.visitors.ShellVisitor;

import java.util.Optional;
import java.util.Scanner;

/**
 * Shell Singleton (not multi-thread singleton) class
 *
 * Gets input form System.in, processes commands, returns result to output.
 */
public class Shell {
    private final static Scanner reader = new Scanner(System.in);
    private static Optional<Shell> instance = Optional.empty();

    /**
     * Returns singleton Shell class
     * @return shell instance
     */
    public static Shell getInstance() {
        if (!instance.isPresent()) {
            instance = Optional.of(new Shell());
        }

        return instance.get();
    }

    /**
     * Starts REPL
     */
    public void run() {
        for (String input = reader.nextLine(); isValidInput(input); input = reader.nextLine()) {
            final Optional<ParseTree> tree = Parser.parse(input);
            final Storage storage = new Storage();
            final ShellVisitor visitor = new ShellVisitor(storage);
            Optional<String> result = getResult(tree, visitor, storage);
        }
    }

    private Shell() {}

    private static boolean isValidInput(String input) {
        if (input == null) {
            return false;
        }
        input = input.trim();

        return !(input.isEmpty());
    }

    private static Optional<String> getResult(Optional<ParseTree> tree, ShellVisitor visitor, Storage storage) {
        if (tree.isPresent()) {
            visitor.visit(tree.get());
            if (storage.getSize() == 1) {
                System.out.println(storage.popArgument());
            }
        }
        return Optional.empty();
    }
}
