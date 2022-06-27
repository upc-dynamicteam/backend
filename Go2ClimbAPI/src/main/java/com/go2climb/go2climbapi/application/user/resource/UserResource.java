package com.go2climb.go2climbapi.application.user.resource;

import com.go2climb.go2climbapi.security.resource.RoleResource;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResource {
    private Long id;
    private String email;
    private List<RoleResource> roles;
}

