// Generated from /home/airvan21/GitHub/Software-Design/Commands/src/main/java/ru/spbau/shell/grammar/antlr4/ShellGrammar.g4 by ANTLR 4.5.3
package ru.spbau.shell.grammar.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ShellGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ShellGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(ShellGrammarParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#pipeCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeCmd(ShellGrammarParser.PipeCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#simpleCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCmd(ShellGrammarParser.SimpleCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#pwd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPwd(ShellGrammarParser.PwdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#exit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit(ShellGrammarParser.ExitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#cat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCat(ShellGrammarParser.CatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#wc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWc(ShellGrammarParser.WcContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#echo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEcho(ShellGrammarParser.EchoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ShellGrammarParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ShellGrammarParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ShellGrammarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ShellGrammarParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#fullQuoting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullQuoting(ShellGrammarParser.FullQuotingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShellGrammarParser#weakQuoting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeakQuoting(ShellGrammarParser.WeakQuotingContext ctx);
}