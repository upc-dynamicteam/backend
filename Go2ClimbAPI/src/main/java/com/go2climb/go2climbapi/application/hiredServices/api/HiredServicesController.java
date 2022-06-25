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
@RequestMapping("api/v1/hiredServices")
public class HiredServicesController {
    private final HiredServiceService hiredServiceService;

    private final HiredServiceMapper mapper;


    public HiredServicesController(HiredServiceService hiredServiceService, HiredServiceMapper mapper) {
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

    @PostMapping
    public HiredServiceResource createHiredService(@RequestBody CreateHiredServiceResource resource){
        return mapper.toResource(hiredServiceService.create(mapper.toModel(resource)));
    }

    @PutMapping
    public HiredServiceResource updateHiredService(@PathVariable Long hiredServiceId, @RequestBody UpdateHiredServiceResource resource) {
        return mapper.toResource(hiredServiceService.update(hiredServiceId, mapper.toModel(resource)));
    }

    @DeleteMapping("{hiredServiceId}")
    public ResponseEntity<?> deleteHiredService(@PathVariable Long hiredServiceId) {
        return hiredServiceService.delete(hiredServiceId);
    }
}
