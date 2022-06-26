package com.go2climb.go2climbapi.application.agencyReviews.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAgencyReviewResource {
    private Long id;
    @NotNull
    @NotBlank
    private String comment;

    /*
    private Date date;*/

    @NotNull
    private float professionalism;

    @NotNull
    private float security;

    @NotNull
    private float quality;

    @NotNull
    private float cost;
}
