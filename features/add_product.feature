Feature: Add product
  Only admin can add products. The product has ID, name, date added, quantity, price and Category.
  Admin should choose Category before adding the product
  Background: Admin want to add product
    Given list of Categories appeared

  Scenario: Successful Product Adding
    When Admin entered '<category>''<name>''<quantity>''<price>'
    Then add "Product" to products list

  Scenario:wrong adding product
    When Admin entered '<category1>''<name1>''<quantity1>''<price1>'
    Then wrong input message appear and return to add product