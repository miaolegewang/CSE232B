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
	 * Enter a parse tree produced by the {@code all}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterAll(@NotNull XPathParser.AllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code all}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitAll(@NotNull XPathParser.AllContext ctx);

	/**
	 * Enter a parse tree produced by the {@code parent}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterParent(@NotNull XPathParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parent}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitParent(@NotNull XPathParser.ParentContext ctx);

	/**
	 * Enter a parse tree produced by the {@code descendantPath}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterDescendantPath(@NotNull XPathParser.DescendantPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descendantPath}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitDescendantPath(@NotNull XPathParser.DescendantPathContext ctx);

	/**
	 * Enter a parse tree produced by the {@code pathIdEq}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPathIdEq(@NotNull XPathParser.PathIdEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathIdEq}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPathIdEq(@NotNull XPathParser.PathIdEqContext ctx);

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
	 * Enter a parse tree produced by the {@code conditionFilter}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterConditionFilter(@NotNull XPathParser.ConditionFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionFilter}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitConditionFilter(@NotNull XPathParser.ConditionFilterContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#descendant}.
	 * @param ctx the parse tree
	 */
	void enterDescendant(@NotNull XPathParser.DescendantContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#descendant}.
	 * @param ctx the parse tree
	 */
	void exitDescendant(@NotNull XPathParser.DescendantContext ctx);

	/**
	 * Enter a parse tree produced by the {@code attTest}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterAttTest(@NotNull XPathParser.AttTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attTest}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitAttTest(@NotNull XPathParser.AttTestContext ctx);

	/**
	 * Enter a parse tree produced by the {@code tagName}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterTagName(@NotNull XPathParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tagName}
	 * labeled alternative in {@link XPathParser#relativePath}.
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
	 * Enter a parse tree produced by the {@code firstFunc}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterFirstFunc(@NotNull XPathParser.FirstFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code firstFunc}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitFirstFunc(@NotNull XPathParser.FirstFuncContext ctx);

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
	 * Enter a parse tree produced by the {@code self}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterSelf(@NotNull XPathParser.SelfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code self}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitSelf(@NotNull XPathParser.SelfContext ctx);

	/**
	 * Enter a parse tree produced by the {@code pathSequence}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterPathSequence(@NotNull XPathParser.PathSequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathSequence}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitPathSequence(@NotNull XPathParser.PathSequenceContext ctx);

	/**
	 * Enter a parse tree produced by the {@code pathWithFilter}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterPathWithFilter(@NotNull XPathParser.PathWithFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathWithFilter}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitPathWithFilter(@NotNull XPathParser.PathWithFilterContext ctx);

	/**
	 * Enter a parse tree produced by the {@code negatvePathFilter}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterNegatvePathFilter(@NotNull XPathParser.NegatvePathFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negatvePathFilter}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitNegatvePathFilter(@NotNull XPathParser.NegatvePathFilterContext ctx);

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
	 * Enter a parse tree produced by the {@code text}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull XPathParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code text}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull XPathParser.TextContext ctx);

	/**
	 * Enter a parse tree produced by the {@code descendantExistence}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterDescendantExistence(@NotNull XPathParser.DescendantExistenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descendantExistence}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitDescendantExistence(@NotNull XPathParser.DescendantExistenceContext ctx);

	/**
	 * Enter a parse tree produced by the {@code pathValueEq}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPathValueEq(@NotNull XPathParser.PathValueEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathValueEq}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPathValueEq(@NotNull XPathParser.PathValueEqContext ctx);

	/**
	 * Enter a parse tree produced by the {@code firstPath}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterFirstPath(@NotNull XPathParser.FirstPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code firstPath}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitFirstPath(@NotNull XPathParser.FirstPathContext ctx);
}