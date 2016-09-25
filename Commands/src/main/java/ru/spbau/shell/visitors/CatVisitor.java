package ru.spbau.shell.visitors;


import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;

import java.util.List;
import java.util.Optional;

/**
 * Created by airvan21 on 25.09.16.
 */
public class CatVisitor extends RecursiveVisitor<ShellGrammarParser.CatContext> {

    @Override
    public void process(Optional<List<String>> args) {

    }
}
