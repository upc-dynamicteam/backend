package com.go2climb.go2climbapi.application.services.api;

import com.go2climb.go2climbapi.application.services.domain.service.ServiceService;
import com.go2climb.go2climbapi.application.services.mapping.ServiceMapper;
import com.go2climb.go2climbapi.application.services.resource.ServiceResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/services")
public class ServiceController {
    private final ServiceService serviceService;
    private final ServiceMapper mapper;

    public ServiceController(ServiceService serviceService, ServiceMapper mapper) {
        this.serviceService = serviceService;
        this.mapper = mapper;
    }

    //funciona
    @GetMapping
    public Page<ServiceResource> getAllServices(Pageable pageable) {
        return mapper.modelListPage(serviceService.getAll(), pageable);
    }

    //funciona
    @GetMapping("{serviceId}")
    public ServiceResource getById (@PathVariable Long serviceId) {
        return mapper.toResource(serviceService.getInfoServiceById(serviceId));
    }
}
