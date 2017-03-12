package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ucsd.xpath.evaluator.XQueryParser.AssContext;
import ucsd.xpath.evaluator.XQueryParser.BindContext;
import ucsd.xpath.evaluator.XQueryParser.WhereClauseContext;
import ucsd.xpath.xmlparser.DomParser;

public class EvalVisitor extends XQueryBaseVisitor<List<Node>>{
	
	HashMap<String, List<Node>> variables = new HashMap<String, List<Node>>();
	
	List<Node> r;
	
	Document doc;

	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitXquery(@NotNull XQueryParser.XqueryContext ctx) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
	    	DocumentBuilder builder = factory.newDocumentBuilder();
	    	doc = builder.newDocument();
	    } catch (ParserConfigurationException parserException) {
	        parserException.printStackTrace();
	    }
		List<Node> test = visit(ctx.query());
		return test;
	}
	
	/*
	 * ============================
	 * Internal use function
	 * ============================
	 */
	
	private String printXML(Node target){
		return "";
	}
	
	private List<String> transform(XQueryParser.AttrsContext ctx){
		List<String> result = new ArrayList<String>();
		for(XQueryParser.AttrContext at: ctx.attr()){
			result.add(at.getText());
		}
		return result;
	}
	
	private List<Node> findChild(Node target){
		List<Node> result = new ArrayList<Node>();
		NodeList children = target.getChildNodes();
		for(int i = 0; i < children.getLength(); i++){
			result.add(children.item(i));
		}
		return result;
	}
	
	private String convertChildren(Node target, List<String> attrs){
		Element result = doc.createElement("container");
		for(String att: attrs){
			NodeList children = target.getChildNodes();
			for(int i = 0; i < children.getLength(); i++){
				if(children.item(i).getNodeType() == Node.ELEMENT_NODE && children.item(i).getNodeName().equals(att)){
					Element root = doc.createElement("result");
					NodeList tmpChild = children.item(i).getChildNodes();
					for(int j = 0; j < tmpChild.getLength(); j++){
						root.appendChild(doc.importNode(tmpChild.item(j), true));
					}
					result.appendChild(root);
				}
			}
		}
		return convertNodeToString(result);
	}
	
	private void iterateFLWR(XQueryParser.FlwrContext ctx, int level, List<Node> results){
		if(level == ctx.forClause().bindings().bind().size()){
			HashMap<String, List<Node>> backup = new HashMap<String, List<Node>>(variables);
			// All variables has been traversed
			if(ctx.letClause() != null)
				visit(ctx.letClause());
			
			if(ctx.whereClause() != null && visit(ctx.whereClause()).size() == 0){ // Question: the first one shoudln't be with !? and should be OR?
				// where condition fails, do not add new content
				return;
			}
			results.addAll(visit(ctx.returnClause()));
			variables.clear();
			variables.putAll(backup);
		} else {
			String varName = ctx.forClause().bindings().bind(level).var().varName().getText();
			List<Node> varQuery = new ArrayList<Node>(visit(ctx.forClause().bindings().bind(level).query()));
			for(Node n: varQuery){
				variables.put(varName, new ArrayList<>(Arrays.asList(n)));
				iterateFLWR(ctx, level + 1, results);
			}
		}
	}
	
	private boolean iterateSome(XQueryParser.SomeClauseContext ctx, int level){
		if(level == ctx.bindings().bind().size()){
			List<Node> tmp = visit(ctx.cond());
			return !tmp.isEmpty();
		} else {
			List<Node> tmp = visit(ctx.bindings().bind(level).query());
			if(tmp.isEmpty()){
				return iterateSome(ctx, level + 1);
			}
			for(Node n : tmp){
				variables.put(ctx.bindings().bind(level).var().varName().getText(), new ArrayList<Node>(Arrays.asList(n)));
				if(iterateSome(ctx, level + 1)){
					return true;
				}
			}
			return false;
		}
	}
	
	private boolean isEqualList(List<Node> a, List<Node> b, boolean value){
		// value: True - Value equality; false - identity equality
		List<Node> tmp1 = new ArrayList<Node>(a);
		List<Node> tmp2 = new ArrayList<Node>(b);
		for(Node n1 : tmp1){
			for(Node n2 : tmp2){
				if((value && n1.isEqualNode(n2)) || (!value && n1.isSameNode(n2)))
					return true;
			}
		}
		return false;
	}
	
	private boolean listContainsElement(List<Node> list, Node target){
		for(Node node: list){
			if(node.isSameNode(target))
				return true;
		}
		return false;
	}
	
	/*
	 * This function will have the same effect as visitParent
	 */
	private void backToParent(){
		List<Node> tmp = new ArrayList<Node>();
		
		for(int i = 0; i < r.size(); i++){
			if(r.get(i).getNodeType() == Node.ATTRIBUTE_NODE){
				Node localNode = ((Attr)r.get(i)).getOwnerElement();
				if(localNode != null)
					tmp.add(localNode);
			} else {
				Node localNode = r.get(i).getParentNode();
				if(localNode != null && localNode.getNodeType() != Node.DOCUMENT_NODE && !listContainsElement(tmp, localNode)){
					tmp.add(localNode);
				}
			}
		}
		r = tmp;
	}
	
	private String convertNodeToString(Node root){
		String result = "";
		NodeList allChildren = root.getChildNodes();
		if(allChildren.getLength() == 0){
			return result;
		}else{
			result += root.getNodeName() + root.getTextContent();
			for(int i = 0; i < allChildren.getLength(); i++){
				result += convertNodeToString(allChildren.item(i));
			}
			return result;
		}
		
	}
	
	/*
	 * =======================================
	 * Join Implementation
	 * =======================================
	 */
	/**
	 * Implement instructions:
	 * 	1. evaluate both queries
	 *  2. store the attributes of the sequence with smaller number into hashmap
	 *  3. for each node of the other sequence, if the value of attributes is stored in hashmap, pair up
	 *  4. for each tuple, combine all the child nodes
	 *  5. return the result list
	 *  
	 * Bug:
	 * 	Return empty list
	 * 	My guess is when invoking containsKey(), it uses equals which may call isSameNode instead of isEqualNode
	 */
	@Override public List<Node> visitJoin(@NotNull XQueryParser.JoinContext ctx) {
		HashMap<String, List<Node>> hashJoin = new HashMap<String, List<Node>>();
		List<Node> result = new ArrayList<Node>();
		List<Node> left = new ArrayList<Node>(visit(ctx.query(0)));
		List<Node> right = new ArrayList<Node>(visit(ctx.query(1)));
		List<String> latt = transform(ctx.attrs(0));
		List<String> ratt = transform(ctx.attrs(1));
		List<Node> small = left.size() < right.size() ? left : right,
				large = left.size() < right.size() ? right : left;
		List<String> smatt = left.size() < right.size() ? latt : ratt,
				lgatt = left.size() < right.size() ? ratt : latt;
		
		// store into hash map
		for(Node smnode : small){
			String key = convertChildren(smnode, smatt);
			if(hashJoin.containsKey(key)){
				hashJoin.get(key).add(smnode);
			} else hashJoin.put(key, new ArrayList<Node>(Arrays.asList(smnode)));
		}
		
		// actual join operation
		for(Node lgnode : large){
			String attributes = convertChildren(lgnode, lgatt);
			if(hashJoin.containsKey(attributes)){
				for(Node smnode : hashJoin.get(attributes)){
					Element container = doc.createElement("tuple");
					List<Node> child = findChild(smnode);
					child.addAll(findChild(lgnode));
					for(Node childnode: child){
						container.appendChild(doc.importNode(childnode, true));
					}
					result.add(container);
				}
			}
		}
		
		return result;
	}
	
	

	/*
	 * =======================================
	 * LetClause Implementation
	 * =======================================
	 */	
	
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
	 * WhereClause and Cond Implementation
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
		List<Node> tmp = new ArrayList<Node>();
		if(isEqualList(visit(ctx.query(0)), visit(ctx.query(1)), true)){
			tmp.add(doc.createElement("Pass"));
		}
		return tmp;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitQueryIDEq(@NotNull XQueryParser.QueryIDEqContext ctx) {
		List<Node> tmp = new ArrayList<Node>();
		if(isEqualList(visit(ctx.query(0)), visit(ctx.query(1)), false)){
			tmp.add(doc.createElement("Pass"));
		}
		return tmp;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitEmptyQuery(@NotNull XQueryParser.EmptyQueryContext ctx) { 
		List<Node> temp = new ArrayList<Node>();
		if(visit(ctx.query()).isEmpty())
			temp.add(doc.createElement("Pass"));
		return temp;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitSomeClause(@NotNull XQueryParser.SomeClauseContext ctx) {
		HashMap<String, List<Node>> backup = new HashMap<String, List<Node>>(variables);

		List<Node> result = new ArrayList<Node>();
		if(iterateSome(ctx, 0)){
			result.add(doc.createElement("Pass"));
		}
		variables = backup;
		return result;
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
		
		if(!c1.isEmpty() && !c2.isEmpty()){
			result.add(doc.createElement("Pass"));
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
		List<Node> tmp = visit(ctx.cond());
		if(tmp.isEmpty()){
			tmp.add(doc.createElement("Pass"));
		} else tmp.clear();
		return tmp;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitPriorityCond(@NotNull XQueryParser.PriorityCondContext ctx) {
		return visit(ctx.cond());
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitPriority(@NotNull XQueryParser.PriorityContext ctx) {
		return visit(ctx.query());
	}
	
	
	/*
	 * =======================================
	 * Return Implementation
	 * =======================================
	 */	

	
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitReturnClause(@NotNull XQueryParser.ReturnClauseContext ctx) {
		return new ArrayList<Node>(visit(ctx.query()));
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitFormat(@NotNull XQueryParser.FormatContext ctx) {
		String tagname = ctx.tag(0).getText();
	    Element n = doc.createElement(tagname);
	    List<Node> tmp = visit(ctx.query());
	    for(Node local: tmp){
	    	if(local.getNodeType() == Node.ATTRIBUTE_NODE){
	    		n.setAttribute(((Attr)local).getName(), ((Attr)local).getValue());
	    	} else {
	    		n.appendChild(doc.importNode(local, true));
	    	}
	    }
	    return new ArrayList<Node>(Arrays.asList(n));
	}
	

	/*
	 * =======================================
	 * XQuery Implementation
	 * =======================================
	 */
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitStringConst(@NotNull XQueryParser.StringConstContext ctx) {
		String fullString = ctx.STR().getText();
		return new ArrayList<Node>(Arrays.asList(doc.createTextNode(fullString.substring(1, fullString.length() - 1))));
	}
	
	@Override public List<Node> visitFlwr(@NotNull XQueryParser.FlwrContext ctx) {
		HashMap<String, List<Node>> backup = new HashMap<String, List<Node>>(variables);
		List<Node> localResult = new ArrayList<Node>();
				
		iterateFLWR(ctx, 0, localResult);
		variables.clear();
		variables.putAll(backup);
		return localResult;
	}
		
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitPairQuery(@NotNull XQueryParser.PairQueryContext ctx) {
		List<Node> result = new ArrayList<Node>(visit(ctx.query(0)));
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
		return new ArrayList<Node>(variables.getOrDefault(ctx.var().varName().getText(), new ArrayList<Node>()));
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
		r = new ArrayList<Node>(visit(ctx.ap()));
		Document root = (Document)r.get(0);
		r.clear();
		r.add(root.getDocumentElement());
		if(ctx.dsl() != null){
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
		r = new ArrayList<Node>(visit(ctx.query()));
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
	
	@Override public List<Node> visitDescendant(@NotNull XQueryParser.DescendantContext ctx) {
		r = new ArrayList<Node>(visit(ctx.query()));
		visit(ctx.dsl());
		visit(ctx.relativePath());
		return r;
	}
	
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
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	
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
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitParent(@NotNull XQueryParser.ParentContext ctx) {
		backToParent();
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
		if(ctx.relativePath(1).getText().length() > 1 && ctx.relativePath(1).getText().charAt(0) == '.'){
			backToParent();
		}
		visit(ctx.relativePath(1));
		List<Node> r1 = new ArrayList<Node>(r);
		r = tmp;
		if(ctx.relativePath(0).getText().length() > 1 && ctx.relativePath(0).getText().charAt(0) == '.'){
			backToParent();
		}
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
		backToParent();
		List<Node> tmp = new ArrayList<Node>();
		for(int i = 0; i < r.size(); i++){
			if(r.get(i).getNodeType() == Node.ELEMENT_NODE){
				Attr attNode = ((Element)r.get(i)).getAttributeNode(ctx.NAME().getText());
				if(attNode != null){
					tmp.add(attNode);
				}
			}
		}
		r = tmp;
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
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitAll(@NotNull XQueryParser.AllContext ctx) {
		List<Node> tmp = new ArrayList<Node>(r);
		for(int i = 0; i < tmp.size();){
			if(tmp.get(i).getNodeType() == Node.ATTRIBUTE_NODE)
				tmp.remove(i);
			else i++;
		}
		r = tmp;
		return null;
	}

}