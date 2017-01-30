// Generated from edu/ucsd/antlrxpath/antlrxpath/XPath.g4 by ANTLR 4.3
package edu.ucsd.antlrxpath.antlrxpath;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPathParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPathVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathFilter(@NotNull XPathParser.PathFilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#equal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(@NotNull XPathParser.EqualContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#xpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpath(@NotNull XPathParser.XpathContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull XPathParser.ConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXquery(@NotNull XPathParser.XqueryContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativePath(@NotNull XPathParser.RelativePathContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#absolutePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolutePath(@NotNull XPathParser.AbsolutePathContext ctx);
}