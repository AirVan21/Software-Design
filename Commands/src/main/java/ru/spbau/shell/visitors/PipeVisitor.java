package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;

/**
 * Created by airvan21 on 26.09.16.
 */
public class PipeVisitor extends CommandVisitor<ShellGrammarParser.PipeCmdContext> {
    public PipeVisitor() {
        super(0, ManualItem.PIPE_MAN);
    }

    /**
     * Pipe visitor is not used in logic
     */
    @Override
    boolean execute(Environment environment, Storage storage) {
        return true;
    }
}
