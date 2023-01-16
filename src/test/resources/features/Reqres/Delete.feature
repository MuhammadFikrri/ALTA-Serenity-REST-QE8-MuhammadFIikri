Feature: Testing Delete user Reqres API

#  @Latihan
#  Scenario Outline: Delete users with valid id
#    Given Delete user with valid id <id>
#    When Send request delete user
#    Then Should return status code 204
#    Examples:
#      | id |
#      | 1  |
#      | 2  |

  @Tugas @Negative-Case
  Scenario Outline: DELETE user with invalid parameter should failed then return 404 response code
    Given Delete user with invalid id input "<id>"
    When Send request delete user
    Then Should return status code 404
    Examples:
      | id      |
      | 4=?gas3 |