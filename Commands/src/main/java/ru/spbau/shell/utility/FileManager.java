package ru.spbau.shell.utility;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by airvan21 on 30.09.16.
 */
public class FileManager {
    public static String getPath() {
        return System.getProperty("user.dir");
    }

    public static Set<String> getFiles(String path) {
        return FileUtils.listFiles(new File(getPath()), null, true)
                .stream()
                .map(File::getName)
                .collect(Collectors.toSet());
    }
}
