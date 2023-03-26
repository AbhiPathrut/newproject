package com.sogeti.automation.test.pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XPath;
import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;

public class E2CO_EdgesPage extends PageClass {
	
SelfHealingDriver objDriver;
SelfHealingDriver driver;
String currentworkingDirectory;
	
	@FindBy(xpath = "//a[@href='/MEC/edges/edge-list']")
	private WebElement edges;
	
	@FindBy(xpath = "//button[contains(text(),'Add new edge')]")
	private WebElement addNewEdgeBtn;
	
	@FindBy(xpath = "//button[@class='e2co-import-btn d-flex align-items-center']")
	private WebElement importBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[normalize-space()='memory']")
	private WebElement SelectEdgeMenu;
	
	@FindBy(xpath="//button[@class='e2co-secondary-btn']")
	private WebElement PreProvisionButton;

	@FindBy(xpath="//input[@id='floatingEdgeID']")
	 private WebElement EdgeIdText;
	 
	 @FindBy (xpath="//select[@formcontrolname='zoneId']")
	 private WebElement ZoneIdSelect;
	 
	 @FindBy (xpath="//select[@formcontrolname='countryCode']")
	 private WebElement CountrySelect;
	 
	 @FindBy(xpath="//select[@formcontrolname='latencyConstraints']")
	 private WebElement LatencySelect;
	 
	 @FindBy (xpath="//input[@id='floatingEnterpriseID']")
	 private WebElement EnterpriseIdText;
	 
	 @FindBy (xpath= "//input[@id='floatingOperatorID']")
	 private WebElement OperatorIdText;
	 
	 @FindBy (xpath="//select[@formcontrolname='bandwidth']")
	 private WebElement BandwidthSelect;
	 
	 @FindBy (xpath="//textarea[@id='floatingTextarea2']")
	 private WebElement DescriptionText;
	 
	 @FindBy(xpath="//input[@id='floatingCity']")
	 private WebElement CityText;
	 
	 @FindBy(xpath="//input[@id='floatingState']")
	 private WebElement StateText;
	 
	 @FindBy(xpath="//input[@id='floatingLocality']")
	 private WebElement LocalityText;
	 
	 @FindBy(xpath="//select[@formcontrolname='radio']")
	 private WebElement RadioSelect;
	 
	 @FindBy (xpath="//input[@id='floatingMCC']")
	 private WebElement MCCText;
	 
	 @FindBy (xpath="//input[@id='floatingMNC']")
	 private WebElement MNCText;
	 
	 @FindBy(xpath="//input[@id='floatingCGI']")
	 private WebElement CGIText;
	 
	 @FindBy(xpath="//input[@id='floatingTAC']")
	 private WebElement TACText;
	 
	 @FindBy(xpath="//select[@formcontrolname='appAvailability']")
	 private WebElement Appavailabilty;
	 
	 @FindBy(xpath="//select[@formcontrolname='loadFilter']")
	 private WebElement SelectLoad;
	 
	 @FindBy(xpath="//input[@id='floatingKubernetesDetails']")
	 private WebElement ClusterName;
	 
	 @FindBy(xpath="//input[@id='floatingLatitude']")
	 private WebElement LatitudeText;
	 
	 @FindBy(xpath="//input[@id='floatingLongitude']")
	 private WebElement LongitudeText;
	 
	 @FindBy(xpath="//button[@type='submit']")
	 private WebElement SubmitButton;
	 
	 @FindBy(xpath = "//button[@class='accordion-button pre-provision-heading custom-accordion-highlight general-text-color']")
	 private WebElement minimizeBtn;
	 
	 @FindBy(xpath = "//button[contains(text(),'Close')]")
	 private WebElement CloseButton;		

		@FindBy(xpath = "//a[@href=\"/MEC/edges/edge-list\"]")
	    WebElement edgeicon;
		
		private String edgeslist="//table[@class='table edge-table mb-0']//tbody//tr";
		
		@FindBy(xpath = "//button[contains(text(),'Add New Edge')]")
	    WebElement addnewedgebttn;
		
		@FindBy(xpath = "//input[@type='file']")
	    WebElement fileupload;
		
