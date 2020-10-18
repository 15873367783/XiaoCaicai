package com.test;


import com.pojo.Student;
import com.pojo.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Test   {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) applicationContext.getBean("student");

        System.out.println(student.getStuid()+"\t"+student.getStuname());

        String[] loves =  student.getLoves();
        if(loves.length!=0){
            for (String love : loves) {
                System.out.println(love);
            }
        }

        Map map = student.getOther();
        System.out.println(map.get("age"));
        System.out.println(map.get("sex"));

        Teacher teacher = student.getTeacher();
        System.out.println(teacher.getTid()+"\t"+teacher.getTname());



    }
}
