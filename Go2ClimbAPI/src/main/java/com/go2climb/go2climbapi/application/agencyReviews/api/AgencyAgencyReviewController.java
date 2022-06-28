package com.go2climb.go2climbapi.application.agencyReviews.api;

import com.go2climb.go2climbapi.application.agencyReviews.domain.service.AgencyReviewService;
import com.go2climb.go2climbapi.application.agencyReviews.mapping.AgencyReviewMapper;
import com.go2climb.go2climbapi.application.agencyReviews.resource.AgencyReviewResource;
import com.go2climb.go2climbapi.application.agencyReviews.resource.CreateAgencyReviewResource;
import com.go2climb.go2climbapi.application.agencyReviews.resource.UpdateAgencyReviewResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/agencies/{agencyId}/agency-reviews")
public class AgencyAgencyReviewController {

    private final AgencyReviewService agencyReviewService;

    private final AgencyReviewMapper mapper;

    public AgencyAgencyReviewController(AgencyReviewService agencyReviewService, AgencyReviewMapper mapper) {
        this.agencyReviewService = agencyReviewService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<AgencyReviewResource> getAllByAgencyId(@PathVariable Long agencyId, Pageable pageable) {
        return mapper.modelListPage(agencyReviewService.getAllByAgencyId(agencyId), pageable);
    }

    @PostMapping("touristId={touristId}")
    public AgencyReviewResource createAgencyReview(@PathVariable Long agencyId, @PathVariable Long touristId,
                                                   @RequestBody CreateAgencyReviewResource resource) {
        return mapper.toResource(agencyReviewService.create(agencyId, touristId, mapper.toModel(resource)));
    }

    @PutMapping("touristId={touristId}/{agencyReviewId}")
    public AgencyReviewResource updateAgencyReview(@PathVariable Long agencyReviewId, @PathVariable Long touristId,
                                                   @PathVariable Long agencyId, @RequestBody UpdateAgencyReviewResource resource) {
        return mapper.toResource(agencyReviewService.update(agencyId, touristId, agencyReviewId, mapper.toModel(resource)));
    }

    @DeleteMapping("touristId={touristId}/{agencyReviewId}")
    public ResponseEntity<?> deleteAgencyReview(@PathVariable Long agencyReviewId, @PathVariable Long touristId,
                                                @PathVariable Long agencyId) {
        return agencyReviewService.delete(agencyId, touristId, agencyReviewId);
    }

}
