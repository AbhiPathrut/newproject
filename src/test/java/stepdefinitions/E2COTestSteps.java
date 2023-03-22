package stepdefinitions;







import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.framework.constants.AppConstants.Web;
import com.sogeti.automation.framework.utils.ExcelReader;
import com.sogeti.automation.test.pageFactory.E2CO_EdgesPage;
import com.sogeti.automation.test.pageFactory.E2CO_LoginPage;
import com.sogeti.automation.test.pageFactory.E2CO_MyApplicationPage;
import com.sogeti.automation.test.pageFactory.E2CO_SDKPage;
import com.sogeti.automation.test.pageFactory.E2CO_TrobleshootPage;
import com.sogeti.automation.test.pageFactory.E2CO_UserManagement;
import com.sogeti.automation.test.pageFactory.E2CO_ZonesPage;
import java.util.List;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.Map;
import org.apache.logging.log4j.ThreadContext;
import org.junit.Assume;
import org.testng.Assert;


public class E2COTestSteps extends TestClass {

    TestContext testContext;
    E2CO_LoginPage e2co_loginpage;
    E2CO_UserManagement e2co_usermanagement;
    E2CO_EdgesPage e2co_edgespage;
    E2CO_ZonesPage e2co_zonespage;
    E2CO_MyApplicationPage e2co_myapplication;
    E2CO_SDKPage e2co_sdkpage;
    E2CO_TrobleshootPage e2co_trobleshootpage;
    String dynamicUserName;
    int previousNumRow;
    int afterNumRow;
    String dynamicSDKVersion;
    int beforedeleterownum;
    int afterdeleterownum;
   ExcelReader excelreader;
   Scenario scenario;
   String version;
   String EdgeIdPreprovisioned;
   String loginname;
   String pass;
   String serviceFromUser;
   String artifactname;
   String componentId;
   String componenetImageName;
   String domainName;
   String appNameFromUser;
   String Password;
   String DomainName;
   String domainname;
   String UNRestPass;
   String NewPassword;
   String ZoneName;
   String ApplicationNmFrDeboard;
   String ApplicationNameFrProvision;
   String ApplicationNameFrDeProvision;
   String Role;

