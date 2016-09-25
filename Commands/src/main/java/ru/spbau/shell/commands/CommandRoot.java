package ru.spbau.shell.commands;

import ru.spbau.shell.utility.Helper;

import java.util.List;

/**
 * Created by airvan21 on 13.09.16.
 */
public abstract class CommandRoot implements Helper {
    public static int amountOfArguments;

    public CommandRoot(int amountOfArguments) {
        this.amountOfArguments = amountOfArguments;
    }

    public abstract String execute(List<String> arguments);
}
