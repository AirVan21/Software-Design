package ru.spbau.shell.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Parser;

/**
 * ErrorHandler class declares strategy for Error Handling
 */
public class ErrorHandler extends DefaultErrorStrategy {
    /**
     * Forbids error recovery
     * @param e - exception which happened
     * @throws InputMismatchException
     */
    @Override
    public void recover(Parser recognizer, RecognitionException e) throws InputMismatchException {
        throw new InputMismatchException(recognizer);
    }

    /**
     * Forbids error recovery
     * @return - exception propagation
     * @throws InputMismatchException
     */
    @Override
    public Token recoverInline(Parser recognizer) throws InputMismatchException {
        throw new InputMismatchException(recognizer);
    }
}
