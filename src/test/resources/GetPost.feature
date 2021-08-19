Feature:Get a single employee data
  Scenario: Viewing a single employee details
    Given Get Single Employee
    When ViewAllEmployees
    And CreateNewEmployee
    And UpdateTheEmployeeDetails
    Then DeleteTheEmployee
