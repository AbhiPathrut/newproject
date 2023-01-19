
Feature: UI Tests - Demo Feature

  Background:
    Given user logs into SwagLabs portal 
 
    
        
      
 Scenario: Verify the item added in cart or not
    When user is on Products page
    And user adds item to cart
    And user click cart icon
    Then item should be listed
    
    
    
#Scenario Outline: Verify the price of item
#
#	When user is on Products page
#	Then verify that price of <Product> is <Price>
#
#Examples:
#		| Product | Price |
#		| Sauce Labs Bolt T-Shirt | $15.99 |
#		| Sauce Labs Fleece Jacket | $49.99 |
#		| Sauce Labs Backpack | $29.99 |
#		| Sauce Labs Bike Light | $9.99 |
#		| Sauce Labs Onesie | $7.99 |
#		| Test.allTheThings() T-Shirt (Red) | $15.99 |
		   
    