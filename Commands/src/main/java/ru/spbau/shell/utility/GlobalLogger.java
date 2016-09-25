package ru.spbau.shell.utility;

import java.util.logging.Logger;


public class GlobalLogger {
    private static Logger logger = Logger.getLogger(GlobalLogger.class.getName());

    public static void log(String info) {
        logger.info(info);
    }
}
