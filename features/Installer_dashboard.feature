Feature: installer dashboard
  installer can view installation requests and schedule appointments or sign out

  Background: user login as installer
    Given user is installer

    Scenario: installer choose to view installation requests
      When installer entered <1>
      Then list installation requests
#go to list installation requests -->
#done
    Scenario: installer choose to sign out
      When installer entered <2>
      Then sign out

    Scenario: wrong input
      When installer entered '<chars>'
      Then wrong input message appears
      And reload installer dashboard
