package com.example.service.app.dto.shop;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddItemToShoppingCartResponse {

    @JsonProperty("MESSAGE")
    private String message;
}
