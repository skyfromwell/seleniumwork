package org.shazhou.selenium;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestChrome {
	
	private ChromeDriver driver;
	
	@BeforeTest
	public void setupSelenium(){
		System.setProperty("webdriver.chrome.driver", "/Users/shazhou/Downloads/chromedriver");
		driver = new ChromeDriver();
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