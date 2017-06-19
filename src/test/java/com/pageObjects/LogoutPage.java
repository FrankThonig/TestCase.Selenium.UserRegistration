package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage

extends PageObject
{

	@FindBy(
			className=
				"bye-text")
	private WebElement _ByeText;
	
	
	
	LogoutPage(
			WebDriver webDriver)
	{
		
		super(
				webDriver);
		
	}
	
	
	
	public String getLoggedOutMessage()
	{
		
		return super.getText(
				_ByeText);
		
	}
	
}
