package com.slt.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 2016/8/6.
 */
public class DataBaseConnion {
    @Test
    public void test() throws Exception {
        /**
         * 注册驱动类
         */
        Class.forName("com.mysql.jdbc.Driver");


        String url="jdbc:mysql://127.0.0.1:3306/sltwy";
        String username="root";
        String password="123456";
        String sql="select * from Goods";

        /**
         * 创建数据库连接
         */
        Connection connection= DriverManager.getConnection(url,username,password);


        /**
         * 创建Statement
         */
        Statement statement = connection.createStatement() ;

        ResultSet resultSet=statement.executeQuery(sql);

        while (resultSet.next()){
            Long id=resultSet.getLong("id");
            String title=resultSet.getString("title");
            System.out.println(id);
            System.out.println(title);
            title=title+"修改";
        }
        connection.close();
    }
}
