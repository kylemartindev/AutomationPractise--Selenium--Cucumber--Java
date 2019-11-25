Feature: Creating an order


  @login
  Scenario: Log In
    Given I goto website
    When I Log in
    Then I make some purchases
    And Check purchases
    And Checkout products
    And I logout

  @checkingorders
  Scenario: Checking Amending Orders
   Given I log in
   When I look at my orders
   Then I add a comment to an order
   And I Logout


