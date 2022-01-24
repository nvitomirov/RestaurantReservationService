package com.nebovito.reservationservce.model.entities;


import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="tableReservation")
public class TableReservation {
    @Id
    private UUID id;
    @Column
    private String reservationName;
    @Column
    private OffsetDateTime timeOfReservation;
    @Column
    private Integer numberOfGuests;
    @ManyToOne
    @JoinColumn(name="tableId", referencedColumnName = "id")
    private RestaurantTable table;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public RestaurantTable getTable() {
        return table;
    }

    public void setTable(RestaurantTable table) {
        this.table = table;
    }
}
