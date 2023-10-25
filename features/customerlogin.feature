Feature: customer login

  Scenario: Successful log in
    Given that the customer is not logged in the app
    And the username customer is "ahmed@gmail"
    And the password customer is "000"
    Then  the customer is logged in the app successfully

  Scenario: customer entered a wrong username
    Given that the customer is not logged in the app
    And the username customer is "wrong"
    And the password customer is "000"
    Then the customer will not login
    And the message appear to tell the customer what's wrong

  Scenario: customer entered a wrong password
    Given that the customer is not logged in the app
    And the username customer is "ahmed@gmail"
    And the password customer is "wrong"
    Then the customer will not login
    And the message appear to tell the customer what's wrong

  Scenario: customer entered empty password or email
    Given that the customer is not logged in the app
    And the username customer is " "
    And the password customer is " "
    Then the customer will not login
    And the message appear to tell the customer what's wrong