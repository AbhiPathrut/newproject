package com.sogeti.automation.test.pageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;

public class E2CO_MyApplicationPage extends PageClass {
	String currentworkingDirectory;
	String inputFile;
	SelfHealingDriver driver;
	SelfHealingDriver objDriver;
	int row;
	String DeletedArtifactName;
	
	@FindBy(xpath = "//a[@href='/MEC/my-apps']")
	private WebElement MyApplication;
	
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
	
	@FindBy(xpath = "//input[@id='inp']")
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
	
	@FindBy(xpath = "//div[contains(text(),'Onboarding New kubernetes')]")
	private WebElement kubernetesSelected;
	
	@FindBy(xpath = "//div[contains(text(),'Create an Artifact')]")
	private WebElement artifactPageTitle;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement close;
	
	@FindBy(xpath = "//div[contains(text(),'Artifact Created !')]")
	private WebElement createdMessage;
	
	@FindBy(xpath = "//input[@id='vmApplication']")
	private WebElement VMselected;
	
	@FindBy(xpath = "//input[@id='kubernetesApplication']")
	private WebElement kubernetesselected;
	
	@FindBy(xpath = "//input[@id='floatingVM']")
	private WebElement vmID;
	
	@FindBy(xpath = "//input[@id='floatingVMImageName']")
	private WebElement VmImageName;
	
	@FindBy(xpath = "//div[contains(text(),'Artifacts List')]")
	private WebElement artifactList;
	
//	@FindBy(xpath = "(//input[@name='artifact'])[2]")
//	private WebElement userId;
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement confirmBttn;
	
	@FindBy(xpath = "//div[contains(text(),'Deleting Artifact !')]")
	private WebElement messageDeleting;
	
	@FindBy(xpath = "//div[contains(text(),'Artifact Deleted !')]")
	private WebElement artifactDeletedMessage;
	
	
	
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
		Thread.sleep(2000);
	}
	
	public void selectContainer() {
		this.container.click();
		log.info("Selected container");
	}
	
	public void selectVM() {
		this.VMselected.click();
		log.info("Selected VM");
	}
	
	
	public void selectKuberenetes() {
		this.kubernetesselected.click();
		log.info("Selected Kubernetes");
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
	
	public void enterVMID(String ComponenetID) {
		this.vmID.click();
		this.vmID.sendKeys(ComponenetID);
		log.info("VMID entered");
		
	}
	
	public void enterComponenetImageName(String componentImageName) {
		this.componenetImagName.click();
		this.componenetImagName.sendKeys(componentImageName);
		log.info("Entered componenet image name");
	}
	
	public void enterVMImageName(String componentImageName) {
		this.VmImageName.click();
		this.VmImageName.sendKeys(componentImageName);
	}
	
	public void browseZipFileContainer() {
		currentworkingDirectory = System.getProperty("user.dir");
		inputFile= currentworkingDirectory + "/input-data/inputFiles/mario.zip";
		this.browseFile.sendKeys(inputFile);
		//driver.findElement(By.xpath("//input[@id='inp']")).sendKeys("C:\\Users\\APathrut\\OneDrive - Capgemini\\Desktop\\mario.zip");
		log.info("zip file is imported");
	}
	
	public void browseZipFileVM() {
		currentworkingDirectory = System.getProperty("user.dir");
		inputFile= currentworkingDirectory + "/input-data/inputFiles/fedora.zip";
		this.browseFile.sendKeys(inputFile);
		//driver.findElement(By.xpath("//input[@id='inp']")).sendKeys("C:\\Users\\APathrut\\OneDrive - Capgemini\\Desktop\\fedora.zip");
		log.info("zip file is imported");
	}
	
	public void clickOnSubmitButton() throws Exception {
		this.submitBtn.click();
		Thread.sleep(45000);
		log.info("Clicked on submit button");
	}
	
	public boolean verifyArtifactIsCreated() {
		this.createdMessage.isDisplayed();
		log.info("Artifact created successfully");
		return true;
	}
	
	public boolean kubernetesIsSelected() {
		this.kubernetesselected.isDisplayed();
		log.info("Kuernetes is selected");
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
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class=\'table mb-0\']//tbody[1]//tr//td[2]"));
		 for (WebElement element : allUserNameElements) {
		String artifactNm = element.getText();
		System.out.println(artifactNm);
		if(ArtifactName.equals(artifactNm)) {
			log.info("Artifact is displayed");
			System.out.println(ArtifactName);
			validationFlag = true;
		}
	}
		  return validationFlag;
}
	public boolean verifyUserIsAbleToSeeArtifactList() {
		this.artifactList.isDisplayed();
		log.info("Artifact List is displayed");
		return true;
		
	}
	public int SizeOfArtifactTable() {
		 List<WebElement> rows = objDriver.findElements(By.xpath("//table[@class=\'table mb-0\']//tbody[1]//tr"));
		  row = rows.size();
		 System.out.println(row);
		return row;
	}
	
	public void deleteArtifactSelect() throws Exception  {
		 Random rand = new Random();
			int randomNum = rand.nextInt((row - 1));
			System.err.println(randomNum);
			if (randomNum==0){          
				randomNum= randomNum+2;
				}
			WebElement artifactNameDeleted = objDriver.findElement(By.xpath("//table[@class=\'table mb-0\']//tbody[1]//tr["+ randomNum +"]//td[2]"));
			Thread.sleep(2000);
			DeletedArtifactName = artifactNameDeleted.getText();
			System.out.println(DeletedArtifactName);
			Thread.sleep(2000);
			WebElement userId = objDriver.findElement(By.xpath("(//input[@name='artifact'])["+ randomNum +"]"));
			Thread.sleep(2000);
			//WebElement userId =  objDriver.findElement(By.xpath("(//input[@name='artifact'])[2]"));
			userId.click();
			Thread.sleep(2000);
			
	}
	
	public void clickOnDeleteButton() throws Exception {
		this.deleteBtn.click();
		log.info("Clicked Delete Button");
		this.confirmBttn.click();
		log.info("Confirmed for deletion of artiofact");
		Thread.sleep(3000);
	}
	
	public boolean verifyArtifactIsDeletedMessage() {
		this.artifactDeletedMessage.isDisplayed();
		log.info("Artifact deleted message is displayed");
		return true;
	}
	
	 public boolean verifyDeletedArtifactIsNotPresentInTable() {
		 boolean validationFlag = false;
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class=\'table mb-0\']//tbody[1]//tr//td[2]"));
		 for (WebElement element : allUserNameElements) {
		String linkText = element.getText();
		if(DeletedArtifactName != (linkText)) {
			log.info("ArtfacTID is not displayed");
			validationFlag = true;
		}
	}
		  return validationFlag;
	 }
	 
	 
}
