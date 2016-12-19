package ru.spbau.design.messenger.model.interfaces;

import java.util.logging.Level;

/**
 * Interface for logger
 */
public interface ILogger {
    /**
     * Logs message with selected warning level
     * @param level warning level
     * @param input message text
     */
    void log(Level level, String input);
}
