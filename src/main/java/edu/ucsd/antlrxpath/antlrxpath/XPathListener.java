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
	 * Enter a parse tree produced by {@link XPathParser#all}.
	 * @param ctx the parse tree
	 */
	void enterAll(@NotNull XPathParser.AllContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#all}.
	 * @param ctx the parse tree
	 */
	void exitAll(@NotNull XPathParser.AllContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#parent}.
	 * @param ctx the parse tree
	 */
	void enterParent(@NotNull XPathParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#parent}.
	 * @param ctx the parse tree
	 */
	void exitParent(@NotNull XPathParser.ParentContext ctx);

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
	 * Enter a parse tree produced by {@link XPathParser#selfNode}.
	 * @param ctx the parse tree
	 */
	void enterSelfNode(@NotNull XPathParser.SelfNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#selfNode}.
	 * @param ctx the parse tree
	 */
	void exitSelfNode(@NotNull XPathParser.SelfNodeContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#attTest}.
	 * @param ctx the parse tree
	 */
	void enterAttTest(@NotNull XPathParser.AttTestContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#attTest}.
	 * @param ctx the parse tree
	 */
	void exitAttTest(@NotNull XPathParser.AttTestContext ctx);

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

	/**
	 * Enter a parse tree produced by {@link XPathParser#descendantOrSelf}.
	 * @param ctx the parse tree
	 */
	void enterDescendantOrSelf(@NotNull XPathParser.DescendantOrSelfContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#descendantOrSelf}.
	 * @param ctx the parse tree
	 */
	void exitDescendantOrSelf(@NotNull XPathParser.DescendantOrSelfContext ctx);

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
	 * Enter a parse tree produced by {@link XPathParser#nagatePathFilter}.
	 * @param ctx the parse tree
	 */
	void enterNagatePathFilter(@NotNull XPathParser.NagatePathFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#nagatePathFilter}.
	 * @param ctx the parse tree
	 */
	void exitNagatePathFilter(@NotNull XPathParser.NagatePathFilterContext ctx);

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
	 * Enter a parse tree produced by {@link XPathParser#concatPath}.
	 * @param ctx the parse tree
	 */
	void enterConcatPath(@NotNull XPathParser.ConcatPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#concatPath}.
	 * @param ctx the parse tree
	 */
	void exitConcatPath(@NotNull XPathParser.ConcatPathContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#filename}.
	 * @param ctx the parse tree
	 */
	void enterFilename(@NotNull XPathParser.FilenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#filename}.
	 * @param ctx the parse tree
	 */
	void exitFilename(@NotNull XPathParser.FilenameContext ctx);

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
	 * Enter a parse tree produced by {@link XPathParser#self}.
	 * @param ctx the parse tree
	 */
	void enterSelf(@NotNull XPathParser.SelfContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#self}.
	 * @param ctx the parse tree
	 */
	void exitSelf(@NotNull XPathParser.SelfContext ctx);

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
	 * Enter a parse tree produced by {@link XPathParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull XPathParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull XPathParser.TextContext ctx);
}