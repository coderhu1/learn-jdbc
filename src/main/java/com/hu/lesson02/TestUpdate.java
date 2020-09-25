package com.hu.lesson02;

import com.hu.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author coderhu1
 * @create 2020-09-25 22:24
 */
public class TestUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();

            String sql = "UPDATE users " +
                    "SET `NAME`='dssadg',`email`='eqeqwe@qq.com' WHERE id=3";

            int num = st.executeUpdate(sql);
            if(num > 0) {
                System.out.println("更新成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
