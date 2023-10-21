Feature: Logout from the Swag labs
  User want to logout from the Swag Labs
  Scenario Outline: Logout from the Swag labs
    Given User Open url "https://www.saucedemo.com/"
    And User Input username "<username>" and password "<password>"
    And User Click login button
    When User should navigate to left sidebar
    Then User click the logout button
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
