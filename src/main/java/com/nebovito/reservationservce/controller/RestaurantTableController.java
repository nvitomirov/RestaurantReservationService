package com.nebovito.reservationservce.controller;

import com.nebovito.reservationservce.model.dto.RestaurantTableCollectionDto;
import com.nebovito.reservationservce.model.dto.RestaurantTableDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/tables")
public class RestaurantTableController {


    public RestaurantTableDto createRestaurantTable(RestaurantTableDto table) {
        throw new UnsupportedOperationException();
    }

    public void deleteRestaurantTable(UUID id) {

    }

    public RestaurantTableCollectionDto readTables() {
        throw new UnsupportedOperationException();
    }

    public RestaurantTableCollectionDto readTables(Integer guests, OffsetDateTime dateTime) {
        throw new UnsupportedOperationException();
    }
}
