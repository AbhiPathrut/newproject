@Enterprise

Feature: Enterprise menu
  
Scenario Outline: onboarding new enterpsie
    When user logs into MEC portal<user>
    And user is on Dashboard page
   	When user cliks on enterprise menu
   	Then user is on enterprise page
   	When user clicks on add new
   	Then onboarding new enterprise page is displayed
   	When new onboarding enterprise details provide<SheetName>, <RowNumber>
   	Then click on submit to create new enterprise
   	When created new enterprise successful popup message is displayed
   	And click on close btn
   	Then user is able to see the created new enterprise in list with the onbarded status
    Examples:
    | user | SheetName | RowNumber |
    | Admin | Enterprise | 0 |