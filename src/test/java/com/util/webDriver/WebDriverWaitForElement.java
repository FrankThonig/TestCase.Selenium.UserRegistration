package com.util.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitForElement
{
	
	public static void waitForElementOnce(
			WebDriver webDriver,
			WebElement webElement,
			int maxWaitingTimeForLoadingWebElementInSeconds)
	{

	    new WebDriverWait(
	    		webDriver,
	    		maxWaitingTimeForLoadingWebElementInSeconds).until(
	    				ExpectedConditions.visibilityOf(
	    						webElement));
		
	}
	
}
