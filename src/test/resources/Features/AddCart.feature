Feature: Add To Cart

  Scenario Outline: Adding product to cart
    Given I open url "https://www.saucedemo.com/"
    And I input username "<username>" and password "<password>"
    And I click login button
    When user click button Add to Cart in first list product
    And user click icon cart
    Then in cart page, will show product user which choose
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

