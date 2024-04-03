package com.example.demo.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static void main(String[] args) {
        // JDBC URL, username, and password of PostgreSQL server
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=assignment";
        String user = "postgres";
        String password = "postgres";

        // JDBC variables for opening, closing, and managing the connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Connection established. Do your database operations here.
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            // Handle errors
            e.printStackTrace();
        }
    }
}