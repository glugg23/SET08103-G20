package com.napier.group20.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PopulationReportTest {

    @Test
    void getName() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 400);

        //Assert
        assertEquals("Test", populationReport.getName());
    }

    @Test
    void getCityPopulation() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 400);

        //Assert
        assertEquals(100, populationReport.getCityPopulation());
    }

    @Test
    void getNonCityPopulation() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 400);

        //Assert
        assertEquals(300, populationReport.getNonCityPopulation());
    }

    @Test
    void getTotalPopulation() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 400);

        //Assert
        assertEquals(400, populationReport.getTotalPopulation());
    }

    @Test
    void getCityPopulationPercentage() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 400);

        //Assert
        assertEquals(25.0, populationReport.getCityPopulationPercentage());
    }

    @Test
    void getNonCityPopulationPercentage() {
        //Arrange
        PopulationReport populationReport = new PopulationReport("Test", 100, 400);

        //Assert
        assertEquals(75.0, populationReport.getNonCityPopulationPercentage());
    }

    @Test
    void toStringTest() {
        //Arrange
        String expect = "PopulationReport{name='Test', totalPopulation=400, cityPopulation=100 (25.00%), nonCityPopulation=300 (75.00%)}";
        PopulationReport populationReport = new PopulationReport("Test", 100, 400);

        //Assert
        assertEquals(expect, populationReport.toString());
    }
}
