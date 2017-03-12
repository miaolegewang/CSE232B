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

import ucsd.xpath.filereader.Readfile;
import ucsd.xpath.xmlparser.DomParser;


/**
 * Hello world!
 *
 */
public class App
{
	
    public static void main( String[] args ) throws ParserConfigurationException
    {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	Document doc = builder.newDocument();
    	Element test1 = doc.createElement("test");
    	Element test2 = doc.createElement("test");
    	test1.appendChild(doc.createTextNode("TEXT1"));
    	test1.appendChild(doc.createTextNode("TEXT2"));
    	test2.appendChild(doc.createTextNode("TEXT1"));
    	test2.appendChild(doc.createTextNode("TEXT2"));
//    	test1.appendChild(test2);
    	PNode hehe = new PNode(test1);
    	PNode quxizao = new PNode(test2);
    	HashMap<PNode, Integer> test = new HashMap<PNode, Integer>();
    	test.put(hehe, 1);
    	System.out.println(Boolean.toString(test.containsKey(quxizao)));
//    	manual_test("test.txt");
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
   
}
