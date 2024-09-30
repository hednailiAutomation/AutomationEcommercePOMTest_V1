Feature: Change Password

  @ChangePassword
  Scenario: Check logged in user can change password
    Given user is on login page
    When user enters "test.myppBaz9995@gmail.com" and "123456Ab-"
    And hits on login button
    And select my account
    And clicks on change password link
    And enters current password "123456Ab-"
    And enters new password "123456aB-"
    And enters confirm password "123456aB-"
    And clicks on save button
    Then password is successfully changed
    
    @OldPasswordCheck
    Scenario: Check if user can login with old password after changing it
    Given user is on login page
    When user enters "test.myppBaz9995@gmail.com" and "123456Ab-"
    And hits on login button
    Then a password error message should be displayed
    
    @DifferentPasswordConfirm
    Scenario: Try to enter different confirm password 
     Given user is on login page
    When user enters "test.myppBaz9995@gmail.com" and "123456Ab-"
    And hits on login button
    And select my account
    And clicks on change password link
    And enters current password "123456Ab-"
    And enters new password "123456aB-"
    And enters confirm password "123456aB"
    And clicks on save button
    Then an error message is displayed
    
    
