package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class productsPage extends BaseTest {
	

    public productsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"PRODUCTS\")") WebElement producttitle;
	
	public String gettitle() {
		return getAttribute(producttitle,"text");
	}
}


