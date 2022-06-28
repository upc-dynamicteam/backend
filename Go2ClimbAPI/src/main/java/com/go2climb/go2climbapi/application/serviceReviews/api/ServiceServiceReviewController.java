package com.go2climb.go2climbapi.application.serviceReviews.api;

import com.go2climb.go2climbapi.application.serviceReviews.domain.service.ServiceReviewService;
import com.go2climb.go2climbapi.application.serviceReviews.mapping.ServiceReviewMapper;
import com.go2climb.go2climbapi.application.serviceReviews.resource.CreateServiceReviewResource;
import com.go2climb.go2climbapi.application.serviceReviews.resource.ServiceReviewResource;
import com.go2climb.go2climbapi.application.serviceReviews.resource.UpdateServiceReviewResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/services/{serviceId}/service-reviews")
public class ServiceServiceReviewController {

    private final ServiceReviewService serviceReviewService;

    private final ServiceReviewMapper mapper;

    public ServiceServiceReviewController(ServiceReviewService serviceReviewService, ServiceReviewMapper mapper) {
        this.serviceReviewService = serviceReviewService;
        this.mapper = mapper;
    }


    @GetMapping
    public Page<ServiceReviewResource> getAllByServiceId(@PathVariable Long serviceId, Pageable pageable) {
        return mapper.modelListPage(serviceReviewService.getAllByServiceId(serviceId), pageable);
    }

    @PostMapping("touristId={touristId}")
    public ServiceReviewResource createServiceReview(@PathVariable Long serviceId, @PathVariable Long touristId,
                                                   @RequestBody CreateServiceReviewResource resource) {
        return mapper.toResource(serviceReviewService.create(serviceId, touristId, mapper.toModel(resource)));
    }

    @PutMapping("touristId={touristId}/{serviceReviewId}")
    public ServiceReviewResource updateServiceReview(@PathVariable Long serviceReviewId, @PathVariable Long touristId,
                                                   @PathVariable Long serviceId, @RequestBody UpdateServiceReviewResource resource) {
        return mapper.toResource(serviceReviewService.update(serviceId, touristId, serviceReviewId, mapper.toModel(resource)));
    }

    @DeleteMapping("touristId={touristId}/{serviceReviewId}")
    public ResponseEntity<?> deleteServiceReview(@PathVariable Long serviceReviewId, @PathVariable Long touristId,
                                                @PathVariable Long serviceId) {
        return serviceReviewService.delete(serviceId, touristId, serviceReviewId);
    }
}
