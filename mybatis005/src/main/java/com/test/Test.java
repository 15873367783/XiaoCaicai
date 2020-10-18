package com.test;

import junit.framework.TestCase;

import java.sql.*;

public class Test extends TestCase {
    public void _testJDBC() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s81","root","root");
        String sql = "call findall()";
        CallableStatement cs = connection.prepareCall(sql);
        ResultSet rs = cs.executeQuery();

        while (rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
        }
    }

    public void testJDBC1() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/s81","root","root");
        String sql = "call findbyid(?)";

        CallableStatement cs = connection.prepareCall(sql);




    }

}
