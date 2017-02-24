package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

import ucsd.xpath.filereader.Readfile;
import ucsd.xpath.xmlparser.DomParser;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	
    	List<String> testcases = Readfile.read("test.txt");


    	for(int i = 0; i < testcases.size(); i++){
    		XQueryEval xquery = new XQueryEval();
    		System.out.println(testcases.get(i));
    		System.out.println("Start File " + Integer.toString(i));
    		List<Node> tmp = xquery.parse(testcases.get(i));
    		try{
    			DomParser.WriteXMLFile(tmp, "testcase_" + Integer.toString(i + 1) + ".xml");
    		}catch(Exception e){			
    			e.printStackTrace();
    		}
    		System.out.println("Finish File " + Integer.toString(i));
    	}
    }
   
}
