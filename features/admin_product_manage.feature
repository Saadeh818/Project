Feature: Admin product management
  Admin can choose to add delete update products or back to dashboard
  Scenario: Choose add product
    When admin in product management entered '1'
    Then add product
#call add product function go to add product -->
#add product done
  Scenario: Choose delete product
    When admin in product management entered '2'
    Then delete product
#call delete product function go to delete product -->
#delete product done
  Scenario: Choose update product
    When admin in product management entered '3'
    Then update product
#call update product function go to update product -->
#update product done
  Scenario: Choose return to dashboard
    When admin in product management entered '4'
    Then go to dashboard

  Scenario Outline: Choose wrong character
    When admin in product management entered '<chars>'
    Then show wrong input message
    And reload product manager
    Examples:
      | chars |
      |5      |
      |156    |
      |a      |
      |       |
