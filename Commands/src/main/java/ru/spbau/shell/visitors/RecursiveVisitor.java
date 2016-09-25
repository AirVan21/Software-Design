package ru.spbau.shell.visitors;

import org.antlr.v4.runtime.ParserRuleContext;
import ru.spbau.shell.grammar.antlr4.ShellGrammarVisitor;

import java.util.List;
import java.util.Optional;

/**
 * Created by airvan21 on 25.09.16.
 */
abstract public class RecursiveVisitor<Context extends ParserRuleContext> {
    public void visit(ShellGrammarVisitor visitor, Context context) {
        visitor.visitChildren(context);
    }

    abstract public void process(Optional<List<String>> args);
}
