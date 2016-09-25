package ru.spbau.shell.environment;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for storing environment variables
 */
public class Environment {
    public static final Map<String, String> table = new HashMap<>();

    public static void setVariable(String key, String value) {
        table.putIfAbsent(key, value);
    }

    /**
     * TODO: Check for null case
     * @param key - search value
     * @return
     */
    public static String getVariable(String key) {
        return table.get(key);
    }
}
