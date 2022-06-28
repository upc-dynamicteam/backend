package com.go2climb.go2climbapi.security.persistence;

import com.go2climb.go2climbapi.security.domain.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import java.sql.Timestamp;

public class DatabaseSeedingConfig {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeedingConfig.class);

    private RoleService roleService;

    public void onApplicationReady(ApplicationReadyEvent event){
        String name = event.getApplicationContext().getId();
        logger.info("Starting Database Seeding Process for {} at {}", name,
                new Timestamp(System.currentTimeMillis()));
        roleService.seed();
        logger.info("Finished Database Seeding Process for {} at {}", name,
                new Timestamp(System.currentTimeMillis()));
    }
}
