package com.go2climb.go2climbapi.security.mapping;

import com.go2climb.go2climbapi.security.domain.model.entity.Role;
import com.go2climb.go2climbapi.security.domain.model.entity.User;
import com.go2climb.go2climbapi.security.resource.UserResource;
import com.go2climb.go2climbapi.shared.mapping.EnhancedModelMapper;
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

    Converter<Role, String> roleToString = new AbstractConverter<>() {
        @Override
        protected String convert(Role role) {
            return role == null ? null : role.getName().name();
        }
    };

    public UserResource toResource(User model){
        mapper.addConverter(roleToString);
        return mapper.map(model, UserResource.class);
    }

    public Page<UserResource> modelListToPage(List<User> modelList, Pageable pageable){
        return  new PageImpl<>(mapper.mapList(modelList, UserResource.class),
                pageable, modelList.size());
    }

}
