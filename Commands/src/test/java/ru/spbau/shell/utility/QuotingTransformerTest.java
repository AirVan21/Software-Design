package ru.spbau.shell.utility;

import org.junit.After;
import org.junit.Test;
import ru.spbau.shell.environment.Environment;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Tests for environment variables substitution
 */
public class QuotingTransformerTest {
    public static final String SIMPLE_RESULT = "text-test";
    public static final String WQ_REPLACE_RESULT = "hello Buffon";
    public static final Environment ENVIRONMENT = new Environment();

    @After
    public void setUp() {
        ENVIRONMENT.setVariable("user", "Buffon");
    }

    @Test
    public void transformWeakQuotingSimple() throws Exception {
        final String WQ_SIMPLE = "\"text-test\"";
        Optional<String> result = QuotingTransformer.transformWeakQuoting(WQ_SIMPLE, ENVIRONMENT);

        assertTrue(result.isPresent());
        assertEquals(SIMPLE_RESULT, result.get());
    }

    @Test
    public void transformWeakQuoting() throws Exception {
        final String WQ_REPLACE = "\"hello $user\"";
        Optional<String> result = QuotingTransformer.transformWeakQuoting(WQ_REPLACE, ENVIRONMENT);

        assertTrue(result.isPresent());
        assertEquals(WQ_REPLACE_RESULT, result.get());
    }

    @Test
    public void transformFullQuoting() throws Exception {
        final String FQ_SIMPLE = "'text-test'";
        Optional<String> result = QuotingTransformer.transformFullQuoting(FQ_SIMPLE);

        assertTrue(result.isPresent());
        assertEquals(SIMPLE_RESULT, result.get());
    }
}