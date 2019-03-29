package com.napier.group20.utils;

import com.napier.group20.places.City;
import com.napier.group20.places.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    /**
     * A generic method for getting the SHA1 hash of a list
     *
     * @param list The list the hash should be made from
     * @param <T> The object type of the list
     * @return A SHA1 hash of all the elements in the list combined together
     */
    <T> String listToSHA1(ArrayList<T> list) {
        StringBuilder hashBuffer = new StringBuilder();
        for(T item : list) {
            hashBuffer.append(item.toString());
        }

        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.update(hashBuffer.toString().getBytes(StandardCharsets.UTF_8));
            sha1 = Base64.getEncoder().encodeToString(crypt.digest());

        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sha1;
    }


    @BeforeAll
    static void init() {
        App.connect("localhost:3306", 1); //This needs to be localhost and not db for some reason
        App.loadDatabase();
        App.disconnect();
    }

    @Test
    void countriesInWorld() {
        //Act
        ArrayList<Country> actual = App.countriesInWorld();

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(239, actual.size());
        assertEquals("8/o7+3uFB368QRAhQIW5SAtTv3c=", sha1);
    }

    @Test
    void countriesInWorldLimit() {
        //Act
        ArrayList<Country> actual = App.countriesInWorldLimit(10);

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(10, actual.size());
        assertEquals("gzS4OY2UtuwBQQRgHK5B684fAFM=", sha1);
    }

    @Test
    void citiesInWorld() {
        //Act
        ArrayList<City> actual = App.citiesInWorld();

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(4079, actual.size());
        assertEquals("UU7JcDurNp+9OTIUDyWE8WBGKY0=", sha1);
    }

    @Test
    void capitalCitiesInWorld() {
        //Act
        ArrayList<City> actual = App.capitalCitiesInWorld();

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(232, actual.size());
        assertEquals("/cv/yz9MRMjtp4igMHEEnKnw+6Y=", sha1);
    }

    @Test
    void populationOfWorld() {
        //Arrange
        long expected = 6078749450L;

        //Act
        long actual = App.populationOfWorld();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfCity() {
        //Arrange
        long expected = 450180;

        //Act
        long actual = App.populationOfCity("Edinburgh");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfCityNotFound() {
        //Arrange
        long expected = -1;

        //Act
        long actual = App.populationOfCity("Does not exist");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfRegion() {
        //Arrange
        long expected = 1490776000;

        //Act
        long actual = App.populationOfRegion("Asia", "Southern and Central Asia");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfRegionNotFound() {
        //Arrange
        long expected = -1;

        //Act
        long actual = App.populationOfRegion("Does not exist", "Does not exist");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfDistrict() {
        //Arrange
        long expected = 10530136;

        //Act
        long actual = App.populationOfDistrict("Argentina", "Buenos Aires");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfDistrictNotFound() {
        //Arrange
        long expected = -1;

        //Act
        long actual = App.populationOfDistrict("Does not exist", "Does not exist");

        //Assert
        assertEquals(expected, actual);
    }
}
