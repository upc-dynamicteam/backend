package com.go2climb.go2climbapi.tourist.mapping;

import com.go2climb.go2climbapi.shared.mapping.EnhancedModelMapper;
import com.go2climb.go2climbapi.tourist.domain.model.entity.Tourist;
import com.go2climb.go2climbapi.tourist.resource.CreateTouristResource;
import com.go2climb.go2climbapi.tourist.resource.TouristResource;
import com.go2climb.go2climbapi.tourist.resource.UpdateTouristResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class TouristMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;


    public TouristResource toResource(Tourist model) { return mapper.map(model, TouristResource.class); }

    public Tourist toModel(CreateTouristResource resource) { return mapper.map(resource, Tourist.class); }

    public Tourist toModel(UpdateTouristResource resource) { return mapper.map(resource, Tourist.class); }
}
