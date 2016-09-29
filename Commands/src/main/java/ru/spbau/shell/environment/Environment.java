package ru.spbau.shell.environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Class for storing environment variables
 */
public class Environment {
    private  final Map<String, String> table = new HashMap<>();

    public Environment() {}

    public void setVariable(String key, String value) {
        table.putIfAbsent(key, value);
    }

    public Optional<String> getVariable(String key) {
        String result = table.get(key);

        return  result != null ? Optional.of(result) : Optional.empty();
    }
}
