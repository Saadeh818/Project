Feature: Changer Password
  Use can change his password

  Scenario: success change password
    When user enters the right password format
    Then the password is set successfully

    Scenario: fail to change password
      When user enters the wrong password format
      Then the password is not set
