package edu.ucsd.xmlparser;

import java.io.File;
import java.util.ArrayList;

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
	
	public static void WriteXMLFile(ArrayList<Node> result, String fileName){
		try{
			System.out.println("Start writing xml file");
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
	public static Document createDoc(ArrayList<Node> listOfNodes){
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			for(int i = 0; i < listOfNodes.size(); i++){
				doc.appendChild(listOfNodes.get(i));
			}
			return doc;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
}
