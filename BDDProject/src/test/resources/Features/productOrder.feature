Feature: Product Order Fonctionalty

  Background: 
    Given user is on home page
    When user hovers on Men in store menu
    And navigates to Tops sub menu
    And navigates to Jackets sub menu and clicks on it
    And clicks on sort product by product name
    And scrolls page to Lando Gym Jacket product
    And choose the size the color and the desired quantity "2"
    And clicks add to cart button

  @ProductOrder
  Scenario: Check User Can Order Product
    When user hits on cart link
    And hits the checkout button
    And enters the email "aaabbb@test.com"
    And enters the password "123456aB."
    And hits the login button
    And enters company "coding" street "Republic" and city "Texas"
    And selects country
    And enters zip "43567"
    And add phone "12345678"
    And check the checkbox billing adress
    And hits the placeholder button
    Then purshase validation message is displayed
