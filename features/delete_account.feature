Feature: delete account
  user can delete his own account and admin can delete any account

  Background: delete account called

  Scenario Outline: user successfully deletes the account
    When user enters the right password '<password>'
    Then the account is deleted successfully
    Examples: Successful Deletion
      | password    |
      | correctPass |

  Scenario Outline: user can't delete his account
    When user enters the wrong password '<password>'
    Then a wrong password message appears
    Examples: Unsuccessful Deletion
      | password      |
      | incorrectPass |
  Scenario Outline: admin successfully deletes any account
    Given the user is an admin
    When admin enters the admin password '<passwordAdmin>'
    And admin deletes the user account
    Then the account is deleted successfully

    Examples: Admin Deletion
      | passwordAdmin |
      | adminPass     |
