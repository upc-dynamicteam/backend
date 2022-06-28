package com.go2climb.go2climbapi.application.agencyReviews.api;

import com.go2climb.go2climbapi.application.agencyReviews.domain.service.AgencyReviewService;
import com.go2climb.go2climbapi.application.agencyReviews.mapping.AgencyReviewMapper;
import com.go2climb.go2climbapi.application.agencyReviews.resource.AgencyReviewResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/agency-reviews")
public class AgencyReviewController {

    private final AgencyReviewService agencyReviewService;

    private final AgencyReviewMapper mapper;


    public AgencyReviewController(AgencyReviewService agencyReviewService, AgencyReviewMapper mapper) {
        this.agencyReviewService = agencyReviewService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<AgencyReviewResource> getAllAgencyReviews(Pageable pageable) {
        return mapper.modelListPage(agencyReviewService.getAll(), pageable);
    }

    @GetMapping("touristId={touristId}")
    public Page<AgencyReviewResource> getAllByTouristId(@PathVariable Long touristId, Pageable pageable) {
        return mapper.modelListPage(agencyReviewService.getAllByTouristId(touristId), pageable);
    }
}
