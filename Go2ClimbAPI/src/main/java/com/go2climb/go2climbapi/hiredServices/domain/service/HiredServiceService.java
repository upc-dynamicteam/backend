package com.go2climb.go2climbapi.hiredServices.domain.service;

import com.go2climb.go2climbapi.hiredServices.domain.model.entity.HiredService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HiredServiceService {

    List<HiredService> getAll();

    List<HiredService> getAllByCustomerId(Long customerId);
    Page<HiredService> getAllByCustomerId(Long customerId, Pageable pageable);

    List<HiredService> getAllByAgencyId(Long agencyId);
    Page<HiredService> getAllByAgencyId(Long agencyId, Pageable pageable);

    HiredService getById(Long hiredServiceId);

    HiredService create (HiredService hiredService);
    HiredService update(Long hiredServiceId, HiredService hiredService);
    ResponseEntity<?> delete(Long hiredServiceId);

}
