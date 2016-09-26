package ru.spbau.shell.utility;

import java.util.logging.Logger;

/**
 * GlobalLogger is a class for convenient wrong behaviour logging
 */
public class GlobalLogger {
    private static Logger logger = Logger.getLogger(GlobalLogger.class.getName());

    /**
     *
     * @param info
     */
    public static void log(String info) {
        logger.info(info);
    }
}
