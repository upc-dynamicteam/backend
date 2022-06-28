package com.go2climb.go2climbapi.security.api;

import com.go2climb.go2climbapi.security.domain.service.UserService;
import com.go2climb.go2climbapi.security.domain.service.communication.AuthenticateRequest;
import com.go2climb.go2climbapi.security.domain.service.communication.RegisterRequest;
import com.go2climb.go2climbapi.security.mapping.UserMapper;
import com.go2climb.go2climbapi.security.resource.UserResource;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Users", description = "Create, read, update and deletes users")
@CrossOrigin(origins = "*", maxAge = 3600)
@SecurityRequirement(name = "acme")
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UsersController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticateRequest request)
    {
        return userService.authenticate(request);
    }

    @PostMapping("/auth/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request)
    {
        return userService.register(request);
    }

    @GetMapping
    @PreAuthorize("hasRole('AGENCY')")
    public ResponseEntity<?> getAllUsers(Pageable pageable){
        Page<UserResource> resources = userMapper.modelListToPage(userService.getAll(),pageable);
        return ResponseEntity.ok(resources);
    }
}
