Feature: schedule appointment for installation
  Only installer and admin can schedule appointments
  Background: want to schedule appointment
    Given get installation id to schedule appointment

  Scenario: successful appointment
    When user entered '<date>'
    Then add appointment

  Scenario: wrong date format
    When user entered '<wrong date format>'
    Then wrong input message appears
    And reload schedule appointment screen
