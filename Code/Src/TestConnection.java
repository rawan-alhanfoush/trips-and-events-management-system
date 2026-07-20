package a.interfacess;


import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = DataBaseManager.getConnection()) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}