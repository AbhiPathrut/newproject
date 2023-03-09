package com.sogeti.automation.test.pageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.epam.healenium.SelfHealingDriver;

public class E2CO_TrobleshootPage extends PageClass{
	
	SelfHealingDriver objDriver;
	
	public E2CO_TrobleshootPage(SelfHealingDriver driver) {
		super(driver);
		this.objDriver = driver;

	}
	
	@FindBy(xpath="//span[normalize-space()='build']")
	private WebElement TroubleshootMenu;
	
	@FindBy(xpath="//select[@id='appN']")
	private WebElement ApplicationName;
	
	@FindBy(xpath="//select[@id='appId']")
	private WebElement AppId;
	
	@FindBy(xpath="//select[@id='version']")
	private WebElement AppVersion;
	
	@FindBy(xpath="//select[@id='instanceId']")
	private WebElement InstanceId;
	
	@FindBy(xpath="//button[normalize-space()='Apply']")
	private WebElement ApplyButton;
	
	@FindBy(xpath="//div[contains(text(),'Troubleshoot Status')]")
	private WebElement TroubleshootStatus;
	
	@FindBy(xpath = "//div[@class='table-responsive troubleshooot-status-table-area custom-scroll-for-table']")
	private WebElement troblshootDetailsDisplyed;
	
	public void ClickOnTroubleshoot() {
		this.TroubleshootMenu.click();
		log.info("User click on troubleshoot menu");
	}
	public void SelectAppName(String applicationName) {
		Select select = new Select(ApplicationName);
		 select.selectByValue(applicationName);
		 log.info("Application name is selected");
	}
	
	public void SelectApplicationId(String appId) {
		Select select = new Select(AppId);
		 select.selectByValue(appId);
		 log.info("Application id is selected");
		
	}
	
	public void SelectAppVersion(String appVersion) {
		Select select = new Select(AppVersion);
		 select.selectByValue(appVersion);
		 log.info("Application version is selected");
	}
	
	public void SelectInstanceId(String instanceId) throws Exception {
		Select select = new Select(InstanceId);
		 select.selectByValue(instanceId);
		 log.info("Instance id is selected");
		 Thread.sleep(2000);
	}
	
	public void ClickonApplyButton() throws Exception {
		this.ApplyButton.click();
		log.info("User click on apply option");
		Thread.sleep(2000);
	}
	

	 public boolean TroubleshootStatusDisplay() {
		 this.TroubleshootStatus.isDisplayed();
		 return true;
	 }
	 
	 public void troblshootDetailsDisplyed() {
		 String TrobleshootDetails = this.troblshootDetailsDisplyed.getText();
		 System.out.println("Troubleshoot Status:");
		 System.out.println(TrobleshootDetails);
	 }
	
	
			
}
