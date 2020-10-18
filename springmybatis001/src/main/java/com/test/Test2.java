package com.test;

import com.mapper.DepMapper;
import com.pojo.Dep;
import com.service.DepService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepService depService = (DepService) applicationContext.getBean("depService");

        Dep dep = new Dep();
        dep.setDepid(22);
        dep.setDepname("笑话部");
        depService.add(dep);
    }
}
