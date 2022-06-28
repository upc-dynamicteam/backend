package com.go2climb.go2climbapi.security.domain.service.communication;

import com.go2climb.go2climbapi.security.resource.AuthenticateResource;
import com.go2climb.go2climbapi.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {

    public AuthenticateResponse(String message){
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource){
        super(resource);
    }
}
