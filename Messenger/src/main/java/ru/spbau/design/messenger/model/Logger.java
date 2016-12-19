package ru.spbau.design.messenger.model;

import ru.spbau.design.messenger.model.interfaces.ILogger;

import java.util.logging.Level;

/**
 * Simple logger for messenger
 */
public class Logger implements ILogger {
    private final java.util.logging.Logger logger;
    private final String path;

    /**
     * Constructor
     * @param path - name of a class where logger will be instantiated
     */
    public Logger(String path) {
        logger = java.util.logging.Logger.getLogger(path);
        this.path = path;
    }

    @Override
    public void log(Level level, String input) {
        // Using class name as a path prefix
        logger.log(level, path + ": " + input);
    }
}
