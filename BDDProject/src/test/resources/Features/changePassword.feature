Feature: Change Password

  Background: 
    Given user is on login page

  @ChangePassword
  Scenario: Check logged in user can change password
    When user enters "test.myppBalk12@gmail.com" and "123456zE-"
    And hits on login button
    And select my account
    And clicks on change password link
    And enters current password "123456zE-"
    And enters new password "123456Bn-"
    And enters new confirm password "123456Bn-"
    And clicks on save button
    Then password is successfully changed

  @OldPasswordCheck
  Scenario: Check user can not login with old password after change it
    When user enters "test.myppBalk12@gmail.com" and "123456zE-"
    And hits on login button
    Then a password error message should be displayed

  @DifferentPasswordConfirm
  Scenario: Try to enter different confirm password
    When user enters "test.myppBalk12@gmail.com" and "123456Bn-"
    And hits on login button
    And select my account
    And clicks on change password link
    And enters current password "123456Bn-"
    And enters new password "123456aB-"
    And enters new confirm password "123456aB"
    And clicks on save button
    Then an error message is displayed
