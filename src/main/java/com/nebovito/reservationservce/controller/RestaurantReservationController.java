package com.nebovito.reservationservce.controller;

import com.nebovito.reservationservce.model.dto.TableReservationCollectionDto;
import com.nebovito.reservationservce.model.dto.TableReservationDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class RestaurantReservationController {

    public TableReservationDto createReservation() {
        throw new UnsupportedOperationException();
    }

    public void deleteReservation(UUID uuid) {

    }

    public TableReservationCollectionDto readTableReservations() {
        throw new UnsupportedOperationException();
    }
}
