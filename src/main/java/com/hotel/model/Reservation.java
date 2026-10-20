package com.hotel.model;

import java.time.LocalDate;

public class Reservation {
    private long id;
    private User user;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int guestCount;
    private double totalPrice;
    private ReservationStatus status;
    private LocalDate createdAt;
    private Payment payment;
}