		@FindBy(xpath = "//button[normalize-space()='Submit']")
	    WebElement submitedgesfile;
		
		@FindBy(xpath="//div[text()=' Edge ID is required ']")
		WebElement verierrormsg;
		
		
		 @FindBy(xpath="//span[normalize-space()='location_on']")
		 private WebElement ZoneMenuButton;
		 
		 @FindBy(xpath="//td[normalize-space()='SouthZone']")
		 private WebElement ClickOnZone;
		 
		 @FindBy(xpath="//td[normalize-space()='edge3']")
		 private WebElement ClickONEdge;
		 
//		 @FindBy(xpath="//button[normalize-space()='Manage Edge']")
//		 private WebElement ManageButton;
		 
		 @FindBy(xpath="//button[normalize-space()='Deboard']")
		 private WebElement DeboardButton;
		 
	//@FindBy(xpath = "//td[contains(text(),'edge02203006580')]")
	@FindBy(xpath = "//td[starts-with(text(),'edge03')]")
	private WebElement egdeDeboard;

	@FindBy(xpath = "//div[contains(text(),'Edge Details')]")
	private WebElement edgeDetailsTitle;
	
	@FindBy(xpath = "//button[@class='e2co-primary-btn']")
	private WebElement ManageButton;
	
	@FindBy(xpath = "//button[contains(text(),'Deboard')]")
	private WebElement deboardButton;
	
	@FindBy(xpath = "//div[contains(text(),'Deboarding This Edge!')]")
	private WebElement deboardWarningMesage;
	
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//button[contains(text(),'Deboarding')]")
	private WebElement deboardingTitle;
	
	@FindBy(xpath = "//div[contains(text(),'Manage Edge Details')]")
	private WebElement manageedgedetailstitle;
	
	@FindBy(xpath = "//div[contains(text(),'Zone Overview')]")
	private WebElement zoneOverviewTitle;
	
	@FindBy(xpath = "//div[@class='top-health-section d-flex align-items-start pt-1']")
	private WebElement edgeIdDeboarded;
	
	@FindBy(xpath = "//div[@class='edge-overiew-top-area bg-white']")
	private WebElement edgeDetailsCm;
	
	@FindBy(xpath = "//button[@class='out-of-service-btn border-0 ft-14 ft-wt-500']")
	private WebElement outOfServiceBtn;
	
	@FindBy(xpath = "//button[@class='in-service-btn border-0 ft-14 ft-wt-500 in-service-btn-deactive']")
	private WebElement inServiceBtn;
	
	@FindBy(xpath = "//div[@class='ft-20 ft-wt-500 general-text oos-state']")
	private WebElement outOfServiceWarMessg;
	
	@FindBy(xpath = "//div[@class='zone-badge bg-healthy ft-12 ft-wt-500 text-white text-center']")
	private WebElement healthy;
	
	@FindBy(xpath = "//div[@class='ft-20 ft-wt-500 general-text is-state']")
	private WebElement InServiceWarMessg;
	
	@FindBy(xpath = "//a[@href='/MEC/systemconfig']")
	private WebElement systemConfigMenu;
	
	@FindBy(xpath = "//div[contains(text(),'System Configuration')]")
	private WebElement systemconfigtitle;
	
	@FindBy(xpath = "//a[normalize-space()='Threshold Settings']")
	private WebElement thresholdSettig;
	
	@FindBy(xpath = "//div[@class='ft-16 ft-wt-400 lb mt-2']")
	private WebElement thresholdsettingtitle;
	
	@FindBy(xpath = "//div[@class='success-text onboard-success-text-spacing ft-18 ft-wt-500']")
	private WebElement updatedSuccessMessg;
	
	@FindBy(xpath = "//input[@formcontrolname='CPUWarning']")
	private WebElement CPUWarning;
	
	@FindBy(xpath = "//input[@formcontrolname='CPUCritical']")
	private WebElement CPUCritical;
	
	@FindBy(xpath = "//input[@formcontrolname='StorageWarning']")
	private WebElement StorageWarning;
	
	@FindBy(xpath = "//input[@formcontrolname='StorageCritical']")
	private WebElement StorageCritical;
	
