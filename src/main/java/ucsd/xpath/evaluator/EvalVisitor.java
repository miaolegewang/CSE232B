package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ucsd.xpath.evaluator.XQueryParser.AssContext;
import ucsd.xpath.evaluator.XQueryParser.BindContext;
import ucsd.xpath.xmlparser.DomParser;

public class EvalVisitor extends XQueryBaseVisitor<List<Node>>{
	
	HashMap<String, List<Node>> variables = new HashMap<String, List<Node>>();
	
	List<Node> r;
	
	Document doc;
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitXquery(@NotNull XQueryParser.XqueryContext ctx) {
		try{
	    	DocumentBuilder builder = factory.newDocumentBuilder();
	    	doc = builder.newDocument();
	    } catch (ParserConfigurationException parserException) {
	        parserException.printStackTrace();
	    }
		List<Node> test = visit(ctx.query());
		if(test != null)
			System.out.println("Success");
		else System.out.println("Fail");
		return test;
	}
		
	
	/*
	 * ============================
	 * Internal use function
	 * ============================
	 */
	private void iterateFLWR(XQueryParser.FlwrContext ctx, int level, List<Node> results){
		if(level == ctx.forClause().bindings().bind().size()){
			// All variables has been traversed
			HashMap<String, List<Node>> backup = new HashMap<String, List<Node>>(variables);
			
//			if(ctx.whereClause().isEmpty() || visit(ctx.whereClause()).isEmpty()){ // Question: the first one shoudln't be with !? and should be OR?
//				// where condition fails, do not add new content
//				return;
//			}
			
			results.addAll(visit(ctx.returnClause()));
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
				
		iterateFLWR(ctx, 0, localResult);
		
		for(Node node: localResult){
			System.out.println("####");
			System.out.println(node.getNodeName().toString());
		}
		
		variables = backup;
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

	
	/*
	 * =======================================
	 * Cond Implementation
	 * =======================================
	 */	

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
	@Override public List<Node> visitQueryValueEq(@NotNull XQueryParser.QueryValueEqContext ctx) { 
		List<Node> q1 = visit(ctx.query(0));
		List<Node> q2 = visit(ctx.query(1));
		List<Integer> checkq1 = new ArrayList<Integer>();
		List<Integer> checkq2 = new ArrayList<Integer>();
		
		if(q1.size() != q2.size())	return null;
		
		for(int i = 0; i < q1.size(); i++){
			for(int j = 0; j < q2.size(); j++){
				if(q1.get(i).isEqualNode(q2.get(j)) && !checkq1.contains(new Integer(i)) && !checkq2.contains(new Integer(j)) ){
					checkq1.add(i);
					checkq2.add(j);
				}
			}
		}
		
		return checkq1.size() == q1.size() ? q1: null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitQueryIDEq(@NotNull XQueryParser.QueryIDEqContext ctx) {
		List<Node> q1 = visit(ctx.query(0));
		List<Node> q2 = visit(ctx.query(1));
		List<Integer> checkq1 = new ArrayList<Integer>();
		List<Integer> checkq2 = new ArrayList<Integer>();
		
		if(q1.size() != q2.size())	return null;
		
		for(int i = 0; i < q1.size(); i++){
			for(int j = 0; j < q2.size(); j++){
				if(q1.get(i).isSameNode(q2.get(j)) && !checkq1.contains(new Integer(i)) && !checkq2.contains(new Integer(j)) ){
					checkq1.add(i);
					checkq2.add(j);
				}
			}
		}
		
		return checkq1.size() == q1.size() ? q1: null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitEmptyQuery(@NotNull XQueryParser.EmptyQueryContext ctx) { 
		List<Node> q = visit(ctx.query());
		return q.isEmpty() ? null: q;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitSomeClause(@NotNull XQueryParser.SomeClauseContext ctx) {
		List<BindContext> binds = ctx.bindings().bind();
		HashMap<String, List<Node>> backup = variables;
		
		List<Node> conditions = visit(ctx.cond());
		List<Node> result = new ArrayList<Node>();
		
		for(BindContext b: binds){
			String var = b.var().varName().getText().toString();
			List<Node> c;
			if(variables.containsKey(var)){
				c = variables.get(var);
			}else{
				c = visit(b.query());
				variables.put(var, c);
			}
			
			List<Node> q = visit(b.query());
			Boolean flag = true;
			for(Node n: q){
				if(!c.contains(n)){
					flag = false;
					break;
				}
			}

		}
		
		
		variables = backup;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitAndCond(@NotNull XQueryParser.AndCondContext ctx) {
		List<Node> c1 = visit(ctx.cond(0));
		List<Node> c2 = visit(ctx.cond(1));
		List<Node> result = new ArrayList<Node>();
		
		for(Node n1: c1){
			for(Node n2: c2){
				if(n1.isEqualNode(n2) && !result.contains(n1)){
					result.add(n1);
				}
			}
		}
		return result;	
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitOrCond(@NotNull XQueryParser.OrCondContext ctx) { 
		List<Node> c1 = visit(ctx.cond(0));
		List<Node> c2 = visit(ctx.cond(1));
		List<Node> result = new ArrayList<Node>();
		
		for(Node n1: c1){
			if(!result.contains(n1)){
				result.add(n1);
			}
		}
		for(Node n2: c2){
			if(!result.contains(n2)){
				result.add(n2);
			}
		}
		return result;
	}

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitNotCond(@NotNull XQueryParser.NotCondContext ctx) { 
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
	@Override public List<Node> visitFormat(@NotNull XQueryParser.FormatContext ctx) {
		String tagname = ctx.tag(0).getText();
	    Node n = doc.createElement(tagname);
	    List<Node> tmp = visit(ctx.query());
	    for(Node local: tmp){
	    	n.appendChild(doc.importNode(local, true));
	    }
	    return new ArrayList<Node>(Arrays.asList(n));
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
	@Override public List<Node> visitAp(@NotNull XQueryParser.ApContext ctx) {
		List<Node> result = new ArrayList<Node>();
		String fname = ctx.FILENAME().getText();
		result.add((Node)DomParser.parse(fname.substring(1, fname.length() - 1)));
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitXpath(@NotNull XQueryParser.XpathContext ctx) {
		r = visit(ctx.ap());
		Document root = (Document)r.get(0);
		r.remove(0);
		r.add(root.getDocumentElement());
		if(!ctx.dsl().isEmpty()){
			visit(ctx.dsl());
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
	
	@Override public List<Node> visitDsl(@NotNull XQueryParser.DslContext ctx) {
		System.out.println(r.size());
		
		for(int startIdx = 0; startIdx < r.size(); startIdx++){
			Node tmp = r.get(startIdx);
			NodeList children = tmp.getChildNodes();
			for(int i = 0; i < children.getLength(); i++){
				if(!listContainsElement(r, children.item(i)))
					r.add(children.item(i));
			}
		}
		
		System.out.println("Size of children");
		System.out.println(r.size());
		
		return null;
	}
	
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
