package com.hu.lesson02;

import com.hu.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author coderhu1
 * @create 2020-09-25 21:36
 */
public class TestInsert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "INSERT INTO users(id,NAME,PASSWORD,email,birthday)" +
                    "VALUES(4,'huzong','1233','herrhu@qq.com','2020-09-25')";

            int num = statement.executeUpdate(sql);
            if(num > 0) {
                System.out.println("插入成功！");
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(connection, statement, resultSet);
        }
    }
}
