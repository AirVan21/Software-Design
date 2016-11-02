package ru.spbau.shell.exceptions;

/**
 * WrongCommandException is an Exception which is thrown when unrecognized command was found
 */
public class WrongCommandException extends RuntimeException{
    public WrongCommandException(String description) {
        super(description);
    }
}
