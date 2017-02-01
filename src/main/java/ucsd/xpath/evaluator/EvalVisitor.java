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
			if(localNode != null){
				tmp.add(localNode);
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
			if(result.get(i).getNodeType() != Node.ELEMENT_NODE || !result.get(i).getNodeName().equals(ctx.getText())){
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
		result.clear();
		result.addAll(tmp);
		visit(ctx.relativePath(0));
		result.addAll(r1);
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

}
