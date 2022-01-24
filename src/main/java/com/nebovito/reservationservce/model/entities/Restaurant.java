package com.nebovito.reservationservce.model.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="restaurant")
public class Restaurant {

    @Id
    private UUID id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String description;

    @OneToMany
    private Set<RestaurantTable> tables;

    public Set<RestaurantTable> getTables() {
        return tables;
    }

    public void setTables(Set<RestaurantTable> tables) {
        this.tables = tables;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
