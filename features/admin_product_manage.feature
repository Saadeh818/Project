Feature: Admin product management
  Admin can choose to add delete update products or back to dashboard
  Scenario: Choose add product
    When admin in product management entered '1'
    Then add product
#call add product function
  Scenario: Choose delete product
    When admin in product management entered '2'
    Then delete product

  Scenario: Choose update product
    When admin in product management entered '3'
    Then update product

  Scenario: Choose Add product
    When admin in product management entered '4'
    Then go to dashboard

  Scenario: Choose Add product
    When admin in product management entered '<chars>'
    Then reload product manager
