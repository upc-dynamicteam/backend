package com.go2climb.go2climbapi.application.hiredServices.domain.service;

import com.go2climb.go2climbapi.application.hiredServices.domain.model.entity.HiredService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HiredServiceService {

    List<HiredService> getAll();

    HiredService getById(Long hiredServiceId);

    List<HiredService> getAllByServiceId(Long serviceId);

    List<HiredService> getAllByTouristId(Long touristId);

    HiredService create (Long serviceId, Long touristId, HiredService hiredService);
    HiredService update(Long serviceId, Long touristId, Long hiredServiceId, HiredService hiredService);
    //HiredService patch(Long serviceId, Long touristId, Long hiredServiceId, HiredService hiredService);
    ResponseEntity<?> delete(Long serviceId, Long touristId, Long hiredServiceId);

}
