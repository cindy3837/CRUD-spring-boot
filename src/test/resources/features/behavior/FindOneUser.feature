Feature: CRUD Controller

  Scenario: Find a User From Database
    When send user to query method
    Then show a user of the id
    But user should be exist