	@FindBy(xpath = "//input[@formcontrolname='MemoryWarning']")
	private WebElement MemoryWarning;
	
	@FindBy(xpath = "//input[@formcontrolname='MemoryCritical']")
	private WebElement MemoryCritical;
	
	@FindBy(xpath = "//input[@formcontrolname='GPUWarning']")
	private WebElement GPUWarning;
	
	@FindBy(xpath = "//input[@formcontrolname='GPUCritical']")
	private WebElement GPUCritical;
	
	
	
	
	public E2CO_EdgesPage(SelfHealingDriver driver) {
		super(driver);
		this.objDriver = driver;
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
	}
	
	public void navigateToEdgesPage() {
		this.edges.click();
		log.info("Clicked on edges");
		}
	
	public void clickOnAddNewEdge() {
		this.addNewEdgeBtn.click();
		log.info("Clicked on Add New Edge");
	
	}
	
	public void ImportYamlFile() {
		this.importBtn.sendKeys("C:\\Users\\APathrut\\Downloads\\edgeonboard.yaml");
		log.info("Importing of yaml file is done");
	}
	
	public void edgesList() {
		List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class='table edge-table mb-0']//tbody//tr//th"));
		 for (WebElement element : allUserNameElements) {
		String linkText = element.getText();
		System.out.println(linkText);
	}

	}
	public void submitDetailsOfEdge() {
		this.submitBtn.click();
		log.info("Clicked on submit button");
	}
	
	public void EdgeMenu() {
		 this.SelectEdgeMenu.click();
		 log.info("Click on Edge menu");
		
	 }
	 
