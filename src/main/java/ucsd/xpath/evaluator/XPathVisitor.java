// Generated from ucsd/xpath/evaluator/XPath.g4 by ANTLR 4.3
package ucsd.xpath.evaluator;
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
	 * Visit a parse tree produced by the {@code all}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(@NotNull XPathParser.AllContext ctx);

	/**
	 * Visit a parse tree produced by the {@code parent}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(@NotNull XPathParser.ParentContext ctx);

	/**
	 * Visit a parse tree produced by the {@code descendantPath}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendantPath(@NotNull XPathParser.DescendantPathContext ctx);

	/**
	 * Visit a parse tree produced by the {@code pathIdEq}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathIdEq(@NotNull XPathParser.PathIdEqContext ctx);

	/**
	 * Visit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(@NotNull XPathParser.AndFilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXquery(@NotNull XPathParser.XqueryContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#descendant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendant(@NotNull XPathParser.DescendantContext ctx);

	/**
	 * Visit a parse tree produced by the {@code attTest}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttTest(@NotNull XPathParser.AttTestContext ctx);

	/**
	 * Visit a parse tree produced by the {@code tagName}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(@NotNull XPathParser.TagNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(@NotNull XPathParser.OrFilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#descendantOrSelf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendantOrSelf(@NotNull XPathParser.DescendantOrSelfContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#xpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpath(@NotNull XPathParser.XpathContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#filename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilename(@NotNull XPathParser.FilenameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code firstFunc}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstFunc(@NotNull XPathParser.FirstFuncContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#absolutePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolutePath(@NotNull XPathParser.AbsolutePathContext ctx);

	/**
	 * Visit a parse tree produced by the {@code self}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf(@NotNull XPathParser.SelfContext ctx);

	/**
	 * Visit a parse tree produced by the {@code pathSequence}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathSequence(@NotNull XPathParser.PathSequenceContext ctx);

	/**
	 * Visit a parse tree produced by the {@code pathWithFilter}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathWithFilter(@NotNull XPathParser.PathWithFilterContext ctx);

	/**
	 * Visit a parse tree produced by the {@code negatvePathFilter}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegatvePathFilter(@NotNull XPathParser.NegatvePathFilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(@NotNull XPathParser.AttNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code text}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(@NotNull XPathParser.TextContext ctx);

	/**
	 * Visit a parse tree produced by the {@code descendantExistence}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendantExistence(@NotNull XPathParser.DescendantExistenceContext ctx);

	/**
	 * Visit a parse tree produced by the {@code pathValueEq}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathValueEq(@NotNull XPathParser.PathValueEqContext ctx);

	/**
	 * Visit a parse tree produced by the {@code firstPath}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstPath(@NotNull XPathParser.FirstPathContext ctx);
}