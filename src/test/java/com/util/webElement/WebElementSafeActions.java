package com.util.webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.webDriver.WebDriverWaitForElement;

public class WebElementSafeActions
{
	
	public static void safeSetElementToStateSelected(
			WebDriver webDriver,
			WebElement webElement,
			int maxWaitingTimeForLoadingWebElementInSeconds)
	{
		
		WebDriverWaitForElement.waitForElementOnce(
				webDriver,
				webElement,
	    		maxWaitingTimeForLoadingWebElementInSeconds);
		
		WebElementActions.setElementToStateSelected(
				webElement);
		
	}
	
	
	
	public static void safeMoveToElement(
			WebDriver webDriver,
			WebElement webElement,
			int maxWaitingTimeForLoadingWebElementInSeconds)
	{
		
		WebDriverWaitForElement.waitForElementOnce(
				webDriver,
				webElement,
	    		maxWaitingTimeForLoadingWebElementInSeconds);
		
		WebElementActions.moveToElement(
				webDriver,
				webElement);
		
	}
	
	
	
	public static void safeClear(
			WebDriver webDriver,
			WebElement webElement,
			int maxWaitingTimeForLoadingWebElementInSeconds)
	{
		
		WebDriverWaitForElement.waitForElementOnce(
				webDriver,
				webElement,
	    		maxWaitingTimeForLoadingWebElementInSeconds);
		
		WebElementActions.clear(
				webElement);
		
	}
	
	
	
	public static void safeSendKeys(
			WebDriver webDriver,
			WebElement webElement,
			int maxWaitingTimeForLoadingWebElementInSeconds,
			String keysToSend)
	{
		
		WebDriverWaitForElement.waitForElementOnce(
				webDriver,
				webElement,
	    		maxWaitingTimeForLoadingWebElementInSeconds);
		
		WebElementActions.sendKeys(
				webElement,
				keysToSend);
		
	}
	
	
	
	public static void safeClick(
			WebDriver webDriver,
			WebElement webElement,
			int maxWaitingTimeForLoadingWebElementInSeconds)
	{
		
		WebDriverWaitForElement.waitForElementOnce(
	    		webDriver,
	    		webElement,
	    		maxWaitingTimeForLoadingWebElementInSeconds);
	    
		WebElementActions.click(
				webElement);
		
	}
	
	
	
	public static void safeSendReturnKey(
			WebDriver webDriver,
			WebElement webElement,
			int maxWaitingTimeForLoadingWebElementInSeconds)
	{
		
		WebDriverWaitForElement.waitForElementOnce(
	    		webDriver,
	    		webElement,
	    		maxWaitingTimeForLoadingWebElementInSeconds);
	    
		WebElementActions.sendReturnKey(
				webElement);
		
	}
	

	
	public static String safeGetText(
			WebDriver webDriver,
			WebElement webElement,
			int maxWaitingTimeForLoadingWebElementInSeconds)
	{
		
		WebDriverWaitForElement.waitForElementOnce(
	    		webDriver,
	    		webElement,
	    		maxWaitingTimeForLoadingWebElementInSeconds);
	    
		
		
		return WebElementActions.getText(
				webElement);
		
	}
	
}
