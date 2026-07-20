package a.interfacess;

import java.sql.*;
import java.util.*;

public class DataBaseManager {

    // Change these to match your local MySQL setup
    private static final String URL = "jdbc:mysql://localhost:3306/smarttripsandeventsmanagement"; // your database name
    private static final String USER = "root"; // your username (commonly 'root' in XAMPP)
    private static final String PASSWORD = "Hazyyan@1590"; // your password (often blank with XAMPP)

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
