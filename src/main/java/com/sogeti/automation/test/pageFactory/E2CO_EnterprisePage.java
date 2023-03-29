package com.sogeti.automation.test.pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;

public class E2CO_EnterprisePage extends PageClass {
	
	@FindBy(xpath = "//a[@href='/MEC/enterprise/list']")
	private WebElement enterpriseMenu;
	
	@FindBy(xpath = "//button[@class='e2co-primary-btn enterprise-list-add-new-btn']")
	private WebElement addNewBtn;
	
	@FindBy(xpath = "//input[@formcontrolname='enterpriseName']")
	private WebElement enterpriseName;
	
	@FindBy(xpath = "//input[@formcontrolname='domainName']")
	private WebElement domainName;
	
	@FindBy(xpath = "//input[@formcontrolname='loginId']")
	private WebElement loginId;
	
	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@formcontrolname='cnfPassword']")
	private WebElement confirmPass;
	
	@FindBy(xpath = "//input[@formcontrolname='description']")
	private WebElement description;
	
	@FindBy(xpath = "//input[@formcontrolname='cpu']")
	private WebElement cpu;
	
	@FindBy(xpath = "//input[@formcontrolname='memory']")
	private WebElement memory;
	
	@FindBy(xpath = "//input[@formcontrolname='storage']")
	private WebElement storage;
	
	@FindBy(xpath = "//select[@formcontrolname='zone']")
	private WebElement zoneId;
	
	@FindBy(xpath = "//button[contains(text(),'Enterprise')]")
	private WebElement enterpriseTitle;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//div[@class='success-text onboard-success-text-spacing ft-18 ft-wt-500']")
	private WebElement successPopupMessage;
	
	@FindBy(xpath = "//button[@class='btn btn-secondary custom-success-close ft-18 ft-wt-400']")
	private WebElement closeBtn;

	public E2CO_EnterprisePage(SelfHealingDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
	}
	
	public void clickOnEnterpriseMenu() {
		this.enterpriseMenu.click();
		log.info("Clicked on enterprise menu.");
	}
	
	public boolean verifyEnterpriseMenuPageIsDispalyed() {
		this.enterpriseTitle.isDisplayed();
		log.info("Enterprise Page is displayed.");
		return true;
	}
	
	public void clickOnAddNew() {
		this.addNewBtn.click();
		log.info("Clicked on add new button.");
	}
	
	public void enterEnterpriseName(String enterprisename) {
		this.enterpriseName.sendKeys(enterprisename);
		log.info("Entered enterprise name.");
	}
	
	public void enterDomainName(String domainname) {
		this.domainName.sendKeys(domainname);
		log.info("Entered domain name.");
	}
	
	public void enterLoginId(String loginid) {
		this.loginId.sendKeys(loginid);
		log.info("Entered loginId.");
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
		log.info("Entered password.");
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		this.confirmPass.sendKeys(confirmPassword);
		log.info("Entered confirm password.");
		
	}
	
	public void eneterDescription(String description) {
		this.description.sendKeys(description);
		log.info("Entered description.");
	}
	
	public void selectZone(String zone) {
		Select select1 = new Select(zoneId);
        select1.selectByVisibleText(zone);
        log.info("Zone selected");
	}
	
	public void enterCPU(String CPU) {
		this.cpu.sendKeys(CPU);
		log.info("Entered cpu value.");
	}
	
	public void enterMemory(String Memory) {
		this.memory.sendKeys(Memory);
		log.info("Entered memory value.");
	}
	
	public void enterStorage(String Storage) {
		this.storage.sendKeys(Storage);
		log.info("Entered storage value.");
	}
	
	public void clickOnSubmitBtn() {
		this.submitBtn.click();
		log.info("Clicked on submit button.");
	}
	
	public boolean verifySuccessPopupMessage() {
		this.successPopupMessage.isDisplayed();
		log.info("SuccessPopup Message Is Displayed.");
		return true;
	}
	
	public void clickOnCloseBtn() {
		this.closeBtn.click();
		log.info("Clicked on close button.");
	}
	
	

}