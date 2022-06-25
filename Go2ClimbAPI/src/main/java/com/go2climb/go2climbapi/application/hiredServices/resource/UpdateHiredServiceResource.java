package com.go2climb.go2climbapi.application.hiredServices.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UpdateHiredServiceResource {
    private Long id;
    @NotBlank
    @NotNull
    private int amount;
    @NotBlank
    @NotNull
    private Double price;
    @NotBlank
    @NotNull
    private Date scheduledDate;
    @NotBlank
    @NotNull
    private String status;
}
