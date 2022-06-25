package com.go2climb.go2climbapi.application.hiredServices.service;

import com.go2climb.go2climbapi.application.hiredServices.domain.model.entity.HiredService;
import com.go2climb.go2climbapi.application.hiredServices.domain.persistence.HiredServiceRepository;
import com.go2climb.go2climbapi.application.hiredServices.domain.service.HiredServiceService;
import com.go2climb.go2climbapi.shared.exception.ResourceNotFoundException;
import com.go2climb.go2climbapi.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class HiredServiceServiceImpl implements HiredServiceService {
    private static final String ENTITY = "HiredService";

    private final HiredServiceRepository hiredServiceRepository;

    private final Validator validator;

    public HiredServiceServiceImpl(HiredServiceRepository hiredServiceRepository, Validator validator) {
        this.hiredServiceRepository = hiredServiceRepository;
        this.validator = validator;
    }

    @Override
    public List<HiredService> getAll() {
        return hiredServiceRepository.findAll();
    }

    @Override
    public List<HiredService> getAllByCustomerId(Long customerId) {
        return null;
    }

    @Override
    public Page<HiredService> getAllByCustomerId(Long customerId, Pageable pageable) {
        return null;
    }

    @Override
    public List<HiredService> getAllByAgencyId(Long agencyId) {
        return null;
    }

    @Override
    public Page<HiredService> getAllByAgencyId(Long agencyId, Pageable pageable) {
        return null;
    }

    @Override
    public HiredService getById(Long hiredServiceId) {
        return hiredServiceRepository.findById(hiredServiceId).orElseThrow(() ->
                new ResourceNotFoundException(ENTITY, hiredServiceId));
    }

    @Override
    public HiredService create(HiredService hiredService) {
        Set<ConstraintViolation<HiredService>> violations = validator.validate(hiredService);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return hiredServiceRepository.save(hiredService);
    }

    @Override
    public HiredService update(Long hiredServiceId, HiredService request) {
        Set<ConstraintViolation<HiredService>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return hiredServiceRepository.findById(hiredServiceId).map(hiredService ->
                        hiredServiceRepository.save(hiredService.withAmount(request.getAmount()).withPrice(request.getPrice()).withScheduledDate(request.getScheduledDate()).withStatus(request.getStatus())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, hiredServiceId));
    }

    @Override
    public ResponseEntity<?> delete(Long hiredServiceId) {
        return hiredServiceRepository.findById(hiredServiceId).map(
                hiredService -> {
                    hiredServiceRepository.delete(hiredService);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, hiredServiceId));
    }
}
