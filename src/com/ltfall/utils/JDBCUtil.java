package com.ltfall.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {

    public static void main(String[] args) {
        Connection conn = JDBCUtil.getConn();
        System.out.println(conn);
    }

    private  static ComboPooledDataSource cpds = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return cpds;
    }

    public static Connection getConn(){
        try {
            return cpds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void closeConn(Connection conn){
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
