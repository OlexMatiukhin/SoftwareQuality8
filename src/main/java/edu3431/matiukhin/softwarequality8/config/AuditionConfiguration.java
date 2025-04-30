package edu3431.matiukhin.softwarequality8.config;/*
@author sasha
@project SoftwareQuality7
@class AuditorConfiguration
@version 1.0.0
@since 24.04.2025 - 20 - 42
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

;

@EnableMongoAuditing
@Configuration
public class AuditionConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }


}