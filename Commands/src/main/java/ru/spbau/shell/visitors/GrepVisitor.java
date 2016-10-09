package ru.spbau.shell.visitors;

import org.apache.commons.cli.*;
import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;
import ru.spbau.shell.utility.FileManager;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Created by airvan21 on 09.10.16.
 */
public class GrepVisitor extends CommandVisitor<ShellGrammarParser.GrepContext> {
    /**
     * Parses CLI arguments
     */
    private static final CommandLineParser optionParser = new DefaultParser();
    private static final Options options = getOptions();
    private static final Optional<Pattern> patter = Optional.empty();
    private static final int MAX_NUM_OF_ARGS = 6;

    public GrepVisitor() {
        // Pattern && File should be
        super(2, ManualItem.GREP_MAN);
    }

    @Override
    boolean execute(Environment environment, Storage storage) {
        if (storage.getSize() < argumentAmount || storage.getSize() > MAX_NUM_OF_ARGS) {
            return false;
        }
        // grep [OPTIONS] PATTERN [FILE]
        String[] arguments = storage.getRawContent();
        String searchFileName = arguments[arguments.length - 1];

        // options parsing
        CommandLine line;
        try {
            line = optionParser.parse(options, arguments);
        } catch (ParseException e) {
            return false;
        }

        // [FILE] or Text
        Optional<File> searchFile = FileManager.getFile(searchFileName);
        String searchSource = searchFileName;
        if (searchFile.isPresent()) {
            searchSource = FileManager.readFile(searchFile.get()).get();
        }
        List<String> searchLines = FileManager.getLinesFromText(searchSource);

        processInput(line, searchLines, storage);

        return false;
    }

    /**
     * Gets grep CLI options
     * @return options for grep command
     */
    private static Options getOptions() {
        Options options = new Options();
        options.addOption("i", "ignore-case", false, "Ignore case distinctions");
        options.addOption("w", "word-regexp", false, "Select only lines containing whole word matches");
        options.addOption("A", "after-context", true, "Print NUM lines of trailing context after matching lines");

        return options;
    }

    private void processInput(CommandLine line, List<String> source, Storage storage) {

    }
}
