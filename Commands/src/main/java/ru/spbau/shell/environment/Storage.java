package ru.spbau.shell.environment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for storing tree arguments
 */
public class Storage {
    private final Queue<String> storage = new LinkedList<>();

    public Storage() {}

    public String popArgument() {
        return storage.remove();
    }

    public void pushArgument(String argument) {
        storage.add(argument);
    }

    public int getSize() {
        return storage.size();
    }

    public boolean isEmpty() {
        return storage.size() == 0;
    }
}
