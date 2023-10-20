Feature: change password
  user can change his own password and admin can also change users passwords
  Background: change password function was called

    Scenario: successful password changing
      When user enter '<right password format>'
      Then password format true
      And set password

    Scenario: fail to change
      When user enter '<wrong password format>'
      Then password format false
      And wrong input message appears
