Feature: Member Signup,Login,Change Password

  Background:
    Given what if everyone visit the website url: "http://localhost/demo", they will be redirect to login-url-path: "/login" to show a login-form

#  Scenario: Received sms-code to pend to register
#    When I visit website, I have no account to login, I have to click signup link to signup-url-path: "/signup" to show signup-form
#    Then I have to fill my mobile-phone: "0912345679" on the signup-form and submit
#    And  system will send sms-code: "5566" to my mobile-phone
#    And  I have to fill the sms-code on the signup-form, the signup-form must be submit in 60 seconds, or sms-code will be expired
#    And  sms-code history will be cleared after signup-form submit from system, or expired

  Scenario: Registering the website member after submit sms-code
    When finishing signup-form, I will be redirect to register-form url-path: "/register", the mobile-phone column is already filled my account: "0912345679"
    Then I have to fill my name: "Peter", password: "12345678", confirm-password: "12345678" to finish register-form
    And  after I submit register-form, my account is be created by system, signup is successfully

  Scenario: Someone login
    When "Peter" visit website,he has to fill his account: "0912345679", and his password: "12345678" on login-from
    Then  after submitting login-form to url-path: "/login", system will verify his password by database
    And he will be redirected to welcome url-path: "/welcome", and see welcome message: "welcome to shopping-mall, Peter"

  Scenario: Member change password
    Given a member: "Peter", account: "0912345679" who has already login
    When member use member-menu to visit change-password-url-path: "/changePassword" to show change-password-form
    Then he has to fill "12345678" to old-password column, new-password: "00000000", confirm-new-password: "00000000" on the form
    And new-password, confirm-new-password must be same
    And account old-password must be verified by database
    And account new-password will be override into database
    And member will be redirect to account url-path: "/account" to show message "Peter, your password is changed successfully"
