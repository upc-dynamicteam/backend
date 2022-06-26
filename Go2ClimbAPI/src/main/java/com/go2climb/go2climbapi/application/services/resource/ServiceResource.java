package com.go2climb.go2climbapi.application.services.resource;

import com.go2climb.go2climbapi.application.agency.resource.AgencyResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResource {
    private Long id;
    private String name;
    private String description;
    private String location;
    private int score;
    private float price;
    private float newPrice;
    private String photos;
    private int isOffer;
    private int isPopular;
    private AgencyResource agency;
}
