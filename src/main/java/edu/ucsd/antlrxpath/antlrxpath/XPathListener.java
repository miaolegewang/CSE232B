// Generated from edu/ucsd/antlrxpath/antlrxpath/XPath.g4 by ANTLR 4.3
package edu.ucsd.antlrxpath.antlrxpath;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPathFilter(@NotNull XPathParser.PathFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPathFilter(@NotNull XPathParser.PathFilterContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#xpath}.
	 * @param ctx the parse tree
	 */
	void enterXpath(@NotNull XPathParser.XpathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#xpath}.
	 * @param ctx the parse tree
	 */
	void exitXpath(@NotNull XPathParser.XpathContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXquery(@NotNull XPathParser.XqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXquery(@NotNull XPathParser.XqueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterRelativePath(@NotNull XPathParser.RelativePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitRelativePath(@NotNull XPathParser.RelativePathContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutePath(@NotNull XPathParser.AbsolutePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutePath(@NotNull XPathParser.AbsolutePathContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(@NotNull XPathParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(@NotNull XPathParser.AttNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(@NotNull XPathParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(@NotNull XPathParser.TagNameContext ctx);
}