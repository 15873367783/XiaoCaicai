package com.test;


import junit.framework.TestCase;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Test extends TestCase {
    public void _testCreate() throws IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("books");

        Element element = root.addElement("book");
        element.addAttribute("id","1");
        element.addAttribute("price","100");
        element.setText("神马两");

        Element element2 = root.addElement("book");
        element2.addAttribute("id","2");
        element2.addAttribute("price","200");
        element2.setText("神");

        Element element3 = root.addElement("book");
        element3.addAttribute("id","3");
        element3.addAttribute("price","300");
        element3.setText("神马");

        XMLWriter xmlWriter = new XMLWriter(new FileWriter("e://s85/a.xml"),OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();

    }
    public void _testSelectone() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("e://s85/a.xml"));

        Element element = (Element) document.selectSingleNode("books/book[@id=2]");
        System.out.println(element.getText());
        System.out.println(element.attribute("id").getValue());
        System.out.println(element.attribute("price").getValue());
    }

    public void testSelectList() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("e://s85/a.xml"));
        List<Element> list = document.selectNodes("books/book");
        if (list.size()>0){
            for (Element element : list) {
                System.out.println(element.getText());
                System.out.println(element.attribute("id").getValue());
                System.out.println(element.attribute("price").getValue());
            }
        }
    }

    public void _testUpdate() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("e://s85/a.xml");

        Element element = (Element) document.selectSingleNode("books/book[@id=2]");
        element.attribute("price").setValue("20");

        XMLWriter xmlWriter = new XMLWriter(new FileWriter("e://s85/a.xml"));
        xmlWriter.write(document);
        xmlWriter.close();

    }

    public void testDelete () throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("e://s85/a.xml");

        Element element = (Element) document.selectSingleNode("books/book[@id=2]");
        element.getParent().remove(element);

        XMLWriter xmlWriter = new XMLWriter(new FileWriter("e://s85/a.xml"));
        xmlWriter.write(document);
        xmlWriter.close();
    }


}
