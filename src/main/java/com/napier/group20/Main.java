package com.napier.group20;

import com.napier.group20.places.City;
import com.napier.group20.places.Country;
import com.napier.group20.utils.App;
import com.napier.group20.utils.LanguageReport;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.err.println("Usage: SET08103-G20 {ip address}");
            return;
        }

        System.out.println("Loading database, this may take a while.");

        String connectionString = String.format("%s:3306", args[0]);
        App app = new App();
        app.connect(connectionString, 10);

        app.loadDatabase();

        System.out.println("Finished loading database.");

        app.disconnect();

        Scanner menuIn = new Scanner(System.in);
        Scanner answerIn = new Scanner(System.in);
        int input = 0;

        do {
            System.out.print("Question ID [1-32, 0 to quit]: ");

            try {
                input = menuIn.nextInt();
            } catch(InputMismatchException e) {
                input = -1;
            }

            switch(input) {
                case 0:
                    break;

                case 1: {
                    System.out.println("All the countries in the world organised by largest population to smallest.");
                    ArrayList<Country> countries = app.countriesInWorld();

                    for(Country c : countries) {
                        System.out.println(c);
                    }

                    break;
                }

                case 2: {
                    System.out.println("All the countries in a continent organised by largest population to smallest.");
                    System.out.print("Continent: ");
                    String search = answerIn.nextLine();

                    ArrayList<Country> countries = app.countriesInContinent(search);
                    for(Country c : countries) {
                        System.out.println(c);
                    }

                    break;
                }

                case 3: {
                    System.out.println("All the countries in a region organised by largest population to smallest.");
                    System.out.print("Region: ");
                    String search = answerIn.nextLine();

                    ArrayList<Country> countries = app.countriesInRegion(search);
                    for(Country c : countries) {
                        System.out.println(c);
                    }

                    break;
                }

                case 4: {
                    System.out.println("The top N populated countries in the world where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    ArrayList<Country> countries = app.countriesInWorldLimit(limit);
                    for(Country c : countries) {
                        System.out.println(c);
                    }

                    break;
                }

                case 5: {
                    System.out.println("The top N populated countries in a continent where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    answerIn.nextLine(); //Clear buffer

                    System.out.print("Continent: ");
                    String search = answerIn.nextLine();

                    ArrayList<Country> countries = app.topPopulatedCountriesInContinent(search, limit);
                    for(Country c : countries) {
                        System.out.println(c);
                    }

                    break;
                }

                case 6: {
                    System.out.println("The top N populated countries in a region where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    answerIn.nextLine(); //Clear buffer

                    System.out.print("Region: ");
                    String search = answerIn.nextLine();

                    ArrayList<Country> countries = app.mostPopulatedCountryRegion(limit, search);
                    for(Country c : countries) {
                        System.out.println(c);
                    }

                    break;
                }

                case 7: {
                    System.out.println("All the cities in the world organised by largest population to smallest.");
                    ArrayList<City> cities = app.citiesInWorld();

                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 8: {
                    System.out.println("All the cities in a continent organised by largest population to smallest.");
                    System.out.print("Continent: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.citiesInContinent(search);

                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 9: {
                    System.out.println("All the cities in a region organised by largest population to smallest.");
                    System.out.print("Region: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.citiesInRegion(search);

                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 10: {
                    System.out.println("All the cities in a country organised by largest population to smallest.");
                    System.out.print("Country: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.citiesInCountry(search);

                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 11: {
                    System.out.println("All the cities in a district organised by largest population to smallest.");
                    System.out.print("District: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.citiesInDistrict(search);

                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 12: {
                    System.out.println("The top N populated cities in the world where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    ArrayList<City> cities = app.mostPopulatedCities(limit);
                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 13: {
                    System.out.println("The top N populated cities in a continent where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    answerIn.nextLine(); //Clear buffer

                    System.out.print("Continent: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.topPopulatedCitiesInContinent(search, limit);
                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 14: {
                    System.out.println("The top N populated cities in a region where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    answerIn.nextLine(); //Clear buffer

                    System.out.print("Region: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.citiesInRegionLimit(search, limit);
                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 15: {
                    System.out.println("The top N populated cities in a country where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    answerIn.nextLine(); //Clear buffer

                    System.out.print("Country: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.citiesInCountryLimit(search, limit);
                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 16: {
                    System.out.println("The top N populated cities in a district where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    answerIn.nextLine(); //Clear buffer

                    System.out.print("District: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.citiesInDistrictLimit(search, limit);
                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 17: {
                    System.out.println("All the capital cities in the world organised by largest population to smallest.");
                    ArrayList<City> cities = app.capitalCitiesInWorld();

                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 18: {
                    System.out.println("All the capital cities in a continent organised by largest population to smallest.");
                    System.out.print("Continent: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.capitalCitiesInContinent(search);

                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 19: {
                    System.out.println("All the capital cities in a region organised by largest population to smallest.");
                    System.out.print("Region: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.capitalCitiesInRegion(search);

                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 20: {
                    System.out.println("The top N populated capital cities in the world where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    ArrayList<City> cities = app.mostPopulatedCapitals(limit);
                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 21: {
                    System.out.println("The top N populated capital cities in a continent where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    answerIn.nextLine(); //Clear buffer

                    System.out.print("Continent: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.mostPopulatedCapitalsContinent(limit, search);
                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }

                case 22: {
                    System.out.println("The top N populated capital cities in a region where N is provided by the user.");
                    System.out.print("N: ");

                    int limit;
                    try {
                        limit = answerIn.nextInt();
                    } catch(InputMismatchException e) {
                        limit = 0;
                        answerIn.nextLine();
                    }

                    if(limit < 0) {
                        break;
                    }

                    answerIn.nextLine(); //Clear buffer

                    System.out.print("Region: ");
                    String search = answerIn.nextLine();

                    ArrayList<City> cities = app.mostPopulatedCapitalsRegion(limit, search);
                    for(City c : cities) {
                        System.out.println(c);
                    }

                    break;
                }
                case 23: {
                    System.out.println("The population of people, people living in cities, and people not living in cities in each continent.");
                    System.out.print("Continent: ");
                    String search = answerIn.nextLine();

                    System.out.println(app.continentPopulationReport(search));

                    break;
                }

                case 24: {
                    System.out.println("The population of people, people living in cities, and people not living in cities in each region.");
                    System.out.print("Region: ");
                    String search = answerIn.nextLine();

                    System.out.println(app.regionPopulationReport(search));

                    break;
                }

                case 25: {
                    System.out.println("The population of people, people living in cities, and people not living in cities in each country.");
                    System.out.print("Country: ");
                    String search = answerIn.nextLine();

                    System.out.println(app.countryPopulationReport(search));

                    break;
                }

                case 26: {
                    System.out.println("The population of the world.");
                    System.out.println(app.populationOfWorld());
                    break;
                }

                case 27: {
                    System.out.println("The population of a continent.");
                    System.out.print("Continent: ");

                    String search = answerIn.nextLine();

                    System.out.println(app.continentPopulationReport(search));
                    break;
                }

                case 28: {
                    System.out.println("The population of a region.");
                    System.out.print("Region: ");

                    String search = answerIn.nextLine();

                    System.out.println(app.regionPopulationReport(search));
                    break;
                }

                case 29: {
                    System.out.println("The population of a country.");
                    System.out.print("Country: ");

                    String search = answerIn.nextLine();

                    System.out.println(app.countryPopulationReport(search));
                    break;
                }

                case 30: {
                    System.out.println("The population of a district.");
                    System.out.print("District: ");

                    String search = answerIn.nextLine();

                    System.out.println(app.populationOfDistrict(search));
                    break;
                }

                case 31: {
                    System.out.println("The population of a city.");
                    System.out.print("City: ");

                    String search = answerIn.nextLine();

                    System.out.println(app.populationOfCity(search));

                    break;
                }

                case 32: {
                    System.out.println("The number of people who speak Chinese, English, Hindi, Spanish or Arabic in the world.");

                    ArrayList<LanguageReport> languageReports = app.languagesOfWorld();
                    for(LanguageReport report : languageReports) {
                        System.out.println(report);
                    }


                    break;
                }

                default:
                    System.err.println("ERROR: Unknown question ID");
                    menuIn.nextLine(); //Clear input buffer
            }

        } while(input != 0);
    }
}
