package com.go2climb.go2climbapi.application.serviceReviews.domain.model.entity;

import com.go2climb.go2climbapi.application.services.domain.model.entity.Service;
import com.go2climb.go2climbapi.application.tourists.domain.model.entity.Tourist;
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
@Table(name = "service_reviews")
public class ServiceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    private Date date;*/

    @NotNull
    @NotBlank
    private String comment;

    @NotNull
    private float score;

    //Relationships
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tourist_id", nullable = false)
    private Tourist tourist;
}
