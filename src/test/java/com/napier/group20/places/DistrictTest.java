package com.napier.group20.places;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DistrictTest {

    @Test
    void getName() {
        // Arrange
        District district = new District("District", null);
        // Assert
        assertEquals("District", district.getName());
    }

    @Test
    void getCities() {
        // Arrange
        City city1 = new City("City1", null, null, 100,true);
        City city2 = new City("City2", null, null, 100,false);
        City city3 = new City("City3", null, null, 100,false);

        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);

        District district = new District("District", cities);

        // Assert
        assertEquals(cities, district.getCities());
    }

    @Test
    void getPopulation() {
        // Arrange
        City city = new City("City", null, null, 12345,true);

        // Assert
        assertEquals(12345, city.getPopulation());
    }

}
