//package assignment2;

import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XMLParser {
    /**
     * TODO: Parse the input XML file and return a dictionary as described in the assignment insturctions
     *
     * @param filename the input XML file
     * @return a dictionary as described in the assignment insturctions
     */
    public static Map<String, Malware> parse(String filename) {
        // TODO: YOUR CODE HERE
    	Map<String, Malware> res = new HashMap<String, Malware>();
    	try
    	{
    		File fXmlFile = new File(filename);
    	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	    Document doc = dBuilder.parse(fXmlFile);
    	    doc.getDocumentElement().normalize();
    	    NodeList nList = doc.getElementsByTagName("row");
    	    for (int temp = 0; temp < nList.getLength(); temp++)
    	    {
    	    	Node nNode = nList.item(temp);
    	    	if (nNode.getNodeType() == Node.ELEMENT_NODE)
    	    	{
    	            Element eElement = (Element) nNode;
    	            Malware ml = new Malware(eElement.getElementsByTagName("title").item(0).getTextContent(),
    	            		Integer.parseInt(eElement.getElementsByTagName("level").item(0).getTextContent()),
    	            		eElement.getElementsByTagName("hash").item(0).getTextContent());
    	            res.put(ml.getHash(), ml);
    	        }
    	    }
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
        return res;
    }
}

