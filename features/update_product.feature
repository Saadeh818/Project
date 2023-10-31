Feature:Update product
  Admin can update category quantity or price
  Background: Update product dashboard
    Given list of Categories appeared

  Scenario Outline: user choose category success
    When user choose category update'<category>'
    And choose product id update '<ID>'
    And get new fields '<new category>''<new name>''<new quantity>''<new price>'
    Then go update product
    Examples:
      | category | ID | new category | new name | new quantity | new price |
      | cat1     |0   |cat2          |updated   |777           |777        |
  Scenario Outline: user choose category failed
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