Feature: installer login

  Scenario Outline: Successful log in
    Given that the installer is not logged in the app
    And the username installer is "<installer username>"
    And the password installer is "<installer password>"
    Then  the installer is logged in the app successfully
    Examples:
      | installer username | installer password |
      |ahmad@installer.com  |00000000           |
  Scenario Outline: installer entered a wrong username
    Given that the installer is not logged in the app
    And the username installer is "<wrong username>"
    And the password installer is "<installer password>"
    Then the installer will not login
    And the message appear to tell the installer what's wrong
    Examples:
      | wrong username | installer password |
      | saadh@gmail.com|12345678           |
      | saadeh         |12345678           |

  Scenario Outline: installer entered a wrong password
    Given that the installer is not logged in the app
    And the username installer is "<installer username>"
    And the password installer is "<wrong password>"
    Then the installer will not login
    And the message appear to tell the installer what's wrong
    Examples:
      | installer username | wrong password |
      | ahmad@installer.com| 11111111       |
      | deema@installer.com|1234567         |
  Scenario: installer entered empty password or email
    Given that the installer is not logged in the app
    And the username installer is " "
    And the password installer is " "
    Then the installer will not login
    And the message appear to tell the installer what's wrong