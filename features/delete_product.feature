Feature: Delete product
  Background: Admin choose to delete product
    Given category list appear

  Scenario: successful delete
    When user choose '<category>' to delete from
    And choose product id '<ID>'
    Then delete product

  Scenario: wrong category selection
    When user choose '<wrong_category>'
    Then print wrong selection message
    And redirect to delete product screen

  Scenario: wrong product id selection
    When user choose '<category>' to delete from
    And choose product id '<wrong_ID>'
    Then print wrong selection message
    And redirect to delete product screen