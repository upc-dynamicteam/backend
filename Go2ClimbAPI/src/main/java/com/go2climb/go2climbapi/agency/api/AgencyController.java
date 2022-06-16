package com.go2climb.go2climbapi.agency.api;

import com.go2climb.go2climbapi.agency.domain.service.AgencyService;
import com.go2climb.go2climbapi.agency.mapping.AgencyMapper;
import com.go2climb.go2climbapi.agency.resource.CreateAgencyResource;
import com.go2climb.go2climbapi.agency.resource.AgencyResource;
import com.go2climb.go2climbapi.agency.resource.UpdateAgencyResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/agency")
public class AgencyController {
    private final AgencyService agencyService;
    private final AgencyMapper mapper;

    public AgencyController(AgencyService agencyService, AgencyMapper mapper) {
        this.agencyService = agencyService;
        this.mapper = mapper;
    }

    @GetMapping("{agencyId}")
    public AgencyResource getInfoAgencyById(@PathVariable Long agencyId) {
        return mapper.toResource(agencyService.getInfoAgencyById(agencyId));
    }

    @PostMapping
    public AgencyResource createAgency(@RequestBody CreateAgencyResource resource){
        return mapper.toResource(agencyService.create(mapper.toModel(resource)));
    }

    @PutMapping
    public AgencyResource updateAgency(@PathVariable Long agencyId, @RequestBody UpdateAgencyResource resource) {
        return mapper.toResource(agencyService.update(agencyId, mapper.toModel(resource)));
    }
}
