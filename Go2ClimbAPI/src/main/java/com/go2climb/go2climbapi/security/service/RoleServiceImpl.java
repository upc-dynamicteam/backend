package com.go2climb.go2climbapi.security.service;

import com.go2climb.go2climbapi.security.domain.model.entity.Role;
import com.go2climb.go2climbapi.security.domain.model.enumeration.Roles;
import com.go2climb.go2climbapi.security.domain.persistence.RoleRepository;
import com.go2climb.go2climbapi.security.domain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    private static String[] DEFAULT_ROLES = {"ROLE_USER", "ROLE_TOURIST", "ROLES_AGENCY"};

    @Override
    public void seed(){
        Arrays.stream(DEFAULT_ROLES).forEach(
                name ->{ Roles roleName = Roles.valueOf(name);
                         if (!roleRepository.existsByName(roleName)){
                            roleRepository.save((new Role()).withName(roleName));}
                        }
                        );
    }

    @Override
    public List<Role> getAll(){
        return roleRepository.findAll();
    }
}
