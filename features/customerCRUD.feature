Feature: Customer CRUD Operations
  The list of customers of the system is continuously changing, so there should be
  the option to perform CRUD operations on the customers list.

  Background: User reached customer tab
    Given main screen is opened
    And customer tab is opened

  Scenario: Adding Customer Successfully
    Given I enter customer information
      | Field         | Value           |
      | Name          | ahmed saadeh         |
      | Email         | ahmed@example.com |
      | Phone Number  | 1234567890      |
      | Address       | howara      |
    And the name is not empty
    And I click add customer button
    Then a new customer is added to the list

  Scenario: Updating Customer Successfully
    Given I select a customer from the list
      | Customer Name  | Customer Email      | Customer Phone Number | Customer Address  |
      | amr           | amr@example.com   | 9876543210            |mreej str      |
    And I enter a different customer information
      | Field            | value      |
      | Customer Name    | amr       |
      | Customer Email   | amr@example.com |
      | Customer Phone Number |9876543210  |
      | Customer Address | mreej str    |
    And I click update customer button
    Then the selected customer is updated

  Scenario: Deleting Customer Successfully
    Given I select a customer from the list
      | Customer Name  | Customer Email      | Customer Phone Number | Customer Address  |
      |ahmed saadeh  | ahmed@example.com     | 1234567890            |   howara    |
    And I click delete customer button
    Then the selected customer is deleted
    Then the selected customer is deleted