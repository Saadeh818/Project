Feature: Changer UserName
  Use can change his userName

  Scenario: success change userName
    When user enters the right username format
    Then the username is set successfully

  Scenario: fail to change userName
    When user enters the wrong userName format
    Then the userName is not set
