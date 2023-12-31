Feature: Add product
  Only admin can add products. The product has ID, name, date added, quantity, price and Category.
  Admin should choose Category before adding the product
  Background: Admin want to add product
    Given list of Categories appeared

  Scenario Outline: Successful Product Adding
    When Admin entered '<category>''<name>''<quantity>''<price>'
    Then add Product to products list
    Examples:
      | category | name | quantity | price |
      |cat1      |product   |10        |500    |
  Scenario Outline:wrong adding product
    When Admin entered '<category1>''<name1>''<quantity1>''<price1>'
    Then wrong input message appear and return to add product
    Examples:
      | category1 | name1 | quantity1 | price1 |
      |cat8       |product    |10         |500     |
      |cat2       |product    |pr1        |500     |
      |cat3       |product    |10         |cat1    |