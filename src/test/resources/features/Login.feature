Feature: Login


  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters valid user name and password
    Then user should be able to login
  @wip
  Scenario Outline: Login with invalid credentials
    Given the user is on the login page
    When user tries to login with invalid "<username>" or "<password>"
    Then error message Login and|or password are wrong should be displayed
    Examples:
      | username | password |
      | abc      | 123      |
      | username | 456      |
      |          |          |






