Feature: Email
  When an order is complete, the customers should be notified via email to come and receive it.
  So the system should have a customer email functionality for finished orders.

  Background: An order is selected
    Given the main screen is opened
    And the orders tab is opened
    And I select a customer from the customer box
    And I select an order from the order list

  Scenario: Notify customer via email for a finished order
    When I mark the selected order as complete
    Then the system sends an email to the selected customer
    And the email contains information about the finished order
    And the email subject is "Your Order is Ready for Pickup"

  Scenario: Do not notify customer if the order is not complete
    When I select an order that is not marked as complete
    Then the system does not send an email to the selected customer
    And no email is received by the customer

  Scenario: Notify customer only once for the same order
    Given the selected order is marked as complete
    When I send an email to the selected customer for the finished order
    Then the system sends only one email to the customer
    And the customer does not receive duplicate emails

  Scenario Outline: Notify customer for multiple finished orders
    Given multiple orders are marked as complete for the selected customer
    When the system sends emails to the selected customer for each finished order
    Then the customer receives emails for each finished order
    Examples:
      | Order Number | Product       | Quantity | Total Amount |
      | 001          | Product A     | 2        | $50          |
      | 002          | Product B     | 1        | $30          |
      | 003          | Product C     | 3        | $80          |
