Feature:orderProducts
  An order of a customer may have diffirent products.
  so there should be the option to perform CRUD operation on the products of the each of the orders.


  Background: User reached order tab
    Given main screen is opened
    And orders tab is opened
    And I select a customer from the customer box
    And I select a customer from the customer list

  Scenario: Adding product to an Order Successfully
    Given I enter product information
    And I select a product from the product box
    And I click add product button
    Then a new product is added to the list

  Scenario: Updating product of an Order Successfully
    Given I select a product from the order product list
    And I enter a different order product information
    And I click update order product button
    Then the selected order product is updated

  Scenario:Deleting product of an Order Successfully
    Given I select  product from the order product list
    And I click delete  order product button
    Then the selected order product is deleted