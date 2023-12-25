Feature: add installation Request
  customer can add installation Request

  Scenario: success Adding Installation Request
    When customer choos the product successfully
    Then Check product
    And add installation request

  Scenario: fail Adding Installation Request
    When customer choos the product wrong
    Then Check product Fail
    And add installation request Fail
