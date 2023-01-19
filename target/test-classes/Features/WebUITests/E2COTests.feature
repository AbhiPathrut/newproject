@usermanagement
Feature: User Management

    
 #Scenario Outline: Create new Admin user and verify login
 #		When user logs into MEC portal<user>
 #		And user is on Dashboard page
 #		And user clicks on User Mangement Menu
 #		Then user management page is displayed
 #		When user clicks on add new user
 #		Then add new user page is displayed
 #		When user enter the details <firstname>, <lastname>, <Role>, <emailid>, <username>, <pass>, <retypepass>, <contactno>, <Max invalid attempts>, <Max validity>
 #		And clicks on submit
 #		Then created user is displayed
 #		When user logs out
 #		Then login page is displayed
 #		When user enter username as <username> and password <pass>
 #		And click on login
 #		Then user is able to login 
 #		Examples:
 #		| user | firstname | lastname | Role | emailid | username | pass| retypepass | contactno | Max invalid attempts | Max validity |
 #		| Admin | admin | user | Admin |admin15@gmail.com | admin | Admin@1234 | Admin@1234 | 1234567890 | 5 | 60 |
 #		
 #		
 #		
 #		
 #Scenario Outline: Create new developer user and verify login
 #		When user logs into MEC portal<user>
 #		And  user is on Dashboard page
 #		And user clicks on User Mangement Menu
 #		Then user management page is displayed
 #		When user clicks on add new user
 #		Then add new user page is displayed
 #		When user enter the details <firstname>, <lastname>, <Role>, <emailid>, <username>, <pass>, <retypepass>, <contactno>, <Max invalid attempts>, <Max validity>
 #		And clicks on submit
 #		Then created user is displayed
 #		When user logs out
 #		Then login page is displayed
 #		When user enter username as <username> and password <pass>
 #		And click on login
 #		Then user is able to login 
 #		Examples:
 #		| user | firstname | lastname | Role | emailid | username | pass| retypepass | contactno | Max invalid attempts | Max validity |
 #		| Admin | developer | user | Application Developer | developer@gmail.com | dev | Admin@1234 | Admin@1234 | 1234567890 | 5 | 60 |
 #		
 		
#Scenario Outline: Developer is not able to create new user
#	When user logs into MEC portal<user>
#	And user is on dashboard page
#	Then user verifies user management menu is not present for developer
#	Examples:
#	| user |
#	| Developer |
 #		
#
 Scenario Outline: Admin is able to delete user
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
	
#	Scenario Outline: Admin is able to inactive the user
#		When user logs into MEC portal<user>
#		And  user is on Dashboard page
 #		And user clicks on User Mangement Menu
 #		Then user management page is displayed
 #		When user clicks on the lock button
 #		Then user is inactivated
 #		When user logs out
 #		Then login page is displayed
 #		When user enters the credientials of inactive user
 #		Then user is not able to login
 #		Examples:
 #		| user |
#		| Admin |
	
 		
 
 		
 		  
 		