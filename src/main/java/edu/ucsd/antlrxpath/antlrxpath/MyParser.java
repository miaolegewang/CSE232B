package edu.ucsd.antlrxpath.antlrxpath;

import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;
import edu.ucsd.xmlparser.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyParser extends XPathBaseListener{
	
	private ArrayList<Node> result;
	
	/**
	 * 
	 * Retrieve the result of executing a xquery
	 */
	public ArrayList<Node> getResult(){
		return result;
	}
	
	/**
	 * 
	 * Refresh the result list before parsing and evaluating a query
	 */
	@Override public void enterXpath(@NotNull XPathParser.XpathContext ctx) { 
		result.clear();
	}
	
	/**
	 *
	 * Read xml file and parse it into a parse tree using DOM Parser
	 * Store the root element into the result array
	 */
	@Override public void exitFilename(@NotNull XPathParser.FilenameContext ctx) { 
		Document tmp = DomParser.parse(ctx.getText());
		result.add(tmp.getDocumentElement());
	}
	
	/**
	 *
	 * This function is called when '//' is parsed. It means the coming relativePath
	 * is used on the current node or its sibling.
	 */
	@Override public void exitDescendantOrSelf(@NotNull XPathParser.DescendantOrSelfContext ctx) { 
		int startIdx = 0, endIdx = result.size();
		for(; startIdx < endIdx; startIdx++){
			Node tmp = result.get(startIdx);
			NodeList children = tmp.getChildNodes();
			for(int i = 0; i < children.getLength(); i++){
				result.add(children.item(i));
			}
			endIdx = result.size();
		}
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParent(@NotNull XPathParser.ParentContext ctx) {
		for(int i = 0; i < result.size(); i++){
			if(result.get(i).getNodeType() != 1 && result.get(i).getNodeValue() == ctx.getText()){
				result.remove(i);
			}
		}
	}

	/**
	 *
	 * This function match 
	 */
	@Override public void exitTagName(@NotNull XPathParser.TagNameContext ctx) { 
		for(int i = 0; i < result.size(); i++){
			if(result.get(i).getNodeType() != 1 && result.get(i).getNodeValue() == ctx.getText()){
				result.remove(i);
			}
		}
	}
	
	/**
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitText(@NotNull XPathParser.TextContext ctx) {
		for(int i = 0; i < result.size(); i++){
			if(result.get(i).getNodeType() != Node.TEXT_NODE ){
				result.remove(i);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAttName(@NotNull XPathParser.AttNameContext ctx) { 
		for(int i = 0; i < result.size(); i++){
			if(result.get(i).getNodeType() != Node.ATTRIBUTE_NODE || !result.get(i).getNodeName().equals(ctx.getText())){
				result.remove(i);
			}
		}
	}
	
	
	
	
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAll(@NotNull XPathParser.AllContext ctx) { 
		
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSelf(@NotNull XPathParser.SelfContext ctx) {
	}
	



}
