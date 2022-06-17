package com.go2climb.go2climbapi.tourist.api;

import com.go2climb.go2climbapi.tourist.domain.service.TouristService;
import com.go2climb.go2climbapi.tourist.mapping.TouristMapper;
import com.go2climb.go2climbapi.tourist.resource.CreateTouristResource;
import com.go2climb.go2climbapi.tourist.resource.TouristResource;
import com.go2climb.go2climbapi.tourist.resource.UpdateTouristResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class TouristController {
    private final TouristService touristService;
    private final TouristMapper mapper;

    public TouristController(TouristService touristService, TouristMapper mapper) {
        this.touristService = touristService;
        this.mapper = mapper;
    }

    @GetMapping("{touristId}")
    public TouristResource getInfoUserById(@PathVariable Long touristId) {
        return mapper.toResource(touristService.getInfoUserById(touristId));
    }

    @PostMapping
    public TouristResource createUser(@RequestBody CreateTouristResource resource){
        return mapper.toResource(touristService.create(mapper.toModel(resource)));
    }

    @PutMapping
    public TouristResource updateUser(@PathVariable Long touristId, @RequestBody UpdateTouristResource resource) {
        return mapper.toResource(touristService.update(touristId, mapper.toModel(resource)));
    }
}
