package ru.spbau.shell.environment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for storing tree arguments
 */
public class Storage {
    /**
     * Container for storing strings
     */
    private final Queue<String> storage = new LinkedList<>();

    public Storage() {}

    /**
     * Gets last argument
     * @return last argument
     */
    public String popArgument() {
        return storage.remove();
    }

    /**
     * Adds argument to storage
     * @param argument
     */
    public void pushArgument(String argument) {
        storage.add(argument);
    }

    /**
     * Gets size
     * @return size
     */
    public int getSize() {
        return storage.size();
    }

    /**
     * Checks if storage is empty()
     * @return true  - if empty
     *         false - otherwise
     */
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    /**
     * Clears storage
     */
    public void clear() {
        storage.clear();
    }
}
