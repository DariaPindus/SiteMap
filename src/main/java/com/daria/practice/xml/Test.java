package com.daria.practice.xml;

import com.daria.practice.xml.my.MyHtmlWriter;
import com.daria.practice.xml.my.UrlNodeMy;
import com.daria.practice.xml.my.UrlNodeTree;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Test {

    public static void main(String[] args) {
        //first();
        UrlNodeTree urlTree = new UrlNodeTree();
        try {
            File inputXml = new File("/home/daria_p/MyDocs/Practice/seoMap_cut.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputXml);

            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("url");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element currentElement = (Element) nodes.item(i);
                if (currentElement.getElementsByTagName("loc").item(0).getTextContent().contains("{"))
                    continue;
                UrlNodeMy urlNode = new UrlNodeMy();
                urlNode.setLocation(currentElement.getElementsByTagName("loc").item(0).getTextContent());
                System.out.println(currentElement.getElementsByTagName("loc").item(0).getTextContent());
                urlNode.setPriority(Double.valueOf(currentElement.getElementsByTagName("priority").item(0).getTextContent()));
                urlTree.addNode(urlNode);
            }

            MyHtmlWriter htmlWriter = new MyHtmlWriter(urlTree);
            htmlWriter.WriteHtml();

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
