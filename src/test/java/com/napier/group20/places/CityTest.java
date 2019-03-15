package com.napier.group20.places;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CityTest {

    @Test
    void getName() {
        //Arrange
        City city = new City("City", 100, false, null, null);

        //Assert
        assertEquals("City", city.getName());
    }

    @Test
    void getPopulation() {
        //Arrange
        City city = new City("City", 100, false, null, null);

        //Assert
        assertEquals(100, city.getPopulation());
    }

    @Test
    void isCapital() {
        //Arrange
        City city = new City("City", 100, true, null, null);

        //Assert
        assertTrue(city.isCapital());
    }

    @Test
    void getCountry() {
        //Arrange
        City city = new City("City", 100, false, "Country", null);

        //Assert
        assertEquals("Country", city.getCountry());
    }

    @Test
    void getDistrict() {
        //Arrange
        City city = new City("City", 100, false, null, "District");

        //Assert
        assertEquals("District", city.getDistrict());
    }

    @Test
    void toStringTest() {
        //Arrange
        City city = new City("City", 100, true, "Country", "District");

        //Assert
        assertEquals("City{name='City', population=100, country='Country', district='District'}", city.toString());
    }
}
