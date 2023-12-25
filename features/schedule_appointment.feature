Feature: schedule appointment for installation
  Only installer and admin can schedule appointments
  Background: want to schedule appointment
    Given request ID

    Scenario Outline: add appointment date
      When date is given as '<date>'
      Then add new appointment
      Examples:
        | date |
        | 10/10/2024|
        | 1/1/2024   |
  Scenario Outline: fail to add appointment
      When date is given as '<date>'
      Then retry appointment
    Examples:
      | date |
      | 31/2/2024|
      |12/122024|
      | 2/9/2000|
      |30/2/2024|