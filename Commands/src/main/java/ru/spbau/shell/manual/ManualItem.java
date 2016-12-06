package ru.spbau.shell.manual;

/**
 * ManualItem class is used for command documentation
 */
public enum ManualItem {
    CAT_MAN("cat - concatenate files and print on the standard output\ncat [OPTION]")
    , EXIT_MAN("exit - cause normal process termination")
    , ECHO_MAN("echo - display a line of text\necho [STRING]")
    , WC_MAN("wc - print newline, word, and byte counts for each file\nwc [FILE]")
    , PWD_MAN("pwd - print name of current/working directory\npwd [OPTION]")
    , ASSIGNMENT_MAN("Assignment operation example:\nkey = value")
    , PIPE_MAN("pipe - command for chaining")
    , PROCESS_MAN("process - this is your external command")
    , GREP_MAN("grep searches the named input FILEs for lines containing a match to the given PATTERN" +
            "\n     -i, ignore case distinctions in both the PATTERN and the input files" +
            "\n     -w, select only those lines containing matches that form whole words" +
            "\n     -A NUM, print NUM lines of trailing context after matching lines")
    , CD_MAN("cd - change current directory to [DIR]\n cd [DIR]")
    , LS_MAN("ls - list of files in directory\n ls")
    ;

    /**
     * Description of the command
     */
    private final String description;

    ManualItem(String source) {
        description = source;
    }

    @Override
    public String toString() {
        return description;
    }
}
