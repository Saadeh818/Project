Feature: delete account

  Scenario Outline: Successfully deleted
    When user choose '<index>'
    Then delete account
    Examples:
      | index |
      |3      |

  Scenario Outline: fail to delete
    When user choose '<index>'
    Then fail to delete
    Examples:
      | index |
      | 6     |