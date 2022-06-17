package com.go2climb.go2climbapi.tourist.service;

import com.go2climb.go2climbapi.shared.exception.ResourceNotFoundException;
import com.go2climb.go2climbapi.shared.exception.ResourceValidationException;
import com.go2climb.go2climbapi.tourist.domain.model.entity.Tourist;
import com.go2climb.go2climbapi.tourist.domain.persistence.TouristRepository;
import com.go2climb.go2climbapi.tourist.domain.service.TouristService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class TouristServiceIn implements TouristService {
    private static final String ENTITY = "TouristService";

    private final TouristRepository touristRepository;

    private final Validator validator;

    public TouristServiceIn(TouristRepository touristRepository, Validator validador) {
        this.touristRepository = touristRepository;
        this.validator = validador;
    }
    @Override
    public Tourist create(Tourist tourist){
        Set<ConstraintViolation<Tourist>> violations = validator.validate(tourist);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return touristRepository.save(tourist);
    }
    @Override
    public Tourist update(Long touristId, Tourist request){
        Set<ConstraintViolation<Tourist>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return touristRepository.findById(touristId).map(tourist ->
                        touristRepository.save(tourist))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, touristId));
    }

    @Override
    public Tourist getInfoUserById(Long touristId){
        return touristRepository.findById(touristId).orElseThrow(() ->
                new ResourceNotFoundException(ENTITY, touristId));
    }
}
