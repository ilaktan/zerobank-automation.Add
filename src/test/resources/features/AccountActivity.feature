Feature: Account Activity

  Background:
    Given the user is on the login page
    When the user enters valid user name and password
    Then user should be able to login
    When the user navigate Online Banking, Account Activity

  Scenario: Account Activity title
    Then the "Zero - Account Activity" page should be displayed

  Scenario:
    And Account drop down should have "Savings" selected
    Then the user should be able to see following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then the user should be able to see following column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |


