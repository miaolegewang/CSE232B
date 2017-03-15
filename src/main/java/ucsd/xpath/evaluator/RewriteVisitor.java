package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

import ucsd.xpath.navigation.NavNode;

public class RewriteVisitor extends XQueryBaseVisitor<String>{
	private HashMap<String, NavNode> root;
	private String tupleName = "taylorSwift";
	private List<Pair> joinConditions;
	
	
	/*
	 * ====================================
	 * Helper Class and Functions
	 * ====================================
	 */
	private class Pair{
		public String first;
		public String second;
		public Pair(String first, String second){
			this.first = first;
			this.second = second;
		}
		@Override public int hashCode(){
			if(first.compareTo(second) < 0)
				return (first + second).hashCode();
			else return (second + first).hashCode();
		}
		public boolean equals(Pair p){
			return (first.equals(p.first) && second.equals(p.second)) ||
					(second.equals(p.first) && first.equals(p.second));
		}
	}
	
	// Print root node using dfs
	private String printForLoop(NavNode root){
		NavNode temp = root;
		return "TODO";
	}
	
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXquery(@NotNull XQueryParser.XqueryContext ctx) {
		this.root = new HashMap<>();
		this.joinConditions = new ArrayList<>();
		return visit(ctx.query());
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFlwr(@NotNull XQueryParser.FlwrContext ctx) {
		if(ctx.whereClause() == null || ctx.letClause() != null)
			return null;
		visit(ctx.forClause());
		String forClause = visit(ctx.whereClause());
		String returnClause = visit(ctx.returnClause());
		return forClause + "\n" + returnClause;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitForClause(@NotNull XQueryParser.ForClauseContext ctx) {
		visit(ctx.bindings());
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitBindings(@NotNull XQueryParser.BindingsContext ctx) {
		for(XQueryParser.BindContext tx : ctx.bind()){
			visit(tx);
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitBind(@NotNull XQueryParser.BindContext ctx) {
		String var = ctx.var().getText();
		String tmp = visit(ctx.query());
		NavNode node = new NavNode(NavNode.VARIABLE_NODE, var, ctx.query().getText());
		if(!tmp.equals("doc")){
			root.get(tmp).addChild(var, node);
		}
		root.put(var, node);
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitChild(@NotNull XQueryParser.ChildContext ctx) {
		String tmp = visit(ctx.query());
		if(tmp != null && !tmp.isEmpty()){
			return tmp;
		} else return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitDescendant(@NotNull XQueryParser.DescendantContext ctx) {
		String tmp = visit(ctx.query());
		if(tmp != null && !tmp.isEmpty()){
			return tmp;
		} else return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitVariable(@NotNull XQueryParser.VariableContext ctx) {
		return ctx.var().getText();
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * Visiting WhereClause will return a forClause string so that it contains for xxx in join(...)
	 * 
	 */
	@Override public String visitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx) {
		visit(ctx.cond());
		String fc;
		HashMap<Pair, HashSet<Pair>> joinMap = new HashMap<>();		// To avoid duplicate join conditions
		for(Pair p : joinConditions){
			Pair r = new Pair(root.get(p.first).root().name(), root.get(p.second).root().name());
			if(joinMap.containsKey(r)){
				joinMap.get(r).add(p);
			} else {
				HashSet<Pair> tmp = new HashSet<>();
				tmp.add(p);
				joinMap.put(r, tmp);
			}
		}
		HashMap<String, String> joinStatement = new HashMap<>();
		for(Pair r: joinMap.keySet()){
			String firstForClause = printForLoop(r.first)
		}
		return fc;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * TODO: 
	 * 		1. Restrict where clause: only optimize the query whose where condition only involves (var|const) = (var|const)
	 * 		2. Handle illegal conditions: e.g. undefined variables
	 */
	@Override public String visitQueryValueEq(@NotNull XQueryParser.QueryValueEqContext ctx) {
		String first = visit(ctx.query(0));
		String second = visit(ctx.query(1));
		if(first.equals("const") || second.equals("const")){
			String varName = first.equals("const") ? second : first;
			String constStr = first.equals("const") ? first : second;
			root.get(varName).addCond(new NavNode(NavNode.CONSTANT_NODE, constStr));
		} else joinConditions.add(new Pair(first, second));
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAndCond(@NotNull XQueryParser.AndCondContext ctx) {
		visit(ctx.cond(0));
		visit(ctx.cond(1));
		return null;
	}

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitStringConst(@NotNull XQueryParser.StringConstContext ctx) { return "const"; }
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx) { return visitChildren(ctx); }


	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXpath(@NotNull XQueryParser.XpathContext ctx) { return "doc"; }
	
	
	
}


	