    public E2COTestSteps(TestContext context) throws Exception {
        super();
        this.testContext = context;
        e2co_loginpage = testContext.getPageObjectManager().getE2CO_LoginPage();
        e2co_usermanagement = testContext.getPageObjectManager().getE2CO_UserManagement();
        e2co_edgespage = testContext.getPageObjectManager().geE2co_EdgesPage();
        e2co_zonespage= testContext.getPageObjectManager().gete2co_zonespage();
        e2co_myapplication = testContext.getPageObjectManager().gete2co_myapplication();
        e2co_sdkpage = testContext.getPageObjectManager().gete2co_sdkpage();
        e2co_trobleshootpage=testContext.getPageObjectManager().gete2co_trobleshootpage();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

   

    @Given("^user logs into MEC portal(.*)")
    public void login(String user) {
    	if(user.equals("Admin")) {
    	e2co_loginpage.login(Web.UI_USERNAME, Web.UI_PASSWORD, Web.UI_DOMAINNAME);
    	}else {
    		e2co_loginpage.login(Web.UI_Dev_USERNAME, Web.UI_Dev_PASSWORD, Web.UI_Dev_DOMAINNAME);
    	}
    	    }
    
    @When("^user is on Dashboard page$")
    public void verifyUserisOnDashboard() {
    	Assert.assertTrue(e2co_loginpage.isElementDisplayed(),"Dashboard page is loaded.");
    }
    
    @And("^user clicks on User Mangement Menu$")
    public void navigateToUserMangementPage() {
    	e2co_usermanagement.usermanagebttn();
    }
    
    @Then("^user management page is displayed$")
    public void verifyUserManagementPageLoaded() throws Exception {
    	Thread.sleep(2000);
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

    @When("^user enter the details of new user(.*), (.*)")
    public void enterDetailsOfUser(String SheetName, int RowNumber) throws IOException, Exception {
    	ExcelReader reader = new ExcelReader();
    	List<Map<String,String>> testData =
    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
    	String firstname = testData.get(RowNumber).get("firstname");
    	String lastname = testData.get(RowNumber).get("lastname");
    	 Role = testData.get(RowNumber).get("Role");
    	String emailid = testData.get(RowNumber).get("emailid");
    	 loginname = testData.get(RowNumber).get("username");
    	 pass = testData.get(RowNumber).get("pass");
    	String retypepass = testData.get(RowNumber).get("retypepass");
    	String contactno = testData.get(RowNumber).get("contactno");
    	String MaxInvalidAttempts = testData.get(RowNumber).get("MaxInvalidAttempts");
    	String MaxValidity = testData.get(RowNumber).get("MaxValidity");
    	 domainName = testData.get(RowNumber).get("domainName");
    	
    	e2co_usermanagement.firstnametext(firstname);
    	e2co_usermanagement.lastnametext(lastname);
    	e2co_usermanagement.selectRole(Role);
    	e2co_usermanagement.emailid(emailid);
//    	String s = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
//    	dynamicUserName = loginname+s;
    	e2co_usermanagement.loginname(loginname);
    	e2co_usermanagement.password(pass);
    	e2co_usermanagement.retypePassword(retypepass);
    	e2co_usermanagement.contactno(contactno);
    	e2co_usermanagement.selectMaxInvdAttpt(MaxInvalidAttempts);
    	e2co_usermanagement.selectMaxValidty(MaxValidity);	
    	e2co_usermanagement.enterDomainName(domainName);
    }
    
    @And("^clicks on the submit$")
    public void submitDetails() {
    	e2co_usermanagement.clickSubmitBtn();
    	e2co_usermanagement.clickOnClose();
    	
    }
    
    @Then("^created user is displayed$")
    public void verifyUserIsCreated() {
    	e2co_usermanagement.SizeOfTable();
    	Assert.assertTrue(e2co_usermanagement.verifyUserCreatedIsDisplayed(loginname),"New user present");
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
    
    @When("^user enter username as (.*), password as (.*) and domain as (.*)")
    public void verifyCreatedUserLogin(String username, String password, String domain ) {
    	e2co_loginpage.enterUserName(loginname);
    	e2co_loginpage.enterPassword(pass);
    	e2co_loginpage.enterDomain(domainName);
    	
    	
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
    
    @And("^enter username(.*), (.*)")
    public void enterUserName(String SheetName, int RowNumber) throws IOException, Exception {
    	ExcelReader reader = new ExcelReader();
    	List<Map<String,String>> testData =
    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
    	String UserName = testData.get(RowNumber).get("UserName");
    	 Password = testData.get(RowNumber).get("Password");
    	 DomainName = testData.get(RowNumber).get("DomainName");
    	e2co_loginpage.enterUserName(UserName);
    	System.out.println(UserName);
    }
    
    @And("^enter password(.*)")
    public void enterPassword(String password) {
    	e2co_loginpage.enterPassword(Password);
    	System.out.println(Password);
    }
    
    @And("^enter domain(.*)")
    public void enterDomainName(String domainName) {
    	e2co_loginpage.enterDomain(DomainName);
    	System.out.println(DomainName);
    }
    
    @Then("^User is on the dashboard page$")
    public void VerifyLoginCredientialsAreWorking() {
    	Assert.assertTrue(e2co_loginpage.isElementDisplayed(),"Dashboard page is loaded.");
    }
    
    @When("^user enters the username as (.*) and password (.*) and domain as (.*)")
    public void enterLoginCredientials(String username, String password, String domain) {
    	e2co_loginpage.enterUserName(loginname);
    	e2co_loginpage.enterPassword(pass);
    	e2co_loginpage.enterDomain(domainName);
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
    	//e2co_usermanagement.ownUserDelete();
    	
    	Assert.assertTrue(e2co_usermanagement.verifyDeletedRowIsNotPresentInTable(),"User is deleted successfully.");
    }

    @When("^user clicks on the lock button$")
    public void inactiveUser() throws Exception {
    	e2co_usermanagement.lockbtn();
    	Assert.assertTrue(e2co_usermanagement.inactivemsg(),"User is inactivated successfully.");
    	e2co_usermanagement.confirmbtn();
    	Thread.sleep(2000);
    	
    }
    
    @And("^user is inactivated$")
    public void verifyUserIsInactivated() {
    	//Assert.assertTrue(e2co_usermanagement.inactivemsg(),"User is inactivated successfully.");	
    	Assert.assertTrue(e2co_usermanagement.verifyInactiveSuccessfulMessageIsDisplayed(),"User is inactivated successfully.");
    	e2co_usermanagement.closeButton();
    	e2co_usermanagement.sizeOfInactiveUsers();
    }
    
    @Then("^user enters the credientials of inactive user and not able to login$")
    public void enterInactivatedCredientials() throws Exception {
    	e2co_usermanagement.verifyLockedUserIsNotAbleToLogin();
    	
    }
    
    @When("^user clicks on open lock button$")
    public void activeUser() throws Exception {
    	e2co_usermanagement.sizeOfInactiveUsers();
    	e2co_usermanagement.openlockbtn();
    	Assert.assertTrue(e2co_usermanagement.verifyActivateWarningMessageIsDisplayed(),"User activate warning message is displayed");
    	e2co_usermanagement.confirmbtn();
    	Thread.sleep(2000);
    }
    
    @Then("^user is activated$")
    public void verifyUserIsActivated() {
    	Assert.assertTrue(e2co_usermanagement.userActivatedSuccessMessagePopupMessageIsDisplayed(),"User activated success popup message is displayed");
    	e2co_usermanagement.closeButton();
    	e2co_usermanagement.sizeOfInactiveUsers();
    }
    
    @And("^user enters the credientials of activated user and able to login$")
    public void enterActivatedCredientials() throws Exception {
    	e2co_usermanagement.verifyUnLockedUserIsAbleToLogin();
    }
    
    @Then("^user is on the dashboard page as user activated$")
    public void verifyActivatedUserIsAbleToLogin() {
    	Assert.assertTrue(e2co_loginpage.isElementDisplayed(),"Dashboard page is loaded.");
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
    @When("^Click on  add new edge option$")
    public void clickOnPreProvision() throws Exception {
    	//e2co_edgespage.PreprovisionOption();
    	e2co_edgespage.clikAddNewEdgebttn();
		Thread.sleep(2000);
		System.out.println("click add new edge button");
    }
    
    @Then("^New edge page is displayed$")
    public void VerifyPreProvisionPageLoaded() {
    	e2co_edgespage.EdgeIdTextIsVisible(); 
    }
    
    @When("^User enter all details (.*), (.*)")
    public void EnterOllDetails(String SheetName, int RowNumber) throws IOException, Exception {
//    	String s = new SimpleDateFormat("MMddmmssSSS").format(new Date());
//    	dynamicEdgeId = EdgeId + s;
    	ExcelReader reader = new ExcelReader();
    	List<Map<String,String>> testData =
    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
    	 EdgeIdPreprovisioned = testData.get(RowNumber).get("EdgeId");
    	String ZoneId = testData.get(RowNumber).get("ZoneId"); 
    	String Country = testData.get(RowNumber).get("Country");
    	String Latency = testData.get(RowNumber).get("Latency");
    	String EnterpriseId = testData.get(RowNumber).get("EnterpriseId");
    	String Bandwidth = testData.get(RowNumber).get("Bandwidth");
    	String Description = testData.get(RowNumber).get("Description");
    	String City = testData.get(RowNumber).get("City");
    	String State = testData.get(RowNumber).get("State");
    	String Locality = testData.get(RowNumber).get("Locality");
    	String radio = testData.get(RowNumber).get("radio");
    	String MCC = testData.get(RowNumber).get("MCC");
    	String MNC = testData.get(RowNumber).get("MNC");
    	String CGI = testData.get(RowNumber).get("CGI");
    	String TAC = testData.get(RowNumber).get("TAC");
    	String Appavailble = testData.get(RowNumber).get("Appavailble");
    	String LoadFilter = testData.get(RowNumber).get("LoadFilter");
    	String Cluster = testData.get(RowNumber).get("Cluster");
    	String Latitude = testData.get(RowNumber).get("Latitude");
    	String Longitude = testData.get(RowNumber).get("Longitude");
    	
    	e2co_edgespage.EdgeIdText(EdgeIdPreprovisioned);
    	//System.out.println(dynamicEdgeId);
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
    	//dynamicCluster = Cluster + s;
    	e2co_edgespage.ClusterName(Cluster);
    	//System.out.println(dynamicCluster);
	 	e2co_edgespage.LatitudeText(Latitude);
	 	e2co_edgespage.LongitudeText(Longitude);   
 	   
    }
    
    @And("^User click on submit button$")
    public void ClickOnSubmit() throws Exception {
    	e2co_edgespage.SubmitButton(); 
    }
    
    @Then("^New pre provsion edge is displayed(.*)")
    public void verifyPreprovisionEdgeIsDisplayed(String EdgeId) {
    	e2co_edgespage.verifyEdgeIsPreProvisioned(EdgeIdPreprovisioned);
    	
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
		Assert.assertTrue(e2co_zonespage.isZonetitlePageDisplayed(),"Zone page is loaded.");
		//System.out.println("user is on zone page");
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
	
	@And ("^user enter the details of new zone (.*), (.*)")
	public void entermandotarydetails(String SheetName, int RowNumber) throws IOException, Exception {
		ExcelReader reader = new ExcelReader();
    	List<Map<String,String>> testData =
    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
    	String zoneid = testData.get(RowNumber).get("zoneid");
    	String latitude = testData.get(RowNumber).get("latitude");
    	String longitude = testData.get(RowNumber).get("longitude");
    	String description = testData.get(RowNumber).get("description");
    	 
		e2co_zonespage.enterZoneName(zoneid);
		//e2co_zonespage.enterCountry(countryname);
		e2co_zonespage.enterLatitude(latitude);
		e2co_zonespage.enterLongitude(longitude);
		e2co_zonespage.enterDescription(description);
		
	}
	
	@Then ("^clicks on a submit$")
	public void clickOnSubmitbttn() throws Exception {
		e2co_zonespage.submitData();
		Assert.assertTrue(true);
		Thread.sleep(2000);
		System.out.println("result");
	}
	
//	@Then ("^user is clicks close icon$")
//	public void clickClosebttn() {
//		e2co_zonespage.closeIcon();
//	}
	
	@And("^user clicks on my application$")
	public void clickOnMyApplication() throws Exception {
		e2co_myapplication.clickOnMyApplication();
		
	}
	
	@Then("^user is on my application page$")
	public void verifyUserIsOnMyApplicationPage() {
		e2co_myapplication.SizeOfApplicationTable();
		Assert.assertTrue(e2co_myapplication.applicationsTitleIsDisplayed(),"Application page is loaded.");
	}
	
	@When("^user clicks on new application$")
	public void clickOnNewApplication() throws Exception {
		e2co_myapplication.clickOnNewApplication();
	}
	
	@Then("^user is on new application page$")
	public void verifyUserIsOnNewApplicationPage() {
		Assert.assertTrue(e2co_myapplication.applicationNewPageIsDisplayed(),"New Application page is loaded.");
		e2co_myapplication.SizeOfApplicationTable();
		
	}
	
	@When("^user selects where to onboard application(.*), (.*)")
	public void selectOnboarding(String SheetName, int RowNumber) throws IOException, Exception {
		ExcelReader reader = new ExcelReader();
    	List<Map<String,String>> testData =
    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
    	 serviceFromUser = testData.get(RowNumber).get("service");
    	 artifactname = testData.get(RowNumber).get("artifactname");
     	 componentId = testData.get(RowNumber).get("componentId");
     	 componenetImageName = testData.get(RowNumber).get("componenetImageName");
    	 
    	 Thread.sleep(2000);
		if(serviceFromUser.equals("container")) {
		e2co_myapplication.selectContainer();
		log.info("Container as service selected");
		}else if (serviceFromUser.equals("VM")){
			e2co_myapplication.selectVM();
			log.info("Vm as service selected");
			}else {
				e2co_myapplication.selectKuberenetes();
				log.info("Kuberenetes as a service selected");
			}
	}
	
	@Then("^user is able to see that service (.*)")
	public void verifySelectedMenuIsVisible(String service) throws Exception {
		if(serviceFromUser.equals("container")) {
		Assert.assertTrue(e2co_myapplication.containerIsSelected(),"Container is selected");
		}else if (serviceFromUser.equals("VM")){
			Assert.assertTrue(e2co_myapplication.applicationNewPageIsDisplayed(),"VM is selected.");
		}else {
			Assert.assertTrue(e2co_myapplication.kubernetesIsSelected(),"Kubernetes is selected.");
		}
	}
	
	@When("^user clicks on create new artifact$")
	public void createNewArtifact() {
		e2co_myapplication.clickOnCreateNewArtifact();
	}
	
	@Then("^user is on artifact page$")
	public void verifyUserIsOnArtifactPage() {
		Assert.assertTrue(e2co_myapplication.verifyuserisOnArtifactPage(),"User is on artifact page");
		
	}
	
	@When("^user enters the details to create artifact(.*), (.*), (.*), (.*)")
	public void enterTheDetailsOfArtifact(String service, String artifactName, String componentID, String componenetimageName ) throws Exception {
		if(serviceFromUser.equals("container")) {
		//String s = new SimpleDateFormat("MMddmmssSSS").format(new Date());
//		dynamicArtifactName = ArtifactName + s;
//		System.out.println(dynamicArtifactName);
		e2co_myapplication.enterArtifactName(artifactname);
		e2co_myapplication.enterComponenetID(componentId);
		e2co_myapplication.enterComponenetImageName(componenetImageName);
		e2co_myapplication.browseZipFileContainer();
		Thread.sleep(2000);
		
		}else if(serviceFromUser.equals("VM")) {
			//String s = new SimpleDateFormat("MMddmmssSSS").format(new Date());
//			dynamicArtifactName = ArtifactName + s;
//			System.out.println(dynamicArtifactName);
			e2co_myapplication.enterArtifactName(artifactname);
			e2co_myapplication.enterVMID(componentId);
			e2co_myapplication.enterVMImageName(componenetImageName);
			e2co_myapplication.browseZipFileVM();
			Thread.sleep(2000);
		}
		else {
			
		}
		
	}
	
	@Then("^user submits the details and able to see successful message$")
	public void submitDetailsAndVerifyArtifact() throws Exception {
		e2co_myapplication.clickOnSubmitButton();
		Thread.sleep(2000);
		Assert.assertTrue(e2co_myapplication.verifyArtifactIsCreated(),"Artifact is created successfully");
		Thread.sleep(2000);
		e2co_myapplication.closeTheDialogBox();
	}
	
	@When("^user clicks on select artifact$")
	public void selectArtifact() throws Exception {
		e2co_myapplication.clickOnSelectArtifact();
		Thread.sleep(2000);
	}
	
	@Then("^user able to see created artifact$")
	public void verifyArtifactIsCreated() throws Exception {
		e2co_myapplication.verifyArtifactCreatedIsDisplayed(artifactname);
		Thread.sleep(2000);;
		
	}
	
	 @When("^user selects from where to artifact is to delete(.*), (.*)")
	    public void selectService(String SheetName, int RowNumber) throws IOException, Exception {
		 ExcelReader reader = new ExcelReader();
	    	List<Map<String,String>> testData =
	    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
	    	 serviceFromUser = testData.get(RowNumber).get("service");
		 if(serviceFromUser.equals("container")) {
			e2co_myapplication.selectContainer();
			log.info("Container as service selected");
		 }else if (serviceFromUser.equals("VM")){
			e2co_myapplication.selectVM();
			log.info("Vm as service selected");
		}else {
			e2co_myapplication.selectKuberenetes();
			log.info("Kuberenetes as a service selected");
					}
			}
		 
	 @Then("^user able to see artifacts uploaded$")
	 public void userIsAbleTOSeeArtifact() throws Exception {
		 Assert.assertTrue(e2co_myapplication.verifyUserIsAbleToSeeArtifactList(),"Artifact list is getting displayed");
		 previousNumRow = e2co_myapplication.SizeOfArtifactTable();
		 Thread.sleep(2000);
	 }
	 
	 @When("^user selects the artifactid for delete$")
	 public void selectTheArtifactId() throws Exception {
		 e2co_myapplication.deleteArtifactSelect();
		 
	 }
	 
	 @And("^user clicks on delete button$")
	 public void clicksOnDeleteButton() throws Exception {
		 e2co_myapplication.clickOnDeleteButton();
		 Thread.sleep(2000);
	 }
	 
	 @Then("^user is not able to find the deleted artifactId$")
	 public void verifyUserNotAbleToSeeDeletedArtifact() throws Exception {
		 //Assert.assertTrue(e2co_myapplication.verifyArtifactIsDeletedMessage(),"Artifact deleted successful message is displayed");
		 e2co_myapplication.verifyArtifactIsDeletedMessage();
		 Thread.sleep(2000);
		 //e2co_myapplication.closeTheDialogBox();
		 //Thread.sleep(2000);
		 afterNumRow = e2co_myapplication.SizeOfArtifactTable();
		    	Thread.sleep(3000);
		    	if(previousNumRow>afterNumRow) {
		    		log.info("Artifact is deleted");
		    		
		    	}else if(previousNumRow==afterNumRow) {
		    		log.info("Artifact is not deleted");
		    	}else {
		    		log.info("page not loaded");
		    	}
		    	
		  Assert.assertTrue(e2co_myapplication.verifyDeletedArtifactIsNotPresentInTable(),"Artifact is deleted successfully.");
		    
	 }
	 
	 @When("^user selects the artifactid$")
	 public void selectArtifactIdForApplicationOnboard() throws Exception {
		 e2co_myapplication.selectArtifactId();
	 }
	 
	 @Then("^user clicks on done button$")
	    public void clickOnDoneButton() {
	    	e2co_myapplication.clickOnDoneBtn();
	    }
	   
	    @When("^click on import button$")
		 public void uploadFile() {
			 e2co_myapplication.clickOnImportButton();
			 
		 }
	    
	    @Then("^upload file page is displayed$")
	    public void verifyTheUploadingPageIsDisplayed() {
	    	Assert.assertTrue(e2co_myapplication.verifyUploadPageIsVisible(),"Upload File Page is displayed");
	    }
	    
	    @When("^upload the yaml file of application$")
	    public void verifyTheUploadingOfFile() {
	    	e2co_myapplication.uploadYAMLFile();
	    }
	    
	    @And("^click on submit button$")
	    public void clickOnSubmitButtonYaml() {
	    	e2co_myapplication.submitBtnOfYAML();
	    	
	    }
	    
	    @Then("^user is able to see uploaded data on page$")
	    public void verifyUploadedDataIsVisible() {
	    	Assert.assertTrue(e2co_myapplication.verifyUploadedDataIsFecthed(),"Uploaded data is displayed on the page");
	    }
	    
	    @When("^update the details of application (.*), (.*)")
	    public void detailsUpdating(String SheetName, int RowNumber) throws IOException, Exception {
	    	//String s = new SimpleDateFormat("MMddmmssSSS").format(new Date());
			//dynamicAppName = appName + s;
	    	ExcelReader reader = new ExcelReader();
	    	List<Map<String,String>> testData =
	    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
	    	 appNameFromUser = testData.get(RowNumber).get("appName");
	    	String Latency = testData.get(RowNumber).get("Latency");
	    	String zone = testData.get(RowNumber).get("zone");
	    	String componentId = testData.get(RowNumber).get("componentId");
	    	String Network = testData.get(RowNumber).get("Network");
	    	
	    	e2co_myapplication.updateAppName(appNameFromUser);
	    	Thread.sleep(2000);
	    	//e2co_myapplication.updateBandWidth(BandWidth);
	    	e2co_myapplication.updateLatency(Latency);
	    	Thread.sleep(2000);
	    	e2co_myapplication.updateZone(zone);
	    	Thread.sleep(2000);
	    	e2co_myapplication.clickOnDeploymentEdit();
	    	Thread.sleep(2000);
	    	e2co_myapplication.updateComponentID(componentId);
	    	Thread.sleep(2000);
	    	e2co_myapplication.updateNetwork(Network);
	    	Thread.sleep(2000);	
	    }
	    
	    @And("^Click on submit button$")
	    public void clickOnSubmitButton() throws Exception {
	    	e2co_myapplication.submitDetailsOfApplication();
	    }
	    
	    @And("^user is able to see successful message for application onboard$")
	    public void verifyApplicationOnboardMessageIsDisplayed() {
	    	Assert.assertTrue(e2co_myapplication.verifyOnboardingMessageIsDisplayed(),"Application onboard request accepted");
	    	e2co_myapplication.closeTheDialogBox();
	    }

	    @Then("^user is can see the application in a list$")
	    public void verifyApplicationOnboardedIsDisplyaedInList() throws Exception {
	    	e2co_myapplication.SizeOfApplicationTable();
	    	e2co_myapplication.verifyApplicationOnoardedIsDisplayed(appNameFromUser);
	    	Thread.sleep(15000);
	    	e2co_myapplication.refresHPageOfWeb();
	    	Thread.sleep(10000);
	    	e2co_myapplication.statusOfApplication(appNameFromUser);
	    	
	    	
	    }
	
	////************
	
	@And("^click on Zone menu$")
    public void NavigateToZoneMenu() {
		e2co_edgespage.ZoneMenuButton();
    }
    
    @And("^click on any one zone$")
    public void SelectTheZone() throws Exception {
    	e2co_edgespage.ClickOnZone();
    	//e2co_deboardedge.SubmitButton();
    }
    
    @And("^click on edge$")
    public void SelectTheEdge() throws Exception {
    	e2co_edgespage.ClickONEdge();
    }
    
    @Then("^Edge details are diasplayed$")
    public void VerifyEdgeDetailsAreDisplayed() {
    	e2co_edgespage.ManageButtonIsVisible();
    	
    }
    
    @When("^user click on manage option$")
    public void ClickOnManageOption() {
    	e2co_edgespage.clickOnManageEdgeBtn();
    }
    
    @And("^click on deboard option$")
    public void ClickOnDeboardOption() throws Exception {
    	e2co_edgespage.ClickOnDeboardButton();
    }
    
    @Then("^Edge is deboarded successfully$")
    public void VerifyEdgeDeobarded() {
    	
    }
	
    @When("^click on the edge which is to deboard(.*), (.*)")
    public void selectEdgeIsToDeboard(String SheetName, int RowNumber) throws IOException, Exception {
    	ExcelReader reader = new ExcelReader();
    	List<Map<String,String>> testData =
    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
    	String EdgeIdDeboard = testData.get(RowNumber).get("EdgeIdDeboard");
    	Thread.sleep(2000);
    	e2co_edgespage.clickOnEdgeIsDeboard(EdgeIdDeboard);
    	Thread.sleep(2000);
    	e2co_edgespage.edgeIdDeboarded();
    }
    
    @Then("^Edge details page is displayed$")
    public void verifyEdgesPageIsDisplayed() {
    	Assert.assertTrue(e2co_edgespage.verifyEdgeDetailsPageIsDispalyed(),"Edge details page is displayed");
    }
    
    @When("^click on manage edge$")
    public void clickOnEdgeManageButn() throws Exception {
    	e2co_edgespage.clickOnManageButton();
    }
    
    @Then("^Manage edge page is displayed$")
    public void verifyManageEdgesDetailsPageIsDisplaying() {
    	Assert.assertTrue(e2co_edgespage.verifyManageEdgeDetailsPageIsDisplayed(),"Manage Edges details page is displayed");
    }
    
    @When("^click on deboard button$")
    public void clickOnDeboardButton() {
    	e2co_edgespage.clickOnDeboardButton();
    	
    }
    
    @Then("^Deboarding warning message popup is diaplyed$")
    public void warningMessageIsDisplayed() {
    	Assert.assertTrue(e2co_edgespage.verifyDeboardingWarningPageIsDisplayed(),"Deboard warning message popup is displayed");
    	
    }
    
    @When("^click on the confirm button$")
    public void clickOnConfirmBtn() {
    	e2co_edgespage.clickOnConfirmButton();
    }
    
    @Then("^Zones page is dispalyed$")
    public void zonesPageIsDisplayed() {
    	Assert.assertTrue(e2co_edgespage.verifyZonesPageIsDisplayedAfterDeboard(),"Zones page is displayed");
    }
    
    @When("^user is clicking on Edge menu$")
    public void  clickOnedgesmenu() {
    	e2co_edgespage.navigateToEdgesPage();
    	
    }
    
    @Then("^user is not able to see the edge which is deboarded$")
    public void verifyEdgeIsRemovedFromList() {
    	
    }
    
   //********************
    @And("^user click on SDK menu$")
    public void ClickOnSdkMenuButton() {
    	e2co_sdkpage.ClickOnSDkMenu();
    }
    
    @Then("^list of SDK is diasplayed$")
    public void ValidateSDklist() {
    	e2co_sdkpage.SizeOfsdkTable();
    	Assert.assertTrue(e2co_sdkpage.listOfsdkTableIsVisible(),"List of sdk displayed");
    	
    }
    @When("^user clicks on upload option$")
    public void ClickONUploadOption() {
    	e2co_sdkpage.ClickOnUploadButton();
    }
    
    
    @And ("^Enter all mandetory details(.*), (.*)")
    public void EnterAllDetails(String SheetName, int RowNumber) throws IOException {
    	ExcelReader reader = new ExcelReader();
    	List<Map<String,String>> testData =
    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
    	String language = testData.get(RowNumber).get("language");
    	 version = testData.get(RowNumber).get("Version");
    	String description = testData.get(RowNumber).get("description");	 
    	e2co_sdkpage.SelectOneLanguage(language);
//    	String s = new SimpleDateFormat("dssSS").format(new Date());
//    	dynamicSDKVersion = Version + s;
    	e2co_sdkpage.EnterSDKVersion(version);
    	e2co_sdkpage.EnterSDKDescription(description);
    	e2co_sdkpage.SelectSDKFile();
    	
    }
    
    @And ("^click on upload button$")
    public void ClickSubmitButton() throws Exception {
    	e2co_sdkpage.SubmitCreatedSDK();
    	Thread.sleep(2000);
    	
    }
    
    @Then ("^SDK is uploaded successfully$")
    public void ValidateSDkUploaded() {
    	Assert.assertTrue(e2co_sdkpage.sdkUploadedSuccessfullyMesgDisplayed(),"sdk uploaded successfully message is displayed");
    	//e2co_sdkpage.ClickOnCloseButton();
    	String dynamicSDKName = "ec_client-sdk_Android_"+version+".zip";
    	System.out.println(dynamicSDKName);
    	e2co_sdkpage.clickOnCloseButton();
    	e2co_sdkpage.SizeOfsdkTable();
    }
    
    @And ("^click on uploaded Sdk(.*), (.*)")
    public void ClickOnUploadedSDK(String SheetName, int RowNumber) throws IOException, Exception {
    	 beforedeleterownum = e2co_sdkpage.SizeOfsdkTable();
    	 ExcelReader reader = new ExcelReader();
     	List<Map<String,String>> testData =
     			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);	 
     	String versionDelete = testData.get(RowNumber).get("versionDelete");
    	e2co_sdkpage.SelectUploadedSDK(versionDelete);
    	e2co_sdkpage.infoOfDeletedSdk();
    }
    
    @And ("^click on delete sdk button$")
    public void ClickOnDeleteOption() throws Exception {
    	e2co_sdkpage.ClickOnDelete();
    }
    
    @And ("^SDK is deleted$")
    public void ClickOnConfirmButton() {
    	e2co_sdkpage.ClickOnConfirm();
    	 afterdeleterownum = e2co_sdkpage.SizeOfsdkTable();
    }
    
    @Then("^SDK is deleted is verified$")
    public void verifySDKIsRemovedFromList() {
    	if(beforedeleterownum>afterdeleterownum) {
    		log.info("SDK is removed from list");
    		//System.out.println("SDK is deleted successfully");
    		
    	}else {
    		log.info("SDK is not removed from list");
    		//System.out.println("SDK is not deleted");
    	}
    }
    
    //******************************
    
    @When("^user clicks on application(.*), (.*)")
    public void selectApplicationIsToProvision(String SheetName, int RowNumber) throws Exception {
    	ExcelReader reader = new ExcelReader();
     	List<Map<String,String>> testData =
     			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);	 
     	 ApplicationNameFrProvision = testData.get(RowNumber).get("ApplicationNameFrProvision");
     	 ZoneName = testData.get(RowNumber).get("ZoneName");
    	e2co_myapplication.selectApplicationForPrvision(ApplicationNameFrProvision);
    }
    
    @Then("^user is able to see the application details$")
    public void verifyUserIsAbleToSeeApplicationDetails() {
    	Assert.assertTrue(e2co_myapplication.userIsOnProvisionPage(),"User is on application provision page");
    }
    
    @When("^user selects the zone for application provision (.*)")
    public void selectZoneForProvisionOfApplication(String zone) {
    	e2co_myapplication.selectZoneForApplicationProvision(ZoneName);
    }
    
    @And("^user click on provision buttton$")
    public void clickOnProvision() {
    	e2co_myapplication.clickOnProvisionBtn();
    }
    
    @Then("^user is able to see successful message for request$")
    public void verifyRequestAcceptMessageIsDisplayed() {
    	Assert.assertTrue(e2co_myapplication.requestAcceptMessageIsDisplayed(),"Request accepted message is displayed");
    }
    
    @When("^user click on close button$")
    public void clickOnCloseButton() {
    	e2co_myapplication.clickOncloseBtn();
    }
    
    @Then("^user is able to see the application in running status$")
    public void verifyApplicationIsInRunningStatus() throws Exception {
    	Thread.sleep(10000);
    	e2co_myapplication.refresHPageOfWeb();
    	Thread.sleep(8000);
    	e2co_myapplication.statusOfApplication(ApplicationNameFrProvision);
    }
    
    //**************************
    
    @And ("^user click on troubleshoot menu$")
    public void ClickOnTrobleshoot() {
    	e2co_trobleshootpage.ClickOnTroubleshoot();
    	
    }
    
    @And ("^user enter all mandetory details(.*), (.*)")
    public void EnterAllDetailsOfApplicationToTrobleshoot(String SheetName, int RowNumber) throws IOException, Exception {
    	ExcelReader reader = new ExcelReader();
     	List<Map<String,String>> testData =
     			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);	 
     	String applicationName = testData.get(RowNumber).get("applicationName");
     	String appId = testData.get(RowNumber).get("appId");
     	String appVersion = testData.get(RowNumber).get("appVersion");
     	String instanceId = testData.get(RowNumber).get("instanceId");
    	e2co_trobleshootpage.SelectAppName(applicationName);
    	e2co_trobleshootpage.SelectApplicationId(appId);
    	e2co_trobleshootpage.SelectAppVersion(appVersion);
    	e2co_trobleshootpage.SelectInstanceId(instanceId);
    }
    
    @And ("^user click on apply button$")
    public void ClickOnApplyOption() throws Exception {
    	e2co_trobleshootpage.ClickonApplyButton();
    }
    
    @Then ("^user able to view troubleshoot status$")
    public void VarifyTroubleShootStatusIsDisplay() {
    	Assert.assertTrue(e2co_trobleshootpage.TroubleshootStatusDisplay(),"Troubleshoot status is displayed");
    	e2co_trobleshootpage.troblshootDetailsDisplyed();
    }
    //************************
    
    @When("^clicks on application which is to deprovision(.*), (.*)")
    public void selectRunningAppForDeprovision(String SheetName, int RowNumber) throws Exception {
    	ExcelReader reader = new ExcelReader();
     	List<Map<String,String>> testData =
     			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);	 
     	 ApplicationNameFrDeProvision = testData.get(RowNumber).get("ApplicationNameFrDeProvision");
    	e2co_myapplication.selectAppForDeprovision(ApplicationNameFrDeProvision);
    }
    
    @Then("^user is able to see the application details of provisioned app$")
    public void detailsOfAppIsDisplayed() {
    	Assert.assertTrue(e2co_myapplication.provisionedAppDetailsIsDisplayed(),"App details are displaying");
    	
    }
    
    @When("^user clicks on deprovision button$")
    public void clickOnDeprovisionButtion() {
    	e2co_myapplication.clickOnDeprovisionButton();
    	
    }
    
    @Then("^user able to see warning message for deprovision$")
    public void verifyWarningMessageIsDisplayed() {
    	Assert.assertTrue(e2co_myapplication.verifyDeprovisionAppWarningMessageIsDisplayed(),"App details are displaying");
    }
    
    @When("^user clicks on confirm button$")
    public void clcikOnConfirmButton() {
    	e2co_myapplication.clickOnConfirmBtn();
    	
    }
    
    @Then("^user able to see the app is deprovisioned$")
    public void verifyAppIsDeprovisioned() throws Exception {
    	Thread.sleep(10000);
    	e2co_myapplication.refresHPageOfWeb();
    	Thread.sleep(8000);
    	e2co_myapplication.statusOfApplication(ApplicationNameFrDeProvision);
    	
    }
    //*************************
    @And("^user clicks on the change password$")
    public void clickOnChangePasswordBtn() {
    	e2co_loginpage.clickOnChangePassword();
    }
    
    @And("^user enters the details for which password is to reset(.*), (.*)")
    public void enterTheDetailsForResetPassword(String SheetName, int RowNumber) throws IOException, Exception {
    	ExcelReader reader = new ExcelReader();
     	List<Map<String,String>> testData =
     			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);	 
     	 UNRestPass = testData.get(RowNumber).get("UNRestPass");
     	String OldPassword = testData.get(RowNumber).get("OldPassword");
     	 NewPassword = testData.get(RowNumber).get("NewPassword");
     	String RetypeNewPassword = testData.get(RowNumber).get("RetypeNewPassword");
     	 domainname = testData.get(RowNumber).get("domainname");
    	e2co_loginpage.enterusernameResetPassword(UNRestPass);
    	e2co_loginpage.enteroldpassword(OldPassword);
    	e2co_loginpage.enterNewPassword(NewPassword);
    	e2co_loginpage.enterretypePassword(RetypeNewPassword);
    }
    @And("^user clicks on the submit button$")
    public void submitDetailsForRestePassword() throws Exception {
    	e2co_loginpage.clickOnSubmitButton();
    }
    
    @Then("^user able to see the successful popup message$")
    public void verifyPasswordIsUpdatedSuccessfulMessageIsDisplayed() {
    	Assert.assertTrue(e2co_loginpage.verifyPasswordUpdateSuccessPopupMessageIsDisplayed(),"App details are displaying");
    	//e2co_loginpage.verifyPasswordUpdateSuccessPopupMessageIsDisplayed();
    }
    
    @When("^user clicks on close button$")
    public void clickOnCloseButtonAfterResetingPassword() {
    	e2co_loginpage.clickOnCloseButton();
    }
    
    @And("^user enter the username reset pass for(.*), newpassword(.*) and domain(.*)")
    public void verifyTheNewPasswordIsWorking(String username, String newpass, String domainName) {
    	e2co_loginpage.enterUserName(UNRestPass);
    	e2co_loginpage.enterPassword(NewPassword);
    	e2co_loginpage.enterDomain(domainname);
    }
    
    @Then("^User is on the dashboard page as using login with new pass$")
    public void userisAbleToLoginWithNewPassword() {
    	Assert.assertTrue(e2co_loginpage.isElementDisplayed(),"Dashboard page is loaded.");
    }
    
    //*****************************
    @When("^clicks on application which is to deboard the application(.*), (.*)")
    public void selectApplicationForDeboarding(String SheetName, int RowNumber) throws IOException, Exception {
    	ExcelReader reader = new ExcelReader();
     	List<Map<String,String>> testData =
     			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);	 
     	 ApplicationNmFrDeboard = testData.get(RowNumber).get("ApplicationNmFrDeboard");
    	e2co_myapplication.selectAppForDebaord(ApplicationNmFrDeboard);
    }
    
