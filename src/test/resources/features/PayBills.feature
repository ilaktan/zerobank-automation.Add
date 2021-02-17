Feature: Pay Bills feature

  Background:
    Given the user is on the login page
    When the user enters valid user name and password
    Then user should be able to login
    When the user navigate Online Banking, Pay Bill

  Scenario:Pay Bills
    Then the "Zero - Pay Bills" page should be displayed

  Scenario:
    When the user completes the pay operation
    Then the user should see "The payment was successfully submitted." message

  Scenario:
    When user tries to make a payment without entering the amount or date
    Then the user should be able to see "Please fill in this field." message





