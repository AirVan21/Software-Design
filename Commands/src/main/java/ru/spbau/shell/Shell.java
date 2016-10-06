package ru.spbau.shell;

import org.antlr.v4.runtime.tree.ParseTree;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.exceptions.WrongArgumentsException;
import ru.spbau.shell.parser.Parser;
import ru.spbau.shell.utility.GlobalLogger;
import ru.spbau.shell.visitors.ShellVisitor;

import java.security.InvalidParameterException;
import java.util.Optional;
import java.util.Scanner;

/**
 * Shell Singleton (not multi-thread singleton) class
 *
 * Gets input form System.in, processes commands, returns result to output.
 */
public class Shell {
    /**
     * Handles user input
     */
    private final static Scanner READER = new Scanner(System.in);
    /**
     * Singleton instance carrier
     */
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
        for (String input = READER.nextLine(); isValidInput(input); input = READER.nextLine()) {
            Optional<String> result = handleInputLine(input);
            if (result.isPresent()) {
                System.out.println(result.get());
            }
        }
    }

    /**
     * Executes one command (method is public for convenient testing)
     * @param input - source line with commands
     * @return commands output
     */
    public Optional<String> handleInputLine(String input) {
        final Optional<ParseTree> tree = Parser.parse(input);
        final Storage storage = new Storage();
        final ShellVisitor visitor = new ShellVisitor(storage);
        processTree(tree, visitor);

        return storage.isEmpty() ? Optional.empty() : Optional.of(storage.popArgument());
    }

    private Shell() {}

    /**
     * Checks if string is acceptable for processing
     * @param source input string
     * @return true  - input is valid
     *         false - input is valid
     */
    private static boolean isValidInput(String source) {
        if (source == null) {
            return false;
        }
        source = source.trim();

        return !(source.isEmpty());
    }

    /**
     * Executes ANTLR4 Parse Tree visiting (including command execution)
     * @param tree - tree built for input string
     * @param visitor - class with logic for search
     * @return true  - correct visiting
     *         false - visiting with errors
     */
    private static boolean processTree(Optional<ParseTree> tree, ShellVisitor visitor) {
        boolean isSuccessful = true;
        if (tree.isPresent()) {
            try {
                visitor.visit(tree.get());
            } catch (WrongArgumentsException exc) {
                GlobalLogger.log("Command couldn't be performed!");
                isSuccessful = false;
            }
        }

        return isSuccessful;
    }
}
