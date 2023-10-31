Feature: Delete product
  Background: Admin choose to delete product
    Given category list appear

  Scenario Outline: successful delete
    When user choose category '<category>'
    And choose product id '<ID>'
    Then delete products
    Examples:
      | category | ID |
      |cat1      |1    |
      |cat2      |2    |
      |cat3      |3    |

  Scenario Outline: wrong category selection
    When user choose category '<wrong_category>'
    Then print wrong selection message
    And redirect to delete product screen
    Examples:
      | wrong_category |
      |cat8            |
  Scenario Outline: wrong product id selection
    When user choose category '<category>'
    And choose product id '<wrong_ID>'
    Then print wrong selection message
    And redirect to delete product screen
    Examples:
      | category | wrong_ID |
      |cat2      |1         |
      |cat1      |1500      |