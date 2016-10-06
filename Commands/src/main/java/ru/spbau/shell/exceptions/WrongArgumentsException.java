package ru.spbau.shell.exceptions;

/**
 * WrongArgumentsException is an Exception which is thrown when invalid number of arguments is provided to command
 */
public class WrongArgumentsException extends RuntimeException {
    public WrongArgumentsException(String description) {
        super(description);
    }
}
