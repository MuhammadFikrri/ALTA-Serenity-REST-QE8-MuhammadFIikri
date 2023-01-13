Feature: Testing Create user Reqres API

#  @Latihan
#  Scenario Outline: Post create new user with valid json
#    Given Post create user with valid json
#    When Send request post create user
#    Then Should return status code 201
#    And Response body name should be "<name>" and job "<job>"
#    And Validate json schema create user
#    Examples:
#      | name                   | job         |
#      | Muhammad Fikri Rabbani | QA Engineer |

  @Tugas-Create-User-Negative-Case
  Scenario Outline: POST new user with blank username body and password body should failed then return 400
    Given Post create user with blank name and job
    When Send request post create user
    Then Should return status code 400
    And Response body name should be "<name>" and job "<job>"
    And Validate json schema create user
    Examples:
      | name | job |
      |      |     |

  @Tugas-Create-User-Negative-Case
  Scenario Outline: POST new user with extra category should failed then return 400
    Given Post create user with category name, job and age
    When Send request post create user
    Then Should return status code 400
    And Response body name should be "<name>", job "<job>" and age "<age>"
    And Validate json schema create user
    Examples:
      | name                   | job         | age |
      | Muhammad Fikri Rabbani | QA Engineer | 22  |
