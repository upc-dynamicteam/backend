package com.go2climb.go2climbapi.agency.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor

public class AgencyResource {
    private Long id;
    private String name;
    private String email;
    private String password;
    private int phoneNumber;
    private String description;
    private String location;
    private long ruc;
    private String photo;
    private int score;
}
