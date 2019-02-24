package com.napier.group20.places;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    @Test
    void getName() {
        //Arrange
        City city = new City("City", null, null, 100, false);

        //Assert
        assertEquals("City", city.getName());
    }

    @Test
    void getCountry() {
        //Arrange
        Country country = new Country("ABC", "Country", null, null, null,
                null, null, 200);
        City city = new City("City", country, null, 100, false);

        //Assert
        assertEquals(country, city.getCountry());
    }

    @Test
    void getDistrict() {
        //Arrange
        District district = new District("District", null);
        City city = new City("City", null, district, 100, false);

        //Assert
        assertEquals(district, city.getDistrict());
    }

    @Test
    void getPopulation() {
        //Arrange
        City city = new City("City", null, null, 100, false);

        //Assert
        assertEquals(100, city.getPopulation());
    }

    @Test
    void isCapital() {
        //Arrange
        City city = new City("City", null, null, 100, true);

        //Assert
        assertTrue(city.isCapital());
    }
}
