package com.go2climb.go2climbapi.application.services.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateServiceResource {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @NotBlank
    private String location;
    @NotNull
    private int score;
    @NotNull
    private float price;
    @NotNull
    private float newPrice;
    @NotNull
    @NotBlank
    private String photos;
    @NotNull
    private boolean isOffer;
    @NotNull
    private boolean isPopular;
}
