package com.sogeti.automation.test.pageFactory;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import java.util.List;
import java.util.Random;





public class E2CO_UserManagement extends PageClass {
	
	SelfHealingDriver objDriver;
	int row;
//	WebElement tableUser;
//	int previousSize;
//	int newSize;
//	Random rand = new Random();
//	int randomNum = rand.nextInt((row - 5));
	
	@CacheLookup
    @FindBy(xpath="//a[@href='/MEC/userManager/user-list']")
    private WebElement usermanagebttn;
    
    @CacheLookup
    @FindBy(xpath="(//button[normalize-space()='Add New User'])[1]")
    private WebElement addnewuser;
    
    @CacheLookup
    @FindBy(xpath="//input[@id='First_name']")
    private WebElement firstnametext;
    
    @CacheLookup
    @FindBy(xpath="//input[@id='last_name']")
    private WebElement lastnametext;
    
    @FindBy(xpath = "//select[@id='floatingSelect']") 
	private WebElement selectRole;

    @CacheLookup
    @FindBy(xpath="//input[@id='email']")
    private WebElement emailid;
    
    @CacheLookup
    @FindBy(xpath="//input[@id='floatinglogin']")
    private WebElement loginname;
    
    @CacheLookup
    @FindBy(xpath="//input[@id='floatingpassword']")
    private WebElement password;
    
    @CacheLookup
    @FindBy(xpath="//input[@id='floatingRetype']")
    private WebElement retypePassword;
    
    @CacheLookup
    @FindBy(xpath="//input[@id='floatingContact']")
    private WebElement contactno;
    
    @FindBy(xpath = "//select[@id='floatingInvalid']")
	private WebElement maxInvalidAttmpt;
	 
	@FindBy(xpath = "//select[@id='floatingmaxAttempt']")
	private WebElement maxValidity;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement Submitbtn;
    
    @FindBy(xpath = "(//div[@class='user-list-table-title ft-18 ft-wt-500'])[1]")
    private WebElement userdatalist;
    
    @FindBy(xpath = "//span[@id='dropdownMenuButton1']")
    private WebElement userDropDownBtn;
    
    @FindBy(xpath = "//button[normalize-space()='Logout']")
    private WebElement logoutBtn;
    
    @FindBy(xpath = "//table[@class='table custom-table-fixed-layout']")
    private WebElement userdatatable;
    
    @FindBy(xpath = "(//div[contains(text(),'delete')])[9]")
    private WebElement deletebtn;
    
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement confirmbtn;
    
    @FindBy(xpath = "//div[@class='d-flex flex-column align-items-center user-manager-delete-pop-up-container']")
    private WebElement popupMessage;
     
    @FindBy(xpath = "(//div[contains(text(),'lock')])[5]")
    private WebElement lockbtn;
    
    @FindBy(xpath = "//th[normalize-space()='inactive']")
    private WebElement inactivemsg;
    
    
    
    
    
    
    
    
    

	
	 
	public E2CO_UserManagement(SelfHealingDriver driver) {
		super(driver);
		this.objDriver = driver;
		
		 wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
	        PageFactory.initElements(driver, this);
	}

	
	public void usermanagebttn() {
    	this.usermanagebttn.click();
    	log.info("Clicked the user management");
    	
     }
	
	public void userManagementPageLoaded() {
		Assert.assertTrue(userdatalist.isDisplayed());
			
	}
	
	public void addnewuser() {
    	this.addnewuser.click();
    	log.info("Clicked the add new user");
    	
     }
	
	public void firstNameTextIsVisible() {
		Assert.assertTrue(firstnametext.isDisplayed());
		
	}
	public void firstnametext(String FirstName) {
    	this.firstnametext.click();
    	this.firstnametext.sendKeys(FirstName);
    	log.info("Entered first name");
    	
     }
	
	public void lastnametext(String LastName) {
    	this.lastnametext.click();
    	this.lastnametext.sendKeys(LastName);
    	log.info("Entered last name");
    	
     }
	
	public void selectRole(String option) {
        Select select = new Select(selectRole);
        select.selectByVisibleText(option);
        log.info("Role selected");
    }
	
