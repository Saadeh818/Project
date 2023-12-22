Feature: modify account options
  any user can modify his own profile and Admin can modify any users profile
  features: change username or password and delete account

#  Background: user want to modify something in his profile
#    Given modify options appeared

  Scenario Outline: choose to change password
    When user want to modify '<installer Or customer>'
    And user id '<id>'
    And modify account option input is '1'
    Then go to change password
    Examples:
      | installer Or customer | id |
      | installer             | 1  |
      | customer              | 1  |
#here we need to implement the change password feature
#change password feature done
  Scenario Outline: choose to change username
    When user want to modify '<installer Or customer>'
    And user id '<id>'
    And modify account option input is '2'
    Then go to change username
    Examples:
      | installer Or customer | id |
      | installer             | 1  |
      | customer              | 1  |
#here we need to implement the change username feature
#Change username done
  Scenario Outline: choose to delete account
    When user want to modify '<installer Or customer>'
    And user id '<id>'
    And modify account option is '3'
    Then go to delete account
    Examples:
      | installer Or customer | id |
      | installer             | 2  |
      | customer              | 2  |
#here we need to implement the delete account feature
#Done
  Scenario: wrong input
    When modify account option'<chars>'
    Then reload modify account option