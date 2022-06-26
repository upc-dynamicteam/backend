package com.go2climb.go2climbapi.application.services.domain.service;

import com.go2climb.go2climbapi.application.services.domain.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceService {

    List<Service> getAll();

    List<Service> getAllByAgencyId(Long agencyId);

    Page<Service> getAllByAgencyId(Long agencyId, Pageable pageable);

    Service create(Long agencyId, Service service);

    Service update(Long agencyId, Long serviceId, Service service);

    ResponseEntity<?> delete(Long agencyId, Long serviceId);

}
