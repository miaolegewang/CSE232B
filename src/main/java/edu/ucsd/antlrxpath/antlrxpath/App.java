package edu.ucsd.antlrxpath.antlrxpath;

import java.util.ArrayList;

import org.w3c.dom.Node;

import edu.ucsd.xmlparser.DomParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /**
         * Now use manual test case input, later use file input
         */
    	ArrayList<String> testcases = new ArrayList<String>();
    	// Add test case here
    	testcases.add("doc(\"j_caesar.xml\")//ACT/TITLE");
    	
    	XPathEval xquery = new XPathEval();
    	for(int i = 0; i < testcases.size(); i++){
    		ArrayList<Node> tmp = xquery.parse(testcases.get(i));
    		DomParser.WriteXMLFile(tmp, "testcase_" + Integer.toString(i + 1) + ".xml");
    	}
    }
}
