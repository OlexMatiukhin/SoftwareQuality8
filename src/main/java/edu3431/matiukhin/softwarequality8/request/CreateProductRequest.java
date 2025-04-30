package edu3431.matiukhin.softwarequality8.request;/*
@author sasha
@project SoftwareQual8
@class CreaateProductRequest
@version 1.0.0
@since 01.05.2025 - 01 - 43
*/


public record CreateProductRequest(String category, String type, String name, double price, String code, String description) {
}
