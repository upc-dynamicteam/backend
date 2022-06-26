package com.go2climb.go2climbapi.application.tourists.api;

import com.go2climb.go2climbapi.application.tourists.domain.service.TouristService;
import com.go2climb.go2climbapi.application.tourists.resource.TouristResource;
import com.go2climb.go2climbapi.application.tourists.resource.UpdateTouristResource;
import com.go2climb.go2climbapi.application.tourists.mapping.TouristMapper;
import com.go2climb.go2climbapi.application.tourists.resource.CreateTouristResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tourists")
public class TouristController {
    private final TouristService touristService;
    private final TouristMapper mapper;

    public TouristController(TouristService touristService, TouristMapper mapper) {
        this.touristService = touristService;
        this.mapper = mapper;
    }

    //funciona
    @GetMapping
    public Page<TouristResource> getAllTourists(Pageable pageable)
    {
        return mapper.modelListPage(touristService.getAll(), pageable);
    }

    //funciona
    @GetMapping("{touristId}")
    public TouristResource getInfoUserById(@PathVariable Long touristId) {
        return mapper.toResource(touristService.getInfoUserById(touristId));
    }

    //funciona
    @PostMapping
    public TouristResource createUser(@RequestBody CreateTouristResource resource){
        return mapper.toResource(touristService.create(mapper.toModel(resource)));
    }

    //funciona
    @PutMapping("/{touristId}")
    public TouristResource updateUser(@PathVariable Long touristId, @RequestBody UpdateTouristResource resource) {
        return mapper.toResource(touristService.update(touristId, mapper.toModel(resource)));
    }

    //funciona
    @DeleteMapping("{touristId}")
    public ResponseEntity<?> deleteTourist(@PathVariable Long touristId) {
        return touristService.delete(touristId);
    }
}
