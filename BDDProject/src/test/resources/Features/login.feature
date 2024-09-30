Feature: login functionality

 @ValidCredentials
  Scenario Outline: Check login with valid credentials
    Given user is on login page
    When user enters username and password
      | username                   | password  |
      | test.myppBaz9995@gmail.com | 123456aB- |
    And hits on login button
    Then user is navigated to home page
    
  @InvalidCredentials1
  Scenario Outline: Check login with invalid e-mail and invalid password
    Given user is on login page
    When user enters username and password
      | username | password  |
      | @.com    | 123456789 |
    And hits on login button
    Then an email error message should be displayed

  @InvalidCredentials2
  Scenario Outline: Check login with invalid e-mail and valid password
    Given user is on login page
    When user enters username and password
      | username   | password  |
      | 123abc@    | 123456aB- |
      | 123abc.com | 123456aB- |
      | 123abc     | 123456aB- |
      | @.com      | 123456aB- |
    And hits on login button
    Then an email error message should be displayed

  @InvalidCredentials3
  Scenario Outline: Check login with valid e-mail and invalid password
    Given user is on login page
    When user enters username and password
      | username                   | password  |
      | test.myppBaz9995@gmail.com | abcdefgh  |
      | test.myppBaz9995@gmail.com | 123456789 |
      | test.myppBaz9995@gmail.com | 1234Ab.    |
    And hits on login button
    Then a password error message should be displayed

  @InvalidCredentials4
  Scenario: Check login with empty credentials
    Given user is on login page
    When user enters "" and "" for credentials
    And hits on login button
    Then required fields error message should be displayed

 
