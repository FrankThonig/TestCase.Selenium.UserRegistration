package com.util.webElement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

class WebElementActions
{
	
	static void setElementToStateSelected(
			WebElement webElement)
	{
		
		if(webElement!=null)
		{
			
			if(!isSelected(
					webElement))
			{
				
				click(
						webElement);
				
			}
			
		}
		
	}
	
	
	
	static void moveToElement(
			WebDriver webdriver,
			WebElement webElement)
	{
		
		if(webElement!=null)
		{
			
			Actions action=
					new Actions(
							webdriver);
			
			action.moveToElement(
					webElement).perform();
			
		}
		
	}
	
	
	
	static void clear(
			WebElement webElement)
	{
		
		if(webElement!=null)
		{
			
			webElement.clear();
			
		}
		
	}
	
	
	
	static void sendKeys(
			WebElement webElement,
			String keysToSend)
	{
		
		if(webElement!=null)
		{
			
			webElement.sendKeys(
					keysToSend);
			
		}
		
	}
	
	
	
	static void click(
			WebElement webElement)
	{
		
		if(webElement!=null)
		{
		    
			webElement.click();
			
		}
		
	}
	
	
	
	static void sendReturnKey(
			WebElement webElement)
	{
		
		sendKeys(
			webElement,
			Keys.RETURN);
		
	}
	
	private static void sendKeys(
			WebElement webElement,
			CharSequence key)
	{
		
		if(webElement!=null)
		{

			webElement.sendKeys(
					key);
			
		}
		
	}
	
	
	
	private static Boolean isSelected(
			WebElement webElement)
	{
		
		return webElement!=null?
				webElement.isSelected():
				null;
		
	}
	
	
	
	static String getText(
			WebElement webElement)
	{
		
		return webElement!=null?
				webElement.getText():
				null;
		
	}
	
}
