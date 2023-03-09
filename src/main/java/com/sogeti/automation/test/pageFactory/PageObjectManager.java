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
    E2CO_EdgesPage e2co_edgespage;
    E2CO_ZonesPage e2co_zonespage;
    E2CO_MyApplicationPage e2co_myapplication;
    E2CO_SDKPage e2co_sdkpage;
    E2CO_TrobleshootPage e2co_trobleshootpage;
    
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
    
    public E2CO_EdgesPage geE2co_EdgesPage() {
    	return((e2co_edgespage == null)? e2co_edgespage = new E2CO_EdgesPage(healingDriver) : e2co_edgespage);
    }
    public E2CO_ZonesPage gete2co_zonespage() {
    	return ( e2co_zonespage == null) ?  e2co_zonespage = new E2CO_ZonesPage(healingDriver) : e2co_zonespage;
    	
    }
    
    public E2CO_MyApplicationPage gete2co_myapplication() {
    	return ( e2co_myapplication == null) ?  e2co_myapplication = new E2CO_MyApplicationPage(healingDriver) : e2co_myapplication;
    	
    }
    
    public E2CO_SDKPage gete2co_sdkpage() {
    	return ( e2co_sdkpage == null) ?  e2co_sdkpage = new E2CO_SDKPage(healingDriver) : e2co_sdkpage;
    	
    }
    
    public E2CO_TrobleshootPage gete2co_trobleshootpage() {
    	return ( e2co_trobleshootpage == null) ?  e2co_trobleshootpage = new E2CO_TrobleshootPage(healingDriver) : e2co_trobleshootpage;
    	
    }
    
}
