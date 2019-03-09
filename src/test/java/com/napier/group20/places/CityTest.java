package com.napier.group20.places;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CityTest {

    @Test
    void getName() {
        //Arrange
        City city = new City("City", 100, false);

        //Assert
        assertEquals("City", city.getName());
    }

    @Test
    void getPopulation() {
        //Arrange
        City city = new City("City", 100, false);

        //Assert
        assertEquals(100, city.getPopulation());
    }

    @Test
    void isCapital() {
        //Arrange
        City city = new City("City", 100, true);

        //Assert
        assertTrue(city.isCapital());
    }
}
