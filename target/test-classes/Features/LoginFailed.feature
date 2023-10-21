Feature: Login test
  Scenario Outline: Login failed on saucedemo using scenario outline
    Given Open url "https://www.saucedemo.com/"
    And User input username "<username>" and password "<password>"
    When Click login button
    Then Failed login and showing message
    Examples:
      |username|password|
      |standard_user|xxxyyyzzzz|