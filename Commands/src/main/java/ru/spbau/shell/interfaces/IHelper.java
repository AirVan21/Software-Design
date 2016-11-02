package ru.spbau.shell.interfaces;

/**
 * Interface for entities which have "How To" information in their logic
 */
public interface IHelper {
    /**
     * Returns help information about object
     * @return formatted hint
     */
    String getHelp();
}
