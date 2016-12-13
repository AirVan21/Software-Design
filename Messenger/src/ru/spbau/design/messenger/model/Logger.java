package ru.spbau.design.messenger.model;

import java.util.logging.Level;

public class Logger implements ILogger {
    private final java.util.logging.Logger logger;
    private final String path;

    public Logger(String path) {
        logger = java.util.logging.Logger.getLogger(path);
        this.path = path;
    }

    @Override
    public void log(Level level, String input) {
        logger.log(level, path + ": " + input);
    }
}
