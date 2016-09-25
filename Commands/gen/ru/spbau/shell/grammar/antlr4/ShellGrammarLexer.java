// Generated from /home/airvan21/GitHub/Software-Design/Commands/src/main/java/ru/spbau/shell/grammar/antlr4/ShellGrammar.g4 by ANTLR 4.5.3
package ru.spbau.shell.grammar.antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShellGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, CAT=2, ECHO=3, WC=4, PWD=5, EXIT=6, ASSIGN=7, PIPE=8, Q_MARK=9, 
		Q_MARK_2=10, ID=11, VAR_ID=12, FullQString=13, WeakQString=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "CAT", "ECHO", "WC", "PWD", "EXIT", "ASSIGN", "PIPE", "Q_MARK", 
		"Q_MARK_2", "ID", "VAR_ID", "FullQString", "WeakQString", "Opchar", "Id", 
		"Var", "CharFull", "CharWeak", "CharEscapeSeq", "StringElement"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'cat'", "'echo'", "'wc'", "'pwd'", "'exit'", "'='", "'|'", 
		"'''", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "CAT", "ECHO", "WC", "PWD", "EXIT", "ASSIGN", "PIPE", "Q_MARK", 
		"Q_MARK_2", "ID", "VAR_ID", "FullQString", "WeakQString"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ShellGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ShellGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\20\u0081\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\6\2/\n\2\r\2\16\2\60"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\7\16X\n\16\f\16\16\16[\13\16\3\16\3\16\3\17\3\17\7\17a\n"+
		"\17\f\17\16\17d\13\17\3\17\3\17\3\20\3\20\3\21\3\21\6\21l\n\21\r\21\16"+
		"\21m\6\21p\n\21\r\21\16\21q\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\25\3\26\3\26\5\26\u0080\n\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\2!\2#\2%\2\'\2)\2+\2\3\2"+
		"\t\4\2\13\13\"\"\17\2\13\f\17\17\"\"$$&&)+..\62;==C_aac}\177\177\6\2\62"+
		";C\\aac|\3\2))\3\2$$\n\2$$))^^ddhhppttvv\4\2\"#%\u0081\u0080\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\3.\3\2\2\2\5\64\3\2\2\2\78\3\2\2\2\t=\3\2"+
		"\2\2\13@\3\2\2\2\rD\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25O\3"+
		"\2\2\2\27Q\3\2\2\2\31S\3\2\2\2\33U\3\2\2\2\35^\3\2\2\2\37g\3\2\2\2!o\3"+
		"\2\2\2#s\3\2\2\2%v\3\2\2\2\'x\3\2\2\2)z\3\2\2\2+\177\3\2\2\2-/\t\2\2\2"+
		".-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\b"+
		"\2\2\2\63\4\3\2\2\2\64\65\7e\2\2\65\66\7c\2\2\66\67\7v\2\2\67\6\3\2\2"+
		"\289\7g\2\29:\7e\2\2:;\7j\2\2;<\7q\2\2<\b\3\2\2\2=>\7y\2\2>?\7e\2\2?\n"+
		"\3\2\2\2@A\7r\2\2AB\7y\2\2BC\7f\2\2C\f\3\2\2\2DE\7g\2\2EF\7z\2\2FG\7k"+
		"\2\2GH\7v\2\2H\16\3\2\2\2IJ\7?\2\2J\20\3\2\2\2KL\7~\2\2L\22\3\2\2\2MN"+
		"\7)\2\2N\24\3\2\2\2OP\7$\2\2P\26\3\2\2\2QR\5!\21\2R\30\3\2\2\2ST\5#\22"+
		"\2T\32\3\2\2\2UY\7)\2\2VX\5%\23\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2"+
		"\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\7)\2\2]\34\3\2\2\2^b\7$\2\2_a\5\'\24\2`_"+
		"\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7$\2\2f\36"+
		"\3\2\2\2gh\n\3\2\2h \3\2\2\2ip\t\4\2\2jl\5\37\20\2kj\3\2\2\2lm\3\2\2\2"+
		"mk\3\2\2\2mn\3\2\2\2np\3\2\2\2oi\3\2\2\2ok\3\2\2\2pq\3\2\2\2qo\3\2\2\2"+
		"qr\3\2\2\2r\"\3\2\2\2st\7&\2\2tu\5!\21\2u$\3\2\2\2vw\n\5\2\2w&\3\2\2\2"+
		"xy\n\6\2\2y(\3\2\2\2z{\7^\2\2{|\t\7\2\2|*\3\2\2\2}\u0080\t\b\2\2~\u0080"+
		"\5)\25\2\177}\3\2\2\2\177~\3\2\2\2\u0080,\3\2\2\2\n\2\60Ybmoq\177\3\2"+
		"\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}