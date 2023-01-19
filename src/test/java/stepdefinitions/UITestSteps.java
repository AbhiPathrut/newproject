package stepdefinitions;

import com.sogeti.automation.framework.basetest.TestClass;
import com.sogeti.automation.framework.basetest.TestContext;

import com.sogeti.automation.test.pageFactory.SwagLabsDemo_LoginPage;
import com.sogeti.automation.test.pageFactory.SwagLabsDemo_ProductsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

public class UITestSteps extends TestClass {

    TestContext testContext;
    SwagLabsDemo_LoginPage swagLabsDemoLoginPage;
    SwagLabsDemo_ProductsPage swagLabsDemo_productsPage;

    public UITestSteps(TestContext context) throws Exception {
//        super();
        this.testContext = context;
        swagLabsDemoLoginPage = testContext.getPageObjectManager().getSwagLabsDemo_LoginPage();
        swagLabsDemo_productsPage = testContext.getPageObjectManager().getSwagLabsDemo_ProductsPage();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    /*@Given("^user opens Konakart application in browser$")
    public void openGoogle() throws InterruptedException {
        Thread.sleep(5000);
    }*/

    @Given("^user logs into SwagLabs portal(.*) and (.*)")
    public void swagLabsLogin(String UI_USERNAME, String UI_Password ) {
        //swagLabsDemoLoginPage.login(Web.UI_USERNAME, Web.UI_PASSWORD);
    	swagLabsDemoLoginPage.login(UI_USERNAME, UI_Password);
        Assert.assertTrue(swagLabsDemo_productsPage.isProductsTitleVisible(),
                "Products page did not load. LOGIN FAILED");
    }

    @When("^user is on Products page$")
    public void isProductsPageLoaded() {
        Assert.assertTrue(swagLabsDemo_productsPage.isProductsTitleVisible(),
                "Products page did not load.");
    }

    @Then("^verify that price of (.*) is (.*)")
    public void verifyProductPrice(String productName, String productPrice) {
        String actualProductName = swagLabsDemo_productsPage.getProductName(productName);
        String actualProductPrice = swagLabsDemo_productsPage.getProductPrice(productName);

        Assert.assertEquals(actualProductName, productName, "Actual Product Name does not match expected value.");
        Assert.assertEquals(actualProductPrice, productPrice,
                "Price of product '" + productName + "' does not match expected value.");
    }
    
    @And("^user adds item to cart$")
    public void verifyProductIsaddedInCart() {
    	swagLabsDemo_productsPage.ClickItem();
    	}
    
    @And("^user click cart icon$")
    public void cartButtonIsClicked() {
    	swagLabsDemo_productsPage.ClickCartButton();
    }
    
    @Then("^item should be listed")
    public void isElementDisplayed() {
    	
    	
//    	 String actualProductName = swagLabsDemo_productsPage.getProductName(productName);
//    	 
//    	 System.out.println(actualProductName);
//    	 Assert.assertEquals(true, true, "Actual Product Name is matched  with expected value.");
//    	String actualitemName = swagLabsDemo_productsPage.getItemName(itemName);
    	//System.out.println(testEnvironment);
    	//Assert.assertEquals(actualitemName, itemName, "Actual Product Name is matched with expected value.");
//    	boolean isDisplayed = itemName.isDisplayed();
    	  // Create instance of page object and check if element is displayed
    	  
    	  //boolean isElementDisplayed = swagLabsDemo_productsPage.isElementDisplayed();
    	  
    	  // Use BDD framework's assertThat method to assert that element is displayed
    	  Assert.assertTrue(swagLabsDemo_productsPage.isElementDisplayed(), "The item is added to list.");
    	  
    	  // Close WebDriver instance
    

    	

    	
    }
    
}
