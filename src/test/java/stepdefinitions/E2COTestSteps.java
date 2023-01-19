package stepdefinitions;


import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.framework.constants.AppConstants.Web;
import com.sogeti.automation.test.pageFactory.E2CO_LoginPage;
import com.sogeti.automation.test.pageFactory.E2CO_UserManagement;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

public class E2COTestSteps extends TestClass {

    TestContext testContext;
    E2CO_LoginPage e2co_loginpage;
    E2CO_UserManagement e2co_usermanagement;
    String dynamicUserName;
    int previousNumRow;
    int afterNumRow;
   

    public E2COTestSteps(TestContext context) throws Exception {
        super();
        this.testContext = context;
        e2co_loginpage = testContext.getPageObjectManager().getE2CO_LoginPage();
        e2co_usermanagement = testContext.getPageObjectManager().getE2CO_UserManagement();
       
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

   

    @Given("^user logs into MEC portal(.*)")
    public void login(String user) {
    	if(user.equals("Admin")) {
    	e2co_loginpage.login(Web.UI_USERNAME, Web.UI_PASSWORD);
    	}else {
    		e2co_loginpage.login(Web.UI_Dev_USERNAME, Web.UI_Dev_PASSWORD);
    	}
    	    }
    
    @When("^user is on Dashboard page$")
    public void verifyUserisOnDashboard() {
    	Assert.assertTrue(e2co_loginpage.isElementDisplayed(),"Dashboard page is not loaded.");
    }
    
    @And("^user clicks on User Mangement Menu$")
    public void navigateToUserMangementPage() {
    	e2co_usermanagement.usermanagebttn();
    }
    
    @Then("^user management page is displayed$")
    public void verifyUserManagementPageLoaded() {
    	e2co_usermanagement.SizeOfTable();
    	e2co_usermanagement.userManagementPageLoaded();
    }
    
    @When("^user clicks on add new user$")
    public void clickOnAddNewUser() {
    	e2co_usermanagement.addnewuser();
    }
    
    @Then("^add new user page is displayed$")
    public void verifyAddNewUserPageLoaded() {
    	e2co_usermanagement.firstNameTextIsVisible();
    }

    @When("^user enter the details (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
    public void enterDetailsOfUser(String firstname, String lastname, String Role, String emailid, String loginname, String loginpass, String retypass, String contactno, String InvdAtttempts, String MaxValdty) {
    	e2co_usermanagement.firstnametext(firstname);
    	e2co_usermanagement.lastnametext(lastname);
    	e2co_usermanagement.selectRole(Role);
    	e2co_usermanagement.emailid(emailid);
    	String s = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    	dynamicUserName = loginname+s;
    	e2co_usermanagement.loginname(loginname+s);
    	e2co_usermanagement.password(loginpass);
    	e2co_usermanagement.retypePassword(retypass);
    	e2co_usermanagement.contactno(contactno);
    	e2co_usermanagement.selectMaxInvdAttpt(InvdAtttempts);
    	e2co_usermanagement.selectMaxValidty(MaxValdty);
    	
    }
    @And("^clicks on submit$")
    public void submitDetails() {
    	e2co_usermanagement.clickSubmitBtn();
    	
    }
    
    @Then("^created user is displayed$")
    public void verifyUserIsCreated() {
    	e2co_usermanagement.SizeOfTable();
    	Assert.assertTrue(e2co_usermanagement.verifyUserCreatedIsDisplayed(dynamicUserName),"New user present");
    }
    
    @When("^user logs out$")
    public void userIsLoggingOut() {
    	e2co_usermanagement.userDropDownBtn();
    	e2co_usermanagement.logoutBtn();
    		
    }
    
    @Then("^login page is displayed$")
    public void verifyUserIsOnLoginPage() {
    	e2co_loginpage.verifyUserIsOnHomePage();	
    }
    
    @When("^user enter username as (.*) and password (.*)")
    public void verifyCreatedUserLogin(String username, String password ) {
    	e2co_loginpage.enterUserName(dynamicUserName);
    	e2co_loginpage.enterPassword(password);
    	
    	
    }
    @And("^click on login$")
    public void clickLoginBtn() {
    	e2co_loginpage.clickLoginBtn();
    	
    }
    
    @Then("^user is able to login$")
    public void verifyUserAbleToLogin() {
    	Assert.assertTrue(e2co_loginpage.isElementDisplayed(),"Dashboard page is not loaded.");
    }
    
    @When("^user is on login page$")
    public void userIsOnLoginPage() {
    	e2co_loginpage.verifyUserIsOnHomePage();	
    } 
    
    @And("^user enters the username as (.*) and password as (.*)")
    public void enterLoginCredientials(String username, String password) {
    	e2co_loginpage.enterUserName(username);
    	e2co_loginpage.enterPassword(password);
    }
    
    @And("^click on login button$")
    public void clickLoginButn() {
    	e2co_loginpage.clickLoginBtn();
    }
    
    @And("^user is on dashboard page$")
    public void verifyUserOnDashboard() {
    	Assert.assertTrue(e2co_loginpage.isElementDisplayed(),"Dashboard page is not loaded.");
    }
    	
    
    @Then("^user verifies user management menu is not present for developer$")
    public void verifyUserManagementmenuunavailaible() {
    	Assert.assertFalse(e2co_usermanagement.verifyUserManagementIsNotAvailable(),"User managemenent is not present for developer");
    	
    }
    
    @When("^user clicks on the delete button$")
    public void verifyUserIsAbleToDelete() {
    	previousNumRow = e2co_usermanagement.SizeOfTable();
    	e2co_usermanagement.deletebtn();
    }
    
    @Then("^user sees popup of confirmation page$")
    public void verifyConfirmPopupMessageIsDisplayed() {
    	Assert.assertTrue(e2co_usermanagement.popupMessageIsDispalyed(),"Popup message for deleting user is displayed.");
    	
    	}
    @When("^clicks on confirm button$")
    public void clickOnConfirmButton() {
    	e2co_usermanagement.confirmbtn();
    }
    
    @Then("^user details are removed$")
    public void verifyUserIsRemovedFromTable() {
    	afterNumRow = e2co_usermanagement.SizeOfTable();
    	if(previousNumRow>afterNumRow) {
    		log.info("Element is deleted");
    	}else {
    		log.info("Element is not deleted");
    	}
    	
    }

    @When("^user clicks on the lock button$")
    public void inactiveUser() {
    	e2co_usermanagement.lockbtn();	
    }
    @Then("^user is inactivated$")
    public void verifyUserIsInactivated() {
    	Assert.assertTrue(e2co_usermanagement.inactivemsg(),"User is inactivated successfully.");
    	e2co_usermanagement.inactiveUser();
    	
    	
    }
    @When("^user enters the credientials of inactive user$")
    public void enterInactivatedCredientials() {
    	
    }
    
    @Then("^user is not able to login$")
    public void verifyUserIsBlockedToLogin() {}
}
