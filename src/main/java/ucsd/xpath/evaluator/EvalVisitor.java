package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ucsd.xpath.evaluator.XQueryParser.AssContext;
import ucsd.xpath.evaluator.XQueryParser.BindContext;
import ucsd.xpath.xmlparser.DomParser;

public class EvalVisitor extends XQueryBaseVisitor<List<Node>>{
	
	HashMap<String, List<Node>> variables = new HashMap<String, List<Node>>();
	
	List<Node> r;
	
	
	/*
	 * ============================
	 * Internal use function
	 * ============================
	 */
	
//	private void iterateFLWR(XQueryParser.FlwrContext ctx, int level, List<Node> results){
//		if(level == ctx.forClause().bindings().bind().size()){
//			// All variables has been traversed
//			HashMap<String, List<Node>> backup = new HashMap<String, List<Node>>(variables);
//			visit(ctx.letClause());
//			if(ctx.whereClause().isEmpty() || visit(ctx.whereClause()).isEmpty()){ // Question: the first one shoudln't be with !? and should be OR?
//				// where condition fails, do not add new content
//				return;
//			}
//			Node newNode = visit(ctx.returnClause()).get(0);
//			results.add(newNode);
//			variables = backup;
//		} else {
//			String varName = ctx.forClause().bindings().bind(level).var().varName().getText();
//			for(Node n: visit(ctx.forClause().bindings().bind(level).query())){
//				variables.put(varName, new ArrayList<>(Arrays.asList(n)));
//				iterateFLWR(ctx, level + 1, results);
//			}
//		}
//	}

	private void iterateFLWR(XQueryParser.FlwrContext ctx, int level, List<Node> results){
		if(level == 0){
			System.out.println(ctx.forClause().bindings().bind(level).var().varName().getText());
		}
		if(level == ctx.forClause().bindings().bind().size()){
			// All variables has been traversed
			HashMap<String, List<Node>> backup = new HashMap<String, List<Node>>(variables);
			visit(ctx.letClause());
			if(ctx.whereClause().isEmpty() || visit(ctx.whereClause()).isEmpty()){ // Question: the first one shoudln't be with !? and should be OR?
				// where condition fails, do not add new content
				return;
			}
			Node newNode = visit(ctx.returnClause()).get(0);
			results.add(newNode);
			variables = backup;
		} else {
			String varName = ctx.forClause().bindings().bind(level).var().varName().getText();
			List<Node> varQuery = visit(ctx.forClause().bindings().bind(level).query());
			for(Node n: varQuery){
				variables.put(varName, new ArrayList<>(Arrays.asList(n)));
				iterateFLWR(ctx, level + 1, results);
			}
		}
	}
	
	private boolean isEqualList(List<Node> a, List<Node> b, boolean value){
		if(a.size() != b.size())
			return false;
		List<Node> tmp1 = new ArrayList<Node>(a);
		List<Node> tmp2 = new ArrayList<Node>(b);
		while(!tmp1.isEmpty()){
			for(int i = 0; i < tmp2.size(); i++){
				if((value && tmp2.get(i).isEqualNode(tmp1.get(0))) || (!value && tmp2.get(i).isSameNode(tmp1.get(0)))){
					tmp2.remove(i);
					break;
				}
			}
			tmp1.remove(0);
			if(tmp1.size() != tmp2.size())
				return false;
		}
		return true;
	}
	
	private boolean listContainsElement(List<Node> list, Node target){
		for(Node node: list){
			if(node.isSameNode(target))
				return true;
		}
		return false;
	}
	
	/*
	 * =======================================
	 * XQuery Implementation
	 * =======================================
	 */
	
