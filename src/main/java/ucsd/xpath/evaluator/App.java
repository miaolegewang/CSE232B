package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

import ucsd.xpath.filereader.Readfile;
import ucsd.xpath.xmlparser.DomParser;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	// List<String> testcases = new ArrayList<String>();
    	// Add test case here
    	// testcases.add("doc(\"j_caesar.xml\")//(ACT,PERSONAE)//TITLE");
    	// testcases.add("doc(\"j_caesar.xml\")//ACT[./TITLE]/*/SPEECH/../TITLE");
    	List<String> testcases = Readfile.read("test.txt");
//    	XPathEval xquery = new XPathEval();
//    	for(int i = 0; i < testcases.size(); i++){
//    		List<Node> tmp = xquery.parse(testcases.get(i));
//    		DomParser.WriteXMLFile(tmp, "testcase_" + Integer.toString(i + 1) + ".xml");
//    	}
    }
}
