Feature: Registration Fonctionality

  Background: 
    Given user is on register page

  @Register
  Scenario: Check user can register
    When enters firstname "Moez"
    And enters lastname "Chkir"
    And enters email "Moez5.chkir@test.fr"
    And enters password "123456aB."
    And enters a confirm password "123456aB."
    And hits create account
    Then registration confirm message is displayed
