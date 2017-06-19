package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testData.UserIDTestData;

public class LoginPage

extends PageObject
{
	
	@FindBy(
			id=
				"username")
	private WebElement _UsernameTextField;
	
	@FindBy(
			id=
				"login_credentials_password")
	private WebElement _PasswordTextField;
	
	@FindBy(
			id=
				"login_submit")
	private WebElement _LoginButton;
	
	
	
	public LoginPage(
			WebDriver webDriver)
	{
		
		super(
				webDriver);
		
	}
	
	
	
	public MyAnonymizedPage login(
			UserIDTestData userIDTestData)
	{
		
		return clearUsernameTextFieldAndEnterUsername(
				userIDTestData).clearPasswordTextFieldAndEnterPassword(
						userIDTestData).clickLoginButton();
		
	}
	
	
	
	private LoginPage clearUsernameTextFieldAndEnterUsername(
			UserIDTestData userIDTestData)
	{
		
		super.clearTextFieldAndEnterText(
	    		_UsernameTextField,
	    		userIDTestData.Username);
		
		
		
		return this;
		
	}
	
	
	
	private LoginPage clearPasswordTextFieldAndEnterPassword(
			UserIDTestData userIDTestData)
	{
		
		super.clearTextFieldAndEnterText(
	    		_PasswordTextField,
	    		userIDTestData.Password);
		
		
		
		return this;
		
	}
	
	
	
	private MyAnonymizedPage clickLoginButton()
	{
		
		super.click(
				_LoginButton);
		
		
		
		return instantiateNewMyAnonymizedPage();
		
	}
	
	
	
	private MyAnonymizedPage instantiateNewMyAnonymizedPage()
	{
		
		return new MyAnonymizedPage(
				_WebDriver);
		
	}
	
}
