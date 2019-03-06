package com.napier.group20.utils;

import com.napier.group20.places.Continent;
import com.napier.group20.places.World;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class App {

    private Connection connection = null;
    private World world = null;

    public void connect(String connectionString, int retries) {
        for(int i = 0; i < retries; ++i) {
            try {
                TimeUnit.SECONDS.sleep(5);
                connection = DriverManager.getConnection(String.format("jdbc:mariadb://%s/world", connectionString), "root", "secret");
                break;
            } catch(InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void disconnect() {
        if(connection != null) {
            try {
                connection.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadDatabase() {
        world = World.getInstance();
        world.setContinents(loadContinents());
    }

    private ArrayList<Continent> loadContinents() {
        ArrayList<Continent> continents = new ArrayList<>();
        String query = "SELECT DISTINCT Continent FROM country;";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                continents.add(new Continent(rs.getString("Continent"), null));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return continents;
    }
}
