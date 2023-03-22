@UserManagement

Feature: User Management Feature

@UserManagement_01
 Scenario Outline: Create new user and verify login
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on User Mangement Menu
 		Then user management page is displayed
 		When user clicks on add new user
 		Then add new user page is displayed
 		When user enter the details of new user<SheetName>, <RowNumber>
 		And clicks on the submit
 		Then created user is displayed
 		When user logs out
 		Then login page is displayed
 		When user enter username as <username>, password as <pass> and domain as <domainName>
 		And click on login
 		Then user is able to login 
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | UserManagement | 1 |
    #| Admin | UserManagement | 1 |
    #| Admin | UserManagement | 2 |
    #| Admin | UserManagement | 3 |
    	
@UserManagement_02 			
Scenario Outline: Developer is not able to create new user
	When user logs into MEC portal<user>
	And user is on dashboard page
	Then user verifies user management menu is not present for developer
	Examples:
	| user |
	| Developer |
 		
 		
@UserManagement_03		
 Scenario Outline: user is able to delete user
 		When user logs into MEC portal<user>
 		And  user is on Dashboard page
 		And user clicks on User Mangement Menu
 		Then user management page is displayed
 		When user clicks on the delete button
 		Then user sees popup of confirmation page
 		When clicks on confirm button
 		Then user details are removed
 		Examples:
		| user |
		| Admin |
		
@UserManagement_04
	Scenario Outline: Admin is able to inactive the user
		When user logs into MEC portal<user>
		And  user is on Dashboard page
 		And user clicks on User Mangement Menu
 		Then user management page is displayed
 		When user clicks on the lock button
 		Then user is inactivated
 		When user logs out
 		And login page is displayed
 		Then user enters the credientials of inactive user and not able to login
 		Examples:
 		| user |
		| Admin |
	
@UserManagement_05		
Scenario Outline: Admin is able to active the user
		When user logs into MEC portal<user>
		And  user is on Dashboard page
 		And user clicks on User Mangement Menu
 		Then user management page is displayed
 		When user clicks on open lock button
 		Then user is activated
 		When user logs out
 		And login page is displayed
 		And user enters the credientials of activated user and able to login
 		Then user is on the dashboard page as user activated
 		Examples:
 		| user |
		| Admin |
 		
@UserManagement_06 		
Scenario Outline: User Management complete end to end scenario
		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on User Mangement Menu
 		Then user management page is displayed
 		When user clicks on add new user
 		Then add new user page is displayed
 		When user enter the details of new user<SheetName>, <RowNumber>
 		And clicks on the submit
 		Then created user is displayed
 		When user logs out
 		Then login page is displayed
 		When user enter username as <username>, password as <pass> and domain as <domainName>
 		And click on login
 		And user is on Dashboard page
 		Then user is admin or dev verify
 		When user clicks on User Mangement Menu for UM
 		Then user management page is displayed
 		When user clicks on the delete button
 		Then user sees popup of confirmation page
 		When clicks on confirm button
 		Then user details are removed
 		When user clicks on the lock button
 		Then user is inactivated
 		When user clicks on open lock button
 		Then user is activated
 		When user logs out
 		And login page is displayed
 		And user enters the credientials of activated user and able to login
 		Then user is on the dashboard page as user activated
 		 Examples:
 		| user | SheetName | RowNumber |
    | Admin | UserManagement | 0 |
    #| Admin | UserManagement | 1 |
    #| Admin | UserManagement | 2 |
    #| Admin | UserManagement | 3 |

 		
 		  
 		