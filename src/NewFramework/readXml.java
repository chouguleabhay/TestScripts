package NewFramework;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class readXml {
	public static void xmlreader(){
		try{
			File fxmlFile = new File("C:/Users/Lync321/workspace/TestCases/Locators.xml");
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
			Document doc = dbuilder.parse(fxmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nlist= doc.getElementsByTagName("objName");
			
			System.out.println("--------------------------------------");
			for(int temp=0;temp<nlist.getLength();temp++){
				Node nNode =nlist.item(temp);
				System.out.println("\n Current element " + nNode.getNodeName());
				
				if(nNode.getNodeType()==Node.ELEMENT_NODE){
					Element eElement = (Element) nNode;
					
					System.out.println("Attribute "+ eElement.getAttributeNode("obj"));
					System.out.println("Attribute "+ eElement.getElementsByTagName("Locator").item(0).getTextContent());
					System.out.println("Attribute "+ eElement.getElementsByTagName("value").item(0).getTextContent());
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
