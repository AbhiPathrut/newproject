package com.sogeti.automation.test.pageFactory;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;

public class E2CO_ZonesPage extends PageClass {
	SelfHealingDriver driver;
	
	@FindBy(xpath = "//a[@href='/MEC/zones/zone-list']")
    WebElement zonesicon;
	
	private String zonelist="//table[@class='table zone-list-table mb-0 custom-table-fixed-layout table-borderless']//tbody//tr";
	
	@FindBy(xpath = "//a[@href='/MEC/zones/zone-list']")
    WebElement zonepagetitle;
	
	@FindBy(xpath = "//table//tbody//tr//td[text()='SouthZone']")
    WebElement southzone;
	
	@FindBy(xpath = "//*[text() = 'NorthZone']")
    WebElement northzone;

	@FindBy(xpath = "//button[text()=' Create New Zone ']")
    WebElement createnewzone;
	
	@FindBy(xpath = "//div[@class='create-new-zone-container']")
    WebElement displayopoupnewzone;
	
	@FindBy(xpath = "//input[@id='Zone ID']")
    WebElement zoneID;
	
	@FindBy(xpath = "//select[@id='floatingSelect']")
    WebElement selectoperatorID;
	
	
	@FindBy(xpath = "//input[@id='Country']")
    WebElement Country;
	
	@FindBy(xpath = "//input[@id='latitude']")
    WebElement latitude;
	
	@FindBy(xpath = "//input[@id='Longitude']")
    WebElement Longitude;
	
	@FindBy(xpath = "//*[@id='Description']")
    WebElement Description;

	@FindBy(xpath = "//button[text()=' Submit ']")
    WebElement submitbttn;
	
	@FindBy(xpath = "//span[text()=' cancel ']")
    WebElement closeIcon;
	
	@FindBy(xpath = "//span[text()=' Enter valid Latitude ']")
    WebElement errormessage;
	
	@FindBy(xpath = "//span[text()=' arrow_back ']")
    WebElement backbttn;
		
	@FindBy(xpath = "//span[@class='material-symbols-outlined']")
    WebElement dropdown;

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
	   	return zonepagetitle.isDisplayed();
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
	   
	   
	//   public void zoneName(String zonename) throws Exception {
//	   	if(zonename.equals("South")) {
//	   		JavascriptExecutor js = (JavascriptExecutor)driver;
//	 	   js.executeScript("arguments[0].scrollIntoView()",southzone );
//	 	   js.executeScript("arguments[0].click()",southzone );
//	 	   Thread.sleep(10000);
//	   	}
//	   	else {
//	   		JavascriptExecutor js = (JavascriptExecutor)driver;
//	 	   js.executeScript("arguments[0].scrollIntoView()",northzone );
//	 	   js.executeScript("arguments[0].click()",northzone );
//	 	   Thread.sleep(10000);
//	   	}
	//   }   
	   

	   public void creatNewZone() {
	       this.createnewzone.click();
//	       boolean isEnabled= displayopoupnewzone.isEnabled();
//	       boolean isdisplayed= displayopoupnewzone.isDisplayed();
//	       if(isEnabled) {
//	     	  System.out.println("popupmsg is isEnabled");
//	       }else {
//	     	  System.out.println("popupmsg is not isEnabled");
//	       }
//	       if(isdisplayed) {
//	     	  System.out.println("popupmsg is isdisplayed");
//	       }else {
//	     	  System.out.println("popupmsg is not isdisplayed");
//	       }
	    }
	   
	  
	   public void  enterZoneName(String Zonename) {
		   this.zoneID.click();
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
	   public void submitData () {
		   
		   submitbttn.click();
		   boolean isEnabled= submitbttn.isEnabled();
	       boolean isdisplayed= submitbttn.isDisplayed();
	      
	       if(isEnabled) {
	     	  System.out.println("submit is isEnabled");
	       }
	       else {
	     	  System.out.println("submit is not isEnabled");
	     	  
	     	 String actual_errormsg= errormessage.getAttribute("innerHTML");
	     	 System.out.println(actual_errormsg);
	         String expected_errormsg="Enter valid Latitude";
	         Assert.assertEquals(actual_errormsg,expected_errormsg );
	       }
	       if(isdisplayed) {
	     	  System.out.println("submit is isdisplayed");
	     	 
	       }
	       else {
	     	  System.out.println("submit is not isdisplayed");
	     	  
	        
	       }
	       
	    }
		
	//   public boolean isDisplayPopup() {
//		  
//			   try {
//		            wait.until(ExpectedConditions.alertIsPresent());
//		            return true;
//		        } catch (NoSuchElementException ne) {
//		            return false;
//		        } catch (Exception e) {
//		            log.error("No popup message is display" + e);
//		            return false;
//		        }
	//   }
	   public void closeIcon () {
			 closeIcon.click();		   
		   }
	   
	   public void  clickOnDropDowndots() {
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   js.executeScript("arguments[0].scrollIntoView()",dropdown );
		   js.executeScript("arguments[0].click()",dropdown );
	     // this.dropdown.click();
	   }  
	
}
