package ru.spbau.shell;

import org.junit.Test;
import ru.spbau.shell.utility.FileManager;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Test for Shell functionality
 */
public class ShellTest {
    private final Shell shell = Shell.getInstance();

    /**
     * Text itself
     */
    // hello everyone
    // one world
    // mad world one
    // test test
    // code
    private final String FILE_NAME = "src/test/resources/test.txt";


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
    public void testWeakQuotes() {
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

    @Test
    public void testFullQuotes() {
        final String key = "user";
        final String value = "jake";

        String line =  key + " = " + value;
        Optional<String> result = shell.handleInputLine(line);
        assertFalse(result.isPresent());

        line = "echo '$user'";
        result = shell.handleInputLine(line);
        assertTrue(result.isPresent());
        assertEquals("$user", result.get());
    }

    @Test
    public void testPipe() {
        final String content = "\"mad mad world\"";
        final String line = "echo " + content + " | wc";
        final Optional<String> result = shell.handleInputLine(line);

        assertTrue(result.isPresent());
        assertEquals("1 3 13", result.get());
    }

    @Test
    public void testSimpleGrep() {
        final String line = "grep \"one\" " + FILE_NAME;

        final Optional<String> result = shell.handleInputLine(line);
        assertTrue(result.isPresent());
        final List<String> lines = FileManager.getLinesFromText(result.get());
        assertEquals("hello everyone", lines.get(0));
        lines.forEach(item -> assertTrue(item.contains("one")));
    }

    @Test
    public void testInsensitiveGrep() {
        final String line = "grep -i \"oNe\" " + FILE_NAME;
        final int RESULT_SIZE = 3;

        final Optional<String> result = shell.handleInputLine(line);
        assertTrue(result.isPresent());
        final List<String> lines = FileManager.getLinesFromText(result.get());
        assertEquals(RESULT_SIZE, lines.size());
        assertEquals("hello everyone", lines.get(0));
        lines.forEach(item -> assertTrue(item.toLowerCase().contains("one")));
    }

    @Test
    public void testWordGrep() {
        final String line = "grep -i -w \"oNe\" " + FILE_NAME;
        final int RESULT_SIZE = 2;

        final Optional<String> result = shell.handleInputLine(line);
        assertTrue(result.isPresent());
        final List<String> lines = FileManager.getLinesFromText(result.get());
        assertEquals(RESULT_SIZE, lines.size());
        assertEquals("one world", lines.get(0));
        lines.forEach(item -> assertTrue(item.toLowerCase().contains("one")));
    }

    @Test
    public void testAfterGrep() {
        final String line = "grep -i -w -A 3 \"test\" " + FILE_NAME;
        // one match, one trailing line (because file end)
        final int RESULT_SIZE = 2;

        final Optional<String> result = shell.handleInputLine(line);
        assertTrue(result.isPresent());
        final List<String> lines = FileManager.getLinesFromText(result.get());
        assertEquals(RESULT_SIZE, lines.size());
        assertEquals("test test", lines.get(0));
    }

    @Test
    public void pipedGrep() {
        final String line = "grep -i \"oNe\" " + FILE_NAME + " | wc";

        final Optional<String> result = shell.handleInputLine(line);
        assertTrue(result.isPresent());
        assertEquals("3 7 39", result.get());
    }
}