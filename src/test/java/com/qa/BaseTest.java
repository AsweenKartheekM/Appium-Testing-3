package com.qa;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	protected static AppiumDriver driver;
	protected Properties p;
	InputStream inputstream;
	@Parameters({"platformName","platformVersion"})
	@BeforeTest
	public void beforetest(String platformName, String platformVersion) throws IOException {
		try {
			String filename="config.properties";
			inputstream=getClass().getClassLoader().getResourceAsStream(filename);
			p=new Properties();
			p.load(inputstream);
			UiAutomator2Options options=new UiAutomator2Options();
			options.setPlatformName(platformName);
			options.setPlatformVersion(platformVersion);
			options.setAutomationName(p.getProperty("androidAutomationName"));
			options.setUdid("RZCT40WK0VR");
			options.setAppPackage(p.getProperty("androidAppPackage"));
			options.setAppActivity(p.getProperty("androidAppActivity"));
			URL url=URI.create(p.getProperty("appiumURL")).toURL();
			driver=new AndroidDriver(url,options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public void waitForVisibility(WebElement e) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(TestUtils.wait));
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void click(WebElement e) {
		waitForVisibility(e);
		e.click();
	}
	
	public void sendKeys(WebElement e, String key) {
		waitForVisibility(e);
		e.sendKeys(key);
	}
	
	public String getAttribute(WebElement e, String value) {
		waitForVisibility(e);
		return e.getAttribute(value);
	} 
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
