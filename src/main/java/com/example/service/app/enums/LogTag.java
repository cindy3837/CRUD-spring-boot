package com.example.service.app.enums;

import lombok.Getter;

@Getter
public enum LogTag {


    AOP("AOP");

    private String name;

    LogTag(String name){
        this.name= name;
    }
}
