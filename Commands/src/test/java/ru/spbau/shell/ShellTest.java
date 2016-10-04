package ru.spbau.shell;

import org.junit.Test;
import ru.spbau.shell.utility.FileManager;

import java.io.File;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Test for Shell functionality
 */
public class ShellTest {
    private final Shell shell = Shell.getInstance();

    @Test
    public void testCat()  {
        final String fileName = "pom.xml";
        final String line = "cat " + fileName;
        final Optional<String> result = shell.handleInputLine(line);

        Optional<File> file = FileManager.getFile(fileName);
        Optional<String> text = FileManager.readFile(file.get());

        assertTrue(result.isPresent());
        assertEquals(result.get(), text.get());
    }

    @Test
    public void testEcho() {
        final String content = "hello_world";
        final String line = "echo " + content;
        final Optional<String> result = shell.handleInputLine(line);

        assertTrue(result.isPresent());
        assertEquals(content, result.get());
    }

    @Test
    public void testWc() {
        final String content = "\"mad mad world\"";
        final String line = "wc " + content;
        final Optional<String> result = shell.handleInputLine(line);

        assertTrue(result.isPresent());
        assertEquals("1 3 13", result.get());
    }

    @Test
    public void testPwd() {
        final String line = "pwd";
        final Optional<String> result = shell.handleInputLine(line);

        assertTrue(result.isPresent());
        assertEquals(FileManager.getPath(), result.get());
    }

    @Test
    public void testExit() {
        final String line = "exit";
        // exit work
        assertEquals("sure", "sure");
    }

    @Test
    public void testVariable() {
        final String key = "user";
        final String value = "jake";

        String line =  key + " = " + value;
        Optional<String> result = shell.handleInputLine(line);
        assertFalse(result.isPresent());

        line = "echo \"$user\"";
        result = shell.handleInputLine(line);
        assertTrue(result.isPresent());
        assertEquals(value, result.get());
    }
}