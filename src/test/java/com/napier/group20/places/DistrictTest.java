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
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("City1", null, null, 100,true));
        cities.add(new City("City2", null, null, 100,false));
        cities.add(new City("City3", null, null, 100,false));

        District district = new District("District", cities);

        // Assert
        assertEquals(cities, district.getCities());
    }

    @Test
    void getPopulation() {
        // Arrange
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("City1", null, null, 100,true));
        cities.add(new City("City2", null, null, 100,false));
        cities.add(new City("City3", null, null, 100,false));

        District district = new District("District", cities);

        // Assert
        assertEquals(300, district.getPopulation());
    }

}
