Feature: Login
  As a user, I want to log in to the program so that I can access my account.

  Background:
    Given the login screen is opened

  Scenario: Successful Admin Login
    When I enter a correct username and correct password for an admin
    And I click on the login button
    Then the login screen switches to the admin dashboard

  Scenario: Successful Customer Login
    When I enter a correct username and correct password for a customer
    And I click on the login button
    Then the login screen switches to the customer dashboard

  Scenario: Successful Installer Login
    When I enter a correct username and correct password for an installer
    And I click on the login button
    Then the login screen switches to the installer dashboard

  Scenario: Failed Login
    When I enter a wrong username or wrong password
    And I click on the login button
    Then an error message indicating a failed login is prompted
