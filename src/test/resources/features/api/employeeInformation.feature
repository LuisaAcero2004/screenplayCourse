Feature: Employee Information

  @inProgress
  Scenario: Create new employee
    Given Endava hired Carlos with the QA role
    When Endava creates his information in the company
    Then Endava should be able to see Carlos's id