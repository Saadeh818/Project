Feature: customer login

  Scenario Outline: Successful log in
    Given that the customer is not logged in the app
    And the username customer is "<customer username>"
    And the password customer is "<customer password>"
    Then  the customer is logged in the app successfully
    Examples:
      | customer username | customer password |
      |saadeh@gmail.com  |12345678           |
      |deema@gmail.com   |00000000           |

  Scenario Outline: customer entered a wrong username
    Given that the customer is not logged in the app
    And the username customer is "<wrong username>"
    And the password customer is "<customer password>"
    Then the customer will not login
    And the message appear to tell the customer what's wrong
    Examples:
      | wrong username | customer password |
      | saadh@gmail.com|12345678           |
      | saadeh         |12345678           |

  Scenario Outline: customer entered a wrong password
    Given that the customer is not logged in the app
    And the username customer is "<customer username>"
    And the password customer is "<wrong password>"
    Then the customer will not login
    And the message appear to tell the customer what's wrong
    Examples:
      | customer username | wrong password |
      | saadeh@gmail.com  | 00000000       |
      | deema@gmail.com   |1234567         |
  Scenario: customer entered empty password or email
    Given that the customer is not logged in the app
    And the username customer is " "
    And the password customer is " "
    Then the customer will not login
    And the message appear to tell the customer what's wrong