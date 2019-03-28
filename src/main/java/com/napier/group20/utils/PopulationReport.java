package com.napier.group20.utils;

public class PopulationReport {
    private String name;
    private long totalPopulation;
    private long cityPopulation;
    private long nonCityPopulation;

    public PopulationReport(String name, long cityPopulation, long totalPopulation) {
        this.name = name;
        this.cityPopulation = cityPopulation;
        this.totalPopulation = totalPopulation;
        this.nonCityPopulation = totalPopulation - cityPopulation;
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
        return totalPopulation;
    }

    public double getCityPopulationPercentage() {
        return (double) cityPopulation / totalPopulation;
    }

    public double getNonCityPopulationPercentage() {
        return (double) nonCityPopulation / totalPopulation;
    }

    @Override
    public String toString() {
        return "PopulationReport{" +
                "name='" + name + '\'' +
                ", totalPopulation=" + totalPopulation +
                ", cityPopulation=" + cityPopulation +
                " (" + getCityPopulationPercentage() + "%)" +
                ", nonCityPopulation=" + nonCityPopulation +
                " (" + getNonCityPopulationPercentage() + "%)" +
                '}';
    }
}
