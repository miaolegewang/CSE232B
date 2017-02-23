// Generated from ucsd/xpath/evaluator/XQuery.g4 by ANTLR 4.3
package ucsd.xpath.evaluator;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XQueryParser#ass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAss(@NotNull XQueryParser.AssContext ctx);

	/**
	 * Visit a parse tree produced by the {@code parent}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParent(@NotNull XQueryParser.ParentContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#assignments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignments(@NotNull XQueryParser.AssignmentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#bindings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindings(@NotNull XQueryParser.BindingsContext ctx);

	/**
	 * Visit a parse tree produced by the {@code descendant}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendant(@NotNull XQueryParser.DescendantContext ctx);

	/**
	 * Visit a parse tree produced by the {@code andCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCond(@NotNull XQueryParser.AndCondContext ctx);

	/**
	 * Visit a parse tree produced by the {@code flwr}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlwr(@NotNull XQueryParser.FlwrContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#bind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBind(@NotNull XQueryParser.BindContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(@NotNull XQueryParser.LetClauseContext ctx);

	/**
	 * Visit a parse tree produced by the {@code let}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(@NotNull XQueryParser.LetContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(@NotNull XQueryParser.TagContext ctx);

	/**
	 * Visit a parse tree produced by the {@code text}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(@NotNull XQueryParser.TextContext ctx);

	/**
	 * Visit a parse tree produced by the {@code firstPath}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstPath(@NotNull XQueryParser.FirstPathContext ctx);

	/**
	 * Visit a parse tree produced by the {@code all}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(@NotNull XQueryParser.AllContext ctx);

	/**
	 * Visit a parse tree produced by the {@code descendantPath}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendantPath(@NotNull XQueryParser.DescendantPathContext ctx);

	/**
	 * Visit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(@NotNull XQueryParser.AndFilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull XQueryParser.VarContext ctx);

	/**
	 * Visit a parse tree produced by the {@code format}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat(@NotNull XQueryParser.FormatContext ctx);

	/**
	 * Visit a parse tree produced by the {@code queryIDEq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryIDEq(@NotNull XQueryParser.QueryIDEqContext ctx);

	/**
	 * Visit a parse tree produced by the {@code priority}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriority(@NotNull XQueryParser.PriorityContext ctx);

	/**
	 * Visit a parse tree produced by the {@code priorityCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriorityCond(@NotNull XQueryParser.PriorityCondContext ctx);

	/**
	 * Visit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(@NotNull XQueryParser.OrFilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAp(@NotNull XQueryParser.ApContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx);

	/**
	 * Visit a parse tree produced by the {@code pathSequence}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathSequence(@NotNull XQueryParser.PathSequenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#dsl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDsl(@NotNull XQueryParser.DslContext ctx);

	/**
	 * Visit a parse tree produced by the {@code descendantExistence}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendantExistence(@NotNull XQueryParser.DescendantExistenceContext ctx);

	/**
	 * Visit a parse tree produced by the {@code child}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChild(@NotNull XQueryParser.ChildContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#stringConst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConst(@NotNull XQueryParser.StringConstContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(@NotNull XQueryParser.VarNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code queryValueEq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryValueEq(@NotNull XQueryParser.QueryValueEqContext ctx);

	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull XQueryParser.StringContext ctx);

	/**
	 * Visit a parse tree produced by the {@code notCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCond(@NotNull XQueryParser.NotCondContext ctx);

	/**
	 * Visit a parse tree produced by the {@code someClause}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomeClause(@NotNull XQueryParser.SomeClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#xpath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpath(@NotNull XQueryParser.XpathContext ctx);

	/**
	 * Visit a parse tree produced by the {@code absolutePath}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolutePath(@NotNull XQueryParser.AbsolutePathContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#sl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSl(@NotNull XQueryParser.SlContext ctx);

	/**
	 * Visit a parse tree produced by the {@code emptyQuery}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyQuery(@NotNull XQueryParser.EmptyQueryContext ctx);

	/**
	 * Visit a parse tree produced by the {@code pathIdEq}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathIdEq(@NotNull XQueryParser.PathIdEqContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXquery(@NotNull XQueryParser.XqueryContext ctx);

	/**
	 * Visit a parse tree produced by the {@code pairQuery}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairQuery(@NotNull XQueryParser.PairQueryContext ctx);

	/**
	 * Visit a parse tree produced by the {@code attTest}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttTest(@NotNull XQueryParser.AttTestContext ctx);

	/**
	 * Visit a parse tree produced by the {@code tagName}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(@NotNull XQueryParser.TagNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code firstFunc}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstFunc(@NotNull XQueryParser.FirstFuncContext ctx);

	/**
	 * Visit a parse tree produced by the {@code orCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCond(@NotNull XQueryParser.OrCondContext ctx);

	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull XQueryParser.VariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(@NotNull XQueryParser.ForClauseContext ctx);

	/**
	 * Visit a parse tree produced by the {@code self}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf(@NotNull XQueryParser.SelfContext ctx);

	/**
	 * Visit a parse tree produced by the {@code pathWithFilter}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathWithFilter(@NotNull XQueryParser.PathWithFilterContext ctx);

	/**
	 * Visit a parse tree produced by the {@code negatvePathFilter}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegatvePathFilter(@NotNull XQueryParser.NegatvePathFilterContext ctx);

	/**
	 * Visit a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(@NotNull XQueryParser.AttNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code pathValueEq}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathValueEq(@NotNull XQueryParser.PathValueEqContext ctx);
}