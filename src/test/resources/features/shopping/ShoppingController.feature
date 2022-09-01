Feature: ShoppingCart Controller

  Background:
    Given a selling-product that name is "A", price is 100, quantity is 10
    And   a checkout-product that name is "A", buy-num is 1
    And   a member name is "Peter", account is "0912345679"

  Scenario: take a item into shopping-cart
    When member take 1 selling-product to shopping-cart
    Then the quantity 10 of selling-product will be reduced to 9
    And  the shopping-cart size will be increased 1 item for checkout

  Scenario: checkout
    When member checkout from shopping-cart
    Then total-amount is the price 100 of selling-product multiplied by 1 of checkout-product buy-num
    And  the shopping-cart will be cleared
