package com.go2climb.go2climbapi.agency.mapping;

import com.go2climb.go2climbapi.shared.mapping.EnhancedModelMapper;
import com.go2climb.go2climbapi.agency.domain.model.entity.Agency;
import com.go2climb.go2climbapi.agency.resource.CreateAgencyResource;
import com.go2climb.go2climbapi.agency.resource.AgencyResource;
import com.go2climb.go2climbapi.agency.resource.UpdateAgencyResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AgencyMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;


    public AgencyResource toResource(Agency model) { return mapper.map(model, AgencyResource.class); }

    public Agency toModel(CreateAgencyResource resource) { return mapper.map(resource, Agency.class); }

    public Agency toModel(UpdateAgencyResource resource) { return mapper.map(resource, Agency.class); }
}
