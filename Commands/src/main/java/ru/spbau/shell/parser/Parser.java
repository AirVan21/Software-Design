package ru.spbau.shell.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import ru.spbau.shell.grammar.antlr4.ShellGrammarLexer;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.utility.GlobalLogger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;


/**
 * Parser class is used to wrap ANTLR4 logic in convenient to use code
 */
public class Parser {
    /**
     * Parses source string
     * @param source - input string
     * @return ParseTree for input
     */
    public static Optional<ParseTree> parse(String source) {
        final Optional<ANTLRInputStream> is = getInputStream(source);
        if (!is.isPresent()) {
            return Optional.empty();
        }

        final ShellGrammarParser parser = getParser(is.get());

        return getParseTree(parser);
    }

    /**
     * Transforms string in ANTLRInputStream
     * @param source - input string
     * @return ANTLERInputStream for source string
     */
    private static Optional<ANTLRInputStream> getInputStream(String source) {
        final InputStream is = new ByteArrayInputStream(source.getBytes());
        ANTLRInputStream stream;
        try {
            stream = new ANTLRInputStream(is);
        } catch (IOException exc) {
            GlobalLogger.log(exc.getMessage());
            return Optional.empty();
        }

        return Optional.of(stream);
    }

    /**
     * Transforms ANTLRInputStream in ShellGrammarParser
     * @param is - ANTLRInputStream
     * @return shell grammar parser
     */
    private static ShellGrammarParser getParser(ANTLRInputStream is) {
        final ShellGrammarLexer lexer = new ShellGrammarLexer(is);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        return new ShellGrammarParser(tokens);
    }

    /**
     * Transforms ShellGrammarParser in ParseTree
     * @param parser - parser
     * @return ParseTree for input parser
     */
    private static Optional<ParseTree> getParseTree(ShellGrammarParser parser) {
        Optional<ParseTree> tree = Optional.empty();
        parser.removeErrorListeners();
        parser.setErrorHandler(new ErrorHandler());

        try {
            tree = Optional.of(parser.command());
        } catch (RecognitionException re) {
            GlobalLogger.log("Command not found!\n");
        }

        return tree;
    }
}
