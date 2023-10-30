Feature: Choose to Login or SignUp

  Background: home
    Given user is on home page
  Scenario: Choose Login as Admin
    When the user enters '1'
    Then go to the admin login page

  Scenario: Choose Login as Customer
    When the user enters '2'
    Then go to the customer login page

  Scenario: Choose Login as Installer
    When the user enters '3'
    Then go to the installer login page

  Scenario: Choose SignUp
    When the user enters '4'
    Then go to the SignUp page

 Scenario Outline: Wrong Input
    When the user enters '<chars>'
    Then display a wrong choice and go to the home page

    Examples:
      | chars |
      | 0      |
#      | '      |
      | 5      |
      | 6      |
      | 41     |
      | a      |
      | $      |
      | #      |
      | @      |
      | !      |
      | "      |
      | qsdf   |
      | +      |
      | *      |
      | /      |