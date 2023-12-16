
Feature: Change Username
  User can change his own username, and admin can change other users' usernames

  Background: Change username called

  Scenario: Successful change username
    When user enters the acceptable new username '<acceptable new username>'
    Then the username is set successfully

  Scenario: Wrong change username
    When user enters the unacceptable new username '<unacceptable new username>'
    Then a wrong input message appears

  Scenario Outline: Admin successfully changes other user's username
    Given the user is an admin
    When admin enters the admin password '<admin password>'
    And admin changes the username to '<new username>' for user '<existing username>'
    Then the username is changed successfully

    Examples: Admin Change Username
      | admin password | new username | existing username |
      | adminPass       | newAdminName  | existingUser1     |
      | adminPass       | newAdminName2 | existingUser2     |
