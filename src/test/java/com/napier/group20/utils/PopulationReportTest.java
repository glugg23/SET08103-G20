package com.napier.group20.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PopulationReportTest {

    @Test
    void getName() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 300);

        //Assert
        assertEquals("Test", populationReport.getName());
    }

    @Test
    void getCityPopulation() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 300);

        //Assert
        assertEquals(100, populationReport.getCityPopulation());
    }

    @Test
    void getNonCityPopulation() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 300);

        //Assert
        assertEquals(300, populationReport.getNonCityPopulation());
    }

    @Test
    void getTotalPopulation() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 300);

        //Assert
        assertEquals(400, populationReport.getTotalPopulation());
    }

    @Test
    void getCityPopulationPercentage() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 300);

        //Assert
        assertEquals(0.25, populationReport.getCityPopulationPercentage());
    }

    @Test
    void getNonCityPopulationPercentage() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 300);

        //Assert
        assertEquals(0.75, populationReport.getNonCityPopulationPercentage());
    }

    @Test
    void toStringTest() {
        //Arrange
        String expect = "PopulationReport{name='Test', totalPopulation=400, cityPopulation=100 (0.25%), nonCityPopulation=300 (0.75%)}";
        PopulationReport populationReport = new PopulationReport("Test", 100, 300);

        //Assert
        assertEquals(expect, populationReport.toString());
    }
}
