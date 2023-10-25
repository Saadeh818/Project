Feature: delete account
  user can delete his own account and admin can delete any account
  Background: delete account called

    Scenario: user successfully delete the account
      When user enter right password '<password>'
      Then delete account


    Scenario: user cant delete his account
      When user enter wrong password '<password>'
      Then wrong password message appeared