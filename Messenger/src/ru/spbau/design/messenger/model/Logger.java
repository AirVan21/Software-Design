package ru.spbau.design.messenger.model;

import java.util.logging.Level;

public class Logger implements ILogger {
    private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    @Override
    public void log(Level level, String input) {
        logger.log(level, input);
    }
}
