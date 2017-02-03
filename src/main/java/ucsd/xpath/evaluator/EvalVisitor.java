package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ucsd.xpath.xmlparser.DomParser;

public class EvalVisitor extends XPathBaseVisitor<List<Node>>{
	
	private List<Node> result;
	
	public List<Node> getResult(){
		return result;
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

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitParent(@NotNull XPathParser.ParentContext ctx) {
		List<Node> tmp = new ArrayList<Node>();
		
		for(int i = 0; i < result.size(); i++){
			Node localNode = result.get(i).getParentNode();
			if(localNode != null && !listContainsElement(tmp, localNode)){
				tmp.add(localNode);
			}
		}
		result.clear();
		for(int i = 0; i < tmp.size(); i++){
			Node localNode = tmp.get(i).getParentNode();
			if(localNode != null && !listContainsElement(result, localNode)){
				result.add(localNode);
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
	@Override public List<Node> visitXquery(@NotNull XPathParser.XqueryContext ctx) { 
		result = new ArrayList<Node>();
		return visitChildren(ctx); 
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitXpath(@NotNull XPathParser.XpathContext ctx) {
		visit(ctx.absolutePath());
		Document root = (Document)result.get(0);
		result.remove(0);
		result.add(root.getDocumentElement());
		visit(ctx.relativePath());
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitDescendant(@NotNull XPathParser.DescendantContext ctx) { 
		List<Node> tmp = new ArrayList<Node>(result);
		result.clear();
		for(int i = 0; i < tmp.size(); i++){
			NodeList children = tmp.get(i).getChildNodes();
			for(int j = 0; j < children.getLength(); j++){
				result.add(children.item(j));
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
	@Override public List<Node> visitTagName(@NotNull XPathParser.TagNameContext ctx) { 
		
		
		for(int i = 0; i < result.size();){
			if(result.get(i).getNodeType() != Node.ELEMENT_NODE || !result.get(i).getNodeName().equals(ctx.getText()) ){
				result.remove(i);
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
	@Override public List<Node> visitDescendantOrSelf(@NotNull XPathParser.DescendantOrSelfContext ctx) {
		int startIdx = 0;
		for(; startIdx < result.size(); startIdx++){
			Node tmp = result.get(startIdx);
			NodeList children = tmp.getChildNodes();
			for(int i = 0; i < children.getLength(); i++){
				if(!listContainsElement(result, children.item(i)))
					result.add(children.item(i));
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
	@Override public List<Node> visitSelf(@NotNull XPathParser.SelfContext ctx) { 
		List<Node> tmp = new ArrayList<Node>();
		for(int i = 0; i < result.size(); i++){
			Node parent = result.get(i).getParentNode();
			if(parent != null && !listContainsElement(tmp, parent)){
				tmp.add(parent);
			}
		}
		result = tmp;
		return null;
	}


	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitFilename(@NotNull XPathParser.FilenameContext ctx) { 
		Document doc = DomParser.parse(ctx.getText());
		result.add(doc);
		return null; 
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitAbsolutePath(@NotNull XPathParser.AbsolutePathContext ctx) { 
		return visit(ctx.filename());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitPathSequence(@NotNull XPathParser.PathSequenceContext ctx) {
		List<Node> tmp = new ArrayList<Node>(result);
		visit(ctx.relativePath(1));
		List<Node> r1 = new ArrayList<Node>(result);
		result = tmp;
		visit(ctx.relativePath(0));
		// Add nodes in r1, need to verify that the node does not exist in result before adding it to the list
		for(Node node: r1){
			if(!listContainsElement(result, node)){
				result.add(node);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * This function handles a visit on any node that has the form "@attribute"
	 * It removes all the nodes that are not attribute nodes in the list
	 */
	@Override public List<Node> visitAttName(@NotNull XPathParser.AttNameContext ctx) {
		for(int i = 0; i < result.size();){
			if(result.get(i).getNodeType() != Node.ATTRIBUTE_NODE || !result.get(i).getNodeName().equals(ctx.getText())){
				result.remove(i);
			} else i++;
		}
		return visitChildren(ctx);
	}

	/**
	 *
	 * This function handles a visit on text node when meeting "text()"
	 * It removes all the nodes that are not text nodes in the list
	 */
	@Override public List<Node> visitText(@NotNull XPathParser.TextContext ctx) {
		for(int i = 0; i < result.size(); ){
			if(result.get(i).getNodeType() != Node.TEXT_NODE ){
				result.remove(i);
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
	@Override public List<Node> visitDescendantExistence(@NotNull XPathParser.DescendantExistenceContext ctx) {
		List<Node> nodes = new ArrayList<Node>(result);
		result.clear();
		for(int i = 0; i < nodes.size();){
			result.add(nodes.get(i));
			visit(ctx.relativePath());
			if(result.size() == 0){
				nodes.remove(i);
			} else i++;
			result.clear();
		}
		result = nodes;
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitNegatvePathFilter(@NotNull XPathParser.NegatvePathFilterContext ctx) {
		List<Node> nodes = new ArrayList<Node>(result);
		visit(ctx.pathFilter());
		for(int i = 0; i < result.size(); i++){
			nodes.remove(result.get(i));
		}
		result = nodes;
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitAndFilter(@NotNull XPathParser.AndFilterContext ctx) {
		List<Node> nodes = new ArrayList<Node>(result);
		visit(ctx.pathFilter(0));
		List<Node> r1 = new ArrayList<Node>(result);
		result = nodes;
		visit(ctx.pathFilter(1));
		for(int i = 0; i < result.size();){
			if(!r1.contains(result.get(i))){
				result.remove(i);
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
	@Override public List<Node> visitOrFilter(@NotNull XPathParser.OrFilterContext ctx) {
		List<Node> nodes = new ArrayList<Node>(result);
		visit(ctx.pathFilter(0));
		List<Node> r1 = new ArrayList<Node>(result);
		result = nodes;
		visit(ctx.pathFilter(1));
		for(int i = 0; i < r1.size(); i++){
			if(!result.contains(nodes.get(i))){
				result.add(nodes.get(i));
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
	@Override public List<Node> visitPathIdEq(@NotNull XPathParser.PathIdEqContext ctx) {
		List<Node> nodes = new ArrayList<Node>(result);
		for(int i = 0; i < nodes.size(); ){
			result.clear();
			result.add(nodes.get(i));
			visit(ctx.relativePath(0));
			List<Node> r1 = new ArrayList<Node>(result);
			result.clear();
			result.add(nodes.get(i));
			visit(ctx.relativePath(1));
			if(!isEqualList(result, r1, false)){
				nodes.remove(i);
				continue;
			}
			i++;
		}
		result = nodes;
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitPathValueEq(@NotNull XPathParser.PathValueEqContext ctx) {
		List<Node> nodes = new ArrayList<Node>(result);
		for(int i = 0; i < nodes.size(); ){
			result.clear();
			result.add(nodes.get(i));
			visit(ctx.relativePath(0));
			List<Node> r1 = new ArrayList<Node>(result);
			result.clear();
			result.add(nodes.get(i));
			visit(ctx.relativePath(1));
			if(!isEqualList(result, r1, true)){
				nodes.remove(i);
				continue;
			}
			i++;
		}
		result = nodes;
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitDescendantPath(@NotNull XPathParser.DescendantPathContext ctx) {
		//System.out.println(ctx.relativePath(1).toStringTree());
		return visitChildren(ctx);
	}
}
