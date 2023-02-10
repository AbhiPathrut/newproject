package stepdefinitions;


import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.framework.constants.AppConstants.Web;
import com.sogeti.automation.test.pageFactory.E2CO_EdgesPage;
import com.sogeti.automation.test.pageFactory.E2CO_LoginPage;
import com.sogeti.automation.test.pageFactory.E2CO_UserManagement;
import com.sogeti.automation.test.pageFactory.E2CO_ZonesPage;

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
    E2CO_EdgesPage e2co_edgespage;
    E2CO_ZonesPage e2co_zonespage;
    String dynamicUserName;
    int previousNumRow;
    int afterNumRow;
    String dynamicEdgeId;
    String dynamicCluster;
  
   

    public E2COTestSteps(TestContext context) throws Exception {
        super();
        this.testContext = context;
        e2co_loginpage = testContext.getPageObjectManager().getE2CO_LoginPage();
        e2co_usermanagement = testContext.getPageObjectManager().getE2CO_UserManagement();
        e2co_edgespage = testContext.getPageObjectManager().geE2co_EdgesPage();
        e2co_zonespage= testContext.getPageObjectManager().gete2co_zonespage();
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
    
    @And("^clicks on the submit$")
    public void submitDetails() {
    	e2co_usermanagement.clickSubmitBtn();
    	e2co_usermanagement.clickOnClose();
    	
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
    public void verifyUserIsRemovedFromTable() throws Exception {
    	Thread.sleep(2000);
    	afterNumRow = e2co_usermanagement.SizeOfTable();
    	Thread.sleep(2000);
    	if(previousNumRow>afterNumRow) {
    		log.info("Element is deleted");
    		
    	}else {
    		log.info("Element is not deleted");
    	}
    	
    	Assert.assertTrue(e2co_usermanagement.verifyDeletedRowIsNotPresentInTable(),"User is deleted successfully.");
    }

    @When("^user clicks on the lock button$")
    public void inactiveUser() {
    	e2co_usermanagement.lockbtn();	
    }
    
    @And("^user is inactivated$")
    public void verifyUserIsInactivated() {
    	Assert.assertTrue(e2co_usermanagement.inactivemsg(),"User is inactivated successfully.");	
    }
    
    @Then("^user enters the credientials of inactive user and not able to login$")
    public void enterInactivatedCredientials() throws Exception {
    	e2co_usermanagement.verifyLockedUserIsNotAbleToLogin();
    	
    }
    
    @And("^user clicks on Edges menu$")
    public void clickOnEdgesMenu() {
    	e2co_edgespage.navigateToEdgesPage();
    }
    
    @Then("^edges page is displayed$")
    public void verifyEdgePageIsDisplayed() {
    	
    }
    
    @When("^user clicks on add new edge$")
    public void clickOnAddNewEdge() {
    	e2co_edgespage.clickOnAddNewEdge();
    }
    
    @Then("^Onboarding a New Edge page is displayed$")
    public void verifyOnboardingNewPageIsDisplayed() {
    	e2co_edgespage.ImportYamlFile();
    	e2co_edgespage.submitDetailsOfEdge();
    	
    }
    @When("^Click on preprovision option$")
    public void clickOnPreProvision() {
    	e2co_edgespage.PreprovisionOption();
    }
    
    @Then("^Edge pre provision page is displayed$")
    public void VerifyPreProvisionPageLoaded() {
    	e2co_edgespage.EdgeIdTextIsVisible(); 
    }
    
    @When("^User enter all details (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*),(.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
    public void EnterOllDetails(String EdgeId,String ZoneId, String Country,String Latency,String EnterpriseId,String Bandwidth,String Description,String City,String State,String Locality,String radio,String MCC,String MNC,String CGI,String TAC,String Appavailble,String LoadFilter,String Cluster,String Latitude,String Longitude) {
    	String s = new SimpleDateFormat("MMddmmssSSS").format(new Date());
    	dynamicEdgeId = EdgeId + s;
    	e2co_edgespage.EdgeIdText(dynamicEdgeId);
    	System.out.println(dynamicEdgeId);
    	e2co_edgespage.ZoneIdSelect(ZoneId);
    	e2co_edgespage.CountrySelect(Country);
    	e2co_edgespage.LatencySelect(Latency);
    	e2co_edgespage.EnterpriseIdText(EnterpriseId);
    	e2co_edgespage.BandwidthSelect(Bandwidth);
    	e2co_edgespage.DescriptionText(Description);
    	e2co_edgespage.CityText(City);
    	e2co_edgespage.StateText(State);
    	e2co_edgespage.LocalityText(Locality);
    	e2co_edgespage.scrollDownPage();
    	e2co_edgespage.RadioSelect(radio);
    	e2co_edgespage.MCCText(MCC);
    	e2co_edgespage.MNCText(MNC);
    	e2co_edgespage.CGIText(CGI);
    	e2co_edgespage.TACText(TAC);
    	e2co_edgespage.Appavailabilty(Appavailble);
    	e2co_edgespage.SelectLoad(LoadFilter);
    	dynamicCluster = Cluster + s;
    	e2co_edgespage.ClusterName(dynamicCluster);
    	System.out.println(dynamicCluster);
	 	e2co_edgespage.LatitudeText(Latitude);
	 	e2co_edgespage.LongitudeText(Longitude);   
 	   
    }
    
    @And("^User click on submit button$")
    public void ClickOnSubmit() throws Exception {
    	e2co_edgespage.SubmitButton(); 
    }
    
    @Then("^New pre provsion edge is displayed(.*)")
    public void verifyPreprovisionEdgeIsDisplayed(String EdgeId) {
    	e2co_edgespage.verifyEdgeIsPreProvisioned(dynamicEdgeId);
    	
    }
    
    /////////
    @Then ("^click on edge button$")
	public void clickOnEdgeIcon() {
    	e2co_edgespage.clikEdgeIcon();
		System.out.println(" click on edgeicon");
	}
    
	@Then ("^check avaliable edges list$")
	public void veriEdgeList() {
		e2co_edgespage.veriEdgelist();
		System.out.println("display edges list");
	}
	
	@Then  ("^click on add new edge button$")
	public void clickOnAddNewEdgebttn() throws Exception {
		e2co_edgespage.clikAddNewEdgebttn();
		Thread.sleep(2000);
		System.out.println("click add new edge button");
	}
	
	@And ("^user upload the file$")
	public void clickOnImportbttn() throws Exception  {
		Thread.sleep(2000);
		e2co_edgespage.clikImportbttn();
		
		System.out.println("file upload");
		
	}
	
	@And ("^user click on edgesubmmit btton$")
	public void clickOnSubmidatatbttn() throws Exception 
	{
		Thread.sleep(2000);
		e2co_edgespage.submitedgedetails();
		System.out.println("Click on submit bttn");
		
	}
	//////////////////////////
	@And ("^user clicks on zone button$")
	public void clicksOnZoneIcon() {
		e2co_zonespage.clikZoneIcon();
		Assert.assertTrue(e2co_zonespage.isZonetitlePageDisplayed(),"Zone page is not loaded.");
		System.out.println("user is on zone page");
	}
	
//	public void southzone() throws Exception {////////////////zone
//		System.out.println("perform javascript");
//		zonepage.zonelist();/////////////////south zone click
//		
//		System.out.println("print south result");
//	}
//	
	@Then("^verify zone list$")
	public void printZoneList() {
		e2co_zonespage.displayZonelist();
		System.out.println("print zonelist details-");
		
	}
	@Then ("^click on south zone$")
	public void clickOnSouthZone() throws Exception {
		e2co_zonespage.clickOnZoneName();
		Thread.sleep(2000);
		e2co_zonespage.clickOnZoneName();
		System.out.println("print which zone name clicked");
		e2co_zonespage.clickOnDropDowndots();
		System.out.println("dropdown clicked");
		
	}
//	@Then ("^click on threedotsdropdown$")
//	public void threeDotsClick() {
//		zonepage.clickOnDropDowndots();
//		System.out.println("three dots");
//	}
//	
	@When ("^user clicks on create new zone$")
	public void clickOnNewZonebttn() {
		
		e2co_zonespage.creatNewZone();
		
		//Assert.assertTrue(true);
		
		System.out.println("user is on createnew zone page");	
	}
	
	@Then ("^user enter the details of new zone (.*), (.*), (.*), (.*), (.*)")
	public void entermandotarydetails(String zonename,String countryname,String latitude,String longitude,String description) {
		e2co_zonespage.enterZoneName(zonename);
		e2co_zonespage.enterCountry(countryname);
		e2co_zonespage.enterLatitude(latitude);
		e2co_zonespage.enterLongitude(longitude);
		e2co_zonespage.enterDescription(description);
		
	}
	
	@When ("^clicks on a submit$")
	public void clickOnSubmitbttn() throws Exception {
		e2co_zonespage.submitData();
		Assert.assertTrue(true);
		Thread.sleep(2000);
		System.out.println("result");
	}
	
	@Then ("^user is clicks close icon$")
	public void clickClosebttn() {
		e2co_zonespage.closeIcon();
	}
}