//	 public void PreprovisionOption() {
//		 this.PreProvisionButton.click();
//		 log.info("Click on preprovision option");
//	 }
	 
	 public void EdgeIdTextIsVisible() {
		 Assert.assertTrue(EdgeIdText.isDisplayed());
	 }
	 
	 
	 public void EdgeIdText(String EdgeId) {
		 this.EdgeIdText.click();
		 this.EdgeIdText.sendKeys(EdgeId);
		 log.info("Enter EdgeId");
	 }
	 
	 public void ZoneIdSelect(String Option) {
		 Select select = new Select(ZoneIdSelect);
	        select.selectByVisibleText(Option);
	        log.info("Zone Id selected");
	 }
	 
	 public void CountrySelect(String Option) {
		 Select select = new Select(CountrySelect);
	        select.selectByVisibleText(Option);
	        log.info("Country is selected");
		 
	 }
	 
	 public void LatencySelect(String Option) {
		 Select select = new Select(LatencySelect);
	        select.selectByVisibleText(Option);
	        log.info("Latency is selected");
		  }
	 
	 public void EnterpriseIdText(String EnterpriseId) {
		 this.EnterpriseIdText.click();
		 this.EnterpriseIdText.sendKeys(EnterpriseId);
	        log.info("Enter EnterPrise Id");
	 }

	 public void BandwidthSelect(String Option) {
		 Select select = new Select(BandwidthSelect);
		 select.selectByVisibleText(Option);
		 log.info("Bandwidth is selected");
	 }
	 public void DescriptionText(String Description) {
		 this.DescriptionText.click();
		 this.DescriptionText.sendKeys(Description);
		 log.info("Enter Edge description");
	 }
	 public void CityText(String City) {
		 this.CityText.click();
		 this.CityText.sendKeys(City);
		 log.info("Enter city name");
	 }
	 public void StateText(String State) {
		 this.StateText.click();
		 this.StateText.sendKeys(State);
		 log.info("Enter city name");
	 }
	 public void LocalityText(String Locality) {
		 this.LocalityText.click();
		 this.LocalityText.sendKeys(Locality);
		 log.info("Enter the locality name");
	 }
	 public void RadioSelect(String Option) {
		 Select select = new Select(RadioSelect);
		 select.selectByVisibleText(Option);
		 log.info("Radio is selected");
	 }
	 public void MCCText(String MCCValue) {
		 this.MCCText.sendKeys(MCCValue);
		 log.info("Enter MCC value");
	 }
	 public void MNCText(String MNCValue) {
		 this.MNCText.sendKeys(MNCValue);
		 log.info("Enter MNC value");
	 }
	 public void CGIText(String CGIValue) {
		 this.CGIText.sendKeys(CGIValue);
		 log.info("Enter CGI value");
	 }
	 public void TACText(String TACValue) {
		 this.TACText.sendKeys(TACValue);
		 log.info("Enter TAC value");
	 }
	 public void Appavailabilty(String Option) {
		 Select select = new Select(Appavailabilty);
		 select.selectByVisibleText(Option);
		 log.info("App availability is selected"); 
	 }
	 public void SelectLoad(String Option) {
		 Select select = new Select(SelectLoad);
		 select.selectByVisibleText(Option);
		 log.info("Load is selected");
	 }
	 public void ClusterName(String cluster) {
		 this.ClusterName.sendKeys(cluster);
		 log.info("Enter cluster name");
	 }
	 public void LatitudeText(String Latitude) {
		 this.LatitudeText.sendKeys(Latitude);
		 log.info("Enter Latitude value");
	 }
	 public void LongitudeText(String Longitude) {
		 this.LongitudeText.sendKeys(Longitude);
		 log.info("Enter Longitude value");
	 }
	 public void scrollDownPage() {
		 JavascriptExecutor js = (JavascriptExecutor)objDriver;
		  js.executeScript("window.scrollBy(0, 400)");
		 
	 }
	 public void SubmitButton() throws Exception {
		 JavascriptExecutor js = (JavascriptExecutor)objDriver;
		  js.executeScript("arguments[0].scrollIntoView()",SubmitButton);
		  js.executeScript("arguments[0].click()", SubmitButton);
		 log.info("Click on submit button");
		 this.CloseButton.click();
		 Thread.sleep(2000);
	 }
	 
	 public void clickOnSubmitBtn() {
		 this.SubmitButton.click();
		 log.info("Clicked on submit button.");
	 }
	 
	 public void clickOnCloseButton() {
		 this.CloseButton.click();
		 log.info("Clicked on close button.");
	 }
	 
	 public boolean verifyEdgeIsPreProvisioned(String EdgeId) {
		 boolean validationFlag = false;
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class='table edge-table mb-0']//tbody//tr//td[1]"));
			 for (WebElement element : allUserNameElements) {
			String linkText = element.getText();
			System.out.println(linkText);
			if(EdgeId.equals(linkText)) {
				System.out.println("The edgeid is: "+ EdgeId);
				log.info("EdgeId is displayed");
				validationFlag = true;
			}
		}
			 return validationFlag;
	 } 
	 
	 public void provisionedEdgesList() {
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class='table edge-table mb-0']"));
		 for (WebElement element : allUserNameElements) {
		String EdgeList = element.getText();
		System.out.println("Provisioned Edges: " + EdgeList);
		 }
	 }
	 
	 public void clikEdgeIcon() {
	       this.edgeicon.click();
	       
	   }
	   
	   public  void veriEdgelist() {
			  
		   List<WebElement> displayedgeslist= driver.findElements(By.xpath(edgeslist));
		   for(WebElement element:displayedgeslist) {
			   String edgesname=element.getText();
			   System.out.println(edgesname);
			   
		   }
	   }
		   
	   public void clikAddNewEdgebttn() {
	       this.addnewedgebttn.click();
	       
	   }
	   public void clikImportbttn() throws Exception  {
		   this.submitedgesfile.click();
		   Thread.sleep(2000);
//		   boolean isEnabled= submitedgesfile.isEnabled();
//		     String actual_errormsg= verierrormsg.getAttribute("innerHTML");
//	     	 System.out.println(actual_errormsg);
//	         String expected_errormsg="Edge ID is required";
//	         Assert.assertEquals(actual_errormsg,expected_errormsg );
//		   driver.navigate().refresh();
		   Thread.sleep(2000);
		   System.out.println("refreah");
		   
		   //driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\APathrut\\OneDrive - Capgemini\\Desktop\\edge_onboard.yaml");
		   currentworkingDirectory = System.getProperty("user.dir");
		String	inputFile= currentworkingDirectory + "/input-data/inputFiles/edge_onboard.yaml";
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(inputFile);
	   }
	   
	 //public void submitEdgesdetails() {
		  //ubmitedgesfile.click();
