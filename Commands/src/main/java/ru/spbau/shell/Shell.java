package ru.spbau.shell;

import java.util.Optional;
import java.util.Scanner;

/**
 * Shell Singleton (not multi-thread singleton) class
 */
public class Shell {
    private static Scanner reader = new Scanner(System.in);
    private static Optional<Shell> instance = Optional.empty();

    public static Shell getInstance() {
        if (!instance.isPresent()) {
            instance = Optional.of(new Shell());
        }

        return instance.get();
    }

    public void run() {
        for (String input = reader.nextLine(); isValidInput(input); input = reader.nextLine()) {
            System.out.println(input);
        }
    }

    private Shell() {}

    private static boolean isValidInput(String input) {
        if (input == null) {
            return false;
        }

        input = input.trim();

        if (input.isEmpty()) {
            return false;
        }

        if (input.equals(":q")) {
            return false;
        }

        return true;
    }

}
