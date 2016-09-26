package ru.spbau.shell.interfaces;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;

/**
 * Interface for entities which can be executed
 */
public interface IExecutable {
    /**
     * Performs an execution logic
     * @param environment - environmental variables
     * @param storage - container for result/argument exchange
     * @return true  - if execution went OK
     *         false - if execution went NOK
     */
    boolean execute(Environment environment, Storage storage);
}
