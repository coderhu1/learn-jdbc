package com.hu.lesson03;

import com.hu.lesson02.utils.JdbcUtils;

import java.sql.*;

/**
 * @author coderhu1
 * @create 2020-09-25 23:54
 */
public class SQLzhuru {
    public static void main(String[] args) {
        login("' or '1=1", "123456");
    }

    public static void login(String username, String password) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "select * from users where name=? and password=?";

            st = conn.prepareStatement(sql);

            st.setString(1, username);
            st.setString(2, password);

            rs = st.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("NAME"));
                System.out.println(rs.getString("PASSWORD"));
                System.out.println("=====================");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
