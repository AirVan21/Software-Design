package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.interfaces.IExecutable;
import ru.spbau.shell.manual.ManualItem;

import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * WcVisitor class is a visitor for Wc command
 */
public class WcVisitor extends CommandVisitor<ShellGrammarParser.WcContext> implements IExecutable {

    public WcVisitor() {
        super(1, ManualItem.WC_MAN);
    }

    @Override
    public boolean execute(Environment environment, Storage storage) {
        if (storage.getSize() != argumentAmount) {
            return false;
        }

        String source = storage.popArgument();
        String result = String.valueOf(getAmountOfLines(source)) + " "
                + String.valueOf(getAmountOfWords(source)) + " " + getAmountOfBytes(source);
        storage.pushArgument(result);

        return false;
    }

    // TODO: replace this code with another
    /**
     * Gets amount of lines in the input string
     * @param input - source string
     * @return amount of lines
     */
    private int getAmountOfLines(String input) {
        LineNumberReader lnr = new LineNumberReader(new StringReader(input));

        return lnr.getLineNumber() + 1;
    }

    /**
     * Gets amount of words from the input string
     * @param input - source string
     * @return amount of words
     */
    private int getAmountOfWords(String input) {
        StringTokenizer st = new StringTokenizer(input);

        return st.countTokens();
    }

    /**
     * Gets amount of bytes from the input string
     * @param input - source string
     * @return amount of bytes
     */
    private int getAmountOfBytes(String input) {
        return input.getBytes().length;
    }
}
