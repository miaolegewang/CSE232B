// Generated from ucsd/xpath/evaluator/XQuery.g4 by ANTLR 4.3
package ucsd.xpath.evaluator;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XQueryParser#ass}.
	 * @param ctx the parse tree
	 */
	void enterAss(@NotNull XQueryParser.AssContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#ass}.
	 * @param ctx the parse tree
	 */
	void exitAss(@NotNull XQueryParser.AssContext ctx);

	/**
	 * Enter a parse tree produced by the {@code parent}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterParent(@NotNull XQueryParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parent}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitParent(@NotNull XQueryParser.ParentContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(@NotNull XQueryParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#assignments}.
	 * @param ctx the parse tree
	 */
	void enterAssignments(@NotNull XQueryParser.AssignmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#assignments}.
	 * @param ctx the parse tree
	 */
	void exitAssignments(@NotNull XQueryParser.AssignmentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#bindings}.
	 * @param ctx the parse tree
	 */
	void enterBindings(@NotNull XQueryParser.BindingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#bindings}.
	 * @param ctx the parse tree
	 */
	void exitBindings(@NotNull XQueryParser.BindingsContext ctx);

	/**
	 * Enter a parse tree produced by the {@code descendant}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterDescendant(@NotNull XQueryParser.DescendantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descendant}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitDescendant(@NotNull XQueryParser.DescendantContext ctx);

	/**
	 * Enter a parse tree produced by the {@code andCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterAndCond(@NotNull XQueryParser.AndCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitAndCond(@NotNull XQueryParser.AndCondContext ctx);

	/**
	 * Enter a parse tree produced by the {@code flwr}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterFlwr(@NotNull XQueryParser.FlwrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flwr}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitFlwr(@NotNull XQueryParser.FlwrContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#bind}.
	 * @param ctx the parse tree
	 */
	void enterBind(@NotNull XQueryParser.BindContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#bind}.
	 * @param ctx the parse tree
	 */
	void exitBind(@NotNull XQueryParser.BindContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(@NotNull XQueryParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(@NotNull XQueryParser.LetClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code let}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterLet(@NotNull XQueryParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code let}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitLet(@NotNull XQueryParser.LetContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(@NotNull XQueryParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(@NotNull XQueryParser.TagContext ctx);

	/**
	 * Enter a parse tree produced by the {@code text}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull XQueryParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code text}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull XQueryParser.TextContext ctx);

	/**
	 * Enter a parse tree produced by the {@code firstPath}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterFirstPath(@NotNull XQueryParser.FirstPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code firstPath}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitFirstPath(@NotNull XQueryParser.FirstPathContext ctx);

	/**
	 * Enter a parse tree produced by the {@code all}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterAll(@NotNull XQueryParser.AllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code all}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitAll(@NotNull XQueryParser.AllContext ctx);

	/**
	 * Enter a parse tree produced by the {@code descendantPath}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterDescendantPath(@NotNull XQueryParser.DescendantPathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descendantPath}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitDescendantPath(@NotNull XQueryParser.DescendantPathContext ctx);

	/**
	 * Enter a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(@NotNull XQueryParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(@NotNull XQueryParser.AndFilterContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull XQueryParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull XQueryParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by the {@code format}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterFormat(@NotNull XQueryParser.FormatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code format}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitFormat(@NotNull XQueryParser.FormatContext ctx);

	/**
	 * Enter a parse tree produced by the {@code queryIDEq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterQueryIDEq(@NotNull XQueryParser.QueryIDEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryIDEq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitQueryIDEq(@NotNull XQueryParser.QueryIDEqContext ctx);

	/**
	 * Enter a parse tree produced by the {@code priority}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterPriority(@NotNull XQueryParser.PriorityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code priority}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitPriority(@NotNull XQueryParser.PriorityContext ctx);

	/**
	 * Enter a parse tree produced by the {@code priorityCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterPriorityCond(@NotNull XQueryParser.PriorityCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code priorityCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitPriorityCond(@NotNull XQueryParser.PriorityCondContext ctx);

	/**
	 * Enter a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(@NotNull XQueryParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(@NotNull XQueryParser.OrFilterContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(@NotNull XQueryParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(@NotNull XQueryParser.ApContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code pathSequence}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterPathSequence(@NotNull XQueryParser.PathSequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathSequence}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitPathSequence(@NotNull XQueryParser.PathSequenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#dsl}.
	 * @param ctx the parse tree
	 */
	void enterDsl(@NotNull XQueryParser.DslContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#dsl}.
	 * @param ctx the parse tree
	 */
	void exitDsl(@NotNull XQueryParser.DslContext ctx);

	/**
	 * Enter a parse tree produced by the {@code descendantExistence}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterDescendantExistence(@NotNull XQueryParser.DescendantExistenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descendantExistence}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitDescendantExistence(@NotNull XQueryParser.DescendantExistenceContext ctx);

	/**
	 * Enter a parse tree produced by the {@code child}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterChild(@NotNull XQueryParser.ChildContext ctx);
	/**
	 * Exit a parse tree produced by the {@code child}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitChild(@NotNull XQueryParser.ChildContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#stringConst}.
	 * @param ctx the parse tree
	 */
	void enterStringConst(@NotNull XQueryParser.StringConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#stringConst}.
	 * @param ctx the parse tree
	 */
	void exitStringConst(@NotNull XQueryParser.StringConstContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(@NotNull XQueryParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(@NotNull XQueryParser.VarNameContext ctx);

	/**
	 * Enter a parse tree produced by the {@code queryValueEq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterQueryValueEq(@NotNull XQueryParser.QueryValueEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryValueEq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitQueryValueEq(@NotNull XQueryParser.QueryValueEqContext ctx);

	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull XQueryParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull XQueryParser.StringContext ctx);

	/**
	 * Enter a parse tree produced by the {@code notCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNotCond(@NotNull XQueryParser.NotCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNotCond(@NotNull XQueryParser.NotCondContext ctx);

	/**
	 * Enter a parse tree produced by the {@code someClause}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterSomeClause(@NotNull XQueryParser.SomeClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code someClause}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitSomeClause(@NotNull XQueryParser.SomeClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code absolutePath}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutePath(@NotNull XQueryParser.AbsolutePathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code absolutePath}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutePath(@NotNull XQueryParser.AbsolutePathContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#sl}.
	 * @param ctx the parse tree
	 */
	void enterSl(@NotNull XQueryParser.SlContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#sl}.
	 * @param ctx the parse tree
	 */
	void exitSl(@NotNull XQueryParser.SlContext ctx);

	/**
	 * Enter a parse tree produced by the {@code emptyQuery}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEmptyQuery(@NotNull XQueryParser.EmptyQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyQuery}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEmptyQuery(@NotNull XQueryParser.EmptyQueryContext ctx);

	/**
	 * Enter a parse tree produced by the {@code pathIdEq}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPathIdEq(@NotNull XQueryParser.PathIdEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathIdEq}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPathIdEq(@NotNull XQueryParser.PathIdEqContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXquery(@NotNull XQueryParser.XqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXquery(@NotNull XQueryParser.XqueryContext ctx);

	/**
	 * Enter a parse tree produced by the {@code pairQuery}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterPairQuery(@NotNull XQueryParser.PairQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pairQuery}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitPairQuery(@NotNull XQueryParser.PairQueryContext ctx);

	/**
	 * Enter a parse tree produced by the {@code attTest}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterAttTest(@NotNull XQueryParser.AttTestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attTest}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitAttTest(@NotNull XQueryParser.AttTestContext ctx);

	/**
	 * Enter a parse tree produced by the {@code tagName}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterTagName(@NotNull XQueryParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tagName}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitTagName(@NotNull XQueryParser.TagNameContext ctx);

	/**
	 * Enter a parse tree produced by the {@code firstFunc}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterFirstFunc(@NotNull XQueryParser.FirstFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code firstFunc}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitFirstFunc(@NotNull XQueryParser.FirstFuncContext ctx);

	/**
	 * Enter a parse tree produced by the {@code orCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterOrCond(@NotNull XQueryParser.OrCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orCond}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitOrCond(@NotNull XQueryParser.OrCondContext ctx);

	/**
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull XQueryParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link XQueryParser#query}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull XQueryParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(@NotNull XQueryParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(@NotNull XQueryParser.ForClauseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code self}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterSelf(@NotNull XQueryParser.SelfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code self}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitSelf(@NotNull XQueryParser.SelfContext ctx);

	/**
	 * Enter a parse tree produced by the {@code pathWithFilter}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterPathWithFilter(@NotNull XQueryParser.PathWithFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathWithFilter}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitPathWithFilter(@NotNull XQueryParser.PathWithFilterContext ctx);

	/**
	 * Enter a parse tree produced by the {@code negatvePathFilter}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterNegatvePathFilter(@NotNull XQueryParser.NegatvePathFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negatvePathFilter}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitNegatvePathFilter(@NotNull XQueryParser.NegatvePathFilterContext ctx);

	/**
	 * Enter a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(@NotNull XQueryParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(@NotNull XQueryParser.AttNameContext ctx);

	/**
	 * Enter a parse tree produced by the {@code pathValueEq}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPathValueEq(@NotNull XQueryParser.PathValueEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pathValueEq}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPathValueEq(@NotNull XQueryParser.PathValueEqContext ctx);
}