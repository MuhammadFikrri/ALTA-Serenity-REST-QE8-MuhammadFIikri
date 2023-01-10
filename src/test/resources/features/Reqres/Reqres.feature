Feature: Testing Reqres API

  Scenario Outline: Get list user with valid parameter page
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body should page <page>
    Examples:
      | page |
      | 1    |
      | 2    |