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
//    	String filename = "integrationtest.txt";
//    	String filename = "contest.txt";
//    	String filename = "flwrtest.txt";
//    	String filename = "consttest.txt";

    	String filename = "test.txt";
    	
    	List<String> testcases = Readfile.read(filename);


    	for(int i = 0; i < testcases.size(); i++){
    		XQueryEval xquery = new XQueryEval();
    		System.out.println("Start File " + Integer.toString(i));
    		System.out.println(testcases.get(i));
    		List<Node> tmp = xquery.parse(testcases.get(i));
    		try{
    			DomParser.WriteXMLFile(tmp, filename + "_output_" + Integer.toString(i + 1) + ".xml");
    		}catch(Exception e){			
    			e.printStackTrace();
    		}
    		System.out.println("Finish File " + Integer.toString(i));
    	}
    }
   
}
