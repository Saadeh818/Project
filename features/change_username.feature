Feature: change username
  user can change his own username and admin can change other users user name
  Background: change username called

  Scenario: successful change user name
    When username entered '<acceptable new username>'
    Then set username

  Scenario: wrong change user name
    When username entered '<unacceptable new username>'
    Then wrong input message appears