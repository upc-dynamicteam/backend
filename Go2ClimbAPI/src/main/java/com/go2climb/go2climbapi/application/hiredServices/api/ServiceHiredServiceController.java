package com.go2climb.go2climbapi.application.hiredServices.api;

import com.go2climb.go2climbapi.application.hiredServices.domain.service.HiredServiceService;
import com.go2climb.go2climbapi.application.hiredServices.mapping.HiredServiceMapper;
import com.go2climb.go2climbapi.application.hiredServices.resource.CreateHiredServiceResource;
import com.go2climb.go2climbapi.application.hiredServices.resource.HiredServiceResource;
import com.go2climb.go2climbapi.application.hiredServices.resource.UpdateHiredServiceResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/services/{serviceId}/hired-services")
public class ServiceHiredServiceController {

    private final HiredServiceService hiredServiceService;

    private final HiredServiceMapper mapper;

    public ServiceHiredServiceController(HiredServiceService hiredServiceService, HiredServiceMapper mapper) {
        this.hiredServiceService = hiredServiceService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<HiredServiceResource> getAllByServiceId(Long serviceId, Pageable pageable) {
        return mapper.modelListPage(hiredServiceService.getAllByServiceId(serviceId), pageable);
    }

    @PostMapping("touristId={touristId}")
    public HiredServiceResource createHiredService(@PathVariable Long serviceId, @PathVariable Long touristId,
                                                     @RequestBody CreateHiredServiceResource resource) {
        return mapper.toResource(hiredServiceService.create(serviceId, touristId, mapper.toModel(resource)));
    }

    @PutMapping("touristId={touristId}/{hiredServiceId}")
    public HiredServiceResource updateHiredService(@PathVariable Long hiredServiceId, @PathVariable Long touristId,
                                                     @PathVariable Long serviceId, @RequestBody UpdateHiredServiceResource resource) {
        return mapper.toResource(hiredServiceService.update(serviceId, touristId, hiredServiceId, mapper.toModel(resource)));
    }

    @DeleteMapping("touristId={touristId}/{hiredServiceId}")
    public ResponseEntity<?> deleteHiredService(@PathVariable Long hiredServiceId, @PathVariable Long touristId,
                                                 @PathVariable Long serviceId) {
        return hiredServiceService.delete(serviceId, touristId, hiredServiceId);
    }
}
