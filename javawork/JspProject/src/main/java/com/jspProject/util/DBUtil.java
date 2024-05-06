package com.jspProject.util;

import java.sql.*;

public class DBUtil {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ECommerceDB?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "seungpil";  // 사용자 이름 확인
    private static final String PASS = "ruikki7853!";  // 사용자 비밀번호 확인

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
