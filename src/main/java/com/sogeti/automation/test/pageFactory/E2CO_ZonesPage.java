package com.sogeti.automation.test.pageFactory;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import com.sogeti.automation.framework.constants.AppConstants.Web;

public class E2CO_ZonesPage extends PageClass {
	SelfHealingDriver driver;
	
	@FindBy(xpath = "//a[@href='/MEC/zones/zone-list']")
    WebElement zonesicon;
	
	private String zonelist="//table[@class='table zone-list-table mb-0 custom-table-fixed-layout table-borderless']//tbody//tr";
	
	@FindBy(xpath = "//div[@class='e2co-header']")
    WebElement zonepagetitle;
	
	@FindBy(xpath = "//table//tbody//tr//td[text()='SouthZone']")
    WebElement southzone;
	
	@FindBy(xpath = "//*[text() = 'NorthZone']")
    WebElement northzone;

	@FindBy(xpath = "//button[text()=' Create New Zone ']")
    WebElement createnewzone;
	
	@FindBy(xpath = "//div[@class='create-new-zone-container']")
    WebElement displayopoupnewzone;
	
	@FindBy(xpath = "//input[@id='Zone_ID']")
    WebElement zoneID;
	
	@FindBy(xpath = "//select[@id='operator']")
    WebElement selectoperatorID;
	
	
	@FindBy(xpath = "//input[@id='Country']")
    WebElement Country;
	
	@FindBy(xpath = "//input[@id='latitude']")
    WebElement latitude;
	
	@FindBy(xpath = "//input[@id='Longitude']")
    WebElement Longitude;
	
	@FindBy(xpath = "//textarea[@id='Description']")
    WebElement Description;

	@FindBy(xpath = "//button[@class='e2co-submit-btn ml-15']")
    WebElement submitbttn;
	
	@FindBy(xpath = "//span[text()=' cancel ']")
    WebElement closeIcon;
	
	@FindBy(xpath = "//span[text()=' Enter valid Latitude ']")
    WebElement errormessage;
	
	@FindBy(xpath = "//span[text()=' arrow_back ']")
    WebElement backbttn;
		
	@FindBy(xpath = "//span[@class='material-symbols-outlined']")
    WebElement dropdown;

	@FindBy(xpath = "//label[@class='ft-22 ft-wt-400']")
	private WebElement createNewZoneTitle;
	
	@FindBy(xpath = "//div[@class='e2co-header']")
	private WebElement zonesPage;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
    private WebElement closeButton;
	
	@FindBy(xpath = "//div[@class='success-text onboard-success-text-spacing ft-18 ft-wt-500']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//input[@id='isEnterprise']")
	private WebElement enterpriseDedicated;
	
	@FindBy(xpath = "//select[@id='bandwidth']")
	private WebElement bandwidth;
	
	@FindBy(xpath = "//select[@id='latency constraint']")
	private WebElement latencyConstraint;
	
	@FindBy(xpath = "//select[@id='radio']")
	private WebElement radio;
	
	@FindBy(xpath = "//input[@formcontrolname='MCC']")
	private WebElement MCC;
	
	@FindBy(xpath = "//input[@formcontrolname='MNC']")
	private WebElement MNC;
	
	@FindBy(xpath = "//input[@formcontrolname='CGI']")
	private WebElement CGI;
	
	@FindBy(xpath = "//input[@formcontrolname='TAC']")
	private WebElement TAC;
	
	@FindBy(xpath = "//input[@formcontrolname='parameter']")
	private WebElement Name;
	
	@FindBy(xpath = "//select[@formcontrolname='value']")
	private WebElement value;
	
	@FindBy(xpath = "//input[@id='isEdgeCharacteristics']")
	private WebElement kubService;
	
	
	
	
	
	
	public E2CO_ZonesPage(SelfHealingDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
	}

	public void clikZoneIcon() {
	       this.zonesicon.click();
	       System.out.println("zones click");
	       
	       
	   }
	   public boolean isZonetitlePageDisplayed() {
	   	 this.zonepagetitle.isDisplayed();
	   	 log.info("user is on zone page");
	   	 return true;
	   	}

	   public E2CO_LoginPage verifyUserIsOnHomePage() {
			Assert.assertTrue(zonepagetitle.isDisplayed());
			return null;	
		}
	  
	   public  void displayZonelist() {
		  
		   List<WebElement> allzoneslist= driver.findElements(By.xpath(zonelist));
		   for(WebElement element:allzoneslist) {
			   String zonesname=element.getText();   
		   }
	   }
	   
