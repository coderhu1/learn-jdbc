package com.hu.lesson04;

import com.hu.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author coderhu1
 * @create 2020-09-26 23:26
 */
public class TransactionTest01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();

            conn.setAutoCommit(false);

            String sql = "update account set money= money-100 where name ='A'";
            st = conn.prepareStatement(sql);
            st.executeUpdate();

//            int i = 1/0;
            //一旦报错，即回滚

            String sql2 = "update account set money= money+100 where name ='B'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            conn.commit();
            System.out.println("Success!");

        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
}
