package com.go2climb.go2climbapi.hiredServices.domain.persistence;

import com.go2climb.go2climbapi.hiredServices.domain.model.entity.HiredService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HiredServiceRepository extends JpaRepository<HiredService, Long> {

    /*
    List<HiredService> findByCustomerId (Long customerId);
    Page<HiredService> findByCustomerId (Long customerId, Pageable pageable);

    List<HiredService> findByAgencyId (Long agencyId);
    Page<HiredService> findByAgencyId (Long agencyId, Pageable pageable);
     */

    /*
    HiredService Add(HiredService hiredService);
    void Update(HiredService hiredService);
    void Remove(HiredService hiredService);
     */

    /*
    Optional<HiredService> findByIdAndCustomerId (Long id, Long customerId);
     */
}
