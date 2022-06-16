package Testconnection;

import java.sql.*;

public class TestConnection2 {
    static final String  DB_URL  = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String User = "system";
    static final String Pass = "root";
    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(DB_URL, User,Pass);
    }

}
