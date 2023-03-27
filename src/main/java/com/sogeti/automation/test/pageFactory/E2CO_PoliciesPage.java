package com.sogeti.automation.test.pageFactory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;

public class E2CO_PoliciesPage extends PageClass {
	
	SelfHealingDriver objDriver;
	
	@FindBy(xpath="//a[@href='/MEC/policies']")
	private WebElement PolicyMenu;

	@FindBy(xpath="//a[contains(text(),'Edge Policies')]")
	private WebElement EdgePolicy;

	@FindBy(xpath="//select[@id='edgePolicyId']")
	private WebElement SelectEdgeId;

	@FindBy(xpath="//select[@id='edgePolicySelection']")
	private WebElement SelectPolicy;

	@FindBy(xpath="//select[@id='edgePolicyRule']")
	private WebElement SelectRule;

	@FindBy(xpath="//select[@id='edgePolicyOverCommit']")
	private WebElement SelectOvercommit;

	@FindBy(xpath="//button[normalize-space()='Submit']")
	private WebElement SubmitButton;

	//@FindBy(xpath="//button[normalize-space()='Ok']")
	//private WebElement OkButton;

	@FindBy(xpath="//div[@class='e2co-header']")
	private WebElement PolicyTitle;

	//@FindBy(xpath="//div[contains(text(),'Updated Successfully!')]")
	@FindBy(xpath="//div[@class='success-text onboard-success-text-spacing ft-18 ft-wt-500']")
	private WebElement PopUpMsg;
	
	@FindBy(xpath="//a[normalize-space()='Application Policies']")
	private WebElement ApplicationPolicy;

	@FindBy(xpath="//select[@id='appName']")
	private WebElement ApplicationField;

	@FindBy(xpath="//select[@class='form-select border-radius-5 config-input-border ft-14 ng-untouched ng-pristine ng-valid']")
	private WebElement AppPolicyField;

	@FindBy(xpath="//select[@class='form-select border-radius-5 config-input-border ft-14 ng-untouched ng-pristine ng-valid']")
	private WebElement ApplicationRule;

	@FindBy(xpath="//input[@type='number']" )
	private WebElement DownloadLimit;

	@FindBy(xpath="//button[@class='primary-custom-bg-blue text-white ft-18 ft-wt-400 e2co-submit-btn ml-15']")
	//button[@class='primary-custom-bg-blue text-white ft-18 ft-wt-400 e2co-submit-btn ml-15']
	private WebElement  SubmitDownloadLimit;

	@FindBy(xpath="//div[@class='e2co-header']")
	private WebElement PolicyHeader;

	@FindBy(xpath="//div[@class='success-text onboard-success-text-spacing ft-18 ft-wt-500']")
	private WebElement SuccessfulMsg;

	@FindBy(xpath="//button[normalize-space()='Close']")
	private WebElement AppCloseButton;
	
	@FindBy(xpath="//a[normalize-space()='Network Policies']")
	private WebElement NetworkPolicy;

	@FindBy(xpath="//select[@id='appName']")
	private WebElement AppForNetworkPolicy;

	@FindBy(xpath="//div[@class='policies-content-container w-100 bg-white border-radius-5']")
	private WebElement GetNetworkData;
	
	public E2CO_PoliciesPage(SelfHealingDriver driver) {
		super(driver);
		this.objDriver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
	}
	
	public void ClickONPolicyMenu() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)objDriver;
		 js.executeScript("arguments[0].scrollIntoView()",PolicyMenu);
		 Thread.sleep(2000);
		 js.executeScript("arguments[0].click()", PolicyMenu);
		 Thread.sleep(2000);
		log.info("User is click on policy menu");
		Thread.sleep(2000);
	}

	public void ClickEdgePlicy() {
		this.EdgePolicy.click();
		log.info("User Click on edge policy");
		
	}

	public boolean PolicyTitleDisplay() {
		this.PolicyTitle.isDisplayed();
		log.info("Policy page is displayed");
		return true;
	}

	public void SelectEdgeId(String Option) {
		Select select = new Select(SelectEdgeId);
		 
		 select.selectByVisibleText(Option);
		 log.info("Edge is selected");
	}

	public void SelectNewPolicy(String Option) {
		Select select = new Select(SelectPolicy);
		 
		 select.selectByVisibleText(Option);
		 log.info("Edge Policy is selected");
	}

	//public void ClickOnOk() {
