Feature: Admin dashboard
  Admin can choose to manage products , manage users or sign out
  Background: User Logged in successfully
    Given user is admin and admin dashboard opened

  Scenario: Admin choose manage products
    When admin in admin dashboard entered '1'
    Then go to product management
#Admin choose to make action on products go to admin product manage -->
#admin product manage done
  Scenario: Admin choose manage users
    When admin in admin dashboard entered '2'
    Then go to user management
#Admin choose to make changes on user accounts go to user management -->
#Done
  Scenario: Admin choose to sign out
    When admin in admin dashboard entered '3'
    Then sign out
#Done
  Scenario: wrong input
    When admin in admin dashboard entered '<chars>'
    Then reload dashboard
#Done