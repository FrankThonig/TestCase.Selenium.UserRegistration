package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testData.UserIDTestData;

public class RegisterPage

extends PageObject
{
	
	@FindBy(
			id=
				"firstname")
	private WebElement _FirstNameTextField;
	
	@FindBy(
			id=
				"lastname")
	private WebElement _LastNameTextField;
	
	@FindBy(
			id=
				"username")
	private WebElement _UsernameTextField;
	
	@FindBy(
			id=
				"email")
	private WebElement _EMailTextField;
	
	@FindBy(
			id=
				"password")
	private WebElement _PasswordTextField;
	
	@FindBy(
			id=
				"accept_privacy")
	private WebElement _AcceptPrivacyCheckBox;
	
	@FindBy(
			id=
				"register_submit")
	private WebElement _RegisterButton;
	
	
	
	public RegisterPage(
			WebDriver webDriver)
	{
		
		super(
				webDriver);
		
	}
	
	
	
	public ValidatePage fillOutAndExecuteRegistration(
			UserIDTestData userIDTestData)
	{
		
		return clearFirstNameTextFieldAndEnterFirstName(
				userIDTestData).clearLastNameTextFieldAndEnterLastName(
						userIDTestData).clearUsernameTextFieldAndEnterUsername(
								userIDTestData).clearEMailTextFieldAndEnterEMailAddress(
										userIDTestData).clearPasswordTextFieldAndEnterPassword(
												userIDTestData).setAcceptPrivacyCheckBoxToStateSelected().clickRegisterButton();
		
	}
	
	
	
	private RegisterPage clearFirstNameTextFieldAndEnterFirstName(
			UserIDTestData userIDTestData)
	{
		
		clearTextFieldAndEnterText(
	    		_FirstNameTextField,
	    		userIDTestData.FirstName);
		
		
		
		return this;
		
	}
	
	
	
	private RegisterPage clearLastNameTextFieldAndEnterLastName(
			UserIDTestData userIDTestData)
	{
		
		clearTextFieldAndEnterText(
	    		_LastNameTextField,
	    		userIDTestData.LastName);
		
		
		
		return this;
		
	}
	
	
	
	private RegisterPage clearUsernameTextFieldAndEnterUsername(
			UserIDTestData userIDTestData)
	{
		
		clearTextFieldAndEnterText(
	    		_UsernameTextField,
	    		userIDTestData.Username);
		
		
		
		return this;
		
	}
	
	
	
	private RegisterPage clearEMailTextFieldAndEnterEMailAddress(
			UserIDTestData userIDTestData)
	{
		
		clearTextFieldAndEnterText(
	    		_EMailTextField,
	    		userIDTestData.EMailAddress);
		
		
		
		return this;
		
	}
	
	
	
	private RegisterPage clearPasswordTextFieldAndEnterPassword(
			UserIDTestData userIDTestData)
	{
		
		clearTextFieldAndEnterText(
	    		_PasswordTextField,
	    		userIDTestData.Password);
		
		
		
		return this;
		
	}
	
	
	
	private RegisterPage setAcceptPrivacyCheckBoxToStateSelected()
	{
		
		super.setElementToStateSelected(
				_AcceptPrivacyCheckBox);
		
		
		
		return this;
		
	}
	
	
	
	private ValidatePage clickRegisterButton()
	{
		
		super.pressReturnKey(
				_RegisterButton);
		
		
		
		return instantiateNewValidatePage();
		
	}
	
	
	
	protected RegisterPage clearTextFieldAndEnterText(
			WebElement webElement,
			String text)
	{
		
		super.clearTextFieldAndEnterText(
				webElement,
				text);
		
		
		
		return this;
		
	}
	
	
	
	private ValidatePage instantiateNewValidatePage()
	{
		
		return new ValidatePage(
				_WebDriver);
		
	}
	
}
