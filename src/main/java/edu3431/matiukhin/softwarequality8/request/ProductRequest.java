package edu3431.matiukhin.softwarequality8.request;/*
@author sasha
@project SoftwareQuality7
@class ItemDTO
@version 1.0.0
@since 24.04.2025 - 20 - 33
*/

public record ProductRequest(String id, String category, String type, String name, double price, String code, String description) {
    public ProductRequest(String id, String category, String type, String name, double price, String code, String description) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.name = name;
        this.price = price;
        this.code = code;
        this.description = description;
    }

    public String id() {
        return this.id;
    }

    public String category() {
        return this.category;
    }

    public String type() {
        return this.type;
    }

    public String name() {
        return this.name;
    }

    public double price() {
        return this.price;
    }

    public String code() {
        return this.code;
    }

    public String description() {
        return this.description;
    }
}
