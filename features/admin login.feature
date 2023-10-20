Feature: admin login

  Scenario: Successful log in
    Given that the admin is not logged in the app
    And the username is "deema"
    And the password is "002"
    Then  the admin is logged in the app successfully

  Scenario: Admin entered a wrong username
    Given that the admin is not logged in the app
    And the username is "wrong"
    And the password is "002"
    Then the admin will not login
    And the message appear to tell the admin what's wrong

  Scenario: Administrator entered a wrong password
    Given that the admin is not logged in the app
    And the username is "deema"
    And the password is "wrong"
    Then the admin will not login
    And the message appear to tell the admin what's wrong

  Scenario: Admin entered empty password or email
    Given that the admin is not logged in the app
    And the username is " "
    And the password is " "
    Then the admin will not login
    And the message appear to tell the admin what's wrong

