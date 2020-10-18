package com.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

public class ApplicationContext {

    public static Object getInstance(String id){

        SAXReader saxReader = new SAXReader();
        Object object = null;
        try {
            Document document = saxReader.read(ApplicationContext.class.getResourceAsStream("applicationContext.xml"));
            Element element = (Element) document.selectSingleNode("beans/bean[@id='"+id+"']");
            String classname = element.attribute("class").getValue();
            Class c = Class.forName(classname);

            object = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object ;

    }

}
