package com.napier.group20.utils;

import com.napier.group20.places.Continent;
import com.napier.group20.places.Region;
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

        for(Continent continent : world.getContinents()) {
            for(Region region : continent.getRegions()) {
                System.out.println(region.getName());
            }
        }
    }

    private ArrayList<Continent> loadContinents() {
        ArrayList<Continent> continents = new ArrayList<>();
        String query = "SELECT DISTINCT Continent FROM country;";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                String continentName = rs.getString("Continent");
                continents.add(new Continent(continentName, loadRegions(continentName)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return continents;
    }

    private ArrayList<Region> loadRegions(String continentName) {
        ArrayList<Region> regions = new ArrayList<>();
        String query = "SELECT DISTINCT Region FROM country WHERE Continent = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, continentName);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String regionName = rs.getString("Region");
                regions.add(new Region(regionName, null));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return regions;
    }
}
