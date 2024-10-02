Feature: Search For Product

  Background: 
    Given user is on home page

  @AutoSuggestSearch
  Scenario: Search Product with Auto-Suggestion
    When user enters a part of productname "jacke" in the search box
    And choose the second suggested option
    And clicks on sort product by price
    And scrolls page to Lando Gym Jacket product
    And choose the size the color and the desired quantity "2"
    And clicks add to cart button
    Then the product is added to cart

  @ManualSearch
  Scenario: Search Product manualy
    When user enters "jacket for men" in the search box
    And hits keybord Enter key
    And clicks on sort product by product name
    And scrolls page to paging toolbar
    And clicks next
    And scrolls page to product
    And choose the size the color and the desired quantity "2"
    And clicks add to cart button
    Then the product is added to cart