	   public void clickOnZoneName() throws Exception {
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   
		   js.executeScript("arguments[0].scrollIntoView()",southzone );
		   js.executeScript("arguments[0].click()",southzone );
		   backbttn.click();
	   }
	   
	   
	

	   public void creatNewZone() {
	       this.createnewzone.click();
	       log.info("Clicked on create new zone.");
	    }
	   
	  
	   public void  enterZoneName(String Zonename) {
		   //this.zoneID.click();
	       zoneID.sendKeys(Zonename);
	       log.info("Entered zone name");
	     
	   }
	   
	   public void selectOperatorName() {
	       selectoperatorID.click();
	       log.info("Entered operatorname name");
	     
	   }
	   
	   public void  enterCountry(String CountryNmae) {
	      Country.sendKeys(CountryNmae);
	       log.info("Entered zone name");
	     
	   }
	   
	   public void  enterLatitude(String latitude) {
	       this.latitude.sendKeys(latitude);
	       log.info("Entered zone name");
	     
	   }
	   
	   public void  enterLongitude(String longtatitude) {
	       this.Longitude.sendKeys(longtatitude);
	       log.info("Entered zone name");
	     
	   }
	   
	   public void  enterDescription(String description) {
	       this.Description.sendKeys(description);
	       log.info("Entered zone name");
	     
	   }
	   
	   public void closeIcon () {
			 closeIcon.click();		   
		   }
	   
	   public void  clickOnDropDowndots() {
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   js.executeScript("arguments[0].scrollIntoView()",dropdown );
		   js.executeScript("arguments[0].click()",dropdown );
	     // this.dropdown.click();
	   }  
	
	   public boolean verifyUserIsOnZonesPage() {
		   this.zonesPage.isDisplayed();
		   log.info("Zones page is displayed.");
		   return true;
	   }
	   
	   public boolean verifyCreateNewZonePopupPageIsDisplayed() {
		   this.createNewZoneTitle.isDisplayed();
		   log.info("Create new zone page is displayed.");
		   return true;
	   }
	   
	   public void clickOnSubmitBtn() {
		   submitbttn.click();
		   log.info("Clicked on submit button.");
	   }
	   
	   public void clickOnCloseBtn() {
		   this.closeButton.click();
		   log.info("Clicked on close button.");
	   }
	   
	   public void successPopupMessage(String zoneName) {
		   String SucessMessage = this.successMessage.getText();
		   System.out.println(SucessMessage);
		   if(SucessMessage.equals(zoneName+" created successfully !!")) {
			   log.info("New zone created successfully.");
		   }else {
			   log.info("New zone not created.");
		   }
	   }
	   
	   public void selectZoneFrEnterpriseDedicated() {
		   this.enterpriseDedicated.click();
		   log.info("Selected for enterpeise dedicated zone.");
	   }
	   
	   public void selectBandwidth(String Bandwidth) {
	        Select select = new Select(bandwidth);
	        select.selectByVisibleText(Bandwidth);
	        log.info("Bandwidth selected");
	    }
	   
	   public void selectLatencyConstraint(String Latency) {
	        Select select = new Select(latencyConstraint);
	        select.selectByVisibleText(Latency);
	        log.info("Latency constraint selected");
	    }
	   
	   public void selectRadio(String Radio) {
	        Select select = new Select(radio);
	        select.selectByVisibleText(Radio);
	        log.info("Radio selected");
	    }
	   
	   public void enterMCC(String mcc) {
		   MCC.sendKeys(mcc);
		   log.info("Entered MCC");
	   }
	   
	   public void enterMNC(String mnc) {
		   MNC.sendKeys(mnc);
		   log.info("Entered MNC");
	   }
	   
	   public void enterCGI(String cgi) {
		   CGI.sendKeys(cgi);
		   log.info("Entered CGI");
	   }
	   
	   public void enterTAC(String tac) {
		   TAC.sendKeys(tac);
		   log.info("Entered TAC");
	   }
	   
	   public void enterName(String name) {
		   Name.sendKeys(name);
		   log.info("Entered Name");
	   }
	   
	   public void selectValue(String Value) {
	        Select select = new Select(value);
	        select.selectByVisibleText(Value);
	        log.info("Value selected");
	    }
	   
	   public void selectKubernetesService() {
		   this.kubService.click();
		   log.info("Selected Edge Characteristics for Kubernetes Service");
	   }

}
