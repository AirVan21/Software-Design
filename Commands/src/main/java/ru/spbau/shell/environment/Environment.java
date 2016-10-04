package ru.spbau.shell.environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Class for storing environment variables
 */
public class Environment {
    /**
     * Stores key to value mapping
     */
    private  final Map<String, String> table = new HashMap<>();

    public Environment() {}

    /**
     * Adds new variable to environment
     * @param key variable name
     * @param value variable value
     */
    public void setVariable(String key, String value) {
        table.put(key, value);
    }

    /**
     * Gets variable value on name
     * @param key variable name
     * @return variable value
     */
    public Optional<String> getVariable(String key) {
        String result = table.get(key);

        return  result != null ? Optional.of(result) : Optional.empty();
    }
}
