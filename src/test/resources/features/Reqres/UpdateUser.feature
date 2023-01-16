Feature: Testing Update user Reqres API
#  @Latihan
#  Scenario: Put update user with valid json
#    Given Put update user with valid json with id 2
#    When Send request put update user
#    Then Should return status code 200
#    And Response body name should be "Muhammad Fikri Rabbani" and job "QA Engineer"

  @Tugas @Negative-Case
  Scenario: PUT update user with extra category should failed then return 400
    Given Put update user with category name, job and age with id 2
    When Send request put update user
    Then Should return status code 400
    And Response body name should be "<name>", job "<job>" and age "<age>"
    And Validate json schema update user
    Examples:
      | name                   | job         | age |
      | Muhammad Fikri Rabbani | QA Engineer | 22  |

  @Tugas @Negative-Case
  Scenario: PUT update user with blank username body and password should failed then return 400
    Given Put update user with blank name and job with id 2
    When Send request put update user
    Then Should return status code 400
    And Response body name should be "<name>" and job "<job>"
    And Validate json schema update user
    Examples:
      | name | job |
      |      |     |
