package com.sogeti.automation.test.pageFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;




public class E2CO_SDKPage extends PageClass {
	String currentworkingDirectory;
	String inputFile;
	SelfHealingDriver objDriver;
	int row;
	
	 @FindBy(xpath="//span[contains(text(),'folder_zip')]")
	 private WebElement SdkMenu;
	 
	 @FindBy(xpath="//button[normalize-space()='Upload New']")
	 private WebElement UploadButton;
	 
	 @FindBy(xpath="//select[@id='floatingSelect']")
	 private WebElement SelectLanguage;
	 
	 @FindBy(xpath="//input[@formcontrolname='sdkVersion']")
	 private WebElement SelectVersion;
	 
	 @FindBy(xpath="//textarea[@id='floatingTextarea2']")
	 private WebElement Enterdescription;
	 
	 @FindBy(xpath="//input[@id='inp']")
	 private WebElement SelectFile;
	 
	 @FindBy(xpath="//button[normalize-space()='Upload']")
	 private WebElement SubmitButton;
	 
	 @FindBy(xpath="//button[normalize-space()='Close']")
	 private WebElement CloseButton;
	 
	 @FindBy(xpath = "//table[@class ='table sdk-list-table']")
	 private WebElement tableList;
	 
	 @FindBy(xpath = "//div[@class='success-text onboard-success-text-spacing ft-18 ft-wt-500']")
	 private WebElement successmesg;
	 
	 @FindBy(xpath = "//button[contains(text(),'Close')]")
	 private WebElement closebtn;
	 
	 @FindBy(xpath="//td[starts-with(text(),'ec_client-sdk_Android_')]")
	 private WebElement SelectUploadedSDK;
	 
	 @FindBy(xpath="//button[normalize-space()='Delete']")
	 private WebElement DeleteButton;
	 
	 @FindBy(xpath="//button[normalize-space()='Confirm']")
	 private WebElement ConfirmButton;
	 
	 @FindBy(xpath = "//div[@class='sdk-details-body bg-white border-radius-5']")
	 private WebElement deletedSDKinfo;
	 
//	 @FindBy(xpath="//td[normalize-space()='ec_client-sdk_Android_1.0.0.zip']")
//	 private WebElement SelectUploadedSDK;

	 @FindBy(xpath="//a[normalize-space()='Download']")
	 private WebElement DownloadButton;
	 
	 @FindBy(xpath="//div[@class='danger-text onboard-success-text-spacing ft-18 ft-wt-500']")
	 private WebElement DuplicateErrorMsg;
	 
	 @FindBy(xpath="//div[@class='danger-text onboard-success-text-spacing ft-18 ft-wt-500']")
	 private WebElement ErrorMessage;
	 
	 @FindBy(xpath="//span[normalize-space()='Only zip file format allowed !!']")
	 private WebElement FileFormatError;

	 
	public E2CO_SDKPage(SelfHealingDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
		this.objDriver = driver;
	}
	
	public void ClickOnSDkMenu() {
		 this.SdkMenu.click();
		 log.info("User click on SDK menu");
	 }
	 
	 public void ClickOnUploadButton() {
		 this.UploadButton.click();
	 }
	 
	 public void SelectOneLanguage(String language) {
		 Select select = new Select(SelectLanguage);
		 //select.selectByVisibleText("Android");
		 select.selectByValue(language);
		 log.info("Language is selected"); 
	 }
	 
	 public void EnterSDKVersion(String Version) {
		 this.SelectVersion.click();
		 this.SelectVersion.sendKeys(Version);
	 }
	 
	 public void EnterSDKDescription(String description) {
		 this.Enterdescription.click();
		 this.Enterdescription.sendKeys(description);
	 }
	 
	 public void SelectSDKFile() {
		 currentworkingDirectory = System.getProperty("user.dir");
		 inputFile= currentworkingDirectory + "/input-data/inputFiles/alpine.zip";
		 this.SelectFile.sendKeys(inputFile);
	 }
	 
