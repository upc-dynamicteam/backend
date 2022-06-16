package com.go2climb.go2climbapi.agency.domain.service;

import com.go2climb.go2climbapi.agency.domain.model.entity.Agency;

public interface AgencyService {
    // Create a new agency
    Agency create(Agency agency);

    // Update agency
    Agency update(Long agencyId, Agency agency);

    // Get info agency by id
    Agency getInfoAgencyById(Long agencyId);
}
