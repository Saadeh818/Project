Feature: signup
  Scenario Outline: One or More Empty Term
    Given you are in signup page
    When you write the "<id>", "<name>", "<PhoneNumber>", "<address>", "<city>", "<street>", "<email>" and "<password>" and "<usertype>"
    Then you should show please fill all informations
    Examples:
      | id   | name | PhoneNumber | address | city     | street | email | password |usertype|
      | 111 |       | 416         |         | Nablus   | rafedya|       | 123456   |owner   |
  Scenario Outline: duplicate id
    Given you are in signup page
    When you write the "<id>", "<name>", "<PhoneNumber>", "<address>", "<city>", "<street>", "<email>","<password>" and "<usertype>"
    Then You should Show please enter another id
    Examples:
      | id  | name  | PhoneNumber | address     | city     | street | email              | password |usertype|
      | 111 | deema | 0594176240  | building 22 | Nablus   | rafedya| deemasal345@gmail.com | 123456   |owner   |

  Scenario Outline: weak password
    Given you are in signup page
    When you write the "<id>", "<name>", "<PhoneNumber>", "<address>", "<city>", "<street>", "<email>","<password>" and "<usertype>"
    Then You should Show please enter more than five character
    Examples:
      | id  | name  | PhoneNumber | address     | city     | street | email                | password |usertype|
      | 111 | deema | 0594176240  | building 22 | Nablus   | rafedya| deemasal345@gmail.com | 123      |owner   |

  Scenario Outline: Added Successfully
    Given you are in signup page
    When you write the "<id>", "<name>", "<PhoneNumber>", "<address>", "<city>", "<street>", "<email>","<password>" and "<usertype>"
    Then The Customer Added Successfully
    Examples:
      | id  | name  | PhoneNumber | address     | city    | street  | email                | password |usertype|
      | 111 | deema | 0594176240  | building 22 | Nablus  | rafedya | deemasal345@gmail.com| 123456   |owner   |


