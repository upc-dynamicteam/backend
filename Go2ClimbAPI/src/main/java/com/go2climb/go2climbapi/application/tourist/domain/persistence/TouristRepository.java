package com.go2climb.go2climbapi.application.tourist.domain.persistence;

import com.go2climb.go2climbapi.application.tourist.domain.model.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository  extends JpaRepository<Tourist, Long> {
    Tourist findByEmail(String email);
    Tourist findByPhoneNumber(int phoneNumber);
}
