package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAnonymizedPage

extends PageObject
{
	
	@FindBy(
			css=
				".header-user-welcome.logged-in-state")
	private WebElement _UserLoggedInHoverField;
	
	@FindBy(
			linkText=
				"Logout")
	private WebElement _LogoutLink;
	
	
	
	public MyAnonymizedPage(
			WebDriver webDriver)
	{
		
		super(
				webDriver);
		
	}
	
	
	
	public String getUserLoggedInHoverFieldText()
	{
		
		return super.getText(
				_UserLoggedInHoverField);
		
	}
	
	
	
	public LogoutPage logout()
	{
		
		return moveToElementUserLoggedInHoverField().clickLogoutLink();
		
	}
	
	
	
	private MyAnonymizedPage moveToElementUserLoggedInHoverField()
	{
		
		super.moveToElement(
	    		_UserLoggedInHoverField);
		
		
		
		return this;
		
	}
	
	
	
	private LogoutPage clickLogoutLink()
	{
		
		super.click(
				_LogoutLink);
		
		
		
		return instantiateNewLogoutPage();
		
	}
	
	
	
	private LogoutPage instantiateNewLogoutPage()
	{
		
		return new LogoutPage(
				_WebDriver);
		
	}
	
}
