Feature: CRUD Controller

  Scenario: Save a User to Database
    When given a url that means add action
    Then read all attributes from addUserRequest
    And save user to table
    But id should be 999,"username","phone" should not be blank or null

  Scenario: Find out a User from Database
    When  given a url that means query action
    Then read all attributes from queryUserRequest
    And query user from table
    But id should be 999

  Scenario: Editor a User and save to Database
    When  given a url that means update action
    Then read all attributes from updateUserRequest
    And update user to table
    But id should be 999,"username","phone" should not be blank or null

  Scenario: Delete a User from Database
    When  given a url that means delete action
    Then read all attributes from deleteUserRequest
    And delete user from table
    But id should be 999