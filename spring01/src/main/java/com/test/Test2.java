package com.test;

import com.ioc.ApplicationContext;
import com.pojo.Student;
import junit.framework.TestCase;

public class Test2 extends TestCase {

    public void testIoc(){
        Student student = (Student) ApplicationContext.getInstance("student");
        student.setStuid(1);
        System.out.println(student.getStuid());

    }
}
