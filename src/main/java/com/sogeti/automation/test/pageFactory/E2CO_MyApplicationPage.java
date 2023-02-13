package com.sogeti.automation.test.pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XPath;
import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;

public class E2CO_MyApplicationPage extends PageClass {
	String currentworkingDirectory;
	String inputFile;
	SelfHealingDriver driver;
	SelfHealingDriver objDriver;
	
	@FindBy(xpath = "//a[@href='/MEC/my-apps']")
	private WebElement MyApplication;
	
	//@FindBy(xpath = "//button[@class='e2co-primary-btn']")
	@FindBy(xpath = "//button[text()=' New Application ']")
	private WebElement newApplication;
	
	@FindBy(xpath = "//input[@id='containerApplication']")
	private WebElement container;
	
	@FindBy(xpath = "//div[contains(text(),'Create New Artifact')]")
	private WebElement createnewArtifact;
	
	@FindBy(xpath = "//input[@id='floatingArtifactName']")
	private WebElement artifactName;
	
	@FindBy(xpath = "//input[@id='floatingVMID']")
	private WebElement componentId;
	
	@FindBy(xpath = "//input[@id='floatingCompImageName']")
	private WebElement componenetImagName;
	
	@FindBy(xpath = "(//button[normalize-space()='Browse'])[1]")
	private WebElement browseFile;
	
	@FindBy(xpath = "//div[@class='ml-15']//button[@class='e2co-submit-btn'][normalize-space()='Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Select Artifact')]")
	private WebElement selectArtifact; 
	
	@FindBy(xpath = "//div[@class='e2co-header']")
	private WebElement applicationsTitle;

	@FindBy(xpath = "//div[contains(text(),'Onboarding New VM')]")
	private WebElement newapplicationpage;
	
	@FindBy(xpath = "//div[contains(text(),'Onboarding New Container')]")
	private WebElement containerSelected;
	
	@FindBy(xpath = "//div[contains(text(),'Create an Artifact')]")
	private WebElement artifactPageTitle;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement close;
	
	@FindBy(xpath = "//div[contains(text(),'Artifact Created !')]")
	private WebElement createdMessage;
	
	public E2CO_MyApplicationPage(SelfHealingDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.objDriver = driver;
		
	}
	
	public void clickOnMyApplication() throws Exception {
		this.MyApplication.click();
		log.info("Clicked on my application menu");
		Thread.sleep(2000);
	}
	
	public void clickOnNewApplication() throws Exception {
		newApplication.click();
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", newApplication);
//		log.info("Clicked on new application");
		Thread.sleep(2000);
	}
	
	public void selectContainer() {
		this.container.click();
		log.info("Selected container");
	}
	
	public void clickOnCreateNewArtifact() {
		this.createnewArtifact.click();
		log.info("Clicked on create new artifact");
	}
	
	public void enterArtifactName(String artifactName) {
		this.artifactName.click();
		this.artifactName.sendKeys(artifactName);
		log.info("Entered artifact name");
	}
	
	public void enterComponenetID(String componentId) {
		this.componentId.click();
		this.componentId.sendKeys(componentId);
		log.info("Enetered componenetID");
	}
	
	public void enterComponenetImageName(String componentImageName) {
		this.componenetImagName.click();
		this.componenetImagName.sendKeys(componentImageName);
		log.info("Entered componenet image name");
	}
	
	public void browseZipFile() {
//		currentworkingDirectory = System.getProperty("user.dir");
//		inputFile= currentworkingDirectory + "/input-data/inputFiles/mario.zip";
//		this.browseFile.sendKeys(inputFile);
		driver.findElement(By.xpath("//input[@id='inp']")).sendKeys("C:\\Users\\APathrut\\OneDrive - Capgemini\\Desktop\\mario.zip");
		log.info("zip file is imported");
		
	}
	
	public void clickOnSubmitButton() throws Exception {
		this.submitBtn.click();
		Thread.sleep(20000);
		log.info("Clicked on submit button");
	}
	
	public boolean verifyArtifactIsCreated() {
		this.createdMessage.isDisplayed();
		log.info("Artifact created successfully");
		return true;
	}
	
	public void closeTheDialogBox() {
		this.close.click();
		log.info("Clicked on close");
	}
	
	public void clickOnSelectArtifact() throws Exception {
		Thread.sleep(2000);
		this.selectArtifact.click();
		log.info("Clicked on select artifact");
	}
	
	public boolean applicationsTitleIsDisplayed() {
		this.applicationsTitle.isDisplayed();
		return true;
	}
	
	public boolean applicationNewPageIsDisplayed() {
		this.newapplicationpage.isDisplayed();
		return true;
		
	}
	
	public boolean containerIsSelected() {
		this.containerSelected.isDisplayed();
		return true;
	}

	public boolean verifyuserisOnArtifactPage() {
		this.artifactPageTitle.isDisplayed();
		return true;
	}
	
	public boolean verifyArtifactCreatedIsDisplayed(String ArtifactName) {
		boolean validationFlag = false;
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class='table mb-0']//tbody//tr//td//th[1]"));
		 for (WebElement element : allUserNameElements) {
		String linkText = element.getText();
		System.out.println(linkText);
		if(ArtifactName.equals(linkText)) {
			log.info("Artifact is displayed");
			validationFlag = true;
		}
	}
		  return validationFlag;
}
}