    @Then("^user is able to see the application details of onboarded application$")
    public void verifyApplicationDetailsAreDisplayingForDeboard() {
    	Assert.assertTrue(e2co_myapplication.userIsOnProvisionPage(),"Application details are displaying");
    }
    
    @When("^user click on Deboarding button$")
    public void clickOnDeboardingButtonOfApp() {
    	e2co_myapplication.clickOnDeboardingAppButton();
    }
    
    @Then("^user is able to see deboarding warning poupup messg$")
    public void verifyDeboardingOfAppWarningPopupMessgDispalyed() {
    	Assert.assertTrue(e2co_myapplication.debordingWarningPopupMessageIsDispalying(),"Application deboarding warning popup message is displayed");
    }
    
    @Then("^user is able to see the application is removed from the list$")
    public void verifyApplicationDeboardedIsRemovedFromDeboarded() throws Exception {
    	e2co_myapplication.clickOncloseBtn();
    	Thread.sleep(2000);
    	e2co_myapplication.verifyDeboardedAppIsNotPresentInAppList(ApplicationNmFrDeboard);
    }
    //****************************
    @When("^user close the artifactWindow$")
    public void closeArtifactWindowForApp() {
    	e2co_myapplication.closeArtifactWindow();
    }
    
    @Then("^user is able to see artifactWindow Closed$")
    public void verifyArtifactWindowClosed() {
    	Assert.assertTrue(e2co_myapplication.artifactwindowClosedValidation(),"Artifact window is closed");
    }
    //*********************
    @When("^user clicks on User Mangement Menu for UM$")
    public void clickOnUserManagementMenu() throws Exception {
    	e2co_usermanagement.usermanagebttn();
    	Thread.sleep(2000);
    }
    
