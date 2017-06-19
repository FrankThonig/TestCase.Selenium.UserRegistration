package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage

extends PageObject
{

	@FindBy(
			className=
				"header-user-column")
	private WebElement _UserHoverField;

	@FindBy(
			linkText=
				"Login")
	private WebElement _LoginLink;

	@FindBy(
			linkText=
				"Register")
	private WebElement _RegisterLink;
	
	
	
	public StartPage(
			WebDriver webDriver)
	{
		
		super(
				webDriver);
		
	}
	
	
	
	public RegisterPage navigateToRegisterPage()
	{
		
		return moveToElementUserHoverField().clickRegisterLink();
		
	}
	
	
	
	public LoginPage navigateToLoginPage()
	{
		
		return moveToElementUserHoverField().clickLoginLink();
		
	}
	
	
	
	private StartPage moveToElementUserHoverField()
	{
		
		super.moveToElement(
	    		_UserHoverField);
		
		
		
		return this;
		
	}
	
	
	
	private RegisterPage clickRegisterLink()
	{

		super.click(
				_RegisterLink);
		
		
		
		return instantiateNewRegisterPage();
		
	}
	
	
	
	private LoginPage clickLoginLink()
	{
		
		super.click(
				_LoginLink);
		
		
		
		return instantiateNewLoginPage();
		
	}
	
	
	
	private RegisterPage instantiateNewRegisterPage()
	{
		
		return new RegisterPage(
				_WebDriver);
		
	}
	
	
	
	private LoginPage instantiateNewLoginPage()
	{
		
		return new LoginPage(
				_WebDriver);
		
	}
	
}
