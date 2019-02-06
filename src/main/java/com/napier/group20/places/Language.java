package com.napier.group20.places;

/**
 * Language.java
 *
 * Stores the language information of a country, including the
 * language name, the country code, what percentage of people speak it
 * and if it is the official language
 *
 */

public class Language {

    private String languageName;
    private String countryCode;
    private double percentage;
    private boolean isOfficial;

    public String getLanguageName() {
        return languageName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public double getPercentage() {
        return percentage;
    }

    public boolean isOfficial() {
        return isOfficial;
    }
}
