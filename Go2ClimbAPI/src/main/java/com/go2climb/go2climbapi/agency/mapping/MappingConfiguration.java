package com.go2climb.go2climbapi.agency.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("agencyMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public AgencyMapper AgencyMapper(){
        return new AgencyMapper();
    }
}
