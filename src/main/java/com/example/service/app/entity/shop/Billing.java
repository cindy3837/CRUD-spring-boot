package com.example.service.app.entity.shop;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Billing {

    private Member member;

    private int totalAmount;

    public Billing(Member member, int totalAmount){
        this.member = member;
        this.totalAmount = totalAmount;
    }

    public void printBill(){
        System.out.println("Thanks for your Shopping, "+ member.getName());
        System.out.println("your totalAmount is , "+ totalAmount);
        System.out.println("calculate time is: "+ LocalDateTime.now());

    }


}
