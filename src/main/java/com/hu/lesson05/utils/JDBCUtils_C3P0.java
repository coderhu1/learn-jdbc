package com.hu.lesson05.utils;

import com.hu.lesson02.utils.JdbcUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author coderhu1
 * @create 2020-09-27 0:52
 */
public class JDBCUtils_C3P0 {
    private static DataSource dataSource = null;

    //读取properties文件中的配置信息
    static {
        try {
            dataSource = new ComboPooledDataSource("MySQL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //释放资源
    public static void release(Connection conn, Statement st, ResultSet re) {
        if(re != null) {
            try {
                re.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
