package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ucsd.xpath.filereader.Readfile;
import ucsd.xpath.filereader.WriteFile;
import ucsd.xpath.xmlparser.DomParser;


/**
 * Hello world!
 *
 */
public class App
{
	private static String convertNodeToString(Node root){
		String result = "";
		NodeList allChildren = root.getChildNodes();
		if(allChildren.getLength() == 0){
			return result;
		}else{
			for(int i = 0; i < allChildren.getLength(); i++){
				result += allChildren.item(i).getNodeName() + allChildren.item(i).getTextContent();
			}
			return result;
		}
		
	}
	
    public static void main( String[] args ) throws ParserConfigurationException
    {
//    	manual_test("test.txt");
    	RewriteTest("test.txt");
    }
    
    /*
     * Running test manually on the test cases stored in test.txt without any answers to compare
     */
    public static void manual_test(String filename){
    	List<String> testcases = Readfile.read(filename);
    	
    	for(int i = 0; i < testcases.size(); i++){
    		XQueryEval xquery = new XQueryEval();
    		System.out.println("Start File " + Integer.toString(i + 1));
    		System.out.println(testcases.get(i));
    		List<Node> tmp = xquery.parse(testcases.get(i));
    		try{
    			DomParser.WriteXMLFile(tmp, filename + "_output_" + Integer.toString(i + 1) + ".xml");
    		} catch(Exception e){
    			e.printStackTrace();
    		}
    		System.out.println("Finish File " + Integer.toString(i + 1));
    	}
    }
   
    public static void RewriteTest(String filename){
    	List<String> testcases = Readfile.read(filename);
    	
    	for(int i = 0; i < testcases.size(); i++){
    		XQueryEval xquery = new XQueryEval();
    		System.out.println("Start File " + Integer.toString(i + 1));
    		System.out.println(testcases.get(i));
    		String rewrittenQuery = xquery.rewrite(testcases.get(i));
    		String query = rewrittenQuery == null? testcases.get(i) : rewrittenQuery;
    		WriteFile.writeTo(query, "rewrite_query_" + Integer.toString(i + 1) + ".txt");
    		System.out.println("");
    	}
    }
}
