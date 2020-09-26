package com.hu.lesson03;

import com.hu.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author coderhu1
 * @create 2020-09-26 21:39
 */
public class TestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = JdbcUtils.getConnection();

            String sql = "delete from users where id=?";

            st = conn.prepareStatement(sql);//预编译参数，先写SQL，不执行

            st.setInt(1, 4);

            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, null);
        }
    }
}
