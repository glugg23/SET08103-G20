package com.napier.group20.utils;

/**
 *  A class to calculate the number of people that speak a language
 */
public class LanguageReport {
    private String languageName;
    private long speakerPopulation = 0;
    private double worldPercentage = 0;

    /**
     *
     * @param languageName The name of the language
     */
    public LanguageReport(String languageName) {
        this.languageName = languageName;
    }

    /**
     *
     * @return The name of the language
     */
    public String getLanguageName() {
        return languageName;
    }

    /**
     *
     * @return The number of people that speak it
     */
    public long getSpeakerPopulation() {
        return speakerPopulation;
    }

    /**
     *
     * @param speakers Add a number of people that speak it
     */
    public void addSpeakerPopulation(long speakers) {
        speakerPopulation += speakers;
    }

    /**
     *
     * @param worldPopulation The world's population
     */
    public void calculateWorldPercentage(long worldPopulation) {
        worldPercentage = ((double) speakerPopulation / worldPopulation) * 100;
    }

    /**
     *
     * @return The percentage of people who speak it
     */
    public double getWorldPercentage() {
        return worldPercentage;
    }

    /**
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "LanguageReport{" +
                "languageName='" + languageName + '\'' +
                ", speakerPopulation=" + speakerPopulation +
                String.format(", worldPercentage=%.2f%%", worldPercentage) +
                '}';
    }
}
