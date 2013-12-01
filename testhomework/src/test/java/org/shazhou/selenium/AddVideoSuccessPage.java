package org.shazhou.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

import java.util.regex.*;

public class AddVideoSuccessPage {
	
	private WebDriver driver;
	
	private String videoFileName;
	
	private final Pattern msgPattern = Pattern.compile("^Video page (\\w.*?)\\s+was successfully added\\.");
	
	@FindBy(css="div.msg")
	private WebElement msg;
	
	@FindBy(partialLinkText="File:")
	private WebElement videoLink;
	
	public AddVideoSuccessPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getFilenameFromFlashMsg(){
		String msgText = msg.getText();
		if (msgText.startsWith("Video page") && msgText.endsWith("was successfully added.")){
			Matcher match = msgPattern.matcher(msgText);
			if (match.find()){
				videoFileName = match.group(1);
			}
		}
		
		return videoFileName;
	}
	
	public VideoPlayPage clickVideoLink(){
		videoLink.click();
		
		return PageFactory.initElements(driver, VideoPlayPage.class);
	}

}
