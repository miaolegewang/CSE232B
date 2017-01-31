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
	 * Visit a parse tree produced by {@link XPathParser#all}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(@NotNull XPathParser.AllContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#parent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(@NotNull XPathParser.ParentContext ctx);

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
	 * Visit a parse tree produced by {@link XPathParser#attTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttTest(@NotNull XPathParser.AttTestContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(@NotNull XPathParser.TagNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#descendantOrSelf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendantOrSelf(@NotNull XPathParser.DescendantOrSelfContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathFilter(@NotNull XPathParser.PathFilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#nagatePathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNagatePathFilter(@NotNull XPathParser.NagatePathFilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#xpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpath(@NotNull XPathParser.XpathContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#concatPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatPath(@NotNull XPathParser.ConcatPathContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#filename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilename(@NotNull XPathParser.FilenameContext ctx);

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

	/**
	 * Visit a parse tree produced by {@link XPathParser#self}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf(@NotNull XPathParser.SelfContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(@NotNull XPathParser.AttNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link XPathParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(@NotNull XPathParser.TextContext ctx);
}