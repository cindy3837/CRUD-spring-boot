Feature: Member Login

  Scenario: a member wants to login into website

    Given account and password
    When a member wants to login the website
    Then should fill username and password of form
    And the member will login successfully
    But password should be same as data of database
