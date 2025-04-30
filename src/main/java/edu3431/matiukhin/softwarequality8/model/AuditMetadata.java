package edu3431.matiukhin.softwarequality8.model;/*
@author sasha
@project SoftwareQuality7
@class AuditMetadata
@version 1.0.0
@since 24.04.2025 - 20 - 39
*/

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class AuditMetadata {
    @CreatedDate
    private LocalDateTime createdDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @LastModifiedBy
    private String lastModifiedBy;
}
