package org.shazhou.selenium;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddVideoTestFirefox {

	private FirefoxDriver driver;
	
	@BeforeTest
	public void setupSelenium(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		LoginPage loginPage = LoginPage.navigateTo(driver, "http://testhomework.wikia.com/");
		loginPage.login("shazhou", "testtest");	
	}
	
	@AfterTest
	public void closeSelenium(){
		driver.close();
		driver.quit();
	}
	
	@Test
	public void addVideo(){
		
		HomePage homepage = HomePage.navigateTo(driver, "http://testhomework.wikia.com/");
		AddVideoPage addVideoPage = homepage.addVideo();
		AddVideoSuccessPage successPage = addVideoPage.addVideo("http://www.youtube.com/watch?v=1QiN6a73Sf4");
		String videoFile = successPage.getFilenameFromFlashMsg();
		VideoPlayPage playPage = successPage.clickVideoLink();
		String playFile = playPage.getFileNameFromUrl();
		Assert.assertEquals(videoFile, playFile.replace("_", " "));
	}
	

}
