package com.go2climb.go2climbapi.tourist.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTouristResource {
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String lastName;
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private int phoneNumber;
    @NotBlank
    @NotNull
    private String country;
    @NotBlank
    @NotNull
    private String password;
    @NotBlank
    @NotNull
    private String photo;
}
