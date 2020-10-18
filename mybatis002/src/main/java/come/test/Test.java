package come.test;

import com.pojo.Dep;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test extends TestCase {

    public void _testFindAll() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();

        List<Dep> list = sqlSession.selectList("com.pojo.Dep.findall");

        for (Dep dep : list) {
            System.out.println(dep.getDepid()+"\t"+dep.getDepname());
        }

        sqlSession.close();

    }

    public void _testFindById() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();

        Dep dep= sqlSession.selectOne("com.pojo.Dep.findbyid" , 1);
        System.out.println(dep.getDepid()+"\t"+dep.getDepname());

    }

    public void _testFenye1() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();

        RowBounds bounds = new RowBounds(1,3);
        List<Dep> list = sqlSession.selectList("com.pojo.Dep.fenye" , null ,bounds);
        for (Dep dep : list) {
            System.out.println(dep.getDepid()+"\t"+dep.getDepname());
        }
    }


    public void _testFenYe() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();

        Map map = new HashMap();
        map.put("a" , 0);
        map.put("b" , 3);

        List<Dep> list = sqlSession.selectList("com.pojo.Dep.fenye1" , map);

        for (Dep dep : list) {
            System.out.println(dep.getDepid()+"\t"+dep.getDepname());
        }

        sqlSession.close();

    }


    public void testQuery() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();

        Dep dep = new Dep();
        dep.setDepid(1);
        dep.setDepname("a");

        List<Dep> list = sqlSession.selectList("com.pojo.Dep.query" , dep);

        for (Dep d : list) {
            System.out.println(d.getDepid()+"\t"+d.getDepname());
        }

        sqlSession.close();


    }



}
