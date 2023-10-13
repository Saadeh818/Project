Feature: modify account options
  any user can modify his own profile and Admin can modify any users profile
  features: change username or password and delete account

  Background: user want to modify something in his profile
    Given modify options appeared

  Scenario: choose to change password
    When modify account option input is '1'
    Then go to change password <'userID'>

  Scenario: choose to change username
    When modify account option input is '2'
    Then go to change username <'userID'>

  Scenario: choose to delete account
    When modify account option is '3'
    Then go to delete account <'userID'>

  Scenario: wrong input
    When modify account option'<chars>'
    Then reload modify account option <'userID'>