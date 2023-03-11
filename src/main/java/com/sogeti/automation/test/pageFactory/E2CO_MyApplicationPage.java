package com.sogeti.automation.test.pageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class E2CO_MyApplicationPage extends PageClass {
	String currentworkingDirectory;
	String inputFile;
	SelfHealingDriver driver;
	SelfHealingDriver objDriver;
	int row;
	String DeletedArtifactName;
	String SelectedArtifactName;
	
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
	
	@FindBy(xpath = "//div[contains(text(),'Overview')]")
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
	
	@FindBy(xpath = "//div[@class= 'success-text onboard-success-text-spacing ft-18 ft-wt-500' ]")
	private WebElement messageDeleting;
	
	//@FindBy(xpath = "//div[contains(text(),'Artifact Deleted !')]")
	//@FindBy(xpath = "//div[@class = '*-text onboard-success-text-spacing ft-18 ft-wt-500']")
	@FindBy(xpath = "//div[@class='onboard-success-container text-center']")
	private WebElement artifactDeletedMessage;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement doneBtn;
	
	@FindBy(xpath = "//button[@class='e2co-import-btn mx-15']")
	private WebElement imprtBtn;
	
	@FindBy(xpath = "//input[@id='inp']")
	private WebElement fileUpload;
	
	@FindBy(xpath = "//button[@class= 'primary-custom-bg-blue border-0 import-file-modal-submit-btn text-white ft-16 ft-wt-500']")
	private WebElement submitBttn;
	
	@FindBy(xpath = "//input[@id='AppName']")
	private WebElement appName;
	
	@FindBy(xpath = "//select[@id='LatencyConstraintSelect']")
	private WebElement selectLatency;
	
	@FindBy(xpath = "//input[@id='floatingbandwidth']")
	private WebElement bandWidth;
	
	//@FindBy(xpath = "//div[@class='onboard-new-app-deployment ms-3 cursor-pt border-radius-5 d-flex align-items-center']")
	@FindBy(xpath = "//i[@class = 'material-symbols-outlined onboard-general-input-border ft-30']")
	private WebElement deploymentEdit;
	
	@FindBy(xpath = "//select[@id='zoneSelect']")
	private WebElement selectZone;
	
	@FindBy(xpath = "//input[@placeholder=' Enter Component ID']")
	private WebElement componentID;
	
	@FindBy(xpath = "//input[@placeholder='Enter network Name']")
	private WebElement network;
	
	@FindBy(xpath = "//button[@class='primary-custom-bg-blue border-0 add-deployment-data-save-btn text-white ft-16 ft-wt-500']")
	private WebElement saveData;
	
	@FindBy(xpath = "//button[@class='e2co-submit-btn']")
	private WebElement SubmitButton;
	
	@FindBy(xpath = "//div[@class='flex-grow-1 ft-20 ft-wt-400']")
	private WebElement FileUploadPage;
	
	@FindBy(xpath = "//div[normalize-space()='Artifact']")
	private WebElement artifactIsDisplaying;
	
	@FindBy(xpath = "//div[contains(text(),'Onboarding Request Accepted !')]")
	private WebElement onboardSuccessfulMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Artifact Deletion Failed !')]")
	private WebElement deletionfailedMessg;
	
	@FindBy(xpath = "//button[@class = 'btn btn-secondary custom-success-close ft-18 ft-wt-400']")
	private WebElement okButton;
	
	@FindBy(xpath = "//select[@formcontrolname='zoneId']")
	private WebElement selectZoneProvision;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement provisionButton;
	
	@FindBy(xpath = "//div[@class = 'success-text onboard-success-text-spacing ft-18 ft-wt-500']")
	private WebElement successMesgOfProvision;
	
	//@FindBy(xpath = "//td[contains(text(),'app02280151592')]")
	//@FindBy(xpath = "//td[starts-with(text(),'app02280151592')]")
	////td[contains(text(),'app02280141176')]
	//private WebElement applicationNmFrProv;
	
	@FindBy(xpath = "//div[@class='provison-instance-title ft-18']")
	private WebElement applicationProvisionPage;
	
	@FindBy(xpath = "//td[contains(text(),'alpineapp1505')]")
	private WebElement applicationForDeprovision;
	
	@FindBy(xpath = "//button[contains(text(),'Deprovision')]")
	private WebElement deprovisionBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Deployment Data')]")
	private WebElement deploymentDataTitle;
	
	@FindBy(xpath = "//div[@class='d-flex flex-column align-items-center user-manager-delete-pop-up-container']")
	private WebElement deprovisionWarningMessage;
	
	@FindBy(xpath = "//div[@class='ft-16 ft-wt-400']")
	private WebElement deboardingPopupMessage;
	
	@FindBy(xpath = "//button[contains(text(),'Deboarding')]")
	private WebElement appDeboardingBtn;
	
	
	
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
		this.newApplication.click();
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
		inputFile= currentworkingDirectory + "/input-data/inputFiles/alpine.zip";
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
		//Thread.sleep(120000);
		WebDriverWait wait = new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Close')]")));
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
			int randomNum = rand.nextInt(row);
			System.err.println(randomNum);
			if (randomNum==0){          
				randomNum= randomNum+1;
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
	
	public void verifyArtifactIsDeletedMessage() throws Exception {
		Thread.sleep(2000);
	String	DeletionMessage = artifactDeletedMessage.getText();
	//System.out.println(DeletionMessage);
		if(DeletionMessage.contains("Artifact Deleted !")) {
			log.info("Artifact is deleted successfully");
			this.close.click();
		}else  {
			log.info("Artifact is InUse can't delete");
			this.okButton.click();
			SizeOfArtifactTable();
			Thread.sleep(2000);			
			objDriver.quit();
		}	
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
	 
	 public void clickOnDoneBtn() {
		 this.doneBtn.click();
		 log.info("Clicked on done button");
	 }
	 
	public void clickOnImportButton() {
		this.imprtBtn.click();
		log.info("Clicked on import button");
	}
	 
	public void uploadYAMLFile() {
		currentworkingDirectory = System.getProperty("user.dir");
		inputFile= currentworkingDirectory + "/input-data/inputFiles/alpine.yaml";
		this.fileUpload.sendKeys(inputFile);
		log.info("YAML file is imported");	
	}
	
	public boolean verifyUploadPageIsVisible() {
		this.FileUploadPage.isDisplayed();
		log.info("Upload Your File ! is displayed");
		return true;
	}
	
	public void submitBtnOfYAML() {
		this.submitBttn.click();
		log.info("Clicked on submit button");
	}
	
	public boolean verifyUploadedDataIsFecthed() {
		this.artifactIsDisplaying.isDisplayed();
		log.info("Imported data is displaying on the page");
		return true;
	}
	
	public void updateAppName(String appName) {
		this.appName.clear();
		this.appName.sendKeys(appName);
		log.info("Updated app name");
     
    }
	
//	public void updateBandWidth(String BandWidth) {
//		this.bandWidth.click();
//		this.bandWidth.sendKeys(BandWidth);
//		log.info("Updated bandwidth");
//		
//	}
	
	public void updateLatency(String Latency) {
		Select select = new Select(selectLatency);
        select.selectByVisibleText(Latency);
        log.info("Latency selected");
		
	}
	
	public void updateZone(String zone) {
		Select select1 = new Select(selectZone);
        select1.selectByVisibleText(zone);
        log.info("Zone selected");
	}
	
	public void clickOnDeploymentEdit() throws Exception {
//		 this.deploymentEdit.click();
//		 Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor)objDriver;
		 js.executeScript("arguments[0].scrollIntoView()",deploymentEdit);
		 Thread.sleep(2000);
		 js.executeScript("arguments[0].click()", deploymentEdit);
		 Thread.sleep(2000);
		// log.info("Click on Manage button");
	}
	
	public void updateComponentID(String ComponentID) throws Exception {
		Thread.sleep(2000);
		this.componentID.clear();
        this.componentID.sendKeys(ComponentID);
        log.info("Updated componenet ID");
	}
		
	public void updateNetwork(String Network) {
		this.network.sendKeys(Network);
		log.info("Updated network");
        this.saveData.click();
	}
	
	public void submitDetailsOfApplication() throws Exception {
//		this.SubmitButton.click();
//		JavascriptExecutor js = (JavascriptExecutor)objDriver;
//		 js.executeScript("scrollBy(0, -1000");
		JavascriptExecutor js = (JavascriptExecutor)objDriver;
		 js.executeScript("arguments[0].scrollIntoView()",SubmitButton);
		 Thread.sleep(2000);
		 js.executeScript("arguments[0].click()", SubmitButton);
		 Thread.sleep(2000);
		 //this.SubmitButton.click();
		log.info("Clicked on submit button");
	}
	
	public boolean verifyOnboardingMessageIsDisplayed() {
		this.onboardSuccessfulMessage.isDisplayed();
		log.info("Onboarding request accepted is message displayed");
		return true;
	}
	
	public int SizeOfApplicationTable() {
		 List<WebElement> rows = objDriver.findElements(By.xpath("//table[@class = 'table mb-0 my-app-body-list-app-row']//tbody//tr"));
		  row = rows.size();
		 System.out.println(row);
		return row;
	}
	
	public boolean verifyApplicationOnoardedIsDisplayed(String AppName) {
		boolean validationFlag = false;
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class = 'table mb-0 my-app-body-list-app-row']//tbody//tr//td[1]"));
		 for (WebElement element : allUserNameElements) {
		String appNm = element.getText();
		System.out.println(appNm);
		if(AppName.equals(appNm)) {
			log.info("Application is displayed");
			System.out.println(AppName);
			validationFlag = true;
		}
	}
		  return validationFlag;
}
	
	public void selectArtifactId() throws Exception {
		 Random rand = new Random();
			int randomNum = rand.nextInt(row);
			System.err.println(randomNum);
			if (randomNum==0){          
				randomNum= randomNum+1;
				}
			WebElement artifactNameSelected = objDriver.findElement(By.xpath("//table[@class=\'table mb-0\']//tbody[1]//tr["+ randomNum +"]//td[2]"));
			Thread.sleep(2000);
			SelectedArtifactName = artifactNameSelected.getText();
			System.out.println(DeletedArtifactName);
			Thread.sleep(2000);
			WebElement userId = objDriver.findElement(By.xpath("(//input[@name='artifact'])["+ randomNum +"]"));
			Thread.sleep(2000);
			//WebElement userId =  objDriver.findElement(By.xpath("(//input[@name='artifact'])[2]"));
			userId.click();
			Thread.sleep(2000);
			
	}
	
	public void selectApplicationForPrvision(String appName) throws Exception {
		//this.applicationNmFrProv.click();
		WebElement applicationNmFrProv = objDriver.findElement(By.xpath("//td[contains(text(),'"+appName+"')]"));
		System.out.println(applicationNmFrProv);
		JavascriptExecutor js = (JavascriptExecutor)objDriver;
		 js.executeScript("arguments[0].scrollIntoView()",applicationNmFrProv);
		 Thread.sleep(2000);
		 js.executeScript("arguments[0].click()", applicationNmFrProv);
		 Thread.sleep(2000);
		log.info("Clicked on application for provision");
	}
	
	public boolean userIsOnProvisionPage() {
		this.applicationProvisionPage.isDisplayed();
		log.info("User is on application provision page");
		return true;
	}
	
	public void selectZoneForApplicationProvision(String zone) {
		Select select1 = new Select(selectZoneProvision);
        select1.selectByVisibleText(zone);
        log.info("Zone selected");
	}
	
	public void clickOnProvisionBtn() {
		this.provisionButton.click();
		log.info("Clicked on provision button");
	}
	
	public boolean requestAcceptMessageIsDisplayed() {
		this.successMesgOfProvision.isDisplayed();
		log.info("Request accepted message is displayed");
		return true;
	}
	
	public void clickOncloseBtn() {
		this.close.click();
	}
	
	public void selectAppForDeprovision(String appName) throws Exception {
		//this.applicationForDeprovision.click();
		WebElement applicationForDeprovision = objDriver.findElement(By.xpath("//td[contains(text(),'"+appName+"')]"));
		JavascriptExecutor js = (JavascriptExecutor)objDriver;
		 js.executeScript("arguments[0].scrollIntoView()",applicationForDeprovision);
		 Thread.sleep(2000);
		 js.executeScript("arguments[0].click()", applicationForDeprovision);
		 Thread.sleep(2000);
		log.info("Clicked on application which is running");
	}
	
	public boolean provisionedAppDetailsIsDisplayed() {
		this.deploymentDataTitle.isDisplayed();
		log.info("Runnig app details page is opned");
		return true;
	}
	
	public void clickOnDeprovisionButton() {
		this.deprovisionBtn.click();
		log.info("Clicked on deprovision button");
	}
	
	public boolean verifyDeprovisionAppWarningMessageIsDisplayed() {
		this.deprovisionWarningMessage.isDisplayed();
		log.info("Warning popup message is dispalyed");
		return true;
	}
	
	public void clickOnConfirmBtn() {
		this.confirmBttn.click();
		log.info("Clicked on confirm button");
	}
	
	public void selectAppForDebaord(String appName) throws Exception {
		WebElement applicationForDeboard = objDriver.findElement(By.xpath("//td[contains(text(),'"+appName+"')]"));
		JavascriptExecutor js = (JavascriptExecutor)objDriver;
		 js.executeScript("arguments[0].scrollIntoView()",applicationForDeboard);
		 Thread.sleep(2000);
		 js.executeScript("arguments[0].click()", applicationForDeboard);
		 Thread.sleep(2000);
		log.info("Clicked on application which is onboarded or onboardingpending");
	}
	
	public boolean debordingWarningPopupMessageIsDispalying() {
		this.deboardingPopupMessage.isDisplayed();
		log.info("Deboarding warning popup message is displayed");
		return true;
	}
	
	public void clickOnDeboardingAppButton() {
		this.appDeboardingBtn.click();
		log.info("Click on deboarding button");
	}
	
	public void applicationIsRemovedFromList(String appName) {
		WebElement applicationForDeboard = objDriver.findElement(By.xpath("//td[contains(text(),'"+appName+"')]"));
		applicationForDeboard.isDisplayed();
		log.info("Application is removed from the list");
		
	}
	
	public boolean verifyDeboardedAppIsNotPresentInAppList(String DeboardedAppName) {
		 boolean validationFlag = false;
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class = 'table mb-0 my-app-body-list-app-row']//tbody//tr//td[1]"));
		 for (WebElement element : allUserNameElements) {
		String linkText = element.getText();
		if(DeboardedAppName != (linkText)) {
			log.info("App is successfully deboarded");
			validationFlag = true;
		}
	}
		  return validationFlag;
	 }
	
	public int rowNumber(String appName) {
		WebElement table = driver.findElement(By.xpath("//table[@class ='table mb-0 my-app-body-list-app-row']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		int rowNumber = -1;
		for (int i = 0; i < rows.size(); i++) {
		    List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
		    for (int j = 0; j < cells.size(); j++) {
		        if (cells.get(j).getText().equals(appName)) {
		            rowNumber = i;
		            break;
		        }
		    }
		    if (rowNumber != -1) {
		        break;
		    }
		}
		System.out.println("Row number: " + rowNumber);
		return rowNumber;
		
	}
	

	
	public void statusOfApplication(String appName) throws Exception {
		int RowNum = rowNumber(appName);
		Thread.sleep(2000);
		WebElement StatusOfApp = objDriver.findElement(By.xpath("//table[@class ='table mb-0 my-app-body-list-app-row']//tbody//tr["+RowNum+"]//td[8]"));
		Thread.sleep(2000);
		String StatusOfApplication = StatusOfApp.getText();
		System.out.println("Status of "+appName+": "+StatusOfApplication);
	}

	public void refresHPageOfWeb() {
		objDriver.navigate().refresh();
		log.info("Page is refreshed");
	}
	
}
	
	
	
	
	

	

