package com.example.service.app.entity.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    private Member member;

    private List<CheckoutProduct> checkoutProductList;

    public int checkout(List<CheckoutProduct> checkoutProductList) {
        this.checkoutProductList = checkoutProductList;
        int totalAmount = 0;
        for (CheckoutProduct checkoutProduct : checkoutProductList) {
            totalAmount = totalAmount + (checkoutProduct.getBuyNum() * checkoutProduct.getPrice());
        }
        this.checkoutProductList.clear();
        return totalAmount;
    }
}
