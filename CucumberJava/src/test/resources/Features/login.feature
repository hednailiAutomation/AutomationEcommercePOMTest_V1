Feature: login functionality

  Scenario Outline: Check login with valid credentials
    Given user is on login page
    When user enters valid username and valid password
      | username                   | password  |
      | test.myppBaz9995@gmail.com | 123456aB- |
      | test.myppBaz9995@gmail.com | 123456aB- |
    And hits on login button
    Then user is navigated to home page

  Scenario Outline: Check login with valid e-mail and invalid password
    Given user is on login page
    When user enters valid username and invalid password
      | test.myppBaz9995@gmail.com | abcdefgh  |
      | test.myppBaz9995@gmail.com | 123456789 |
      | test.myppBaz9995@gmail.com | 123Ab-    |
    And hits on login button
    Then an error message should be displayed
