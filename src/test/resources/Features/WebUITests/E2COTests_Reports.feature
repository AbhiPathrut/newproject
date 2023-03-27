@Reports

Feature: Reports Feature
  
@Reports_01
Scenario: Test reports Application Based Reports functionality 
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on reports icon  
 		Then verify user is on reports page
 		Then select data from dropdown and click on show metrics button <SheetName>, <RowNumber>
 #		Then click on reset button 
 		Examples:
		| user | SheetName | RowNumber |
		| Admin | Reports | 0 |
		| Admin | Reports | 1 |