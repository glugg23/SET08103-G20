package com.napier.group20.utils;

import com.napier.group20.places.*;

import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * App.java
 *
 * A class which holds all the methods for interacting
 * with the database and returning data for user queries
 */
public class App {

    private Connection connection = null;
    private World world = null;

    /**
     * Creates a connection to a mariadb database
     *
     * @param connectionString Where to connect to, usually db:3306 or localhost:3306
     * @param retries The number of times the connection should be attempted
     */
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

    /**
     * Close the connection to the database
     */
    public void disconnect() {
        if(connection != null) {
            try {
                connection.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Implements the feature to return all the countries in the world,
     * ordered by their population, largest to smallest
     *
     * @return A list of all the countries in the world, ordered by population
     */
    public ArrayList<Country> countriesInWorld() {
        //If world is not instantiated return null
        if(world == null) {
            return null;
        }

        ArrayList<Country> countries = new ArrayList<>();

        for(Continent continent : world.getContinents()) {
            for(Region region : continent.getRegions()) {
                countries.addAll(region.getCountries());
            }
        }

        countries.sort(Comparator.comparingLong(Country::getPopulation).reversed());

        return countries;
    }

    /**
     * Finds the top N countries in the world based on their population
     *
     * @param limit The number of countries to get
     * @return A list of N countries which have the most population
     */
    public ArrayList<Country> countriesInWorldLimit(int limit) {
        return new ArrayList<>(countriesInWorld().subList(0, limit));
    }

    /**
     * Implements the feature to return all the cities in the world,
     * ordered by their population, from largest to smallest
     *
     * @return A list of all cities in the world, ordered by population
     */
    public ArrayList<City> citiesInWorld() {
        //If world is not instantiated return null
        if(world == null) {
            return null;
        }

        ArrayList<City> cities = new ArrayList<>();

        for(Continent continent : world.getContinents()) {
            for(Region region : continent.getRegions()) {
                for(Country country : region.getCountries()) {
                    for(District district : country.getDistricts()) {
                        cities.addAll(district.getCities());
                    }
                }
            }
        }

        cities.sort(Comparator.comparingLong(City::getPopulation).reversed());

        return cities;
    }

    /**
     * Implements the feature to return all the capital cities in the world,
     * ordered by population
     *
     * @return List of all capital cities
     */
    public ArrayList<City> capitalCitiesInWorld() {
        //If world is not instantiated return null
        if(world == null) {
            return null;
        }

        ArrayList<City> capitalCities = new ArrayList<>();

        for(Continent continent : world.getContinents()) {
            for(Region region : continent.getRegions()) {
                for(Country country : region.getCountries()) {
                    if(country.getCapital() != null) {
                        capitalCities.add(country.getCapital());
                    }
                }
            }
        }

        capitalCities.sort(Comparator.comparingLong(City::getPopulation).reversed());

        return capitalCities;
    }

    /**
     * Finds the population of the whole world
     *
     * @return The population of the world
     */
    public long populationOfWorld() {
        if(world == null) {
            throw new NullPointerException();
        }

        return world.getPopulation();
    }

    /**
     * Implements the feature to return the population of a city
     *
     * @param cityName The name of the city to return the population of
     * @return Population of a city
     */
    public long populationOfCity(String cityName) {
        if (world == null) {
            throw new NullPointerException();
        }

        for (City city : citiesInWorld()) {
            if (city.getName().equals(cityName)) {
                return city.getPopulation();
            }
        }

        return -1;
    }

    /**
     * Implements feature to return the population of a region
     *
     * @param continentName Name of the continent where the region is
     * @param regionName Name of the region to return the population of
     *
     * @return Population of a given region if found, otherwise return -1
     */
    public long populationOfRegion(String continentName, String regionName) {
        if (world == null) {
            throw new NullPointerException();
        }

        for (Continent continent : world.getContinents()) {
            if (continent.getName().equals(continentName)) {
                for (Region region : continent.getRegions()) {
                    if(region.getName().equals(regionName)) {
                        return region.getPopulation();
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Implements feature to return the population of a given district
     *
     * @param countryName The country name of where the district is
     * @param districtName The district name to return the population of
     *
     * @return Population of given district if found, otherwise return -1
     */
    public long populationOfDistrict(String countryName, String districtName) {
        if (world == null) {
            throw new NullPointerException();
        }

        for (Country country : countriesInWorld()) {
            if (country.getName().equals(countryName)) {
                for (District district : country.getDistricts()) {
                    if (district.getName().equals(districtName)) {
                        return district.getPopulation();
                    }
                }
            }
        }
        return -1;
    }

    /**
     *
     *
     * @return Every language spoken in the world
     */
    public ArrayList<Language> languagesOfWorld() {
        if (world == null) {
            throw new NullPointerException();
        }

        ArrayList<Language> languages = new ArrayList<>();
        for (Continent continent : world.getContinents()) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    languages.addAll(country.getLanguages());
                }
            }
        }
        // Remove duplicated languages
        ArrayList<Language> uniqueLanguages = new ArrayList<>();
        Set<Language> uniqueValues = new HashSet<>();
        for (Language language : languages) {
            if (uniqueValues.add(language)) {
                uniqueLanguages.add(language);
            }
        }
        return uniqueLanguages;
    }

    /**
     * Loads the contents of the database into the world member variable
     */
    public void loadDatabase() {
        world = World.getInstance();
        world.setContinents(loadContinents());
    }

    /**
     * Queries the database for all the continents and creates the
     * relevant objects
     *
     * @return A list of all the continents
     */
    private ArrayList<Continent> loadContinents() {
        ArrayList<Continent> continents = new ArrayList<>();
        String query = "SELECT DISTINCT Continent FROM country;";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                String continentName = rs.getString("Continent");
                //Call the function to load all regions for a continent
                continents.add(new Continent(continentName, loadRegions(continentName)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return continents;
    }

    /**
     * Loads all the region data for a given continent from the database
     *
     * @param continentName The name of the continent for which we want the regions
     * @return A list of all regions for a given continent
     */
    private ArrayList<Region> loadRegions(String continentName) {
        ArrayList<Region> regions = new ArrayList<>();
        String query = "SELECT DISTINCT Region FROM country WHERE Continent = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, continentName);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String regionName = rs.getString("Region");
                //Call function to load countries for a region
                regions.add(new Region(regionName, loadCountries(regionName)));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return regions;
    }

    /**
     * Gets the required data for all the countries in a region
     *
     * @param regionName The region we want to get the countries from
     * @return A list of all countries for this region
     */
    private ArrayList<Country> loadCountries(String regionName) {
        ArrayList<Country> countries = new ArrayList<>();
        String query = "SELECT Code, Name, Capital, Population, Continent FROM country WHERE Region = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, regionName);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                //Put this in a variable to save writing this statement in multiple places
                String countryCode = rs.getString("Code");
                String countryName = rs.getString("Name");
                //Find the capital city
                City capital = loadCapital(countryCode);
                //Call function to load districts and to load languages
                countries.add(new Country(countryCode, countryName, loadDistricts(countryCode, rs.getString("Name"), capital),
                        capital, loadLanguages(countryCode), rs.getLong("Population"),
                        rs.getString("Continent"), regionName));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    /**
     * Gets a list of all the languages spoken for a specific country
     *
     * @param countryCode The country code for which we want the languages from
     * @return A list of all languages spoken in a country
     */
    private ArrayList<Language> loadLanguages(String countryCode) {
        ArrayList<Language> languages = new ArrayList<>();
        String query = "SELECT Language, IsOfficial, Percentage FROM countrylanguage WHERE CountryCode = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, countryCode);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                //Convert the database data into a boolean
                boolean isOfficial = rs.getString("isOfficial").equals("T");
                languages.add(new Language(rs.getString("Language"), rs.getDouble("Percentage"), isOfficial));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return languages;
    }

    /**
     * Finds a list of all the districts in a country
     *
     * @param countryCode The country code for the districts we want
     * @param countryName The country name for the current country as we need this as data
     *                    for all the cities in a district
     * @param capital We pass this because some countries do not have districts or even
     *                a capital so we can use this as a check here as well as passing
     *                it to the loadCities function to avoid duplicate data
     * @return A list of all districts for a country
     */
    private ArrayList<District> loadDistricts(String countryCode, String countryName, City capital) {
        ArrayList<District> districts = new ArrayList<>();

        //EDGE CASE: If there is no capital there will not be any districts so return early
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
                //Load cities into new district object
                districts.add(new District(districtName, loadCities(districtNameOrig, countryName, countryCode, capital)));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return districts;
    }

    /**
     * Finds the capital of a given country
     *
     * @param countryCode The country code for the capital that we need to find
     * @return An object representing the capital of a country
     */
    private City loadCapital(String countryCode) {
        String query = "SELECT city.Name, city.Population, District, country.Name FROM country LEFT JOIN city ON Capital = ID AND Code = CountryCode WHERE Code = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, countryCode);
            ResultSet rs = ps.executeQuery();

            //Get first result
            rs.next();

            //Without this we get City objects of {null, 0, true} for countries without a capital
            if(rs.getString("city.Name") == null) {
                return null;
            }

            String districtName = rs.getString("District");
            //If it's a strange value set it to something which makes more sense for the user
            if(districtName.equals("") || districtName.equals("–")) {
                districtName = "None";
            }

            return new City(rs.getString("city.Name"), rs.getInt("city.Population"), true,
                    rs.getString("country.Name"), districtName);

        } catch(SQLException e) {
            e.printStackTrace();
        }

        //Return null for any countries without a capital
        return null;
    }

    /**
     * Finds a list of all the cities in a given district.
     *
     * @param districtName The district we want to get the cities for
     * @param countryName The country the city is in
     * @param countryCode The country this district is in
     * @param capital The capital for this country in order to not have duplicate data
     * @return A list of all cities in a district
     */
    private ArrayList<City> loadCities(String districtName, String countryName, String countryCode, City capital) {
        ArrayList<City> cities = new ArrayList<>();
        String query = "SELECT Name, Population FROM city WHERE District = ? AND CountryCode = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, districtName);
            ps.setString(2, countryCode);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                //We don't want to double include the capital
                if(rs.getString("Name").equals(capital.getName())
                        && rs.getInt("Population") == capital.getPopulation()) {
                    cities.add(capital);
                } else {
                    cities.add(new City(rs.getString("Name"), rs.getInt("Population"), false,
                            countryName, districtName));
                }
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }
}
