package org.shazhou.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

public class AddVideoPage {
	
	private WebDriver driver;
	
	@FindBy(id="wpWikiaVideoAddUrl")
	private WebElement videoField;
	
	@FindBy(css="div.submits > input[type=\"submit\"]")
	private WebElement submitButton;
	
	public AddVideoPage(WebDriver driver){
		this.driver = driver;
	}
	
	public AddVideoSuccessPage addVideo(String url){
		videoField.sendKeys(url);
		submitButton.click();
		
		return PageFactory.initElements(driver, AddVideoSuccessPage.class);
	}

}
