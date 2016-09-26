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
 * Created by airvan21 on 25.09.16.
 */
public class Parser {
    public static Optional<ParseTree> parse(String string) {
        Optional<ANTLRInputStream> is = getInputStream(string);
        if (!is.isPresent()) {
            return Optional.empty();
        }

        ShellGrammarParser parser = getParser(is.get());

        return getParseTree(parser);
    }

    private static Optional<ANTLRInputStream> getInputStream(String string) {
        InputStream is = new ByteArrayInputStream(string.getBytes());
        ANTLRInputStream stream;
        try {
            stream = new ANTLRInputStream(is);
        } catch (IOException exc) {
            GlobalLogger.log(exc.getMessage());
            return Optional.empty();
        }

        return Optional.of(stream);
    }

    private static ShellGrammarParser getParser(ANTLRInputStream is) {
        ShellGrammarLexer lexer = new ShellGrammarLexer(is);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        return new ShellGrammarParser(tokens);
    }

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
