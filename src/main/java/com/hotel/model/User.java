package com.hotel.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class User {
    @Getter @Setter
    private long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private Role role;
    @Getter @Setter
    private LocalDate createdAT;
    @Getter @Setter
    private List<Reservation> reservations;

    public User(){
    }
}
