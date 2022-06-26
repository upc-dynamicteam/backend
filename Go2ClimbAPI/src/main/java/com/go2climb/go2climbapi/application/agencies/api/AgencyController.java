package com.go2climb.go2climbapi.application.agencies.api;

import com.go2climb.go2climbapi.application.agencies.domain.service.AgencyService;
import com.go2climb.go2climbapi.application.agencies.mapping.AgencyMapper;
import com.go2climb.go2climbapi.application.agencies.resource.AgencyResource;
import com.go2climb.go2climbapi.application.agencies.resource.CreateAgencyResource;
import com.go2climb.go2climbapi.application.agencies.resource.UpdateAgencyResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/agencies")
public class AgencyController {
    private final AgencyService agencyService;
    private final AgencyMapper mapper;

    public AgencyController(AgencyService agencyService, AgencyMapper mapper) {
        this.agencyService = agencyService;
        this.mapper = mapper;
    }

    //funciona
    @GetMapping
    public Page<AgencyResource> getAllAgencies(Pageable pageable)
    {
        return mapper.modelListPage(agencyService.getAll(), pageable);
    }

    //funciona
    @GetMapping("{agencyId}")
    public AgencyResource getInfoAgencyById(@PathVariable Long agencyId) {
        return mapper.toResource(agencyService.getInfoAgencyById(agencyId));
    }

    //funciona
    @PostMapping
    public AgencyResource createAgency(@RequestBody CreateAgencyResource resource){
        return mapper.toResource(agencyService.create(mapper.toModel(resource)));
    }

    //funciona
    @PutMapping("/{agencyId}")
    public AgencyResource updateAgency(@PathVariable Long agencyId, @RequestBody UpdateAgencyResource resource) {
        return mapper.toResource(agencyService.update(agencyId, mapper.toModel(resource)));
    }

    //funciona
    @DeleteMapping("{agencyId}")
    public ResponseEntity<?> deleteAgency(@PathVariable Long agencyId) {
        return agencyService.delete(agencyId);
    }
}
