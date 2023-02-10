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
	String DeletedUserName;
	String LockedUserName;

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
    
//    @FindBy(xpath = "(//div[@class='material-symbols-outlined cursor-pt'][normalize-space()='delete'])[6]")
//    private WebElement deletebtn;
    
    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    private WebElement confirmbtn;
    
    @FindBy(xpath = "//div[@class='d-flex flex-column align-items-center user-manager-delete-pop-up-container']")
    private WebElement popupMessage;
     
//    @FindBy(xpath = "(//div[contains(text(),'lock')])[5]")
//    private WebElement lockbtn;
    
    @FindBy(xpath = "//th[normalize-space()='inactive']")
    private WebElement inactivemsg;
    
    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-success-dialog-box/div/button")
    WebElement closebtn;
    
//    @FindBy(xpath = "//div[@class='login-content border-radius-10 bg-white']")
//    WebElement loginBorder;
    
    @FindBy(xpath = "//div[@class='text-critical ft-13']")
    WebElement ErrorMessage;
    
    
    
    
    
    
    

	
	 
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
    	//Thread.sleep(2000);
    	log.info("Clicked the add new user");
    	
     }
	
	public void firstNameTextIsVisible() {
		Assert.assertTrue(firstnametext.isDisplayed());
		
	}
	public void firstnametext(String FirstName) {
    	this.firstnametext.click();
    	//Thread.sleep(2000);
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
    	//this.emailid.click();
    	this.emailid.sendKeys(EmailId);
    	log.info("Entered EmailId");
    	
	}
	
	
	public void loginname(String UserName) {
    	//this.loginname.click();
    	this.loginname.sendKeys(UserName);
    	log.info("Entered UserName");
    	
	}
	
	public void password(String Password) {
    	//this.password.click();
    	this.password.sendKeys(Password);
    	log.info("Entered Password");
    	
	}
	
	
	public void retypePassword(String RetypePassword) {
    	//this.retypePassword.click();
    	this.retypePassword.sendKeys(RetypePassword);
    	log.info("Entered RetypePassword");
    	
	}
	
	public void contactno(String ContactNo) {
    	//this.contactno.click();
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
	
	public void clickOnClose() {
		this.closebtn.click();
		log.info("Clicked popup message of user created successfully");
	}
	
	
	public boolean verifyUserCreatedIsDisplayed(String userName) {
		boolean validationFlag = false;
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class=\"table custom-table-fixed-layout\"]//tbody//tr//th[3]"));
		 for (WebElement element : allUserNameElements) {
		String linkText = element.getText();
		System.out.println(linkText);
		if(userName.equals(linkText)) {
			log.info("User is displayed");
			validationFlag = true;
		}
	}
		  return validationFlag;
}
	

	public int SizeOfTable() {
		 List<WebElement> rows = objDriver.findElements(By.xpath("//table[@class='table custom-table-fixed-layout']//tbody//tr"));
		  row = rows.size();
		 System.out.println(row);
		return row;
	}
	
	
	public void inactiveUser() {
		List<WebElement> inactiveUsers = objDriver.findElements(By.xpath("//table[@class=\"table custom-table-fixed-layout\"]//tbody//(//th[@class='ft-wt-400'][normalize-space()='inactive'])"));
		for(WebElement userInactive :inactiveUsers ) {
			String UserInactive = userInactive.getText();
			System.out.println(UserInactive);
		}
	}
	
	
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
	
	 
	 public void deletebtn() {
		 Random rand = new Random();
		int randomNum = rand.nextInt((row - 1));
		if (randomNum==0){          
			randomNum= randomNum+2;
			}
		System.out.println(randomNum);
		WebElement userNameDeleted = objDriver.findElement(By.xpath("//table[@class='table custom-table-fixed-layout']//tbody//tr["+ randomNum+"]//th[3]"));
		DeletedUserName = userNameDeleted.getText();
		 WebElement deletebtn= objDriver.findElement(By.xpath("(//div[@class='material-symbols-outlined cursor-pt'][normalize-space()='delete'])["+ randomNum +"]"));
		 deletebtn.click();
		 log.info("Clicked delete button");
		 System.out.println(DeletedUserName);
	 }
	 
	 
	 
	 public boolean verifyDeletedRowIsNotPresentInTable() {
		 boolean validationFlag = false;
		 List<WebElement> allUserNameElements = objDriver.findElements(By.xpath("//table[@class=\"table custom-table-fixed-layout\"]//tbody//tr//th[3]"));
		 for (WebElement element : allUserNameElements) {
		String linkText = element.getText();
		if(DeletedUserName != (linkText)) {
			log.info("User is not displayed");
			validationFlag = true;
		}
	}
		  return validationFlag;
	 }
	 
	 
	 
	 public boolean popupMessageIsDispalyed() {
		 this.popupMessage.isDisplayed();
		 return true;
	 }
	 
	 
	 
	 public void confirmbtn() {
		 this.confirmbtn.click();
		 log.info("Clicked confirm button");
	 } 
	 
	 
	 public void lockbtn() {
		 Random rand = new Random();
			int randomNum = rand.nextInt((row - 1));
			if (randomNum==0){          
				randomNum= randomNum+2;
				}
			System.out.println(randomNum);
			WebElement UserNamelocked = objDriver.findElement(By.xpath("//table[@class='table custom-table-fixed-layout']//tbody//tr["+ randomNum+"]//th[3]"));
			 LockedUserName = UserNamelocked.getText();
			 WebElement lockbtn= objDriver.findElement(By.xpath("(//div[contains(text(),'lock')])["+randomNum+"]"));
			 lockbtn.click();
			 log.info("Clicked locked button");
			 System.out.println(LockedUserName); 
	 }
	 
	 

	 public boolean inactivemsg() {
		 this.inactivemsg.isDisplayed();
		 return true;
	 }
	 
	 
	 
	 public void verifyLockedUserIsNotAbleToLogin() throws Exception {
		 E2CO_LoginPage e2co_LoginPage = new E2CO_LoginPage(objDriver);
		e2co_LoginPage.enterUserName(LockedUserName);
		e2co_LoginPage.enterPassword("Admin@1234");
		e2co_LoginPage.clickLoginBtn(); 
		
		String expectedErrorMessage = "Please contact admin user is inactive";
		
		String actualErrorMessage = ErrorMessage.getText();
		
		 //System.out.println(actualErrorMessage);
		
		 //Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		 
		 if(actualErrorMessage.equals(expectedErrorMessage)) {
			 log.info("User is inactivated");
		 }else {
			 log.info("User is active");
		 }
		 
		}	

}
