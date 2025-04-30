package edu3431.matiukhin.softwarequality8.request;/*
@author sasha
@project SoftwareQuality7
@class CreateProductRequest
@version 1.0.0
@since 30.04.2025 - 21 - 30
*/

public record CreateProductRequest(String category, String type, String name, double price, String code, String description) {
}
