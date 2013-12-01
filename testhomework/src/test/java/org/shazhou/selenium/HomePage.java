package org.shazhou.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(css="nav.wikia-menu-button.contribute.secondary.combined")
	private WebElement contributeDrop;
	
	@FindBy(linkText="Add a Video")
	private WebElement addVideoLink;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getLinkUserName(String username){
		
		WebElement linkName = driver.findElement(By.linkText(username));
		
		return linkName.getText();
	}
	
	public AddVideoPage addVideo(){
		contributeDrop.click();
		addVideoLink.click();
		
		return PageFactory.initElements(driver, AddVideoPage.class);
	}
	
	public static HomePage navigateTo(WebDriver driver, String url){
		driver.navigate().to(url);
		
		return PageFactory.initElements(driver, HomePage.class);
	}

}
