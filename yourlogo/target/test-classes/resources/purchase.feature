
@tag
Feature: Making purchases

  @tag1
  Scenario: Ordering products
Given when I log in to site
When I click a product to view it
Then I can adjust the size
And add it too my basket
And I continue shopping
When I choose another product 
And I can add a second product to my basket

Scenario: Check basket

Given I have added too my basket
When I click my basket
Then I can check the sizes I selected are correct
Then I can check that the prices are also correct 

Scenario: Checkout Process
Given I am happy with my basket
When I click onto checkout 


 