	public void emailid(String EmailId) {
    	this.emailid.click();
    	this.emailid.sendKeys(EmailId);
    	log.info("Entered EmailId");
    	
	}
	
	
	public void loginname(String UserName) {
    	this.loginname.click();
    	this.loginname.sendKeys(UserName);
    	log.info("Entered UserName");
    	
	}
	
	public void password(String Password) {
    	this.password.click();
    	this.password.sendKeys(Password);
    	log.info("Entered Password");
    	
	}
	
	
	public void retypePassword(String RetypePassword) {
    	this.retypePassword.click();
    	this.retypePassword.sendKeys(RetypePassword);
    	log.info("Entered RetypePassword");
    	
	}
	
	public void contactno(String ContactNo) {
    	this.contactno.click();
    	this.contactno.sendKeys(ContactNo);
    	log.info("Entered ContactNo");
    	
	}
	
	public void selectMaxInvdAttpt(String option) {
        Select select = new Select(maxInvalidAttmpt);
        select.selectByVisibleText(option);
        log.info("Max invalid attempt selected");
    }
	
	public void selectMaxValidty(String option) {
        Select select = new Select(maxValidity);
        select.selectByVisibleText(option);
        log.info("Max validity selected");
    }
	
	
	public void clickSubmitBtn() {
		this.Submitbtn.click();
		log.info("Clicked Submit Button");
		
	}
	
	
	public boolean verifyUserCreatedIsDisplayed(String userName) {
		boolean validationFlag = false;
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class=\"table custom-table-fixed-layout\"]//tbody//tr//th[3]"));
		 for (WebElement element : allUserNameElements) {
		String linkText = element.getText();
		System.out.println(linkText);
		if(userName.equals(linkText)) {
			log.info("Created user is displayed");
			validationFlag = true;
		}
	}
		  return validationFlag;
}

	public int SizeOfTable() {
		 List<WebElement> rows = objDriver.findElements(By.xpath("//table[@class=\"table custom-table-fixed-layout\"]//tbody//tr"));
		  row = rows.size();
		 System.out.println(row);
		return row;
	}
	public void inactiveUser() {
		List<WebElement> inactiveUsers = objDriver.findElements(By.xpath("//table[@class=\"table custom-table-fixed-layout\"]//tbody//tr[5]//div[contains(text(),'inactive')])]"));
		for(WebElement userInactive :inactiveUsers ) {
			String UserInactive = userInactive.getText();
			System.out.println(UserInactive);
		}
	}
//	public int previousSize() {
//		 previousSize = SizeOfTable();
//		return previousSize;
//	}
//	public int afterDeleteSize() {
//	int newSize = 	SizeOfTable();
//	return newSize;
//	}
	
	public void userDropDownBtn() {
		this.userDropDownBtn.click();
		log.info("Clicked on user");
		
	}
	
	public void logoutBtn() {
		this.logoutBtn.click();
		log.info("Clicked logout button");
		
	}
	
	public void userdatatable() {
		this.userdatatable.getSize();
		
	}
	
	 public boolean verifyUserManagementIsNotAvailable() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(usermanagebttn));
	            return true;
	        } catch (NoSuchElementException ne) {
	            return false;
	        } catch (Exception e) {
	            log.error("Page not loaded" + e);
	            return false;
	        }
	    }
	
//	public boolean verifyUserManagementIsNotAvailable() {
//		this.usermanagebttn.isDisplayed();
//		return true;
//	}
	 public void deletebtn() {
		 this.deletebtn.click();
		 log.info("Clicked delete button");

	 }
	 
	 public boolean popupMessageIsDispalyed() {
		 this.popupMessage.isDisplayed();
		 return true;
	 }
	 
	 public void confirmbtn() {
		 this.confirmbtn.click();
		 log.info("Clicked confirm button");
	 } 
	 
//	 public void verifyUserIsRemoved() {
//		  if (newSize < previousSize) {
//			    System.out.println("Element deleted successfully");
//			    log.info("Element deleted successfully");
//			} else {
//			    System.out.println("Element not deleted");
//			    log.info("Element not deleted");
//			} 
//	 }

	 public void lockbtn() {
		this.lockbtn.click();
		log.info("Clicked locked button");
		 
	 }

	 public boolean inactivemsg() {
		 this.inactivemsg.isDisplayed();
		 return true;
	 }
}
