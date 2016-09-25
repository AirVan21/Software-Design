package ru.spbau.shell.utility;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by airvan21 on 25.09.16.
 */
public class ContextTransformer {
    public static Optional<List<String>> transformContext(List<ShellGrammarParser.LiteralContext> contexts) {
        if (contexts == null) {
            return Optional.empty();
        }

        return Optional.of(contexts.stream()
                                   .map(ContextTransformer::transformContext)
                                   .collect(Collectors.toList()));

    }

    public static String transformContext(ShellGrammarParser.LiteralContext context) {
        return getFirstTerminalNode(context).getText();
    }

    /**
     * TODO: refactor
     * @param node
     * @return
     */
    private static TerminalNode getFirstTerminalNode(ParseTree node) {
        if (node == null || node instanceof TerminalNode) {
            return (TerminalNode) node;
        }

        return getFirstTerminalNode(node.getChild(0));
    }
}