	 public void selectSDKFileInvalidFormat() {
		 currentworkingDirectory = System.getProperty("user.dir");
		 inputFile= currentworkingDirectory + "/input-data/inputFiles/alpine.yaml";
		 this.SelectFile.sendKeys(inputFile);
	 }
	 public void SubmitCreatedSDK() {
		 this.SubmitButton.click();
		 log.info("SDK is submitted successfully");

	 }
	 
	 public void ClickOnCloseButton() {
		 this.CloseButton.click();
		 log.info("SDK is uploaded");
	 }

	 public boolean listOfsdkTableIsVisible() {
		 this.tableList.isDisplayed();
		 log.info("List of sdk displayed");
		 return true;
	 }
	 
	 public boolean verifyUploadeddSDKIsDisplayed(String SDKName) {
			boolean validationFlag = false;
			 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class ='table sdk-list-table']//tbody//tr//td[1]"));
			 for (WebElement element : allUserNameElements) {
			String sdkNm = element.getText();
			System.out.println(sdkNm);
			if(SDKName.equals(sdkNm)) {
				log.info("SDK is displayed");
				System.out.println(SDKName);
				validationFlag = true;
			}
		}
			  return validationFlag;
	}
	 
	 public boolean sdkUploadedSuccessfullyMesgDisplayed() {
		 this.successmesg.isDisplayed();
		 log.info("SDK created successfully");
		 return true;
		 
	 }
	 
	 public void clickOnCloseButton() {
		 this.closebtn.click();
		 log.info("Clicked on close button");
	 }
	 
	 public void SelectUploadedSDK(String version) {
		 WebElement SelectUploadedSDK = objDriver.findElement(By.xpath("//td[contains(text(),"+version+")]"));
		 SelectUploadedSDK.click();
		 log.info("User Click on uploaded SDK");
	 }
	 
	 public void ClickOnDelete() throws Exception {
		 this.DeleteButton.click();
		 Thread.sleep(2000);
	 }
	 
	 public void ClickOnConfirm() {
		 this.ConfirmButton.click();
		 log.info("SDK is deleted successfully");
		 
	 }
	 
	 public int SizeOfsdkTable() {
		 List<WebElement> rows = objDriver.findElements(By.xpath("//table[@class ='table sdk-list-table']//tbody//tr"));
		  row = rows.size();
		 System.out.println(row);
		return row;
	}
	 
	 public void infoOfDeletedSdk() {
		 String InfoOFSDK = this.deletedSDKinfo.getText();
		 System.out.println(InfoOFSDK);
	 }
	 
	 public void ClickonDownloadButton() throws Exception {
		 this.DownloadButton.click();
		 log.info("SdK is downloaded ");
		 Thread.sleep(3000);
	 }
	 
	 public void ValidateFileDownloaded() {
		 String fileURL = objDriver.getCurrentUrl();
		 String sourceLocation = DownloadButton.getAttribute("a");
	        String fileName = fileURL.substring(fileURL.lastIndexOf('/') + 1);
	        File downloadedFile = new File(System.getProperty("user.dir") + File.separator + fileName);
	        
	        try {
	            URL url = new URL(fileURL);
	            FileUtils.copyURLToFile(url, downloadedFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        objDriver.quit();
}
	 public void DuplicateErrorMsgDisplay() {
		 String DuplicateError = this.DuplicateErrorMsg.getText();
		 System.out.println(DuplicateError);
	 }

 
	 public boolean ErrorMsgDisplayed() {
		 this.ErrorMessage.isDisplayed();
		 log.info("Error message is displayed");
		 return true;
	 }
	 
	 public void ValidateErrorMessage() {
		 String FileErrorMsg = this.FileFormatError.getText();
		 System.out.println(FileErrorMsg);
		 
	 }
	 
	 public boolean ValidateInvalidFileFormat() {
		 this.FileFormatError.isDisplayed();
		 log.info("Validate error message");
		 return true;
	 }

	  
}
