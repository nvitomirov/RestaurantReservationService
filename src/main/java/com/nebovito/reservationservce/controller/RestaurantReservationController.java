package com.nebovito.reservationservce.controller;

import com.nebovito.reservationservce.model.dto.TableReservationCollectionDto;
import com.nebovito.reservationservce.model.dto.TableReservationDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class RestaurantReservationController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public TableReservationDto createReservation(@RequestBody TableReservationDto tableReservation) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(UUID uuid) {

    }

    @GetMapping
    @ResponseBody
    public TableReservationCollectionDto readTableReservations() {
        throw new UnsupportedOperationException();
    }
}