//		this.OkButton.click();
//		log.info("user click on Ok button");s
	//}
	public void SelectAnyRule(String Option) throws Exception {
		Select select = new Select(SelectRule);
		 
		 select.selectByVisibleText(Option);
		 log.info("Rule is selected");
		 Thread.sleep(2000);
	}

	public void SelectOvercommitRange(String Option) throws Exception {
		Select select = new Select(SelectOvercommit);
		 
		 select.selectByVisibleText(Option);
		 log.info("OverCoomit is selected");
		 Thread.sleep(20000);
	}

	public void ClickSubmitButton() throws Exception {
		this.SubmitButton.click();
		log.info("User clicks on submit button");
		Thread.sleep(20000);
	}

	public boolean SuccessfulPopMsg() {
		this.PopUpMsg.isDisplayed();
		log.info("Successfully updated message is display");
		return true;
	}

	public void GetSuccessMsg() {
		String successMessage = this.PopUpMsg.getText();
		System.out.println(successMessage);
		System.out.println(PopUpMsg);
	}
	
	public void ClickOnAppMenu() {
		this.ApplicationPolicy.click();
		log.info("Application menu is selected");
	}

	public void SelectOneApp(String Option) throws Exception {
		Select select = new Select(ApplicationField);
		 
		select.selectByVisibleText(Option);
		 log.info("Application is selected");
		 Thread.sleep(2000);
	}

	public void SelectAppPolicy(String Option) throws Exception {
		Select select = new Select(AppPolicyField);
		 
		 select.selectByVisibleText(Option);
		 log.info("Application policy is selected");
		 Thread.sleep(5000);
	}

	public void SelectAppEdgeAffinity(String Option) throws Exception {
		Select select = new Select(AppPolicyField);
		 
		 select.selectByVisibleText(Option);
		 log.info("Application policy with edge affinity is selected");
		 Thread.sleep(5000);
	}
	public void SelectAppRule(String Option) throws Exception {
		Select select = new Select(ApplicationRule);
		 
		 select.selectByVisibleText(Option);
		 log.info("Application rule is selected");
		 Thread.sleep(5000);
	}

	public void EntertDownloadLimit(String DownloadLimit) {
		this.DownloadLimit.click();
		this.DownloadLimit.sendKeys(DownloadLimit);
	}

	public void SubmitOneDownloadLimit() {
		this.SubmitDownloadLimit.click();
		log.info("Submit download limit");
	}

	public void VerifySuccessfulAppPolicy() {
		this.SuccessfulMsg.getText();
		System.out.println(SuccessfulMsg);
		
	}
	public void AppCloseButton() {
		this.AppCloseButton.click();
		log.info("User successfully close App policy");
	}

	public Boolean VerifyAppPage() {
		this.PolicyHeader.isDisplayed();
		return true;
		
	}
	
	public void ClickOnNetworkPolicy() throws Exception {
		this.NetworkPolicy.click();
		log.info("user click on network policy");
		Thread.sleep(5000);
	}

	public void SelectAppForNextworkPolicy(String Option) throws Exception {
		Select select = new Select(AppForNetworkPolicy);
		 
		 select.selectByVisibleText(Option);
		 log.info("Application for network policy is selected");
		 Thread.sleep(5000);
	}

	public  void GetNetworkSelectedDetails() {
		this.GetNetworkData.getText();
		System.out.println(GetNetworkData);
	}

}