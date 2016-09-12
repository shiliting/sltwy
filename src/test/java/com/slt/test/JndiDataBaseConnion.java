package com.slt.test;

import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2016/8/6.
 */
public class JndiDataBaseConnion {
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

        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");


        /**
         * 创建数据库连接
         */
        Connection connection= DriverManager.getConnection(url,username,password);


        connection.close();
    }
}
