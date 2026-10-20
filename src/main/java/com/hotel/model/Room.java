package com.hotel.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Room {
    @Getter @Setter
    private long id;
    @Getter @Setter
    private String roomNumber;
    @Getter @Setter
    private RoomType type;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private double pricePerNight;
    @Getter @Setter
    private int capacity;
    @Getter @Setter
    private RoomStatus status;
    @Getter @Setter
    private List<Reservation> reservations;

    public Room(long id, String roomNumber, String description, double pricePerNight, int capacity, RoomStatus status) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.status = status;
    }

}
