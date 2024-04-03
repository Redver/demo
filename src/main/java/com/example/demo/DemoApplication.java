package com.example.demo;

import com.example.demo.DataAccess.DatabaseSetup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws SQLException, InterruptedException {
        SpringApplication.run(DemoApplication.class, args);
    }

}
