package com.go2climb.go2climbapi.application.hiredServices.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class HiredServiceResource {
    private Long id;
    private int amount;
    private Double price;
    private Date scheduledDate;
    private String status;

    //Relationships
    /*
    private CustomerResource customer;
    private AgencyResource agency;
     */
}
