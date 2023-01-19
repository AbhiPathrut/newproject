package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import java.time.Duration;

public class E2CO_LoginPage extends PageClass {

    @FindBy(xpath = "//input[@id='floatingInput']")
    private WebElement txtUserName;

    @FindBy(xpath = "//input[@id='floatingPassword']")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;
    
    @FindBy(xpath = "(//span[@class='material-symbols-outlined me-2'])[1]")
    private WebElement userIcon;

    public E2CO_LoginPage(SelfHealingDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password) {
    	enterUserName(userName);
    	enterPassword(password);
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
}
