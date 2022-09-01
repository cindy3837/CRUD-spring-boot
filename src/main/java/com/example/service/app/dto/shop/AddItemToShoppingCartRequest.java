package com.example.service.app.dto.shop;

import com.example.service.app.entity.shop.Member;
import com.example.service.app.entity.shop.ShoppingCart;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddItemToShoppingCartRequest {

    @ApiModelProperty(value = "會員", required = true)
    @JsonProperty("MEMBER")
    private Member member;

    @ApiModelProperty(value = "購物車", required = true)
    @JsonProperty("SHOPPING_CART")
    private ShoppingCart shoppingCart;

}
