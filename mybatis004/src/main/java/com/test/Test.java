package com.test;

import com.pojo.Dep;
import com.pojo.Emp;
import junit.framework.TestCase;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Test extends TestCase {
    public void _testAdd() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

        Dep dep = new Dep();
        dep.setDepname("aaaa");

        Dep dep2 = new Dep();
        dep.setDepname("aaaa");

        Dep dep3 = new Dep();
        dep3.setDepname("aaaa");

        sqlSession.insert("com.pojo.Dep.insert",dep);
        sqlSession.insert("com.pojo.Dep.insert",dep);
        sqlSession.insert("com.pojo.Dep.insert",dep);
        sqlSession.commit();
        sqlSession.close();
    }

    public void testUpdate() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession  sqlSession = sqlSessionFactory.openSession();

        Emp  emp = new Emp();
        emp.setEmpid("10040");
        emp.setEmpname("李四");
        emp.setGender(2);

        int n = sqlSession.update("com.pojo.Emp.update",emp);
        sqlSession.commit();
        sqlSession.close();





    }


}
