Feature: add user by admin
  admin can add users of any type

  Scenario Outline: add installer success
    When admin choose type '1' choose username '<username>' choose password '<password>'
    Then add installer
    Examples:
      | username | password |
    | from_test@installer.com|12345678|

  Scenario Outline: add customer success
    When admin choose type '2' choose username '<username>' choose password '<password>'
    Then add customer
    Examples:
      | username | password |
      | from_test@customer.com|12345678|

  Scenario Outline: add user fail
    When admin choose type '<chars>' choose username '<username>' choose password '<password>'
    Then fail to add
    Examples:
      | chars | username          | password |
      |3      | username1@info.com|12345678  |
      |1      | username1info.com |12345678  |
      |2      | username1info.com |12345678  |
      |1      | username1@info.com|1234567   |
      |2      | username1@info.com|1234567   |
      |*      | username1@info.com|12345678  |
      |j      | username1@info.com|12345678  |
      |=      | username1@info.com|12345678  |
      |r      | username1@info.com|12345678  |
