Feature: login functionality

  Scenario: Check login is successful with valid credentials
    Given user is on login page
    When user enters username "test.myppBaz9993@gmail.com" and password "123456"
    And clicks on login button
    Then user is navigated to home page
