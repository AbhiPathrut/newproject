package com.sogeti.automation.test.pageFactory;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;

public class E2CO_EnterprisePage extends PageClass {
	

	public E2CO_EnterprisePage(SelfHealingDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
	}
	

}
