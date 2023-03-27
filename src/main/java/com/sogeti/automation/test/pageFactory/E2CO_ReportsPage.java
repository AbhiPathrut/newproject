package com.sogeti.automation.test.pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;

public class E2CO_ReportsPage extends PageClass {
	
SelfHealingDriver driver;
	
	String currentworkingDirectory;

	@FindBy(xpath = "//a[@href='/MEC/reports']")
    WebElement reports;
	
	@FindBy(xpath="//select[@class='form-select reports-metrics-drop-down config-input-border ft-14 ng-untouched ng-pristine ng-invalid']")
	WebElement searchreport;
	
	@FindBy(xpath="//select[@class='form-select reports-metrics-drop-down config-input-border ft-14 ng-untouched ng-pristine ng-invalid']")
	WebElement searchCategory;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement searchsubCategory;
	
	@FindBy(xpath="//span[@class='ng-arrow-wrapper']")
	WebElement downarrowbttn;
	
	@FindBy(xpath="//select[@aria-label='App Name']")
	WebElement appName;
	
	@FindBy(xpath="//select[@aria-label='App ID']")
	WebElement appId;
	
	@FindBy(xpath="//select[@aria-label='App Version']")
	WebElement appVersion;
	
	@FindBy(xpath="//select[@aria-label='Instances ID']")
	WebElement instancesId;
	
	@FindBy(xpath="//select[@aria-label='Country']")
	WebElement selectCountry;
	
	@FindBy(xpath="//select[@aria-label='Operator']")
	WebElement selectOperator;
	
	@FindBy(xpath="//select[@aria-label='Zone']")
	WebElement selectZone;
	
	@FindBy(xpath="//select[@aria-label='Edge']")
	WebElement selectEdge;
	
	@FindBy(xpath="//button[text()=' Show Metrics ']")
	WebElement showmetricsbttn;
	
	@FindBy(xpath="//button[text()=' Reset ']")
	WebElement resetbttn;
	
	@FindBy(xpath="//div[text()='Reports & Metrics']")
	WebElement verifyreportspagetitle;
	

	public E2CO_ReportsPage(SelfHealingDriver driver) {
		super(driver);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
	}
	
	public void clikOnReportsIcon() {
	       reports.click();
	       
	   }
	   public void clickOnSearchReport(String ReportType) {
		   
		   Select sel=new Select(searchreport);
		   sel.selectByVisibleText(ReportType);
	   }
	   public void clickOnSearchCategory(String Searchcategory) {
		   Select sel1=new Select(searchCategory);
		   sel1.selectByVisibleText(Searchcategory);
	   }
	   public void clickOnSearchSubCategory(String Searchsubcategoray) throws Exception {
		   searchsubCategory.click();
		   searchsubCategory.sendKeys(Searchsubcategoray);
		   Thread.sleep(2000);
		   //downarrowbttn.click();
	   }   
	   public void clickOnAppName(String AppName) {
		   //this.searchreport.click();
		   Select sel3=new Select(appName);
		   sel3.selectByVisibleText(AppName);
	   }
	   public void clickOnAppId(String AppId ) {
		   //this.searchreport.click();
		   Select sel4=new Select(appId);
		   sel4.selectByVisibleText(AppId);
	   }
	   public void clickOnAppVersion(String Appversion ){
		   //this.searchreport.click();
		   Select sel5=new Select(appVersion);
		   sel5.selectByVisibleText(Appversion);
	   }
	   public void clickOnInstancesID(String Instancesid) {
		  
		   Select sel6=new Select(instancesId);
		   sel6.selectByValue(Instancesid);
	   }
	   public void clickOnCountry(String Country) {
		   
		   Select sel7=new Select(selectCountry);
		   sel7.selectByVisibleText(Country);
		  
	   }
	   public void clickOnOperator(String Operator) {
		  
		   Select sel8=new Select(selectOperator);
		   sel8.selectByVisibleText(Operator);
	   }
	   public void clickOnZone(String Zone) {
		   //this.searchreport.click();
		   Select sel9=new Select(selectZone);
		   sel9.selectByVisibleText(Zone);
	   }
	   public void clickOnEdge(String Edge) {
		   //this.searchreport.click();
		   Select sel10=new Select(selectEdge);
		   sel10.selectByVisibleText(Edge);
	   }
	   public void clickOnShowmetricsbttn() {
		   showmetricsbttn.click();
	   }
	   public void clickOnreset() {
		   resetbttn.click();
	   }
	   public boolean isReportPageDisplayed() {
		   	  verifyreportspagetitle.isDisplayed();
		   	  return true;
		   	}

		  


}
