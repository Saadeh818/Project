Feature: choose user to modify
  Admin should use the user to manage his account so after list of users
  appears he should enter user id to
  Background: admin didn't choose user by id
    Given list of users appears

    Scenario: successful choosing
      When admin entered user id '<ID>'
      Then modify options appeared

  Scenario: fail choosing
    When admin entered user id '<wrongID>'
    Then wrong input message appears
    And return to choose user to modify