Feature:Update product
  Admin can update category quantity or price
  Background: Update product dashboard
    Given list of Categories appeared

  Scenario: user choose category success
    When user enter category number'<categoryNum>'
    Then list items

  Scenario: user choose category failed
    When user enter category number'<WrongCategoryNum>'
    Then wrong input message appears
    And reload categories
