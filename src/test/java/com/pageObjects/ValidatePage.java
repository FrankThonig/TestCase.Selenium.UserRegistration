package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ValidatePage

extends PageObject
{
	
	@FindBy(
			id=
				"validate_email_hint")
	private WebElement _ValidateEMailText;

	@FindBy(
			className=
				"header-user-column")
	private WebElement _UserHoverField;

	@FindBy(
			linkText=
				"Logout")
	private WebElement _LogoutLink;
	
	
	
	ValidatePage(
			WebDriver webDriver)
	{
		
		super(
				webDriver);
		
	}
	
	
	
	public String getValidationMessage()
	{
		
		return super.getText(
				_ValidateEMailText);
		
	}
	
	
	
	public LogoutPage logout()
	{
		
		return moveToElementUserHoverField().clickLogoutLink();
		
	}
	
	
	
	private ValidatePage moveToElementUserHoverField()
	{
		
		super.moveToElement(
	    		_UserHoverField);
		
		
		
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
