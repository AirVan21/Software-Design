// Generated from /home/airvan21/GitHub/Software-Design/Commands/src/main/java/ru/spbau/shell/grammar/antlr4/ShellGrammar.g4 by ANTLR 4.5.3
package ru.spbau.shell.grammar.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShellGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, CAT=2, ECHO=3, WC=4, PWD=5, EXIT=6, ASSIGN=7, PIPE=8, Q_MARK=9, 
		Q_MARK_2=10, ID=11, VAR_ID=12, FullQString=13, WeakQString=14;
	public static final int
		RULE_command = 0, RULE_pipeCmd = 1, RULE_simpleCmd = 2, RULE_pwd = 3, 
		RULE_exit = 4, RULE_cat = 5, RULE_wc = 6, RULE_echo = 7, RULE_assignment = 8, 
		RULE_id = 9, RULE_variable = 10, RULE_literal = 11, RULE_fullQuoting = 12, 
		RULE_weakQuoting = 13;
	public static final String[] ruleNames = {
		"command", "pipeCmd", "simpleCmd", "pwd", "exit", "cat", "wc", "echo", 
		"assignment", "id", "variable", "literal", "fullQuoting", "weakQuoting"
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

	@Override
	public String getGrammarFileName() { return "ShellGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShellGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CommandContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PipeCmdContext pipeCmd() {
			return getRuleContext(PipeCmdContext.class,0);
		}
		public SimpleCmdContext simpleCmd() {
			return getRuleContext(SimpleCmdContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_command);
		try {
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				pipeCmd();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				simpleCmd();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PipeCmdContext extends ParserRuleContext {
		public List<SimpleCmdContext> simpleCmd() {
			return getRuleContexts(SimpleCmdContext.class);
		}
		public SimpleCmdContext simpleCmd(int i) {
			return getRuleContext(SimpleCmdContext.class,i);
		}
		public PipeCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitPipeCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipeCmdContext pipeCmd() throws RecognitionException {
		PipeCmdContext _localctx = new PipeCmdContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pipeCmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			simpleCmd();
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				match(PIPE);
				setState(36);
				simpleCmd();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PIPE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleCmdContext extends ParserRuleContext {
		public CatContext cat() {
			return getRuleContext(CatContext.class,0);
		}
		public EchoContext echo() {
			return getRuleContext(EchoContext.class,0);
		}
		public WcContext wc() {
			return getRuleContext(WcContext.class,0);
		}
		public PwdContext pwd() {
			return getRuleContext(PwdContext.class,0);
		}
		public ExitContext exit() {
			return getRuleContext(ExitContext.class,0);
		}
		public SimpleCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitSimpleCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleCmdContext simpleCmd() throws RecognitionException {
		SimpleCmdContext _localctx = new SimpleCmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simpleCmd);
		try {
			setState(46);
			switch (_input.LA(1)) {
			case CAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				cat();
				}
				break;
			case ECHO:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				echo();
				}
				break;
			case WC:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				wc();
				}
				break;
			case PWD:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				pwd();
				}
				break;
			case EXIT:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				exit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PwdContext extends ParserRuleContext {
		public PwdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pwd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitPwd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PwdContext pwd() throws RecognitionException {
		PwdContext _localctx = new PwdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pwd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(PWD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExitContext extends ParserRuleContext {
		public ExitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitExit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitContext exit() throws RecognitionException {
		ExitContext _localctx = new ExitContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(EXIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public CatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitCat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatContext cat() throws RecognitionException {
		CatContext _localctx = new CatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(CAT);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << VAR_ID) | (1L << FullQString) | (1L << WeakQString))) != 0)) {
				{
				{
				setState(53);
				literal();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WcContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public WcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitWc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WcContext wc() throws RecognitionException {
		WcContext _localctx = new WcContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_wc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(WC);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << VAR_ID) | (1L << FullQString) | (1L << WeakQString))) != 0)) {
				{
				{
				setState(60);
				literal();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EchoContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public EchoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_echo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitEcho(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EchoContext echo() throws RecognitionException {
		EchoContext _localctx = new EchoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_echo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(ECHO);
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				literal();
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << VAR_ID) | (1L << FullQString) | (1L << WeakQString))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			id();
			setState(73);
			match(ASSIGN);
			setState(74);
			literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShellGrammarParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VAR_ID() { return getToken(ShellGrammarParser.VAR_ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(VAR_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public FullQuotingContext fullQuoting() {
			return getRuleContext(FullQuotingContext.class,0);
		}
		public WeakQuotingContext weakQuoting() {
			return getRuleContext(WeakQuotingContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_literal);
		try {
			setState(84);
			switch (_input.LA(1)) {
			case FullQString:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				fullQuoting();
				}
				break;
			case WeakQString:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				weakQuoting();
				}
				break;
			case VAR_ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				variable();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullQuotingContext extends ParserRuleContext {
		public TerminalNode FullQString() { return getToken(ShellGrammarParser.FullQString, 0); }
		public FullQuotingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullQuoting; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitFullQuoting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullQuotingContext fullQuoting() throws RecognitionException {
		FullQuotingContext _localctx = new FullQuotingContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fullQuoting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(FullQString);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeakQuotingContext extends ParserRuleContext {
		public TerminalNode WeakQString() { return getToken(ShellGrammarParser.WeakQString, 0); }
		public WeakQuotingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weakQuoting; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShellGrammarVisitor ) return ((ShellGrammarVisitor<? extends T>)visitor).visitWeakQuoting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeakQuotingContext weakQuoting() throws RecognitionException {
		WeakQuotingContext _localctx = new WeakQuotingContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_weakQuoting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(WeakQString);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20]\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\5\2#\n\2\3\3\3\3\3"+
		"\3\6\3(\n\3\r\3\16\3)\3\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\7\79\n\7\f\7\16\7<\13\7\3\b\3\b\7\b@\n\b\f\b\16\bC\13\b\3\t\3\t"+
		"\6\tG\n\t\r\t\16\tH\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\5\rW\n\r\3\16\3\16\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\2\2\\\2\"\3\2\2\2\4$\3\2\2\2\6\60\3\2\2\2\b\62\3\2\2\2\n\64\3\2"+
		"\2\2\f\66\3\2\2\2\16=\3\2\2\2\20D\3\2\2\2\22J\3\2\2\2\24N\3\2\2\2\26P"+
		"\3\2\2\2\30V\3\2\2\2\32X\3\2\2\2\34Z\3\2\2\2\36#\5\22\n\2\37#\5\4\3\2"+
		" #\5\6\4\2!#\3\2\2\2\"\36\3\2\2\2\"\37\3\2\2\2\" \3\2\2\2\"!\3\2\2\2#"+
		"\3\3\2\2\2$\'\5\6\4\2%&\7\n\2\2&(\5\6\4\2\'%\3\2\2\2()\3\2\2\2)\'\3\2"+
		"\2\2)*\3\2\2\2*\5\3\2\2\2+\61\5\f\7\2,\61\5\20\t\2-\61\5\16\b\2.\61\5"+
		"\b\5\2/\61\5\n\6\2\60+\3\2\2\2\60,\3\2\2\2\60-\3\2\2\2\60.\3\2\2\2\60"+
		"/\3\2\2\2\61\7\3\2\2\2\62\63\7\7\2\2\63\t\3\2\2\2\64\65\7\b\2\2\65\13"+
		"\3\2\2\2\66:\7\4\2\2\679\5\30\r\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3"+
		"\2\2\2;\r\3\2\2\2<:\3\2\2\2=A\7\6\2\2>@\5\30\r\2?>\3\2\2\2@C\3\2\2\2A"+
		"?\3\2\2\2AB\3\2\2\2B\17\3\2\2\2CA\3\2\2\2DF\7\5\2\2EG\5\30\r\2FE\3\2\2"+
		"\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\21\3\2\2\2JK\5\24\13\2KL\7\t\2\2LM\5"+
		"\30\r\2M\23\3\2\2\2NO\7\r\2\2O\25\3\2\2\2PQ\7\16\2\2Q\27\3\2\2\2RW\5\32"+
		"\16\2SW\5\34\17\2TW\5\26\f\2UW\5\24\13\2VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2"+
		"VU\3\2\2\2W\31\3\2\2\2XY\7\17\2\2Y\33\3\2\2\2Z[\7\20\2\2[\35\3\2\2\2\t"+
		"\")\60:AHV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}