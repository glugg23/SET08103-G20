package com.napier.group20.places;

public class City {
    private String name;
    private String country;
    private String district;
    private int population;
    private boolean isCapital;

    public City() {

    }

    public City(String name, String country, String district, int population, boolean isCapital) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public boolean isCapital() {
        return isCapital;
    }

}
