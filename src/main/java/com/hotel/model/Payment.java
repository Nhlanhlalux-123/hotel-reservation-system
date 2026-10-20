package com.hotel.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Payment {
    @Getter @Setter
    private long id;
    @Getter @Setter
    private Reservation reservation;
    @Getter @Setter
    private double amount;
    @Getter @Setter
    private PaymentMethod method;
    @Getter @Setter
    private PaymentStatus status;
    @Getter @Setter
    private LocalDate paymentDate;

}
