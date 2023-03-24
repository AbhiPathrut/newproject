@Zones

Feature: Zones Feature
 
@Zones_01
Scenario Outline: Create new zone simple
 		When user logs into MEC portal<user>
 		And user is on Dashboard page 
 		And user clicks on zones menu
 		Then user is on zones page
 		When click on create new zone
 		Then create new zone page is diplayed
 		When new zone details update<SheetName>, <RowNumber>
 		Then click on submit
 		When user is able to see successful popup message created new zone
 		Then click on close button
 		Examples:
		| user | SheetName | RowNumber |
    | Admin | Zones | 0 |

@Zones_02
Scenario Outline: Create new zone with enterprise dedicated zone
 		When user logs into MEC portal<user>
 		And user is on Dashboard page 
 		And user clicks on zones menu
 		Then user is on zones page
 		When click on create new zone
 		Then create new zone page is diplayed
 		When user select enterprise dedicated zone
 		When new zone details update<SheetName>, <RowNumber>
 		Then click on submit
 		When user is able to see successful popup message created new zone
 		Then click on close button
 		Examples:
		| user | SheetName | RowNumber |
    | Admin | Zones | 0 |
 		
@Zones_03
Scenario Outline: Create new zone simple with kubernetes service
 		When user logs into MEC portal<user>
 		And user is on Dashboard page 
 		And user clicks on zones menu
 		Then user is on zones page
 		When click on create new zone
 		Then create new zone page is diplayed
 		When kubernetes service selected update new zone details<SheetName>, <RowNumber>
 		Then click on submit
 		When user is able to see successful popup message created new zone
 		Then click on close button
 		Examples:
		| user | SheetName | RowNumber |
    | Admin | Zones | 0 |	

@Zones_04    
Scenario Outline: Create new zone with enterprise dedicated zone with kubernetes service 
 		When user logs into MEC portal<user>
 		And user is on Dashboard page 
 		And user clicks on zones menu
 		Then user is on zones page
 		When click on create new zone
 		Then create new zone page is diplayed
 		When user select enterprise dedicated zone
 		When kubernetes service selected update new zone details<SheetName>, <RowNumber>
 		Then click on submit
 		When user is able to see successful popup message created new zone
 		Then click on close button
 		Examples:
		| user | SheetName | RowNumber |
    | Admin | Zones | 1 |
    