Feature: Register user

  @Tugas-Register-Positive-Case
  Scenario: Register user with valid input email and password
    Given Register user with valid json input
    When Send request register user
    Then Should return status code 200
    And Validate json schema success register user

  @Tugas-Register-Negative-Case
  Scenario: Register user with valid input email and blank password
    Given Register user with valid email and blank password
    When Send request register user
    Then Should return status code 400
    And Validate json schema failed register user