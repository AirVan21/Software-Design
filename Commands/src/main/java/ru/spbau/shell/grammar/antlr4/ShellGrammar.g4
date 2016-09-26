grammar ShellGrammar;

/* ============================================================  */
/* This Grammar was taken from ilnurshug (SoftwareDesign Repo)   */
/* ============================================================  */

command     : assignment | pipeCmd | simpleCmd |;
pipeCmd     : simpleCmd ('|' simpleCmd)+ ;
simpleCmd   : cat | echo | wc | pwd | exit ;

pwd         : 'pwd';
exit        : 'exit';
cat         : 'cat' literal*;
wc          : 'wc' literal*;
echo        : 'echo' literal*;
assignment  : id '=' literal;

id          : ID;
variable    : VAR_ID;

literal     : fullQuoting | weakQuoting | variable | id;

fullQuoting : FullQString;
weakQuoting : WeakQString;

WS          : [ \t]+ -> channel(HIDDEN);
CAT         : 'cat';
ECHO        : 'echo';
WC          : 'wc';
PWD         : 'pwd';
EXIT        : 'exit';
ASSIGN      : '=';
PIPE        : '|';
Q_MARK	    : '\'';
Q_MARK_2    : '"';
ID          : Id;
VAR_ID      : Var;

FullQString : '\'' CharFull* '\'' ;
WeakQString : '"' CharWeak* '"' ;


fragment Opchar
            : ~[a-zA-Z0-9()[\]{};, \r\t\n'"$_] ;
fragment Id
            : ([a-zA-Z_0-9] | Opchar+)+ ;
fragment Var
            : '$' Id ;
fragment CharFull
            : ~['] ;
fragment CharWeak
            : ~["] ;
fragment CharEscapeSeq
            : '\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\');
fragment StringElement
            : '\u0020'| '\u0021'|'\u0023' .. '\u007F'| CharEscapeSeq;

/* ============================================================  */
