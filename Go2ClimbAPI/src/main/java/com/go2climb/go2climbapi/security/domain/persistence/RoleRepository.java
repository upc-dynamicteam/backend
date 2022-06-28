package com.go2climb.go2climbapi.security.domain.persistence;

import com.go2climb.go2climbapi.security.domain.model.entity.Role;
import com.go2climb.go2climbapi.security.domain.model.enumeration.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Roles name);

    boolean existsByName(Roles name);
}

