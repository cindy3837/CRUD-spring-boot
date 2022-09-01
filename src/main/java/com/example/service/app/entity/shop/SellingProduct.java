package com.example.service.app.entity.shop;

import lombok.*;
@Data
public class SellingProduct extends Product {

    private int quantity;
    public SellingProduct(String name, int price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }
}
