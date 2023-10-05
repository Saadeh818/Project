Feature: sign-up
  Scenario: successful sign-up
    When user entered username 'ahmad'
    And  password '12345678'
    Then Go to login page

  Scenario: wrong user name
  When user entered username and username usability flag is 'true'
  Then username is used try another one

  Scenario: wrong password format
    When user entered password and password acceptance flag is 'false'
    Then password formatted wrong try another one

#  Scenario: successful signUp
#    Given user entered username "ahmad2"
#    And password "00000000"
#    When username not used
#    And password is acceptable
#    Then Add user
#
#  Scenario: used username
#    Given user entered username "ahmad"
#    And password "00000000"
#    When username used
#    Then try another username
#
#  Scenario: acceptable username unacceptable password
#    Given user entered emaill "ahmad@stu.edu"
#    And password "1234567"
#    When email not used
#    And password is unacceptable
#    Then try another password

