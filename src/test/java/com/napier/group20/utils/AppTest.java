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
import static org.junit.jupiter.api.Assertions.assertNull;

class AppTest {
    private static App app;

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
        app = new App();
        app.connect("localhost:3306", 1); //This needs to be localhost and not db for some reason
        app.loadDatabase();
        app.disconnect();
    }

    @Test
    void countriesInWorld() {
        //Act
        ArrayList<Country> actual = app.countriesInWorld();

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(239, actual.size());
        assertEquals("8/o7+3uFB368QRAhQIW5SAtTv3c=", sha1);
    }

    @Test
    void countriesInWorldLimit() {
        //Act
        ArrayList<Country> actual = app.countriesInWorldLimit(10);

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(10, actual.size());
        assertEquals("gzS4OY2UtuwBQQRgHK5B684fAFM=", sha1);
    }

    @Test
    void citiesInWorld() {
        //Act
        ArrayList<City> actual = app.citiesInWorld();

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(4079, actual.size());
        assertEquals("UU7JcDurNp+9OTIUDyWE8WBGKY0=", sha1);
    }

    @Test
    void capitalCitiesInWorld() {
        //Act
        ArrayList<City> actual = app.capitalCitiesInWorld();

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(232, actual.size());
        assertEquals("/cv/yz9MRMjtp4igMHEEnKnw+6Y=", sha1);
    }

    @Test
    void citiesInCountry() {
        //Act
        ArrayList<City> actual = app.citiesInCountry("Norway");

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(5, actual.size());
        assertEquals("gpqL4gN7I198D4qZ/x8k/jqXnCM=", sha1);
    }

    @Test
    void citiesInCountryLimit() {
        //Act
        ArrayList<City> actual = app.citiesInCountryLimit("Norway", 2);

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(2, actual.size());
        assertEquals("ToM0/1a6X+708RfHwQJFLt1YBYQ=", sha1);
    }

    @Test
    void citiesInDistrict() {
        //Act
        ArrayList<City> actual = app.citiesInDistrict("Buenos Aires");

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(31, actual.size());
        assertEquals("fTxddv3wTKPZdZvCR8iqAfaOxCs=", sha1);
    }

    @Test
    void citiesInDistrictLimit() {
        //Act
        ArrayList<City> actual = app.citiesInDistrictLimit("Buenos Aires", 10);

        //Assert
        String sha1 = listToSHA1(actual);
        assertEquals(10, actual.size());
        assertEquals("0O6su4YbZ6DCs81cWaTeqDywRLY=", sha1);
    }

    @Test
    void populationOfWorld() {
        //Arrange
        long expected = 6078749450L;

        //Act
        long actual = app.populationOfWorld();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfCountry() {
        //Arrange
        long expected = 4478500;

        //Act
        long actual = app.populationOfCountry("Norway");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfCity() {
        //Arrange
        long expected = 450180;

        //Act
        long actual = app.populationOfCity("Edinburgh");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfCityNotFound() {
        //Arrange
        long expected = -1;

        //Act
        long actual = app.populationOfCity("Does not exist");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfRegion() {
        //Arrange
        long expected = 1490776000;

        //Act
        long actual = app.populationOfRegion("Asia", "Southern and Central Asia");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfRegionNotFound() {
        //Arrange
        long expected = -1;

        //Act
        long actual = app.populationOfRegion("Does not exist", "Does not exist");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfDistrict() {
        //Arrange
        long expected = 10530136;

        //Act
        long actual = app.populationOfDistrict("Argentina", "Buenos Aires");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfDistrictNotFound() {
        //Arrange
        long expected = -1;

        //Act
        long actual = app.populationOfDistrict("Does not exist", "Does not exist");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void continentPopulationReport() {
        //Arrange
        String expected = "PopulationReport{name='Europe', totalPopulation=730074600, cityPopulation=241942813 (0.33139464514996136%), nonCityPopulation=488131787 (0.6686053548500386%)}";

        //Act
        PopulationReport actual = app.continentPopulationReport("Europe");

        //Assert
        assertEquals(expected, actual.toString());
    }

    @Test
    void continentPopulationReportNotFound() {
        //Act
        PopulationReport report = app.continentPopulationReport("Does not exist");

        //Assert
        assertNull(report);
    }

    @Test
    void regionPopulationReport() {
        //Arrange
        String expected = "PopulationReport{name='Melanesia', totalPopulation=6472000, cityPopulation=484459 (0.07485460444993819%), nonCityPopulation=5987541 (0.9251453955500618%)}";

        //Act
        PopulationReport actual = app.regionPopulationReport("Melanesia");

        //Assert
        assertEquals(expected, actual.toString());
    }
}
