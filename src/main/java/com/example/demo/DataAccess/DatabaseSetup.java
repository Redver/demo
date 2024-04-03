package com.example.demo.DataAccess;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
public class DatabaseSetup {
    public static void start() throws SQLException {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection("jdbc:postgresql://database:5432/postgres","postgres","postgres");
        PreparedStatement statement = connection.prepareStatement("CREATE SCHEMA IF NOT EXISTS assignment");
        statement.execute();

        connection = DriverManager.getConnection("jdbc:postgresql://database:5432/postgres?currentSchema=assignment","postgres","postgres");
        statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS posts (\n" +
                "    Id SERIAL PRIMARY KEY,\n" +
                "    title VARCHAR(255) NOT NULL,\n" +
                "    content TEXT NOT NULL,\n" +
                "    category VARCHAR(100) NOT NULL\n" +
                ");");

        statement.execute();

    }

}
