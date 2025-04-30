package edu3431.matiukhin.softwarequality8.request;/*
@author sasha
@project SoftwareQual8
@class ProductRequest
@version 1.0.0
@since 01.05.2025 - 01 - 44
*/

import java.time.LocalDateTime;
import java.util.List;

public record ProductRequest(String id, String category, String type, String name, double price, String code, String description, LocalDateTime createDate, List<LocalDateTime> updateDates) {

}
