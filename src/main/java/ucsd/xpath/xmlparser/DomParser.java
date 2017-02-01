package ucsd.xpath.xmlparser;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class DomParser {
	
	/**
	 * 
	 * Read XML file and parse it into a parseTree using DOM API
	 * @return XML Document Object
	 */
	public static Document parse(String fpath){
		try {
			File inputFile = new File(fpath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();	// removes empty Text nodes, and joins adjacent Text nodes
			return doc;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void WriteXMLFile(List<Node> result, String fileName){
		try{
			Document doc = createDoc(result);
			TransformerFactory tmfactory = TransformerFactory.newInstance();
			Transformer transformer = tmfactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult r = new StreamResult(new File(fileName));
			
			transformer.transform(source, r);
			System.out.println("File Saved!");
		} catch (TransformerException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Read a ArrayList of nodes and create a document with its children being the nodes in arraylist
	 * @return XML Document Object
	 */
	public static Document createDoc(List<Node> listOfNodes){
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Node root = doc.createElement("Result");
			for(int i = 0; i < listOfNodes.size(); i++){
				Node tmp = doc.importNode(listOfNodes.get(i), true);
				root.appendChild(tmp);
			}
			doc.appendChild(root);
			return doc;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}
