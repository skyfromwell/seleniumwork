package org.shazhou.selenium;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTestFirefox {
	
	private FirefoxDriver driver;
	
	@BeforeTest
	public void setupSelenium(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
	}
	
	@AfterTest
	public void closeSelenium(){
		driver.close();
		driver.quit();
	}
	
	@Test
	public void login(){
		LoginPage loginPage = LoginPage.navigateTo(driver, "http://testhomework.wikia.com/");
		HomePage homePage = loginPage.login("shazhou", "testtest");
		String linkUsername = homePage.getLinkUserName("Shazhou");
		Assert.assertEquals("Shazhou", linkUsername);
	}
	

}
