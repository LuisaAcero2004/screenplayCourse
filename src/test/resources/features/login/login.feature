@Login
Feature: Login to Sauce home page

  @QA
  Scenario: Success Login to Sauce home page
    Given Carlos is a Sauce Customer
    When He tries to login
    Then He should see the products list

  @QA
  Scenario Outline: Success Login to Sauce home page
    Given Carlos is a Sauce Customer
    When He tries to login with username <username> and password <password>
    Then He should see the products list
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |