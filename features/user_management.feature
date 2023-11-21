Feature: user management
  Admin should choose the user type to manage his account
  Background: user type choosing
    Given type selection dashboard opened
  Scenario: choose to manage installers
    When admin in user management entered '1'
    Then list installers
#list of installers should open and the admin can choose user to modify account
  Scenario: choose to manage customers
    When admin in user management entered '2'
    Then list customers
#list of customers should open and the admin can choose user to modify account
#go to choose_user_to_modify.feature ---------------->
  Scenario: choose to add user
    When admin in user management entered '3'
    Then add new user

  Scenario Outline: wrong input
    When admin in user management entered '<chars>'
    Then reload user management
    Examples:
      | chars |
    | 4     |
    |r      |
    |;      |
    |323    |