Feature: Change Password

  Scenario: member wants to change password

    Given a member who has already login
    When member wants to change password
    And member has to input old-password, new-password, confirm-new-password
    And new-password, confirm-new-password must be same
    Then password change successfully