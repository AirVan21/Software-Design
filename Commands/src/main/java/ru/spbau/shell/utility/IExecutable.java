package ru.spbau.shell.utility;

import ru.spbau.shell.environment.Environment;
import ru.spbau.shell.environment.Storage;

/**
 * Interface for entities which can be executed
 */
public interface IExecutable {
    /**
     *
     * @param environment
     * @param storage
     * @return
     */
    boolean execute(Environment environment, Storage storage);
}
