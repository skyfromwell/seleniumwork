package org.shazhou.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(linkText="Log in")
	private WebElement loginLink;
	
	@FindBy(name="username")
	private WebElement userNameField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(css="input.login-button")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public static LoginPage navigateTo(WebDriver driver, String url){
		driver.get(url);
		
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public HomePage login(String username, String password){
		loginLink.click();
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		
		return PageFactory.initElements(driver, HomePage.class);
	}

}
