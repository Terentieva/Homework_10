package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetConfigAndTestData {


    public HashMap<String, String> properties;

    public GetConfigAndTestData() {
        String fileName = "./src/main/resources/Properties.xml";
        properties = readFromXMLFile(fileName);
    }


    public HashMap readFromXMLFile(String fileName) {
        HashMap prop = new HashMap<String, String>();

        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("property");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                String propertyName = "";
                String propertyValue = "";
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    propertyName = element.getAttribute("name").toString();
                    propertyValue = element.getElementsByTagName("value").item(0).getTextContent().toString();

                }
                if (!propertyName.isEmpty() & !propertyValue.isEmpty()) {
                    prop.put(propertyName, propertyValue);
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("File does not found");
        } catch (NullPointerException e) {
            System.out.println("File does not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }



    public String getConfigUrl()
    {
        return this.properties.get("URL").toString();
    }

    public String getLogin()
    {
        return this.properties.get("Login").toString();
    }

    public String getPassword()
    {
        return this.properties.get("Password").toString();
    }

    public String getSearchDescription()
    {
        return this.properties.get("SearchDescription").toString();
    }

}
