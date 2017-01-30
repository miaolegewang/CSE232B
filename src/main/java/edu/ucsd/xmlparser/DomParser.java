package edu.ucsd.xmlparser;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

public class DomParser {
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
}
