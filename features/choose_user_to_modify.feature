Feature: choose user to modify
  Admin should use the user to manage his account so after list of users
  appears he should enter user id to

    Scenario Outline: successful choosing
      When user want to modify '<installer Or customer>'
      And admin entered user id '<ID>'
      Then modify options appeared
      Examples:
        | ID |installer Or customer|
        | 2  | customer            |
        | 2  | installer           |
        | 1  | customer            |
        | 1  | installer           |
#        | 70 | installer           |


#now go to modify_user_account_options.feature ------->
#
  Scenario Outline: fail choosing
    When user want to modify '<installer Or customer>'
    And admin entered user id '<wrongID>'
    And return to choose user to modify
    Examples:
      | wrongID | installer Or customer |
      | 70      | installer             |
      | hk      | customer              |