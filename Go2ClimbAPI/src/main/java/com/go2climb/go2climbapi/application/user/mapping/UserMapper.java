package com.go2climb.go2climbapi.application.user.mapping;

import com.go2climb.go2climbapi.security.domain.model.entity.Role;
import com.go2climb.go2climbapi.shared.mapping.EnhancedModelMapper;
import com.go2climb.go2climbapi.application.user.domain.model.entity.User;
import com.go2climb.go2climbapi.application.user.resource.CreateUserResource;
import com.go2climb.go2climbapi.application.user.resource.UpdateUserResource;
import com.go2climb.go2climbapi.application.user.resource.UserResource;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping
    public UserResource toResource(User model){
        return mapper.map(model,UserResource.class);
    }

    public List<UserResource> modelListToResource(List<User> modelList){return mapper.mapList(modelList, UserResource.class); }

    public Page<UserResource> modelListToPage(List<User> modelList, Pageable pageable) {

        mapper.addConverter(roleToString);
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }

    Converter<Role, String> roleToString = new AbstractConverter<>() {
        @Override
        protected String convert(Role role) {
            return role == null ? null : role.getName().name();
        }
    };

    public User toModel(CreateUserResource resource){
        return mapper.map(resource,User.class);
    }

    public User toModel(UpdateUserResource resource){
        return mapper.map(resource,User.class);
    }
}
