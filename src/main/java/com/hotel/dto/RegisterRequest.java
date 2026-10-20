package com.hotel.dto;

import lombok.Getter;
import lombok.Setter;

public class RegisterRequest {
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String password;
}
