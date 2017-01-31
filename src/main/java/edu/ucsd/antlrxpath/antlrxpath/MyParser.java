package edu.ucsd.antlrxpath.antlrxpath;

import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;
import edu.ucsd.xmlparser.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

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
	}
}
