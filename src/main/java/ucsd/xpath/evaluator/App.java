package ucsd.xpath.evaluator;

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
    	List<String> testcases = Readfile.read("test_1.txt");
    	XPathEval xquery = new XPathEval();
    	for(int i = 0; i < testcases.size(); i++){
    		List<Node> tmp = xquery.parse(testcases.get(i));
    		DomParser.WriteXMLFile(tmp, "testcase_" + Integer.toString(i + 1) + ".xml");
    	}
    }
}
