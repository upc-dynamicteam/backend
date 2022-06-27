package com.go2climb.go2climbapi.application.user.service;

import com.go2climb.go2climbapi.security.domain.model.entity.Role;
import com.go2climb.go2climbapi.security.domain.model.enumeration.Roles;
import com.go2climb.go2climbapi.security.domain.persistence.RoleRepository;
import com.go2climb.go2climbapi.security.domain.service.communication.AuthenticateRequest;
import com.go2climb.go2climbapi.security.domain.service.communication.AuthenticateResponse;
import com.go2climb.go2climbapi.security.domain.service.communication.RegisterRequest;
import com.go2climb.go2climbapi.security.domain.service.communication.RegisterResponse;
import com.go2climb.go2climbapi.security.middleware.JwtHandler;
import com.go2climb.go2climbapi.security.middleware.UserDetailsImpl;
import com.go2climb.go2climbapi.security.resource.AuthenticateResource;
import com.go2climb.go2climbapi.shared.exception.ResourceNotFoundException;
import com.go2climb.go2climbapi.shared.mapping.EnhancedModelMapper;
import com.go2climb.go2climbapi.application.user.domain.model.entity.User;
import com.go2climb.go2climbapi.application.user.domain.persistence.UserRepository;
import com.go2climb.go2climbapi.application.user.domain.service.UserService;
import com.go2climb.go2climbapi.application.user.resource.UserResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hibernate.usertype.DynamicParameterizedType.ENTITY;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtHandler handler;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    EnhancedModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with username: %s", email)));
        return UserDetailsImpl.build(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,userId)) ;
    }

    @Override
    public ResponseEntity<?> authenticate(AuthenticateRequest request)
    {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword()
                    ));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = handler.generateToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            AuthenticateResource resource = mapper.map(userDetails, AuthenticateResource.class);
            resource.setRoles(roles);
            resource.setToken(token);

            AuthenticateResponse response = new AuthenticateResponse(resource);

            return ResponseEntity.ok(response.getResource());


        } catch (Exception e) {
            AuthenticateResponse response = new AuthenticateResponse(String.format("An error occurred while authenticating: %s", e.getMessage()));
            return ResponseEntity.badRequest().body(response.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> register(RegisterRequest request)
    {
        if (userRepository.existsByEmail(request.getEmail())) {
            AuthenticateResponse response = new AuthenticateResponse("Email is already used.");
            return ResponseEntity.badRequest()
                    .body(response.getMessage());
        }

        try {

            Set<String> rolesStringSet = request.getRoles();
            Set<Role> roles = new HashSet<>();

            if (rolesStringSet == null) {
                roleRepository.findByName(Roles.ROLE_CLIENT)
                        .map(roles::add)
                        .orElseThrow(() -> new RuntimeException("Role not found."));
            } else {
                rolesStringSet.forEach(roleString ->
                        roleRepository.findByName(Roles.valueOf(roleString))
                                .map(roles::add)
                                .orElseThrow(() -> new RuntimeException("Role not found.")));
            }

            logger.info("Roles: {}", roles);

            User user = new User()
                    .withEmail(request.getEmail())
                    .withPassword(encoder.encode(request.getPassword()))
                    .withRoles(roles);


            userRepository.save(user);
            UserResource resource = mapper.map(user, UserResource.class);
            RegisterResponse response = new RegisterResponse(resource);
            return ResponseEntity.ok(response.getResource());

        } catch (Exception e) {

            RegisterResponse response = new RegisterResponse(e.getMessage());
            return ResponseEntity.badRequest().body(response.getMessage());

        }
    }
}
