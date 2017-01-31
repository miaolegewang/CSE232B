package edu.ucsd.antlrxpath.antlrxpath;
import org.w3c.dom.Node;

import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class XPathEval {
	/*
	 * Parse the string and evaluate the query
	 * Return the result of query as NodeList
	 * 
	 */
	public ArrayList<Node> parse(String queryAsString){
		ANTLRInputStream input = new ANTLRInputStream(queryAsString);
        XPathLexer lexer = new XPathLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tokens);
        parser.removeErrorListeners();
        ParseTree tree = parser.xquery();
        ParseTreeWalker walker = new ParseTreeWalker();
        MyParser builder = new MyParser();
        walker.walk(builder, tree);
        return builder.getResult();
	}
}
