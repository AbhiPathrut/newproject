package stepdefinitions;



import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.framework.constants.AppConstants.Web;
import com.sogeti.automation.test.pageFactory.E2CO_EdgesPage;
import com.sogeti.automation.test.pageFactory.E2CO_LoginPage;
import com.sogeti.automation.test.pageFactory.E2CO_MyApplicationPage;
import com.sogeti.automation.test.pageFactory.E2CO_SDKPage;
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
    E2CO_MyApplicationPage e2co_myapplication;
    E2CO_SDKPage e2co_sdkpage;
    String dynamicUserName;
    int previousNumRow;
    int afterNumRow;
    String dynamicEdgeId;
    String dynamicCluster;
    String dynamicArtifactName;
    String dynamicAppName;
    String dynamicSDKVersion;
    String dynamicSDKName;
    int beforedeleterownum;
    int afterdeleterownum;
   

    public E2COTestSteps(TestContext context) throws Exception {
        super();
        this.testContext = context;
        e2co_loginpage = testContext.getPageObjectManager().getE2CO_LoginPage();
        e2co_usermanagement = testContext.getPageObjectManager().getE2CO_UserManagement();
        e2co_edgespage = testContext.getPageObjectManager().geE2co_EdgesPage();
        e2co_zonespage= testContext.getPageObjectManager().gete2co_zonespage();
        e2co_myapplication = testContext.getPageObjectManager().gete2co_myapplication();
        e2co_sdkpage = testContext.getPageObjectManager().gete2co_sdkpage();
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
		Assert.assertTrue(e2co_zonespage.isZonetitlePageDisplayed(),"Zone page is loaded.");
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
	
	@And ("^user enter the details of new zone (.*), (.*), (.*), (.*), (.*)")
	public void entermandotarydetails(String zonename,String countryname,String latitude,String longitude,String description) {
		e2co_zonespage.enterZoneName(zonename);
		e2co_zonespage.enterCountry(countryname);
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
	
	@When("^user selects where to onboard application (.*)")
	public void selectOnboarding(String service) {
		if(service.equals("container")) {
		e2co_myapplication.selectContainer();
		log.info("Container as service selected");
		}else if (service.equals("VM")){
			e2co_myapplication.selectVM();
			log.info("Vm as service selected");
			}else {
				e2co_myapplication.selectKuberenetes();
				log.info("Kuberenetes as a service selected");
			}
	}
	
	@Then("^user is able to see that service (.*)")
	public void verifySelectedMenuIsVisible(String service ) {
		if(service.equals("container")) {
		Assert.assertTrue(e2co_myapplication.containerIsSelected(),"Container is selected");
		}else if (service.equals("VM")){
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
	
	@When("^user enters the details to create artifact (.*), (.*), (.*), (.*)")
	public void enterTheDetailsOfArtifact(String service, String ArtifactName, String ComponentID, String ComponentImageName) throws Exception {
		if(service.equals("container")) {
		String s = new SimpleDateFormat("MMddmmssSSS").format(new Date());
		dynamicArtifactName = ArtifactName + s;
		System.out.println(dynamicArtifactName);
		e2co_myapplication.enterArtifactName(dynamicArtifactName);
		e2co_myapplication.enterComponenetID(ComponentID);
		e2co_myapplication.enterComponenetImageName(ComponentImageName);
		e2co_myapplication.browseZipFileContainer();
		Thread.sleep(2000);
		
		}else if(service.equals("VM")) {
			String s = new SimpleDateFormat("MMddmmssSSS").format(new Date());
			dynamicArtifactName = ArtifactName + s;
			System.out.println(dynamicArtifactName);
			e2co_myapplication.enterArtifactName(dynamicArtifactName);
			e2co_myapplication.enterVMID(ComponentID);
			e2co_myapplication.enterVMImageName(ComponentImageName);
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
		e2co_myapplication.verifyArtifactCreatedIsDisplayed(dynamicArtifactName);
		Thread.sleep(2000);;
		
	}
	
	 @When("^user selects from where to artifact is to delete (.*)")
	    public void selectService(String service) {
		 if(service.equals("container")) {
			e2co_myapplication.selectContainer();
			log.info("Container as service selected");
		 }else if (service.equals("VM")){
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
	    
	    @When("^update the details of application (.*), (.*), (.*), (.*), (.*)")
	    public void detailsUpdating(String appName, String Latency, String zone, String ComponentID, String Network) throws Exception {
	    	String s = new SimpleDateFormat("MMddmmssSSS").format(new Date());
			dynamicAppName = appName + s;
	    	e2co_myapplication.updateAppName(dynamicAppName);
	    	Thread.sleep(2000);
	    	//e2co_myapplication.updateBandWidth(BandWidth);
	    	e2co_myapplication.updateLatency(Latency);
	    	Thread.sleep(2000);
	    	e2co_myapplication.updateZone(zone);
	    	Thread.sleep(2000);
	    	e2co_myapplication.clickOnDeploymentEdit();
	    	Thread.sleep(2000);
	    	e2co_myapplication.updateComponentID(ComponentID);
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
	    	Thread.sleep(2000);
	    	e2co_myapplication.SizeOfApplicationTable();
	    	Thread.sleep(2000);
	    	e2co_myapplication.verifyApplicationOnoardedIsDisplayed(dynamicAppName);
	    	
	    	
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
	
    @When("^click on the edge which is to deboard$")
    public void selectEdgeIsToDeboard() {
    	e2co_edgespage.clickOnEdgeIsDeboard();
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
    
    
    @And ("^Enter all mandetory details(.*),(.*)")
    public void EnterAllDetails(String Version, String description) {
    	
    	e2co_sdkpage.SelectOneLanguage();
    	String s = new SimpleDateFormat("dssSS").format(new Date());
    	dynamicSDKVersion = Version + s;
    	e2co_sdkpage.EnterSDKVersion(dynamicSDKVersion);
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
    	dynamicSDKName = "ec_client-sdk_Android_"+dynamicSDKVersion+".zip";
    	System.out.println(dynamicSDKName);
    	e2co_sdkpage.clickOnCloseButton();
    	e2co_sdkpage.SizeOfsdkTable();
    	
    }
    
    @And ("^click on uploaded Sdk$")
    public void ClickOnUploadedSDK() {
    	 beforedeleterownum = e2co_sdkpage.SizeOfsdkTable();
    	e2co_sdkpage.SelectUploadedSDK();
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
    
    @When("^user clicks on application$")
    public void selectApplicationIsToProvision() throws Exception {
    	e2co_myapplication.selectApplicationForPrvision();
    }
    
    @Then("^user is able to see the application details$")
    public void verifyUserIsAbleToSeeApplicationDetails() {
    	Assert.assertTrue(e2co_myapplication.userIsOnProvisionPage(),"User is on application provision page");
    }
    
    @When("^user selects the zone for application provision (.*)")
    public void selectZoneForProvisionOfApplication(String zone) {
    	e2co_myapplication.selectZoneForApplicationProvision(zone);
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
    public void verifyApplicationIsInRunningStatus() {
    	
    }
}