//		   try {
//			   assertEquals("Value is required and can't be empty", driver.findElement(By.xpath("")).getText());
//			 } catch (Error e) {
//			  //code for the case when the texts are not same
//			   verificationErrors.append(e.toString());
//			 }
		   
//		   StringBuffer verificationErrors = new StringBuffer();
//
//		   try {
//		         assertTrue(driver.findElement(By.xpath("//div[text()=' Edge ID is required ']")).getText().matches("^[\\s\\S]*required[\\s\\S]*$"));
//		         //assertTrue(driver.findElement(By.xpath("//div[text()=' Edge ID is required ']")).getText().matches(currentworkingDirectory);
//		   } catch (Error e) {
//		         verificationErrors.append(e.toString());
//		       }
//		     }
	    	  public void submitedgedetails() {
	    		  submitedgesfile.click();
	   	       
	   	   }
	    	  
	    	 
	    		 
	    		 public void ZoneMenuButton()  {
	    			 this.ZoneMenuButton.click();
	    			 log.info("Click on zone menu");
	    			 
	    			
	    		 }
//	    		 
	    		 
	    	///*******************************************/////	 
	    		 public void ClickOnZone() {
//	    	      this.ClickOnZone.click();
//	    		   log.info("Click on selected zone");
	    			 
	    			 JavascriptExecutor js = (JavascriptExecutor)objDriver;
	    			 js.executeScript("scrollBy(0, 1000+document.body.scrollHeight)");
	    			 this.ClickOnZone.click();
	    			 log.info("Click on selected zone");
	    		 //js.executeScript("arguments[0].scrollIntoView()",ClickOnZone );
//	    			 js.executeScript("arguments[0].click()",ClickOnZone );
	    			 
	    		 }
	    		 
	    		 public void EdgeIsVisible() {
	    			 Assert.assertTrue(ClickONEdge.isDisplayed());
	    		 }
	    		 
//	    		 public void ClickONEdge() throws InterruptedException  {
//	    			 JavascriptExecutor js = (JavascriptExecutor)objDriver;
//	    			 js.executeScript("scrollBy(0,document.body.scrollHeight)");
//	    			 Thread.sleep(3000);
//	    			this.ClickONEdge.click();
//	    			log.info("Click on Edge");
//	    			
//	    		 }
	    		 public void ClickONEdge() {
	    			 JavascriptExecutor js = (JavascriptExecutor)objDriver;
	    			 js.executeScript("arguments[0].scrollIntoView()",ClickONEdge);
	    			 js.executeScript("arguments[0].click()", ClickONEdge);
	    			 log.info("Click on Edge");
	    			 
	    		 }
	    		 
	    		 public void ManageButtonIsVisible() {
	    			 Assert.assertTrue(ManageButton.isDisplayed());
	    			 
	    		 }
	    		 
	    		 
