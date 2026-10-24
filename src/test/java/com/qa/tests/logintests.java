package com.qa.tests;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.loginPage;
import com.qa.pages.productsPage;

public class logintests extends BaseTest{

	loginPage loginpage;
	productsPage productspage;
	
	@BeforeMethod
	public void beforemethod(Method m) {
		loginpage=new loginPage();
		System.out.println("Method name: "+m);
	}
	
	@Test
	public void invalidusername() {
		loginpage.enterusername("abc");
		loginpage.enterpassword("secret_sauce");
		loginpage.clickloginbutton();
		
		String actualerrortext=loginpage.geterrortext();
		String expectederrortext="Username and password do not match any user in this service.";
		Assert.assertEquals(actualerrortext, expectederrortext);
	}
	
	@Test
	public void invalidpassword() {
		loginpage.enterusername("standard_user");
		loginpage.enterpassword("abc");
		productspage=loginpage.clickloginbutton();
		
		String actualerrortext=loginpage.geterrortext();
		String expectederrortext="Username and password do not match any user in this service.";
		Assert.assertEquals(actualerrortext, expectederrortext);
	}
	
	@Test
	public void successfullogin() {
		loginpage.enterusername("standard_user");
		loginpage.enterpassword("secret_sauce");
		productspage=loginpage.clickloginbutton();
		
		Assert.assertEquals(productspage.gettitle(), "PRODUCTS");
	}
}
