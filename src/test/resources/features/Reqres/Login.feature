Feature: User Login

  @Tugas-Login-Positive-Case
  Scenario: User login with registered input email and password
    Given User login with valid username and password
    When Send request login user
    Then Should return status code 200
    And Validate json schema success login user

  @Tugas-Login-Negatve-Case
  Scenario: User login with registered username and blank password
    Given User login with valid username and blank password
    When Send request login user
    Then Should return status code 400
    And Validate json schema failed login user