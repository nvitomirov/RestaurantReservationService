package com.nebovito.reservationservce.controller;

import com.nebovito.reservationservce.model.dto.RestaurantCollectionDto;
import com.nebovito.reservationservce.model.dto.RestaurantDto;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.NotSupportedException;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RestaurantDto createRestaurant(@RequestBody RestaurantDto restaurant) {
        //TODO
        throw new UnsupportedOperationException();
    }

    @GetMapping
    @ResponseBody
    public RestaurantCollectionDto readRestaurants() {
        //TODO
        throw new UnsupportedOperationException();
    }

}
