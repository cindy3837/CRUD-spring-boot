Feature: Member Signup

  Scenario: someone wants to be signup the website member
    When I want to signup to be a member of website
    Then I have to fill username, password, and confirm-password
    And my account will be created, signup will be successfully
