package ru.spbau.shell.visitors;

import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;

/**
 * Created by airvan21 on 26.09.16.
 */
public class PipeVisitor extends CommandVisitor<ShellGrammarParser.PipeCmdContext> {
    public PipeVisitor() {
        super(0);
    }
}
