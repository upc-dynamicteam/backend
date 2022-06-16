package com.go2climb.go2climbapi.agency.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateAgencyResource {
    private Long id;

    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private String password;
    @NotBlank
    @NotNull
    private int phoneNumber;
    @NotBlank
    @NotNull
    private String description;
    @NotBlank
    @NotNull
    private String location;
    @NotBlank
    @NotNull
    private long ruc;
    @NotBlank
    @NotNull
    private String photo;
    @NotBlank
    @NotNull
    private int score;
}
