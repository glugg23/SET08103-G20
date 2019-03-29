package com.napier.group20.utils;

/**
 *  PopulationReport.java
 *
 *  A class to represent the information needed for a population report
 */
public class PopulationReport {
    private String name;
    private long totalPopulation;
    private long cityPopulation;
    private long nonCityPopulation;

    /**
     * Constructs a new object and sets the required values
     *
     * @param name The name of the place the population report is for
     * @param cityPopulation The city population of that place
     * @param totalPopulation The total population of that place
     */
    public PopulationReport(String name, long cityPopulation, long totalPopulation) {
        this.name = name;
        this.cityPopulation = cityPopulation;
        this.totalPopulation = totalPopulation;
        this.nonCityPopulation = totalPopulation - cityPopulation;
    }

    /**
     *
     * @return Name of population report
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return Total population in cities
     */
    public long getCityPopulation() {
        return cityPopulation;
    }

    /**
     *
     * @return Total population not in cities
     */
    public long getNonCityPopulation() {
        return nonCityPopulation;
    }

    /**
     *
     * @return Total population
     */
    public long getTotalPopulation() {
        return totalPopulation;
    }

    /**
     *
     * @return Percentage of people in cities
     */
    public double getCityPopulationPercentage() {
        return (double) cityPopulation / totalPopulation;
    }

    /**
     *
     * @return Percentage of people not in cities
     */
    public double getNonCityPopulationPercentage() {
        return (double) nonCityPopulation / totalPopulation;
    }

    /**
     *
     * @return String representation of report
     */
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