    @Then("^user is admin or dev verify$")
    public void verifyUserIsAdminOrDev() throws Exception {
    	if(Role.contains("Admin")) {
    		Thread.sleep(2000);
    		log.info("Admin is able to access user management.");
    		
    	}else {
    		Assert.assertFalse(e2co_usermanagement.verifyUserManagementIsNotAvailable(),"User managemenent is not present for developer");
    		log.info("User managemenent is not present for developer.");
    		e2co_usermanagement.userDropDownBtn();
        	e2co_usermanagement.logoutBtn();
        	Assume.assumeTrue(false);
        	

    	}
    	
    }
    
    //**************
    @When("^click on the edge for the details of edge(.*), (.*)")
    public void selectEdgeToViewDetails(String SheetName, int RowNumber) throws IOException, Exception {
    	ExcelReader reader = new ExcelReader();
    	List<Map<String,String>> testData =
    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
    	String EdgeForDetails = testData.get(RowNumber).get("EdgeForDetails");
    	Thread.sleep(2000);
    	e2co_edgespage.clickOnEdgeIsDeboard(EdgeForDetails);
    	Thread.sleep(2000);
    	e2co_edgespage.edgeIdDeboarded();
    	
    }
    
    @Then("^Edge details page is displayed for the particular edge$")
    public void verifyEdgeDetailsAreAbleToSeeForParticularEdge() throws Exception {
    	Thread.sleep(3000);
    	e2co_edgespage.edgeDetails();
    }
    
