package com.go2climb.go2climbapi.application.serviceReviews.api;

import com.go2climb.go2climbapi.application.serviceReviews.domain.service.ServiceReviewService;
import com.go2climb.go2climbapi.application.serviceReviews.mapping.ServiceReviewMapper;
import com.go2climb.go2climbapi.application.serviceReviews.resource.ServiceReviewResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/service-reviews")
public class ServiceReviewController {

    private final ServiceReviewService serviceReviewService;

    private final ServiceReviewMapper mapper;

    public ServiceReviewController(ServiceReviewService serviceReviewService, ServiceReviewMapper mapper) {
        this.serviceReviewService = serviceReviewService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ServiceReviewResource> getAllServiceReviews(Pageable pageable) {
        return mapper.modelListPage(serviceReviewService.getAll(), pageable);
    }

    @GetMapping("touristId={touristId}")
    public Page<ServiceReviewResource> getAllByTouristId(@PathVariable Long touristId, Pageable pageable) {
        return mapper.modelListPage(serviceReviewService.getAllByTouristId(touristId), pageable);
    }
}
