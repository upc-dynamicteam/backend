package com.go2climb.go2climbapi.tourist.domain.model.entity;

import com.go2climb.go2climbapi.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Tourist extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String lastName;
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private int phoneNumber;
    @NotBlank
    @NotNull
    private String country;
    @NotBlank
    @NotNull
    private String password;
    @NotBlank
    @NotNull
    private String photo;

}
