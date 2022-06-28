package com.go2climb.go2climbapi.security.api;

import com.go2climb.go2climbapi.security.domain.service.RoleService;
import com.go2climb.go2climbapi.security.mapping.RoleMapper;
import com.go2climb.go2climbapi.security.resource.RoleResource;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Roles", description = "Create, read, update and deletes roles")
@CrossOrigin(origins = "*", maxAge = 3600)
@SecurityRequirement(name = "acme")
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    public RoleController(RoleService roleService, RoleMapper roleMapper){
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('TOURIST') or hasRole('AGENCY')")
    public ResponseEntity<?> getAllRoles(Pageable pageable){
        Page<RoleResource> resources = roleMapper.modelListToPage(roleService.getAll(),
                pageable);
        return  ResponseEntity.ok(resources);

    }

}
