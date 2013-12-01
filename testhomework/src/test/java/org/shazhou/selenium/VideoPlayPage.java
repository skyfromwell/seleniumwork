package org.shazhou.selenium;

import org.openqa.selenium.WebDriver;

import java.util.regex.*;

public class VideoPlayPage {
	
	private WebDriver driver;
	
	private String vedioFileName;
	
	private final Pattern urlPattern = Pattern.compile("^http.*/wiki/(\\w.*)$");
	
	public VideoPlayPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getFileNameFromUrl(){
		String url = driver.getCurrentUrl();
		if (url.startsWith("http:")){
			Matcher match = urlPattern.matcher(url);
			if (match.find()){
				vedioFileName = match.group(1);
			}
		}
		
		return vedioFileName;
	}

}