    @Then("^provisioned list of edges displayed$")
    public void provisionedEdgesListAbleToSee() throws Exception {
    	Thread.sleep(2000);
    	e2co_edgespage.provisionedEdgesList();
    	
    }
    
    @And("^user clicks on my application for enterprise$")
    public void clickOnMyApplicationForEnterprise() {
    	e2co_myapplication.clickOnMyApplfrEnter();
    }
    
    @When("^the details of application for enterprise(.*), (.*)")
    public void detailsUpdatingFrEnterprise(String SheetName, int RowNumber) throws IOException, Exception {
    	//String s = new SimpleDateFormat("MMddmmssSSS").format(new Date());
		//dynamicAppName = appName + s;
    	ExcelReader reader = new ExcelReader();
    	List<Map<String,String>> testData =
    			reader.getData(System.getProperty("user.dir")+ "\\input-data\\inputFiles\\InputData.xlsx", SheetName);
    	 appNameFromUser = testData.get(RowNumber).get("appName");
    	String Latency = testData.get(RowNumber).get("Latency");
    	String zone = testData.get(RowNumber).get("zone");
    	String componentId = testData.get(RowNumber).get("componentId");
    	String Network = testData.get(RowNumber).get("Network");
    	
    	e2co_myapplication.UpdateappName(appNameFromUser);
    	Thread.sleep(2000);
    	//e2co_myapplication.updateBandWidth(BandWidth);
    	e2co_myapplication.updateLatency(Latency);
    	Thread.sleep(2000);
    	e2co_myapplication.updateZone(zone);
    	Thread.sleep(2000);
    	e2co_myapplication.clickOnDeploymentEdit();
    	Thread.sleep(2000);
    	e2co_myapplication.updateComponentID(componentId);
    	Thread.sleep(2000);
    	e2co_myapplication.updateNetwork(Network);
    	Thread.sleep(2000);	
    }
    
