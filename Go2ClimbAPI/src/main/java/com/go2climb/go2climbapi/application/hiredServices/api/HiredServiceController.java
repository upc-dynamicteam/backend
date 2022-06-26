package com.go2climb.go2climbapi.application.hiredServices.api;

import com.go2climb.go2climbapi.application.hiredServices.domain.service.HiredServiceService;
import com.go2climb.go2climbapi.application.hiredServices.mapping.HiredServiceMapper;
import com.go2climb.go2climbapi.application.hiredServices.resource.HiredServiceResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hired-services")
public class HiredServiceController {
    private final HiredServiceService hiredServiceService;

    private final HiredServiceMapper mapper;


    public HiredServiceController(HiredServiceService hiredServiceService, HiredServiceMapper mapper) {
        this.hiredServiceService = hiredServiceService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<HiredServiceResource> getAllHiredServices(Pageable pageable)
    {
        return mapper.modelListPage(hiredServiceService.getAll(), pageable);
    }

    @GetMapping("{hiredServiceId}")
    public HiredServiceResource getHiredServiceById(@PathVariable Long hiredServiceId) {
        return mapper.toResource(hiredServiceService.getById(hiredServiceId));
    }

    @GetMapping("touristId={touristId}")
    public Page<HiredServiceResource> getAllByTouristId(@PathVariable Long touristId, Pageable pageable) {
        return mapper.modelListPage(hiredServiceService.getAllByTouristId(touristId), pageable);
    }
}
