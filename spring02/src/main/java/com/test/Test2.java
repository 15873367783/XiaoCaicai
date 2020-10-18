package com.test;

import com.inter.MyInterface;
import com.service.CRUD;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app*.xml");
        CRUD crud = (CRUD) applicationContext.getBean("service");
        crud.add();
        System.out.println(applicationContext.getBean("service").getClass());

    }

}
