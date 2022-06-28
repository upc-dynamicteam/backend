package com.go2climb.go2climbapi.application.services.api;

import com.go2climb.go2climbapi.application.services.domain.service.ServiceService;
import com.go2climb.go2climbapi.application.services.mapping.ServiceMapper;
import com.go2climb.go2climbapi.application.services.resource.ServiceResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
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

    @GetMapping("isOffer={isOffer}")
    public Page<ServiceResource> getAllByIsOffer(@PathVariable int isOffer, Pageable pageable) {
        System.out.print("s");
        return mapper.modelListPage(serviceService.getAllByIsOffer(isOffer), pageable);
    }

    @GetMapping("isPopular={isPopular}")
    public Page<ServiceResource> getAllByIsPopular(@PathVariable int isPopular, Pageable pageable) {
        return mapper.modelListPage(serviceService.getAllByIsPopular(isPopular), pageable);
    }

    @GetMapping("name_like={text}")
    public Page<ServiceResource> getAllByText(@PathVariable String text, Pageable pageable) {
        return mapper.modelListPage(serviceService.getAllByText(text), pageable);
    }

    //funciona
    @GetMapping("{serviceId}")
    public ServiceResource getById (@PathVariable Long serviceId) {
        return mapper.toResource(serviceService.getInfoServiceById(serviceId));
    }
}
