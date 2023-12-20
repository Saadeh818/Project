Feature: Customer Invoicing

  As a business owner, I want to be able to create and manage customer invoices.

  Background: User navigates to customer invoice tab
    Given main screen is opened
    And customer invoice tab is selected
    And I select a customer from the customer box

  Scenario: Creating a New invoice Successfully
    Given I click on the "Create New Invoice" button
    And I enter the necessary details for the new invoice
    Then a new invoice is created and added to the invoice list
  Example:
  | Invoice Number | Customer Name  | Total Amount | Due Date    |
  | 001        | dena   |         $500         | 2023-02-15  |
  | 002        | tala   |         $800         | 2023-03-01  |

  Scenario: Deleting an invoice Successfully
    Given I select an invoice from the invoice list
    And I click on the "Delete Invoice" button
    Then the selected invoice is deleted from the invoice list
  Example:
  | Invoice Number | Customer Name  | Total Amount | Due Date    |
  | 001        | dena   |        $500         | 2023-02-15  |

  Scenario: Updating an Invoice Successfully
    Given I select an invoice from the invoice list
    And I click on the "Edit Invoice" button
    And I make changes to the invoice details
    Then the invoice details are updated in the invoice list
  Example:
  | Invoice Number | Customer Name  | Total Amount | Due Date    |
  | 001        | dena    |           $600         | 2023-02-15  |

  Scenario: Viewing Invoice Details Successfully
    Given I select an invoice from the invoice list
    And I click on the "View Invoice" button
    Then the details of the selected invoice are displayed on the screen
  Example:
  | Invoice Number | Customer Name  | Total Amount | Due Date    |
  | 001        | dena    |         $600         | 2023-02-15  |

  Scenario: Sending an Invoice to Customer Successfully
    Given I select an invoice from the invoice list
    And I click on the "Send Invoice" button
    And I enter the customer email address
    Then the invoice is sent to the customer's email address.

  Example:
  | Invoice Number | Customer Name  | Total Amount | Due Date    | Customer Email          |
  | 001        | dena    |          $600         | 2023-02-15  | dena123@email.com  |
