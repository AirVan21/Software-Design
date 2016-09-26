package ru.spbau.shell.environment;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for storing environment variables
 */
public class Environment {
    private  final Map<String, String> table = new HashMap<>();
    private  boolean isPipe = false;

    public Environment() {}

    public void setVariable(String key, String value) {
        table.putIfAbsent(key, value);
    }

    public String getVariable(String key) {
        return table.get(key);
    }

    public void setPipe(boolean value) {
        isPipe = value;
    }

    public boolean getPipe(boolean value) {
        return isPipe;
    }
}
