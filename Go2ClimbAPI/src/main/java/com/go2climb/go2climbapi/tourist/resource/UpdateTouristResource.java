package com.go2climb.go2climbapi.tourist.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateTouristResource {
    private Long id;
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
    private int number;
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
