package com.nebovito.reservationservce.model.dto;

import java.util.UUID;

public class RestaurantDto {

    private UUID id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
