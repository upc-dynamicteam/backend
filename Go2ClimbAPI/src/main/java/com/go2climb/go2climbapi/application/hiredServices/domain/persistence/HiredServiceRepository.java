package com.go2climb.go2climbapi.application.hiredServices.domain.persistence;

import com.go2climb.go2climbapi.application.hiredServices.domain.model.entity.HiredService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
