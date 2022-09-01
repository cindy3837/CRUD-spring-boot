package com.example.service.app.entity.shop;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Member {

    private String account;

    private String name;

    public Member(String account,String name){
        this.account = account;
        this.name = name;
    }
}
