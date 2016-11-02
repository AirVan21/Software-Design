package ru.spbau.shell.visitors;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;
import ru.spbau.shell.grammar.antlr4.ShellGrammarParser;
import ru.spbau.shell.manual.ManualItem;
import ru.spbau.shell.utility.GlobalLogger;

/**
 * ProcessVisitor class is a visitor class for external process start
 */
public class ProcessVisitor extends CommandVisitor<ShellGrammarParser.ProcessContext> {

    public ProcessVisitor() {
        super(0, ManualItem.PROCESS_MAN);
    }

    @Override
    boolean execute(Environment environment, Storage storage) {
        GlobalLogger.log("Script execution logic in not implemented!");
        return true;
    }
}
