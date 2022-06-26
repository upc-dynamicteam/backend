package com.go2climb.go2climbapi.application.serviceReviews.resource;

import com.go2climb.go2climbapi.application.services.resource.ServiceResource;
import com.go2climb.go2climbapi.application.tourists.resource.TouristResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ServiceReviewResource {
    private Long id;
    //private Date date;
    private String comment;
    private float score;
    private ServiceResource service;
    private TouristResource tourist;
}
