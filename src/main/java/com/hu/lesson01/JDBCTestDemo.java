package com.hu.lesson01;

import java.sql.*;

/**
 * @author coderhu1
 * @create 2020-09-24 21:13
 */
public class JDBCTestDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动，内部代码块已经使用了DriverManager
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/jdbcStudy?useUnicode=true&characterEncoding=utf8&useSSl=ture";
        String username = "root";
        String password = "123456";

        //2.获取连接 connnection代表与数据库的连接，客户端与数据库的所有交互都是通过connnection完成的
        Connection connection = DriverManager.getConnection(url, username, password);


        //3.statement用于向数据库发送sql语句
        Statement statement = connection.createStatement();

        //4.执行sql，resultSet代表sql语句的执行结果
        String sql = "SELECT * FROM users;";
        ResultSet resultSet = statement.executeQuery(sql);

        //5.获取信息
        //When a call to the next method returns false, the cursor is positioned after the last row.
        while(resultSet.next()){
            System.out.print("id = " + resultSet.getObject("id") + " ");
            System.out.print("NAME = " + resultSet.getObject("NAME") + " ");
            System.out.print("PASSWORD = " + resultSet.getObject("PASSWORD") + " ");
            System.out.print("email = " + resultSet.getObject("email") + " ");
            System.out.println("birthday = " + resultSet.getObject("birthday") + " ");
        }

        //6.关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
