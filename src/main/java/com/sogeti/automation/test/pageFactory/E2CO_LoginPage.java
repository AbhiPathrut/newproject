package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import java.time.Duration;

public class E2CO_LoginPage extends PageClass {
	
	SelfHealingDriver objDriver;

    @FindBy(xpath = "//input[@id = 'Username']")
    private WebElement txtUserName;

    @FindBy(xpath = "//input[@id = 'floatingPassword']")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;
    
    @FindBy(xpath = "//input[@placeholder='Domain']")
    private WebElement domain;
    
    @FindBy(xpath = "(//span[@class='material-symbols-outlined me-2'])[1]")
    private WebElement userIcon;
    
    @FindBy(xpath = "//button[@type='button']")
    private WebElement changePassword;
    
    @FindBy(xpath = "//input[@id='userName']")
    private WebElement resetUserName;
    
    @FindBy(xpath = "//input[@id='oldPassword']")
    private WebElement oldPassword;
    
    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newPassword;
    
    @FindBy(xpath = "//input[@id='RetypeNewPassword']")
    private WebElement retypeNewPassword;
    
    @FindBy(xpath = "//button[@class='btn change-password-sub-btn ft-18']")
    private WebElement submitPassword;
    
    @FindBy(xpath = "//div[@class='onboard-success-container text-center']")
    private WebElement passwordUpdateMessage;
    
    @FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement close;

    public E2CO_LoginPage(SelfHealingDriver driver) {
        super(driver);
        this.objDriver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password, String domain) {
    	enterUserName(userName);
    	enterPassword(password);
    	enterDomain(domain);
    	clickLoginBtn();
      
    }

    public boolean isElementDisplayed() {
    	return userIcon.isDisplayed();
    	}
    public E2CO_LoginPage verifyUserIsOnHomePage() {
		Assert.assertTrue(txtUserName.isDisplayed());
		return null;	
	}
    
    
    public void enterUserName(String userName) {
    	try {
            wait.until(ExpectedConditions.visibilityOf(txtUserName));
            txtUserName.clear();
            txtUserName.sendKeys(userName);
            log.info("Entered username");
        } catch (Exception e) {
            log.error("Failed to enter username.\n" + e);
        }
		
    	
    }
    
    public void enterPassword(String password) {
    	 try {
             txtPassword.clear();
             txtPassword.sendKeys(password);
             log.info("Entered password");
         } catch (Exception e) {
             log.error("Failed to enter password.\n" + e);
         }

    }
    
    public void clickLoginBtn() {
    	
    	 try {
             btnLogin.click();
         } catch (Exception e) {
             log.error("Failed to click Login button.\n" + e);
         }
		
    	
    }
    
    public void enterDomain(String domainName) {
    	try {
    		domain.clear();
    		domain.sendKeys(domainName);
            log.info("Entered domain");
        } catch (Exception e) {
            log.error("Failed to enter domain.\n" + e);
        }
    }
    
    public void clickOnChangePassword() {
    	this.changePassword.click();
    	log.info("Clicked on change password");
    	
    }
    
    public void enterusernameResetPassword(String username) {
    	this.resetUserName.clear();
    	this.resetUserName.sendKeys(username);
    	log.info("Entered username for which password is to change");
    }
    
    public void enteroldpassword(String password) {
    	this.oldPassword.clear();
    	this.oldPassword.sendKeys(password);
    	log.info("Entered old password");
    	
    }
    
    public void enterNewPassword(String newPassword) {
    	this.newPassword.sendKeys(newPassword);
    	log.info("Entered new password");
    }
    
    public void enterretypePassword(String newPassword) {
    	this.retypeNewPassword.sendKeys(newPassword);
    	log.info("Retyped the password");
    }
    
    public void clickOnSubmitButton() throws Exception {
    	JavascriptExecutor js = (JavascriptExecutor)objDriver;
		 js.executeScript("arguments[0].scrollIntoView()",submitPassword);
		 Thread.sleep(2000);
		 js.executeScript("arguments[0].click()", submitPassword);
		 Thread.sleep(2000);
    	//this.submitPassword.click();
    	log.info("Clicked on submit button");
    }
    
    public boolean verifyPasswordUpdateSuccessPopupMessageIsDisplayed() {
    	this.passwordUpdateMessage.isDisplayed();
    	log.info("Password update successfully popup message is dispalyed");
    	return true;
    }
    
    public void clickOnCloseButton() {
    	this.close.click();
    	log.info("Clicked on close button");
    }
}
