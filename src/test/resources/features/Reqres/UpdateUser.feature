Feature: Testing Update user Reqres API
  @Latihan
  Scenario: Put update user with valid json
    Given Put update user with valid json with id 2
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "Muhammad Fikri Rabbani" and job "QA Engineer"

  #Silahkan tambahkan skenario negatif case dll