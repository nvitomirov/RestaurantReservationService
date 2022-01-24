package com.nebovito.reservationservce.model.entities;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name="restaurantTable")
public class RestaurantTable {
    @Id
    private UUID id;
    @Column
    private Integer number;
    @Column
    private String code;
    @Column
    private Integer numberOfSeats;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="restaurantId", referencedColumnName = "id")
    private Restaurant restaurant;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}