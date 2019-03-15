package com.napier.group20.places;

import com.napier.group20.utils.Population;

import java.util.ArrayList;

/**
 * Country.java
 *
 * Stores the country's attributes
 *
 */

public class Country implements Population {

    private String countryCode;
    private String name;
    private ArrayList<District> districts;
    private City capital;
    private ArrayList<Language> languages;
    private long population;
    private String continent;
    private String region;

    public Country(String countryCode, String name, ArrayList<District> districts, City capital,
                   ArrayList<Language> languages, long population, String continent, String region) {
        this.countryCode = countryCode;
        this.name = name;
        this.districts = districts;
        this.capital = capital;
        this.languages = languages;
        this.population = population;
        this.continent = continent;
        this.region = region;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public City getCapital() {
        return capital;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public ArrayList<Language> getOfficialLanguages() {
        ArrayList<Language> officialLanguages = new ArrayList<>();
        for(Language language : languages) {
            if(language.isOfficial()) {
                officialLanguages.add(language);
            }
        }

        if(officialLanguages.isEmpty()) {
            return null;
        }

        return officialLanguages;
    }

    public long getPopulation() {
        return population;
    }

    public long getCitiesPopulation() {
        long countryPopulation = 0;
        for (District district : districts) {
            countryPopulation += district.getPopulation();
        }
        return countryPopulation;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    //TODO: Write unit test once City class has been updated with toString method
    @Override
    public String toString() {
        return "Country{" +
                "countryCode='" + countryCode + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital=" + capital +
                '}';
    }
}