	@Override public List<Node> visitFlwr(@NotNull XQueryParser.FlwrContext ctx) {
		HashMap<String, List<Node>> backup = new HashMap<String, List<Node>>(variables);
		List<Node> localResult = new ArrayList<Node>();
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^");
		
		iterateFLWR(ctx, 0, localResult);
		variables = backup;
		
		for(Node node: localResult){
			System.out.println("####");
			System.out.println(node.getNodeName().toString());
		}
		
		return localResult;
	}
	
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitLet(@NotNull XQueryParser.LetContext ctx) {
		HashMap<String, List<Node>> backup = new HashMap<String, List<Node>>(variables);		
		visit(ctx.letClause()); // Question: when visit letclause, how to assign varialbe with certain list node;
		List<Node> result = visit(ctx.query());
		variables = backup;
		return result;
	}
	
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitLetClause(@NotNull XQueryParser.LetClauseContext ctx) { 
		List<AssContext> allAssign = ctx.assignments().ass();
		for(AssContext as: allAssign){
			variables.put(as.var().varName().getText(), visit(as.query()));
		}
		return null;
	}

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitWhereClause(@NotNull XQueryParser.WhereClauseContext ctx) {
		return visit(ctx.cond());
	}
	
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx) {
		return visit(ctx.query());
	}
		
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitPairQuery(@NotNull XQueryParser.PairQueryContext ctx) {
		List<Node> result = visit(ctx.query(0));
		result.addAll(visit(ctx.query(1)));
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitVariable(@NotNull XQueryParser.VariableContext ctx) {
		return variables.getOrDefault(ctx.var().varName().getText(), new ArrayList<Node>());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitAbsolutePath(@NotNull XQueryParser.AbsolutePathContext ctx) {		
		List<Node> result = new ArrayList<Node>();
		String fname = ctx.ap().FILENAME().getText();
		result.add((Node)DomParser.parse(fname.substring(1, fname.length() - 1)));
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitChild(@NotNull XQueryParser.ChildContext ctx) {
		r = visit(ctx.query());
		String fullString = ctx.relativePath().getText();
		if(!(fullString.length() >= 1 && fullString.charAt(0) == '.')){
			// Want to check if the first two characters are ".." or '.'. If yes, then do not need to update array r by its descendants 
			visit(ctx.getChild(1));
		}
		visit(ctx.relativePath());
		return r;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	@Override public List<Node> visitDescendant(@NotNull XQueryParser.DescendantContext ctx) {
		r = visit(ctx.query());
		visit(ctx.dsl());
		visit(ctx.relativePath());
		return r;
	}
	*/
	/*
	 * =======================================
	 * XPATH : RelativePath implementation
	 * =======================================
	 */
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	
	/*
	@Override public List<Node> visitSl(@NotNull XQueryParser.SlContext ctx) {
		List<Node> tmp = new ArrayList<Node>(r);
		r.clear();
		for(int i = 0; i < tmp.size(); i++){
			NodeList children = tmp.get(i).getChildNodes();
			for(int j = 0; j < children.getLength(); j++){
				r.add(children.item(j));
			}
		}
		return null;
	}
	*/
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	@Override public List<Node> visitDsl(@NotNull XQueryParser.DslContext ctx) {
		for(int startIdx = 0; startIdx < r.size(); startIdx++){
			Node tmp = r.get(startIdx);
			NodeList children = tmp.getChildNodes();
			for(int i = 0; i < children.getLength(); i++){
				if(!listContainsElement(r, children.item(i)))
					r.add(children.item(i));
			}
		}
		return null;
	}
	*/
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitParent(@NotNull XQueryParser.ParentContext ctx) {
		List<Node> tmp = new ArrayList<Node>();
		
		for(int i = 0; i < r.size(); i++){
			Node localNode = r.get(i).getParentNode();
			if(localNode != null && !listContainsElement(tmp, localNode)){
				tmp.add(localNode);
			}
		}
		r = tmp;
		
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitTagName(@NotNull XQueryParser.TagNameContext ctx) { 
		
		
		for(int i = 0; i < r.size();){
			if(r.get(i).getNodeType() != Node.ELEMENT_NODE || !r.get(i).getNodeName().equals(ctx.getText()) ){
				r.remove(i);
			} else i++;
		}
		
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitPathSequence(@NotNull XQueryParser.PathSequenceContext ctx) {
		List<Node> tmp = new ArrayList<Node>(r);
		visit(ctx.relativePath(1));
		List<Node> r1 = new ArrayList<Node>(r);
		r = tmp;
		visit(ctx.relativePath(0));
		// Add nodes in r1, need to verify that the node does not exist in result before adding it to the list
		for(Node node: r1){
			if(!listContainsElement(r, node)){
				r.add(node);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * This function handles a visit on any node that has the form "@attribute"
	 * It removes all the nodes that are not attribute nodes in the list
	 */
	@Override public List<Node> visitAttName(@NotNull XQueryParser.AttNameContext ctx) {
		for(int i = 0; i < r.size();){
			if(r.get(i).getNodeType() != Node.ATTRIBUTE_NODE || !r.get(i).getNodeName().equals(ctx.getText())){
				r.remove(i);
			} else i++;
		}
		return visitChildren(ctx);
	}
	
	/**
	 *
	 * This function handles a visit on text node when meeting "text()"
	 * It removes all the nodes that are not text nodes in the list
	 */
	@Override public List<Node> visitText(@NotNull XQueryParser.TextContext ctx) {
		for(int i = 0; i < r.size(); ){
			if(r.get(i).getNodeType() != Node.TEXT_NODE ){
				r.remove(i);
			} else i++;
		}
		return visitChildren(ctx);
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitDescendantExistence(@NotNull XQueryParser.DescendantExistenceContext ctx) {
		List<Node> nodes = new ArrayList<Node>(r);
		r.clear();
		for(int i = 0; i < nodes.size();){
			r.add(nodes.get(i));
			visit(ctx.relativePath());
			if(r.size() == 0){
				nodes.remove(i);
			} else i++;
			r.clear();
		}
		r = nodes;
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitNegatvePathFilter(@NotNull XQueryParser.NegatvePathFilterContext ctx) {
		List<Node> nodes = new ArrayList<Node>(r);
		visit(ctx.pathFilter());
		for(int i = 0; i < r.size(); i++){
			nodes.remove(r.get(i));
		}
		r = nodes;
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitAndFilter(@NotNull XQueryParser.AndFilterContext ctx) {
		List<Node> nodes = new ArrayList<Node>(r);
		visit(ctx.pathFilter(0));
		List<Node> r1 = new ArrayList<Node>(r);
		r = nodes;
		visit(ctx.pathFilter(1));
		for(int i = 0; i < r.size();){
			if(!r1.contains(r.get(i))){
				r.remove(i);
			} else i++;
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitOrFilter(@NotNull XQueryParser.OrFilterContext ctx) {
		List<Node> nodes = new ArrayList<Node>(r);
		visit(ctx.pathFilter(0));
		List<Node> r1 = new ArrayList<Node>(r);
		r = nodes;
		visit(ctx.pathFilter(1));
		for(int i = 0; i < r1.size(); i++){
			if(!r.contains(nodes.get(i))){
				r.add(nodes.get(i));
			}
		}
		return null;
	} 
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitPathIdEq(@NotNull XQueryParser.PathIdEqContext ctx) {
		List<Node> nodes = new ArrayList<Node>(r);
		for(int i = 0; i < nodes.size(); ){
			r.clear();
			r.add(nodes.get(i));
			visit(ctx.relativePath(0));
			List<Node> r1 = new ArrayList<Node>(r);
			r.clear();
			r.add(nodes.get(i));
			visit(ctx.relativePath(1));
			if(!isEqualList(r, r1, false)){
				nodes.remove(i);
				continue;
			}
			i++;
		}
		r = nodes;
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitPathValueEq(@NotNull XQueryParser.PathValueEqContext ctx) {
		List<Node> nodes = new ArrayList<Node>(r);
		for(int i = 0; i < nodes.size(); ){
			r.clear();
			r.add(nodes.get(i));
			visit(ctx.relativePath(0));
			List<Node> r1 = new ArrayList<Node>(r);
			r.clear();
			r.add(nodes.get(i));
			visit(ctx.relativePath(1));
			if(!isEqualList(r, r1, true)){
				System.out.println(nodes.get(i).getNodeName());
				nodes.remove(i);
				continue;
			}
			i++;
		}
		r = nodes;
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitDescendantPath(@NotNull XQueryParser.DescendantPathContext ctx) {
		visit(ctx.relativePath(0));
		String className = ctx.relativePath(1).getClass().getSimpleName();
		if(!className.equals("ParentContext") && !className.equals("SelfContext")){
			visit(ctx.getChild(1));
		}
		visit(ctx.relativePath(1));
		return null;
	}
	

}
