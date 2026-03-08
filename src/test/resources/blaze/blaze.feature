Feature: Blaze order functionality

  Background:
    Given user is on the product store home page

  @regression
  Scenario Outline: User completes purchase successfully
    When user clicks on login button
    And user logs in with valid credentials
    Then user select the laptops category then select product mac pro
    And user adds the product to cart and click on Cart
    Then user click on place order
    And user enters name as '<name>' and country as '<country>'
    Then user enters city '<city>' and credi card as '<creditcard>'
    And user enters month as '<month>' and year as '<year>' and the click on purchase
    Then user should see the success message '<message>'
    Examples: test data for blaze order
    |name|country   |city    |creditcard  |month  |year |message                     |
    | demo1| Turkey | izmir  |411111111111|02     |2025 |Thank you for your purchase!|
    | demo2| canada | Toronto|11111111111 |11     |2024 |Thank you for your purchase!|
    | demo3| USA    | philly |341111111111|02|2025|Thank you for your purchase!      |

    @negative
    Scenario: User cannot login with invalid credentials
      When user opens login modal
      And user logs in with invalid credentials as 'wrong' and 'wrongPassword'
      Then user should see an error message 'Wrong password.'


