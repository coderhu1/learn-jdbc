package com.hu.lesson03;

import com.hu.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author coderhu1
 * @create 2020-09-26 21:08
 */
public class TestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = JdbcUtils.getConnection();

            String sql = "insert into users(id,`NAME`,`PASSWORD`,`email`,`birthday`) values(?,?,?,?,?)";

            st = conn.prepareStatement(sql);//预编译参数，先写SQL，不执行

            st.setInt(1, 4);
            st.setString(2, "huzongwang");
            st.setString(3,"2402394");
            st.setString(4, "lsgjjlskdf@qq.com");
            //sql.Date 数据库
            //util.Date Java
            st.setDate(5, new Date(new java.util.Date().getTime()));

            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, null);
        }
    }
}
