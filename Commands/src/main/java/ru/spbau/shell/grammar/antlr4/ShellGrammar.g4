grammar ShellGrammar;

/* ============================================================  */
/* This Grammar was taken from ilnurshug (SoftwareDesign Repo)   */
/* ============================================================  */

command     : assignment | pipeCmd | simpleCmd |;
pipeCmd     : simpleCmd ('|' simpleCmd)+ ;
simpleCmd   : cat | echo | wc | pwd | exit | grep | process | cd | ls ;

pwd         : 'pwd';
exit        : 'exit';
cat         : 'cat' literal*;
wc          : 'wc' literal*;
echo        : 'echo' literal*;
grep        : 'grep' literal+;
cd          : 'cd' literal+;
ls          : 'ls';
assignment  : id '=' literal;
process     : literal+;

id          : ID;
variable    : VAR_ID;

literal     : fullQuoting | weakQuoting | variable | id;

fullQuoting : FullQString;
weakQuoting : WeakQString;

WS          : [ \t]+ -> channel(HIDDEN);
GREP        : 'grep';
CAT         : 'cat';
ECHO        : 'echo';
WC          : 'wc';
PWD         : 'pwd';
EXIT        : 'exit';
CD          : 'cd';
LS          : 'ls';
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
