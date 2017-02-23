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
    	
    	for(String str: testcases){
    		System.out.println(str);
    	}

//    	List<Integer> a = new ArrayList<Integer>();
//    	a.add(4);
//    	List<Integer> b = new ArrayList<Integer>();
//    	b.add(5);
//    	a.addAll(b);
//    	System.out.println(a.size());
//    	XPathEval xquery = new XPathEval();
    	XQueryEval xquery = new XQueryEval();
    	for(int i = 0; i < testcases.size(); i++){
    		System.out.println("Starrt");
    		System.out.println(i);
    		List<Node> tmp = xquery.parse(testcases.get(i));
    		DomParser.WriteXMLFile(tmp, "testcase_" + Integer.toString(i + 1) + ".xml");
    		System.out.println("Finish");
    	}
    }
}
