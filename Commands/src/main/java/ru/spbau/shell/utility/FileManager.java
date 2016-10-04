package ru.spbau.shell.utility;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by airvan21 on 30.09.16.
 */
public class FileManager {
    public static String getPath() {
        return System.getProperty("user.dir");
    }

    public static Set<String> listFiles(String path) {
        return FileUtils.listFiles(new File(getPath()), null, true)
                .stream()
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    public static Optional<File> getFile(String filePath) {
        File file;
        try {
            file = FileUtils.getFile(filePath);
        } catch (NullPointerException exc) {
            return Optional.empty();
        }

        return Optional.of(file);
    }

    public static Optional<String> readFile(File file) {
        String result;
        try {
            // TODO: please google a charset
            result = FileUtils.readFileToString(file);
        } catch (IOException exc) {
            return Optional.empty();
        }

        return Optional.of(result);
    }
}