    @Then("^user is can see the application in a list for enterprise$")
    public void applicationIsOnboardedOrNot() throws Exception {
    	e2co_myapplication.SizeOfApplicationTableFrEnterprise();
    	e2co_myapplication.verifyAppOnboardedIsDisplayedFrEnterprise(appNameFromUser);
    	Thread.sleep(15000);
    	e2co_myapplication.refresHPageOfWeb();
    	Thread.sleep(10000);
    	e2co_myapplication.statusOfApplicationFrEnterprise(appNameFromUser);
    }
    
    @Then("^user is able to see the application in running status for enterprise$")
    public void verifyApplicationStatusIsRunningFrEnterprise() throws Exception {
    	Thread.sleep(10000);
    	e2co_myapplication.refresHPageOfWeb();
    	Thread.sleep(8000);
    	e2co_myapplication.statusOfApplicationFrEnterprise(ApplicationNameFrProvision);
    }
    
    @Then("^user able to see the app is deprovisioned for enterprise$")
    public void verifyApplicationIsDeprovisionedFrEnterprise() throws Exception {
    	Thread.sleep(10000);
    	e2co_myapplication.refresHPageOfWeb();
    	Thread.sleep(8000);
    	e2co_myapplication.statusOfApplicationFrEnterprise(ApplicationNameFrDeProvision);
    	
    }
    
    @Then("^user is able to see the application is removed from the list for enterprise$")
    public void verifyAppIsDeboardedFrEnterprise() throws Exception {
    	e2co_myapplication.clickOncloseBtn();
    	Thread.sleep(2000);
    	e2co_myapplication.verifyDeboardedAppIsNotPresentInAppListFrEnterprise(ApplicationNmFrDeboard);
    	
    }
}