//	    		 public void CkickOnManageButton() {
//	    			 JavascriptExecutor js = (JavascriptExecutor)objDriver;
//	    			 js.executeScript("scrollBy(0,document.body.scrollHeight");
//	    			 this.ManageButton.click();
//	    			 log.info("Click on Manage option");
//	    		 }
	    		 
	    		 public void clickOnManageEdgeBtn() {
	    			 JavascriptExecutor js = (JavascriptExecutor)objDriver;
	    			 js.executeScript("arguments[0].scrollIntoView()",ManageButton);
	    			 js.executeScript("arguments[0].click()", ManageButton);
	    			 log.info("Click on Manage button");
	    		 }
	    		 
	    		 public void ClickOnDeboardButton() throws Exception {
	    			 this.DeboardButton.click();
	    			 Thread.sleep(2000);
	    			 Alert Confirmationalert = objDriver.switchTo().alert();
	    			 String alertText = Confirmationalert.getText();
	    			 Confirmationalert.accept();
	    			 log.info("Click on deboard button");
	    		 }
	    		 
	    		 public void clickOnEdgeIdIsToDeboard() {
	    			 //this.egdeDeboard.click();
	    			 log.info("Clicked on edgeid");
	    		 }
	    	////////////////////////////////////////////////////////////////////
	    		 public void clickOnEdgeIsDeboard(String EdgeId) throws Exception {
	    			 WebElement EdgeDeboard = objDriver.findElement(By.xpath("//td[contains(text(),"+EdgeId+")]"));
	    			 EdgeDeboard.click();
	    			 log.info("Clicked on edge.");
	    		 }
	    		 
	    		 public void edgeIdDeboarded() {
	    			 String EdgeId = this.edgeIdDeboarded.getText();
	    			 System.out.println(EdgeId);
	    		 }
	    		 
	    		 public void edgeDetails() throws Exception {
	    			 String EdgeDetails = this.edgeDetailsCm.getText();
	    			 Thread.sleep(2000);
	    			 System.out.println(EdgeDetails);
	    		 }
	    		 
	    		 public boolean verifyEdgeDetailsPageIsDispalyed() {
	    			 this.edgeDetailsTitle.isDisplayed();
	    			 log.info("Edge details page is displayed");
	    			 return true;
	    		 }
	    		 
	    		 public void clickOnManageButton() throws Exception {
	    			 //this.ManageButton.click();
//	    			 log.info("Clicked on manage button");
	    			 JavascriptExecutor js = (JavascriptExecutor)objDriver;
	    			 js.executeScript("arguments[0].scrollIntoView()",ManageButton);
	    			 Thread.sleep(2000);
	    			 js.executeScript("arguments[0].click()", ManageButton);
	    			 log.info("Click on Manage button");
	    		 }
	    		 
	    		 public boolean verifyManageEdgeDetailsPageIsDisplayed() {
	    			 this.manageedgedetailstitle.isDisplayed();
	    			 log.info("Manage Edge page is displayed");
	    			 return true;
	    		 }
	    		 
	    		 public void clickOnDeboardButton() {
	    			 this.deboardButton.click();
	    			 log.info("Clicked on deboard button");
	    		 }
	    		 
	    		 public boolean verifyDeboardingWarningPageIsDisplayed() {
	    			 this.deboardWarningMesage.isDisplayed();
	    			 log.info("Deboard edge warning popup message page is displayed");
	    			 return true;
	    		 }
	    		 
	    		 public void clickOnConfirmButton() {
	    			 this.confirmButton.click();
	    			 log.info("Clicked on confirm button");
	    		 }
	    		 
	    		 public boolean verifyZonesPageIsDisplayedAfterDeboard() {
	    			 this.zoneOverviewTitle.isDisplayed();
	    			 log.info("Zone page is displayed");
	    			 return true;
	    		 }
	    		 
	    		 public void clickOnOOSBtn() {
	    			 this.outOfServiceBtn.click();
	    			 log.info("Clicked on out of service button.");
	    		 }
	    		 
	    		 public void clickOnISBtn() {
	    			 this.inServiceBtn.click();
	    			 log.info("Clicked on in service button.");
	    		 }
	    		 
	    		 public void clickOnEdgeIDTOOS(String EdgeId) throws Exception {
	    			 WebElement EdgeOOS = objDriver.findElement(By.xpath("//td[contains(text(),"+EdgeId+")]"));
	    			 EdgeOOS.click();
	    			 log.info("Clicked on edge.");
	    		 }
	    		 
	    		 public boolean verifyOOSWarningMessageIsDispalyed() {
	    			 this.outOfServiceWarMessg.isDisplayed();
	    			 log.info("Out of service warning message displayed.");
	    			 return true;
	    		 }
	   
	    		 public boolean verifyHealthyStatusIsVisible() {
	    			 this.healthy.isDisplayed();
	    			 log.info("Healthy status is displayed.");
	    			 return true;
	    		 }
	    		 
	    		 public boolean verifyISWarningMessageIsDispalyed() {
	    			 this.InServiceWarMessg.isDisplayed();
	    			 log.info("In service warning message displayed.");
	    			 return true;
	    		 }
	    		 
	    		 public void clickOnEdgeIDIS(String EdgeId) throws Exception {
	    			 WebElement EdgeIS = objDriver.findElement(By.xpath("//td[contains(text(),"+EdgeId+")]"));
	    			 EdgeIS.click();
	    			 log.info("Clicked on edge.");
	    		 }
	    		 
	    		 public void verifyEdgeStatus() {
	    			 //boolean validationFlag = false;
	    			 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class='table edge-table mb-0']//tbody//tr//td[4]"));
	    				 for (WebElement element : allUserNameElements) {
	    				String linkText = element.getText();
	    				System.out.println(linkText);
	    				if(linkText.equals("onboarded")) {
	    					//System.out.println("The edge status is : "+linkText );
	    					log.info("Edge is in onboarded state.");
	    					//validationFlag = true;
	    				}else if(linkText.equals("faulty")){
	    					//System.out.println("The edge status is : "+linkText );
	    					log.info("Edge is in Faulty state.");
	    				}else {
	    					log.info("Edge is in degraded state.");
	    				}
	    			}
	    				 //return validationFlag;
	    		 } 
	    		 
	    		 public void clickOnSystemConfigMenu() {
	    			 this.systemConfigMenu.click();
	    			 log.info("Clicked on system config menu.");
	    		 }
	    		 
	    		 public boolean verifySystemConfigPageIsDisplayed() {
	    			 this.systemconfigtitle.isDisplayed();
	    			 log.info("System config page is opened.");
	    			 return true;
	    		 }
	    		 
	    		 public void clickOnThresholdSettings() {
	    			 this.thresholdSettig.click();
	    			 log.info("Clicked threshold menu.");
	    		 }
	    		 
	    		 public boolean verifyThresholdPageIsDisplayed() {
	    			 this.thresholdsettingtitle.isDisplayed();
	    			 log.info("Threshold setting page is displayed.");
	    			 return true;
	    		 }
	    		 
	    		 public boolean verifySuccessPopupMessagDisplayed() {
	    			 this.updatedSuccessMessg.isDisplayed();
	    			 log.info("Updated successfully popup message is dispalyed.");
	    			 return true;
	    		 }
	    		 
	    		 public void enterCPUWarning(String CPUWar) {
	    			 this.CPUWarning.clear();
	    			 this.CPUWarning.sendKeys(CPUWar);
	    			 log.info("Changed CPUwarning value");
	    		 }
	    		 
	    		 public void enterCPUCritical(String CPUCrit) {
	    			 this.CPUCritical.clear();
	    			 this.CPUCritical.sendKeys(CPUCrit);
	    			 log.info("Changed CPUCritical value");
	    		 }
	    		 
	    		 public void enterStorageWarning(String StorageWar) {
	    			 this.StorageWarning.clear();
	    			 this.StorageWarning.sendKeys(StorageWar);
	    			 log.info("Changed StorageWarning value");
	    		 }
	    		 
	    		 public void enterStorageCritical(String StorageCrit) {
	    			 this.StorageCritical.clear();
	    			 this.StorageCritical.sendKeys(StorageCrit);
	    			 log.info("Changed StorageCritical value");
	    		 }
	    		 
	    		 public void enterMemoryWarning(String MemoryWar) {
	    			 this.MemoryWarning.clear();
	    			 this.MemoryWarning.sendKeys(MemoryWar);
	    			 log.info("Changed MemoryWarning value");
	    		 }
	    		 
	    		 public void enterMemoryCritical(String MemoryCrit) {
	    			 this.MemoryCritical.clear();
	    			 this.MemoryCritical.sendKeys(MemoryCrit);
	    			 log.info("Changed MemoryCritical value");
	    		 }
	    		 
	    		 public void enterGPUWarning(String GPUWar) {
	    			 this.GPUWarning.clear();
	    			 this.GPUWarning.sendKeys(GPUWar);
	    			 log.info("Changed GPUWarning value");
	    		 }
	    		 
	    		 public void enterGPUCritical(String GPUCrit) {
	    			 this.GPUCritical.clear();
	    			 this.GPUCritical.sendKeys(GPUCrit);
	    			 log.info("Changed GPUCritical value");
	    		 }
	    		 
	    		 public void refresHPageOfWeb() {
	    				objDriver.navigate().refresh();
	    				log.info("Page is refreshed");
	    			}
	    		 

}
	 

	
