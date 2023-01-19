package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
    SelfHealingDriver healingDriver;
    PageClass pageClass;
    SwagLabsDemo_LoginPage swagLabsDemoLoginPage;
    SwagLabsDemo_ProductsPage swagLabsDemo_productsPage;
    SelfHealDemoPage selfHealDemoPage;
    E2CO_LoginPage e2co_loginpage;
    E2CO_UserManagement e2co_usermanagement;

    public PageObjectManager(SelfHealingDriver driver) {
        this.healingDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageClass getCommonPage() {
        return((pageClass == null) ? pageClass = new PageClass(healingDriver) : pageClass);
    }

    public SwagLabsDemo_LoginPage getSwagLabsDemo_LoginPage() {
        return (swagLabsDemoLoginPage == null) ? swagLabsDemoLoginPage = new SwagLabsDemo_LoginPage(healingDriver) : swagLabsDemoLoginPage;
    }

    public SwagLabsDemo_ProductsPage getSwagLabsDemo_ProductsPage() {
        return (swagLabsDemo_productsPage == null) ? swagLabsDemo_productsPage = new SwagLabsDemo_ProductsPage(healingDriver) : swagLabsDemo_productsPage;
    }

    public SelfHealDemoPage getSelfHealDemoPage() {
        return (selfHealDemoPage == null) ? selfHealDemoPage = new SelfHealDemoPage(healingDriver) : selfHealDemoPage;
    }
    public E2CO_LoginPage getE2CO_LoginPage() {
        return (e2co_loginpage == null) ? e2co_loginpage = new E2CO_LoginPage(healingDriver) : e2co_loginpage;
    }
    
    public E2CO_UserManagement getE2CO_UserManagement() {
        return (e2co_usermanagement == null) ? e2co_usermanagement = new E2CO_UserManagement(healingDriver) : e2co_usermanagement;
    }
}
