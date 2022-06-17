package com.go2climb.go2climbapi.tourist.domain.service;

import com.go2climb.go2climbapi.tourist.domain.model.entity.Tourist;

public interface TouristService {
    // Create a new user
    Tourist create(Tourist tourist);

    // Update user
    Tourist update(Long touristId, Tourist tourist);

    // Get info user by id
    Tourist getInfoUserById(Long touristId);
}
