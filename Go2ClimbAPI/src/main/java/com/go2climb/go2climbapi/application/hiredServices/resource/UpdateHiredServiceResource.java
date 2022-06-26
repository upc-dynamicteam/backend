package com.go2climb.go2climbapi.application.hiredServices.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHiredServiceResource {
    private Long id;
    @NotNull
    private int amount;
    @NotNull
    private Double price;
    @NotNull
    private Date scheduledDate;
    @NotBlank
    @NotNull
    private String status;
}
