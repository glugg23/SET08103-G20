package com.napier.group20.utils;

import com.napier.group20.places.*;

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
                for(Country country : region.getCountries()) {
                    for(District district : country.getDistricts()) {
                        for(City city : district.getCities()) {
                            System.out.println(city.getName());
                        }
                    }
                }
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
                regions.add(new Region(regionName, loadCountries(regionName)));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return regions;
    }

    private ArrayList<Country> loadCountries(String regionName) {
        ArrayList<Country> countries = new ArrayList<>();
        String query = "SELECT Code, Name, Capital, Population FROM country WHERE Region = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, regionName);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String countryCode = rs.getString("Code");
                City capital = loadCapital(countryCode);

                countries.add(new Country(countryCode, rs.getString("Name"), loadDistricts(countryCode, capital), capital, null, rs.getLong("Population")));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    private ArrayList<District> loadDistricts(String countryCode, City capital) {
        ArrayList<District> districts = new ArrayList<>();

        //EDGE CASE: If there is no capital there not be any districts so return early
        if(capital == null) {
            return districts;
        }

        String query = "SELECT DISTINCT District FROM city WHERE CountryCode = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, countryCode);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                //Get original district name for next query
                String districtNameOrig = rs.getString("District");
                String districtName = districtNameOrig;

                //If it's a strange value set it to something which makes more sense for the user
                if(districtNameOrig.equals("") || districtNameOrig.equals("–")) {
                    districtName = "None";
                }

                districts.add(new District(districtName, loadCities(districtNameOrig, countryCode, capital)));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return districts;
    }

    private City loadCapital(String countryCode) {
        String query = "SELECT city.Name, city.Population FROM country LEFT JOIN city ON Capital = ID AND Code = CountryCode WHERE Code = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, countryCode);
            ResultSet rs = ps.executeQuery();

            //Get first result
            rs.next();

            //This without this we get City objects of {null, 0, true} which is not what we intend
            if(rs.getString("city.Name") == null) {
                return null;
            }
            return new City(rs.getString("city.Name"), rs.getInt("city.Population"), true);

        } catch(SQLException e) {
            e.printStackTrace();
        }

        //Return null for any countries without a capital
        return null;
    }

    private ArrayList<City> loadCities(String districtName, String countryCode, City capital) {
        ArrayList<City> cities = new ArrayList<>();
        String query = "SELECT Name, Population FROM city WHERE District = ? AND CountryCode = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, districtName);
            ps.setString(2, countryCode);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                //We don't want to double include the capital
                if(rs.getString("Name").equals(capital.getName()) && rs.getInt("Population") == capital.getPopulation()) {
                    cities.add(capital);
                } else {
                    cities.add(new City(rs.getString("Name"), rs.getInt("Population"), false));
                }
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }
}
