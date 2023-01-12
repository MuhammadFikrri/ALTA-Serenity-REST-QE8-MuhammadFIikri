Feature: Testing List Users Reqres API

  @Latihan
  Scenario Outline: Get list users with valid parameter page reqres API
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body page should be <page>
    Examples:
      |page|
      |1   |
      |2   |

  @Tugas
  Scenario Outline: GET list user with modified parameter should succes then return 200 response code
    Given Get list user with total user per page <perPage> and total page <totalPage>
    When Send request get list user with modified parameter
    Then Should return status code 200
    And Response body page should be <page>
    Examples:
      | perPage | totalPage | page |
      | 12      | 1         | 1    |

  #Silahkan tambahkan skenario negatif case dll