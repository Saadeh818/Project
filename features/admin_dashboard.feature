Feature: Admin dashboard
  Admin can choose to manage products , manage users or sign out
  Scenario: Admin choose manage products
    When admin entered '1'
    Then go to product management

  Scenario: Admin choose manage products
    When admin entered '2'
    Then go to user management

  Scenario: Admin choose manage products
    When admin entered '3'
    Then sign out

  Scenario: Admin choose manage products
    When admin entered '<chars>'
    Then reload dashboard
