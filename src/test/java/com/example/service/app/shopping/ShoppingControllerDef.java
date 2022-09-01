package com.example.service.app.shopping;

import com.example.service.app.entity.shop.*;
import io.cucumber.java.en.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class ShoppingControllerDef {

    private static Member member;

    private static List<CheckoutProduct> checkoutProductArrayList = new ArrayList<>();
    private static ShoppingCart shoppingCart = new ShoppingCart();
    private SellingProduct sellingProduct;

    private int totalAmount;

    private CheckoutProduct checkoutProduct;
    private Billing billing;


    //Background
    @Given("a selling-product that name is {string}, price is {int}, quantity is {int}")
    public void aSellingProductThatNameIsPriceIsQuantityIs(String checkoutProductName, int price, int quantity) {
        this.sellingProduct = new SellingProduct(checkoutProductName, price, quantity);
    }

    @And("a checkout-product that name is {string}, buy-num is {int}")
    public void aCheckoutProductThaneNameIsBuyNumIs(String checkoutProductName, int buyNum) {
        this.checkoutProduct = new CheckoutProduct(checkoutProductName, this.sellingProduct.getPrice(), buyNum);
    }

    @And("a empty shopping-cart")
    public void aEmptyShoppingCart() {
        this.shoppingCart = new ShoppingCart();
    }

    @And("a empty buying-list")
    public void aEmptyBuyingList() {

        this.checkoutProductArrayList = new ArrayList<>();
    }

    @And("a member name is {string}, account is {string}")
    public void aMemberNameIsAccountIs(String memberName, String memberAccount) {

        this.member = new Member(memberAccount, memberName);

    }

    @And("total-amount is {int}")
    public void totalAmountIs(int totalAmount) {
        this.totalAmount = totalAmount;
    }


    // put-in shopping-cart
    @When("member take {int} selling-product to shopping-cart")
    public void memberTakeSellingProductToShoppingCart(int buyNum) {
        this.checkoutProductArrayList.add(this.checkoutProduct);
        this.shoppingCart.setMember(member);
        assertThat(buyNum, equalTo(this.checkoutProduct.getBuyNum()));
        // log.info("member take {} selling-product to shopping-cart",this.checkoutProduct.getBuyNum());

    }

    @Then("the quantity {int} of selling-product will be reduced to {int}")
    public void theQuantityOfSellingProductWillBeReducedTo(int beforeQuantity, int changeQuantity) {

        this.sellingProduct.setQuantity(this.sellingProduct.getQuantity() - this.checkoutProduct.getBuyNum());
        assertThat(changeQuantity, equalTo(this.sellingProduct.getQuantity()));
        //  log.info("the quantity {} of selling-product will be reduced to {}", beforeQuantity,this.sellingProduct.getQuantity());

    }

    @And("the shopping-cart size will be increased {int} item for checkout")
    public void theShoppingCartSizeWillBeIncreasedForCheckoutProduct(int shoppingCartSize) {
        this.shoppingCart.setCheckoutProductList(this.checkoutProductArrayList);
        assertThat(this.shoppingCart.getCheckoutProductList().size(), equalTo(shoppingCartSize));
        //     log.info("the shopping-cart size will be increased {} for checkout-product", this.shoppingCart);
    }

    @When("member checkout from shopping-cart")
    public void memberCheckoutFromShoppingCart() {
        this.totalAmount = this.shoppingCart.checkout(this.checkoutProductArrayList);
    }

    @Then("total-amount is the price {int} of selling-product multiplied by {int} of checkout-product buy-num")
    public void totalAmountIsThePriceOfSellingProductMultipliedByOfCheckoutProduct(int sellingProductPrice, int buyNum) {
        //  log.info("total-amount is the price {} of selling-product multiplied by {} of checkout-product", sellingProductPrice, buyNum);
        int totalAmount = sellingProductPrice * buyNum;
        assertThat(this.totalAmount, equalTo(totalAmount));

    }
    @And("the shopping-cart will be cleared")
    public void theShoppingCartWillBeCleared() {
        //  log.info("the shopping-cart will be cleared: {}", this.shoppingCart);
        Assert.assertTrue(this.shoppingCart.getCheckoutProductList().isEmpty());
    }


}
