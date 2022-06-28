package com.go2climb.go2climbapi.security.domain.service.communication;

import com.go2climb.go2climbapi.security.resource.UserResource;
import com.go2climb.go2climbapi.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource>{

    public RegisterResponse(String message){
        super(message);
    }

    public RegisterResponse(UserResource resource){
        super(resource);
    }
}
