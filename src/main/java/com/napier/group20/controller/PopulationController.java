package com.napier.group20.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/population")
public class PopulationController {

    @RequestMapping("/report")
    public <T> List<T> getPopulatedPlaces(
            @RequestParam(value = "place") String place,
            @RequestParam(value = "place_type") String parentPlace,
            @RequestParam(value = "child_place") String childPlace,
            @RequestParam(value = "count") Optional<String> count
            ) {

        List<T> places = null;
        switch (parentPlace.toLowerCase()) {
            case "country":
                break;
            case "region":
                break;
        }
        return places;
    }

}
