package edu3431.matiukhin.softwarequality8.config;/*
@author sasha
@project SoftwareQuality7
@class AuditorAwareImpl
@version 1.0.0
@since 24.04.2025 - 20 - 42
*/import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of(System.getProperty("user.name"));
    }
}