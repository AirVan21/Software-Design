package ru.spbau.shell.utility;

import ru.spbau.shell.environment.Environment;

import java.util.Optional;

/**
 * QuotingTransformer class provides functionality for string handling using
 * - Weak Quoting rules
 * - Full Quoting rules
 */
public class QuotingTransformer {
    /**
     * CONSTs which are used in manual string parsing
     */
    private static final String VARIABLE_SIGN = "$";
    private static final String SPACE_SIGN = " ";
    private static final String TWO_QUOTES = "''";

    /**
     * Transforms input string by removing bounding quotes and
     * replacing environmental variables by their values
     * @param source - input string
     * @param environment - storage for environmental variables
     * @return processed input string
     */
    public static Optional<String> transformWeakQuoting(String source, Environment environment) {
        Optional<String> content = removeFirstLastSymbol(source);
        if (!content.isPresent()) {
            return Optional.empty();
        }

        StringBuilder sb = new StringBuilder();
        source = source.trim();

        if (!source.contains(VARIABLE_SIGN)) {
            sb.append(source);

            return Optional.of(sb.toString());
        }

        do {
            // adds start text
            int indexSign = source.indexOf(VARIABLE_SIGN);
            sb.append(source.substring(0, indexSign));
            source = source.substring(indexSign + 1);

            // translates variable
            indexSign = getDelimiterIndex(source);
            String pattern = source.substring(0, indexSign);
            Optional<String> value = environment.getVariable(pattern);
            if (!value.isPresent()) {
                break;
            }
            sb.append(value.get());
            source = source.substring(indexSign);
        } while (source.contains(VARIABLE_SIGN));

        return Optional.of(sb.toString());
    }

    /**
     * Transforms input string removing bounding quotes
     * @param source - input string
     * @return input string without bounding quotes
     */
    public static Optional<String> transformFullQuoting(String source) {
        return removeFirstLastSymbol(source);
    }

    /**
     * Gets index of symbol is a delimiter for environmental variable
     * @param source - input string
     * @return index of a delimiter symbol
     */
    private static int getDelimiterIndex(String source) {
        boolean hasSign = source.contains(VARIABLE_SIGN);
        boolean hasSpace = source.contains(SPACE_SIGN);

        if (!(hasSign || hasSpace)) {
            return source.length();
        }

        if (hasSign && hasSpace) {
            return Math.min(source.indexOf(SPACE_SIGN), source.indexOf(VARIABLE_SIGN));
        }

        if (hasSign) {
            return source.indexOf(VARIABLE_SIGN);
        }

        // hasSpace case
        return source.indexOf(SPACE_SIGN);
    }

    /**
     * Removes first and last symbols
     * @param source input string
     * @return input string without first and last symbols
     */
    private static Optional<String> removeFirstLastSymbol(String source) {
        if (source.length() < TWO_QUOTES.length()) {
            return Optional.empty();
        }
        source = source.substring(1, source.length() - 1);

        return Optional.of(source);
    }
}
