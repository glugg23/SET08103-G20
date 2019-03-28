package com.napier.group20.utils;

public class PopulationReport {
    private String name;
    private long cityPopulation;
    private long nonCityPopulation;

    public PopulationReport(String name, long cityPopulation, long nonCityPopulation) {
        this.name = name;
        this.cityPopulation = cityPopulation;
        this.nonCityPopulation = nonCityPopulation;
    }

    public String getName() {
        return name;
    }

    public long getCityPopulation() {
        return cityPopulation;
    }

    public long getNonCityPopulation() {
        return nonCityPopulation;
    }

    public long getTotalPopulation() {
        return cityPopulation + nonCityPopulation;
    }

    public double getCityPopulationPercentage() {
        return (double) cityPopulation / getTotalPopulation();
    }

    public double getNonCityPopulationPercentage() {
        return (double) nonCityPopulation / getTotalPopulation();
    }

    @Override
    public String toString() {
        return "PopulationReport{" +
                "name='" + name + '\'' +
                ", totalPopulation=" + getTotalPopulation() +
                ", cityPopulation=" + cityPopulation +
                " (" + getCityPopulationPercentage() + "%)" +
                ", nonCityPopulation=" + nonCityPopulation +
                " (" + getNonCityPopulationPercentage() + "%)" +
                '}';
    }
}
