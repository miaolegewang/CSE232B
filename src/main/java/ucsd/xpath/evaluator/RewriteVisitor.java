package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.misc.NotNull;

import ucsd.xpath.navigation.NavNode;

public class RewriteVisitor extends XQueryBaseVisitor<String>{
	private HashMap<String, NavNode> root;
	private String tupleName = "taylorSwift";
	private HashMap<String, Pair> joinConditions;
	private HashMap<String, Integer> rootNodes;
	boolean fromReturnClause;
	
	
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
	    Stack<NavNode> st = new Stack<>();
	    st.push(root);
	    String result = "\nfor ";
	    List<String> fors = new ArrayList<>();
	    List<String> conditions = new ArrayList<>();
	    List<String> varList = new ArrayList<>();
	    
	    // for clause
	    while(!st.empty()){
	        NavNode node = st.pop();
	        fors.add(node.name() + " in " + node.edge());
	        varList.add(node.name().substring(1));
	        for(NavNode n: node.childrenList())
	        	st.push(n);
	        for(NavNode n : node.condition()){
	        	conditions.add(" " + node.name() + " = " + n.name() + " ");
	        }
	    }
	    result += joinList(fors, ",\n") + "\n";
	    
	    // where clause
	    result += "where" + joinList(conditions, " and ") + "\n";
	     
	    // return clause
	    List<String> returns = new ArrayList<>();
	    for(String varName : varList){
	    	returns.add(" <" + varName + ">{$" + varName + "}</" + varName + "> ");
	    }
	    result += "return <tuple>{" + joinList(returns, ",") + "}</tuple>\n";
	    return result;
	}
	
	private String joinList(List<String> attrs, String delimiter){
		String tmp = "";
		for(int i = 0; i < attrs.size(); i++){
			if(i > 0){
				tmp += delimiter;
			}
			tmp += attrs.get(i);
		}
		return tmp;
	}
	
	private String pairToString(Pair p){
		if(p.first.compareTo(p.second) < 0){
			return p.first + "-" + p.second;
		} else return p.second + "-" + p.first;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXquery(@NotNull XQueryParser.XqueryContext ctx) {
		root = new HashMap<>();
		joinConditions = new HashMap<>();
		rootNodes = new HashMap<>();
		return visit(ctx.query());
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFlwr(@NotNull XQueryParser.FlwrContext ctx) {
		fromReturnClause = false;
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
		} else rootNodes.put(var, rootNodes.size());
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
		if(fromReturnClause){
			return visit(ctx.query()) + "/" + ctx.relativePath().getText();
		} else {
			String tmp = visit(ctx.query());
			if(tmp != null && !tmp.isEmpty()){
				return tmp;
			} else return null;
		}
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitDescendant(@NotNull XQueryParser.DescendantContext ctx) {
		if(fromReturnClause){
			return visit(ctx.query()) + "//" + ctx.relativePath().getText();
		} else {
			String tmp = visit(ctx.query());
			if(tmp != null && !tmp.isEmpty()){
				return tmp;
			} else return null;
		}
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitVariable(@NotNull XQueryParser.VariableContext ctx) {
		if(fromReturnClause){
			return "$" + tupleName + "/" + ctx.var().varName().getText() + "/*";
		}
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
		String fc = "for ";
		HashMap<String, HashSet<Pair>> joinMap = new HashMap<>();		// To avoid duplicate join conditions
		HashMap<String, Pair> tmpJoinConditions = new HashMap<>(joinConditions);
		for(String pStr : tmpJoinConditions.keySet()){
			Pair p = tmpJoinConditions.get(pStr);
			Pair r = new Pair(root.get(p.first).root().name(), root.get(p.second).root().name());
			String rStr = pairToString(r);
			if(joinConditions.containsKey(rStr)){
				joinMap.get(rStr).add(p);
			} else {
				HashSet<Pair> tmp = new HashSet<>();
				tmp.add(p);
				joinMap.put(rStr, tmp);
				joinConditions.put(rStr, r);
			}
		}
		
		// Produce For clause for every root node
		HashMap<Integer, String> joinStatement = new HashMap<>();
		for(String rootNode : rootNodes.keySet()){
			joinStatement.put(rootNodes.get(rootNode), "(" + printForLoop(root.get(rootNode)) + ")");
		}
		
		// Produce join statement
		for(String rStr: joinMap.keySet()){
			Pair r = joinConditions.get(rStr);
			String firstForClause = joinStatement.get(rootNodes.get(r.first));
			String secondForClause = joinStatement.get(rootNodes.get(r.second));
			List<String> firstAttrs = new ArrayList<>(), secondAttrs = new ArrayList<>();
			for(Pair attr : joinMap.get(rStr)){
				if(root.get(attr.first).root().name().equals(r.first)){
					firstAttrs.add(attr.first);
					secondAttrs.add(attr.second);
				} else {
					firstAttrs.add(attr.second);
					secondAttrs.add(attr.first);
				}
			}
			String joinClause = "join(\n " + firstForClause + ",\n " + secondForClause + ",\n ["
							  + joinList(firstAttrs, ",") + "], [" + joinList(secondAttrs, ",") + "])\n";
			joinStatement.remove(rootNodes.get(r.first));
			joinStatement.remove(rootNodes.get(r.second));
			int idx = Math.min(rootNodes.get(r.first), rootNodes.get(r.second));
			System.out.println(joinClause);
			joinStatement.put(idx, joinClause);
			rootNodes.put(r.first, idx);
			rootNodes.put(r.second, idx);
		}
		
		// Handling Cartesian product
		Stack<String> joinStatementList = new Stack<>();
		for(String query : joinStatement.values()){
			joinStatementList.push(query);
		}
		while(joinStatementList.size() > 1){
			String first = joinStatementList.pop(),
				   second = joinStatementList.pop();
			joinStatementList.push("join(" + first + ", " + second +  "[], [])");
		}
		fc += "$" + tupleName + " in " + joinStatementList.peek() + "\n";
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
		if(!first.equals("const") && !second.equals("const") && root.get(first).root() != root.get(second).root()){
			Pair tmp = new Pair(first, second);
			joinConditions.put(pairToString(tmp), tmp);
		} else if(first.equals("const") || second.equals("const") || root.get(first).root() == root.get(second).root()){
			String varName = first.equals("const") ? second : first;
			String constStr = first.equals("const") ? first : second;
			NavNode tmp = constStr.equals("const") ? new NavNode(NavNode.CONSTANT_NODE, ctx.query(1).getText()) : root.get(constStr);
			root.get(varName).addCond(tmp);
		}
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
	@Override public String visitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx) {
		fromReturnClause = true;
		String tmp = visit(ctx.query());
		fromReturnClause = false;
		return tmp;
	}
	
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFormat(@NotNull XQueryParser.FormatContext ctx) { 
		if(fromReturnClause){
			String tagName = ctx.tag(0).getText();
			String tmp = visit(ctx.query());
			return "<" + tagName + ">{" + tmp + "}</" + tagName + ">";
		} else return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPairQuery(@NotNull XQueryParser.PairQueryContext ctx) {
		if(fromReturnClause){
			return visit(ctx.query(0)) + ", " + visit(ctx.query(1));
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPriority(@NotNull XQueryParser.PriorityContext ctx) {
		return "(" + visit(ctx.query()) + ")";
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitXpath(@NotNull XQueryParser.XpathContext ctx) { return "doc"; }
	
}


	
