package com.go2climb.go2climbapi.application.services.api;

import com.go2climb.go2climbapi.application.services.domain.service.ServiceService;
import com.go2climb.go2climbapi.application.services.mapping.ServiceMapper;
import com.go2climb.go2climbapi.application.services.resource.ServiceResource;
import com.go2climb.go2climbapi.application.services.resource.UpdateServiceResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/agencies/{agencyId}/services")
public class AgencyServiceController {

    private final ServiceService serviceService;

    private final ServiceMapper mapper;

    public AgencyServiceController(ServiceService serviceService, ServiceMapper mapper) {
        this.serviceService = serviceService;
        this.mapper = mapper;
    }

    //funciona
    @GetMapping
    public Page<ServiceResource> getAllServicesByAgencyId(Long agencyId, Pageable pageable) {
        return mapper.modelListPage(serviceService.getAllByAgencyId(agencyId), pageable);
    }

    //funciona
    @PostMapping
    public ServiceResource createService(Long agencyId, @RequestBody UpdateServiceResource resource) {
        return mapper.toResource(serviceService.create(agencyId, mapper.toModel(resource)));
    }

    //funciona
    @PutMapping("{serviceId}")
    public ServiceResource updateService(@PathVariable Long serviceId,
                                         Long agencyId, UpdateServiceResource resource) {
        return mapper.toResource(serviceService.update(agencyId, serviceId, mapper.toModel(resource)));
    }

    //funciona
    @DeleteMapping("{serviceId}")
    public ResponseEntity<?> deleteService(Long agencyId, @PathVariable Long serviceId) {
        return serviceService.delete(agencyId, serviceId);
    }
}
