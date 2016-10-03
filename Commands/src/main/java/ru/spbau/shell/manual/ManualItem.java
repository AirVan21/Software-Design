package ru.spbau.shell.manual;

/**
 * Created by airvan21 on 03.10.16.
 */
public enum ManualItem {
    CAT_MAN("cat - concatenate files and print on the standard output\ncat [OPTION]")
    , EXIT_MAN("exit - cause normal process termination")
    , ECHO_MAN("echo - display a line of text\necho [STRING]")
    , WC_MAN("wc - print newline, word, and byte counts for each file\nwc [FILE]")
    , PWD_MAN("pwd - print name of current/working directory\npwd [OPTION]")
    , ASSIGNMENT_MAN("Assigment operation expample:\nkey = value")
    , PIPE_MAN("pipe is PIPE - NANANANA")
    ;

    private final String description;

    ManualItem(String source) {
        description = source;
    }

    @Override
    public String toString() {
        return description;
    }
}
