package com.napier.group20;

import com.napier.group20.places.City;
import com.napier.group20.places.Country;
import com.napier.group20.utils.App;
import com.napier.group20.utils.LanguageReport;
import com.napier.group20.utils.PopulationReport;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.connect("db:3306", 10);

        app.loadDatabase();

        app.disconnect();

        ArrayList<Country> topNCountries = app.topPopulatedCountriesInContinent("Europe", 5);
        for (Country country : topNCountries) {
            System.out.println(country.toString());
        }

        ArrayList<LanguageReport> languagesOfWorld = app.languagesOfWorld();
        for (LanguageReport report : languagesOfWorld) {
            System.out.println(report.toString());
        }

        long populationOfWorld = app.populationOfWorld();
        System.out.println(populationOfWorld);

        long populationOfCity = app.populationOfCity("Edinburgh");
        System.out.println(populationOfCity);

        long populationOfRegion = app.populationOfRegion("Asia", "Southern and Central Asia");
        System.out.println(populationOfRegion);

        long populationOfDistrict = app.populationOfDistrict("Argentina", "Buenos Aires");
        System.out.println(populationOfDistrict);

        PopulationReport continentReport = app.continentPopulationReport("Europe");
        System.out.println(continentReport.toString());
    }
}
