package com.example.service.app.backound;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundDef {
    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        System.out.println("I am at the LogIn Page");
    }

    @When("I submit username and password")
    public void iSubmitUsernameAndPassword() {
        System.out.println("I Submit my Username and Password");

    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        System.out.println("I am logged on to the website");
    }

    @Given("User search for Lenovo Laptop")
    public void userSearchForLenovoLaptop() {
        System.out.println("User searched for Lenovo Laptop");
    }

    @When("Add the first laptop that appears in the search result to the basket")
    public void addTheFirstLaptopThatAppearsInTheSearchResultToTheBasket() {
        System.out.println("First search result added to bag");
    }

    @Then("User basket should display with added item")
    public void userBasketShouldDisplayWithAddedItem() {
        System.out.println("Bag is now contains the added product");
    }

    @Given("User navigate for Lenovo Laptop")
    public void userNavigateForLenovoLaptop() {
        System.out.println("User navigated for Lenovo Laptop");
    }

    @When("Add the laptop to the basket")
    public void addTheLaptopToTheBasket() {
        System.out.println("Laptop added to the basket");
    }
}
