package com.hu.lesson03;

import com.hu.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author coderhu1
 * @create 2020-09-26 21:43
 */
public class TestSelect {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.prepareStatement("select * from users where id=?");

            st.setInt(1, 1);
            rs = st.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("NAME"));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }

    }
}
