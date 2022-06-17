package com.go2climb.go2climbapi.tourist.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor

public class TouristResource {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String country;
    private String password;
    private String photo;
}
