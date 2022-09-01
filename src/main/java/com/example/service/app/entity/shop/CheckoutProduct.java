package com.example.service.app.entity.shop;

import lombok.Getter;

@Getter
public class CheckoutProduct extends Product {

    private int buyNum;

    public CheckoutProduct(String name, int price, int buyNum) {
        super(name, price);
        this.buyNum = buyNum;
    }
}
