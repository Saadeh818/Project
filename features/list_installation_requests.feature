Feature: list installation requests
  user can view the list choose request by its number to schedule appointment or go to dashboard
  Background: installation requests appeared
    Given installation requests appeared

  Scenario: choose request successfully
    When user entered installation request id <id>
    Then go to schedule appointment
#go to schedule appointment -->
#done
  Scenario: choose to return to dashboard
    When installer entered <0>
    Then reload installer dashboard

  Scenario: wrong input
    When user entered installation request id '<chars>'
    Then wrong input message appears
    And reload installer dashboard

