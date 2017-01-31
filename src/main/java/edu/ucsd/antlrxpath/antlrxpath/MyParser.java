package edu.ucsd.antlrxpath.antlrxpath;

import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;
import edu.ucsd.xmlparser.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyParser extends XPathBaseListener{
	
	private ArrayList<Node> result = new ArrayList<Node>();
	
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
		result.add(tmp);
	}
	
	/**
	 *
	 * This function is called when '//' is parsed. It means the coming relativePath
	 * is used on the current node or its sibling.
	 */
	@Override public void exitDescendantOrSelf(@NotNull XPathParser.DescendantOrSelfContext ctx) { 
		int startIdx = 0, endIdx = result.size();
		for(; startIdx < endIdx; startIdx++){
			if(result.get(startIdx).getNodeType() == Node.DOCUMENT_TYPE_NODE){
				Document root = (Document)result.get(startIdx);
				result.remove(startIdx);
				startIdx--;
				result.add(root.getDocumentElement());
				continue;
			}
			Node tmp = result.get(startIdx);
			NodeList children = tmp.getChildNodes();
			for(int i = 0; i < children.getLength(); i++){
				result.add(children.item(i));
			}
			endIdx = result.size();
		}
	}
	
	/**
	 *
	 * Retrieve the immediate descendant from itself
	 */
	@Override public void exitDescendant(@NotNull XPathParser.DescendantContext ctx) { 
		ArrayList<Node> tmp = new ArrayList<Node>(result);
		System.out.println(tmp.size());
		for(int i = 0; i < tmp.size(); i++){
			if(tmp.get(i).getNodeType() == Node.DOCUMENT_TYPE_NODE){
				Document root = (Document)tmp.get(i);
				result.add(root.getDocumentElement());
				continue;
			}
			NodeList children = tmp.get(i).getChildNodes();
			for(int j = 0; j < children.getLength(); j++){
				//System.out.println(children.item(j).getNodeType());
				if(children.item(j).getNodeType() == Node.ELEMENT_NODE)
					System.out.println(children.item(j).getNodeName());
				result.add(children.item(j));
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParent(@NotNull XPathParser.ParentContext ctx) {
		ArrayList<Node> tmp = new ArrayList<Node>();
		for(int i = 0; i < result.size(); i++){
			Node localNode = result.get(i).getParentNode();
			if(localNode != null){
				tmp.add(localNode);
			}
		}
		result = tmp;
	}

	/**
	 *
	 * This function match 
	 */
	@Override public void exitTagName(@NotNull XPathParser.TagNameContext ctx) {

		for(int i = 0; i < result.size();){
			System.out.println( " : " );
			System.out.println(result.get(i));
			if(result.get(i).getNodeType() != Node.ELEMENT_NODE || !result.get(i).getNodeName().equals(ctx.getText())){
				result.remove(i);
			} else i++;
		}
	}
	
	/**
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitText(@NotNull XPathParser.TextContext ctx) {
		for(int i = 0; i < result.size(); ){
			if(result.get(i).getNodeType() != Node.TEXT_NODE ){
				result.remove(i);
			}else i++;
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAttName(@NotNull XPathParser.AttNameContext ctx) { 
		for(int i = 0; i < result.size();){
			if(result.get(i).getNodeType() != Node.ATTRIBUTE_NODE || !result.get(i).getNodeName().equals(ctx.getText())){
				result.remove(i);
			}else i++;
		}
	}



}
