package com.napier.group20;

import java.util.concurrent.TimeUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        while (connection == null) {
            try {
                TimeUnit.SECONDS.sleep(5);
                connection = DriverManager.getConnection("jdbc:mariadb://db:3306/world", "root", "secret");
            } catch (Exception e) {
                System.err.println("Connection to MariaDB container failed, retrying.");
            }
        }
        try {
            String query = "SELECT * FROM country;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                System.out.println(resultSet.getString("Name"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
