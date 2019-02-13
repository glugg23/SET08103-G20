package com.napier.group20;

import java.util.concurrent.TimeUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        int count = 10;

        if (args.length > 0) {
            count = Integer.parseInt(args[0]);
        }

        for (int i = 0; (i < count) && (connection == null); i++){
            try {
                TimeUnit.SECONDS.sleep(5);
                connection = DriverManager.getConnection("jdbc:mariadb://db:3306/world", "root", "secret");
            } catch (Exception e) {
                System.err.println("Connection to MariaDB container failed, retrying.");
            }
        }

        if (connection == null) {
            System.out.println("Cannot find instance of MariaDB. Closing program.");
            System.exit(-1);
        }

        try {
            String query = "SELECT * FROM country;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                System.out.println(resultSet.getString("Name"));
            }
            connection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
