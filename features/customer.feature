Feature:customer

  Background:
  And customer tab is opened

  Given I enter customer information
  Scenario:
  And the name is not empty

  And I click add customer button

  Then a new customer is added to the list
  Scenario:
  Given I select a customer from the list

  And I enter a different customer information

  And I click update customer button
  Scenario:
  Then the selected customer is updated
  And I click delete customer button
  Then the selected customer is deleted