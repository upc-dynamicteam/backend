package com.go2climb.go2climbapi.security.domain.service;

import com.go2climb.go2climbapi.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {
    void seed();

    List<Role> getAll();
}
