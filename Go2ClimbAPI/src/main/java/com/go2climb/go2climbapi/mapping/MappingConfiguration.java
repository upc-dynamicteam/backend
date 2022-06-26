package com.go2climb.go2climbapi.mapping;

import com.go2climb.go2climbapi.application.agency.mapping.AgencyMapper;
import com.go2climb.go2climbapi.application.hiredServices.mapping.HiredServiceMapper;
import com.go2climb.go2climbapi.application.services.mapping.ServiceMapper;
import com.go2climb.go2climbapi.application.tourist.mapping.TouristMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("Go2ClimbAPIMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public AgencyMapper AgencyMapper() { return new AgencyMapper(); }
    @Bean
    public HiredServiceMapper hiredServiceMapper() { return new HiredServiceMapper(); }
    @Bean
    public TouristMapper touristMapper() { return new TouristMapper(); }
    @Bean
    public ServiceMapper serviceMapper() { return new ServiceMapper(); }
}