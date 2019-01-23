package com.napier.group20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/world", "root", "password");
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
