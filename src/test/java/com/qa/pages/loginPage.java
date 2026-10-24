package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class loginPage extends BaseTest {
	

    public loginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	
	@AndroidFindBy(accessibility="test-Username") WebElement username;
	@AndroidFindBy(xpath="//android.widget.EditText[@content-desc='test-Password']") WebElement password;
	@AndroidFindBy(accessibility="test-LOGIN") WebElement loginbutton;
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Username and password do not match')]") WebElement errormsg;
	
	public loginPage enterusername(String key) {
		sendKeys(username,key);
		return this;
	} 
	
	public loginPage enterpassword(String Password) {
		sendKeys(password,Password);
		return this;
	} 
	
	public productsPage clickloginbutton() {
		click(loginbutton);
		return new productsPage();
	} 
	
	public String geterrortext() {
		return getAttribute(errormsg,"text");
	}
}