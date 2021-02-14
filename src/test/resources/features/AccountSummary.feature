Feature: Account Summary

  Background:
    Given the user is on the login page
    When the user enters valid user name and password
    Then user should be able to login
    When the user navigate Online Banking, Account Summary

  Scenario: Account summary title
    Then page title should be "Zero – Account summary"

  Scenario: Account Types
    Then the user should be able to see following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

    Scenario: Credit Accounts Columns
      Then the user should be able to see following credit accounts columns
        | Account     |
        | Credit Card |
        | Balance     |





