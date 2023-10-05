Feature: choose to Login or SignUp
  Scenario: choose Login
    When user entered one '1'
    Then go to login page

  Scenario: choose SignUp
    When user entered tow '2'
    Then go to SignUp page

  Scenario: wrong input
    When user entered '<chars>'
    Then display wrong choose and go home page