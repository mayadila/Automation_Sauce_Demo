Feature: Login test

  Scenario Outline: Login success on saucedemo using scenario outline
    Given Open web url <url>
    And Input username <username> and password <password>
    When user Click login button
    Then Should success login and redirected to homepage
    Examples:
      | url                          | username        | password        |
      | "https://www.saucedemo.com/" | "standard_user" | "standard_user" |
