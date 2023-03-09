@Loginpage

Feature: Login Feature
  
#Scenario Outline: Login to MEC portal
    #When user is on login page
    #And enter username<SheetName>, <RowNumber>
    #And enter password<password>
    #And enter domain<domainName>
    #And click on login
    #Then User is on the dashboard page 
    #When user logs out
 #		Then login page is displayed
 #		Examples:
 #		| SheetName | RowNumber |
    #| Login | 0 |
    #| Login | 1 |
    #| Login | 2 |
    #| Login | 3 |   


Scenario Outline: Change the password and setting new one
    When user is on login page
    And user clicks on the change password
    And user enters the details for which password is to reset<SheetName>, <RowNumber>
    And user clicks on the submit button
   	Then user able to see the successful popup message
    When user clicks on close button
    And user enter the username rest pass for<username>, newpassword<newpass> and domain<domainName> 
    And click on login
    Then User is on the dashboard page as using login with new pass
    Examples:
 		| SheetName | RowNumber |
 		| Login | 0 |
    #| Login | 1 |
    #| Login | 2 |
    #| Login | 3 |