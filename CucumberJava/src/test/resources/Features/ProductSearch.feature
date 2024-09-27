Feature: test product search functionality

  Scenario: validate Product search fonctionality
    Given browser is open
    And user is on search page
    When user enters product name in search box
    And hits enter
    Then user is navigated to search result
