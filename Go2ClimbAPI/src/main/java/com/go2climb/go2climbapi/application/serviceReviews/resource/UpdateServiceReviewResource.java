package com.go2climb.go2climbapi.application.serviceReviews.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateServiceReviewResource {
    private Long id;
    @NotNull
    @NotBlank
    private String comment;

    /*
    private Date date;*/

    @NotNull
    private float score;
}
