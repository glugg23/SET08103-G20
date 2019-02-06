package com.napier.group20.utils;

/**
 * An interface to define a method for getting the total population.
 *
 * We're using this because every other class that we use needs some
 * way to calculate its total population.
 */
public interface Population {
    long getPopulation();
}
