package ru.spbau.shell.visitors;

import org.apache.commons.cli.*;
import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;
import ru.spbau.shell.utility.FileManager;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * GrepVisitor class is a visitor class for grep operation
 */
public class GrepVisitor extends CommandVisitor<ShellGrammarParser.GrepContext> {
    /**
     * Parses CLI arguments
     */
    private static final CommandLineParser optionParser = new DefaultParser();
    /**
     * Predefined options for grep command
     */
    private static final Options options = getOptions();
    /**
     * Option constants
     */
    private static final String IGNORE_CASE = "i";
    private static final String WORD_MATCH = "w";
    private static final String AFTER_CONTEXT = "A";

    public GrepVisitor() {
        // Pattern && File should be presented
        super(2, ManualItem.GREP_MAN);
    }

    @Override
    boolean execute(Environment environment, Storage storage) {
        // grep [OPTIONS] PATTERN [FILE]
        String[] arguments = storage.getRawContent();
        storage.clear();

        CommandLine line;
        try {
            line = optionParser.parse(options, arguments);
        } catch (ParseException e) {
            return false;
        }
        if (line.getArgList().size() < argumentAmount) {
            return false;
        }

        // [FILE] or Text
        String searchFileName = line.getArgList().remove(line.getArgList().size() - 1);
        Optional<File> searchFile = FileManager.getFile(searchFileName);
        String searchSource = searchFileName;
        if (searchFile.isPresent()) {
            searchSource = FileManager.readFile(searchFile.get()).get();
        }
        final List<String> searchLines = FileManager.getLinesFromText(searchSource);
        final String result = processInput(line, searchLines);
        storage.pushArgument(result);

        return true;
    }

    /**
     * Gets grep CLI options
     * @return options for grep command
     */
    private static Options getOptions() {
        Options options = new Options();
        options.addOption(IGNORE_CASE, "ignore-case", false, "Ignore case distinctions");
        options.addOption(WORD_MATCH, "word-regexp", false, "Select only lines containing whole word matches");
        options.addOption(AFTER_CONTEXT, "after-context", true, "Print NUM lines of trailing context after matching lines");

        return options;
    }

    private String processInput(CommandLine line, List<String> source) {
        String stringPattern = line.getArgList().remove(line.getArgList().size() - 1);
        boolean hasIgnoreCase = false;
        int trailingLinesNum = 1;

        if (line.hasOption(IGNORE_CASE)) {
            hasIgnoreCase = true;
            stringPattern = stringPattern.toLowerCase();
        }
        if (line.hasOption(WORD_MATCH)) {
            final String boundary = "\\b";
            stringPattern =  boundary + stringPattern + boundary;
        }
        if (line.hasOption(AFTER_CONTEXT)) {
            Properties properties = line.getOptionProperties(AFTER_CONTEXT);
            // Gets argument of "A" option
            if (properties.keys().hasMoreElements()) {
                trailingLinesNum = Integer.parseInt(properties.keys().nextElement().toString());
            }
        }

        final StringBuilder sb = new StringBuilder();
        final Pattern pattern = Pattern.compile(stringPattern);
        for (int i = 0; i < source.size(); i++) {
            final String matchStr = hasIgnoreCase
                            ? source.get(i).toLowerCase()
                            : source.get(i);
            final Matcher matcher = pattern.matcher(matchStr);

            if (matcher.find()) {
                // Adds trailing lines
                for (int j = i; j < trailingLinesNum + i && j < source.size(); j++) {
                    sb.append(source.get(j) + "\n");
                }
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
