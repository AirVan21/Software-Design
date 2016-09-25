package ru.spbau.shell.commands;

import java.util.List;

/**
 * Created by airvan21 on 13.09.16.
 */
public class Cat extends CommandRoot {

    public Cat() {
        super(1);
    }

    @Override
    public String execute(List<String> arguments) {
        return "";
    }

    @Override
    public String getHelp() {
        return "";
    }
}
