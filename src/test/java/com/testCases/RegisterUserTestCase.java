package com.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assertData.LogoutPageAssertData;
import com.assertData.MyAnonymizedPageAssertData;
import com.assertData.ValidatePageAssertData;
import com.factories.WebDriverManager;
import com.factories.WebDriverManagerFactory;
import com.pageObjects.LogoutPage;
import com.pageObjects.MyAnonymizedPage;
import com.pageObjects.StartPage;
import com.pageObjects.ValidatePage;
import com.testData.ConstantPageTestData;
import com.testData.DynamicTestData;
import com.testData.UserIDTestData;
import com.util.misc.string.StringContent;
import com.util.webDriver.WebDriverNavigate;

public class RegisterUserTestCase
{

    private WebDriverManagerFactory _WebDriverManagerFactory;
    private WebDriverManager _WebDriverManager;
    private WebDriver _WebDriver;

    
    
    public RegisterUserTestCase()
    {
    	
    	_WebDriverManagerFactory=
    			new WebDriverManagerFactory();
    	
    }
    
    
    
    @BeforeMethod
	public void beforeMethod()
    {
		
		_WebDriverManager=
				_WebDriverManagerFactory.createWebDriverManager();
		
    	if(_WebDriverManager!=null)
    	{
    		
    		_WebDriver=
    				_WebDriverManager.createWebDriver();
        	
    	}
    	
    }

    
    
    @AfterMethod
	public void afterMethod()
    {
    	
    	if(_WebDriverManager!=null)
    	{
    		
        	_WebDriverManager.quitWebDriver();
        	
    	}
    	
    }
    
    
    
	@Test(
			dataProvider=
				"testData",
			dataProviderClass=
				DynamicTestData.class)
	public void testRegisterUserAndLoginAndLogout(
			UserIDTestData userIDTestData)
	{
    	
		WebDriverNavigate.navigateToURL(
				_WebDriver,
				ConstantPageTestData.StartPageURL);
		
		ValidatePage validatePage=
				new StartPage(
						_WebDriver).navigateToRegisterPage().fillOutAndExecuteRegistration(
								userIDTestData);
		
		
		
		String displayedRegistrationValidationMessage=
				validatePage.getValidationMessage();
		
		String expectedRegistrationValidationMessage=
				assembleExpectedRegistrationValidationMessage(
						userIDTestData);
		
		Assert.assertTrue(
				isDisplayedRegistrationValidationMessageCorrect(
						expectedRegistrationValidationMessage,
						displayedRegistrationValidationMessage),
				"\n" +
				"Displayed registration validation message is not correct.\n" +
				"Expected registration validation message:\n" +
				expectedRegistrationValidationMessage +
				"\n" +
				"Displayed registration validation message:\n" +
				displayedRegistrationValidationMessage +
				"\n");
		
		
		
		LogoutPage logoutPage=
				validatePage.logout();
		
		String displayedLoggedOutMessage=
				logoutPage.getLoggedOutMessage();
		
		String expectedLoggedOutMessage=
				assembleExpectedLoggedOutMessage();
		
		Assert.assertTrue(
				isDisplayedLoggedOutMessageCorrect(
						expectedLoggedOutMessage,
						displayedLoggedOutMessage),
				"\n" +
				"Logout after new user registration.\n" +
				"Displayed logged out message is not correct.\n" +
				"Expected logged out message:\n" +
				expectedLoggedOutMessage +
				"\n" +
				"Displayed logged out message:\n" +
				displayedLoggedOutMessage +
				"\n");
		
		
		
		WebDriverNavigate.navigateToURL(
				_WebDriver,
				ConstantPageTestData.StartPageURL);
		
		MyAnonymizedPage myAnonymizedPage=
				new StartPage(
						_WebDriver).navigateToLoginPage().login(
								userIDTestData);
		
		String displayedLoggedInText=
				myAnonymizedPage.getUserLoggedInHoverFieldText();
		
		String expectedLoggedInText=
				assembleExpectedLoggedInText(
						userIDTestData);
		
		Assert.assertTrue(
				isDisplayedLoggedInTextCorrect(
						expectedLoggedInText,
						displayedLoggedInText),
				"\n" +
				"Displayed logged in text is not correct.\n" +
				"Expected logged in text:\n" +
				expectedLoggedInText +
				"\n" +
				"Displayed logged in text:\n" +
				displayedLoggedInText +
				"\n");
		
		
		
		logoutPage=
				myAnonymizedPage.logout();
		
		displayedLoggedOutMessage=
				logoutPage.getLoggedOutMessage();
		
		expectedLoggedOutMessage=
				assembleExpectedLoggedOutMessage();
		
		Assert.assertTrue(
				isDisplayedLoggedOutMessageCorrect(
						expectedLoggedOutMessage,
						displayedLoggedOutMessage),
				"\n" +
				"Logout after new user login.\n" +
				"Displayed logged out message is not correct.\n" +
				"Expected logged out message:\n" +
				expectedLoggedOutMessage +
				"\n" +
				"Displayed logged out message:\n" +
				displayedLoggedOutMessage +
				"\n");
		
	}
	
	
	
	private String assembleExpectedRegistrationValidationMessage(
    		UserIDTestData userIDTestData)
	{
		
		return ValidatePageAssertData.ExpectedRegistrationValidationMessagePart1 +
				userIDTestData.EMailAddress +
				ValidatePageAssertData.ExpectedRegistrationValidationMessagePart2;
		
	}
	
    private boolean isDisplayedRegistrationValidationMessageCorrect(
    		String expectedRegistrationValidationMessage,
    		String displayedRegistrationValidationMessage)
    {
    	
    	boolean isDisplayedRegistrationValidationMessageCorrect=
    			false;
    	
    	
		
		if(displayedRegistrationValidationMessage!=null)
		{
			
			isDisplayedRegistrationValidationMessageCorrect=
					StringContent.isString1EqualToString2(
							expectedRegistrationValidationMessage,
							displayedRegistrationValidationMessage);
			
		}
		
		
		
		return isDisplayedRegistrationValidationMessageCorrect;
    	
    }
    
    
    
	private String assembleExpectedLoggedInText(
    		UserIDTestData userIDTestData)
	{
		
		return MyAnonymizedPageAssertData.ExpectedLoggedInMessagePart1 +
				userIDTestData.Username;
		
	}
	
    private boolean isDisplayedLoggedInTextCorrect(
    		String expectedLoggedInText,
    		String displayedLoggedInText)
    {
    	
    	boolean isDisplayedLoggedInTextCorrect=
    			false;
    	
    	
		
		if(displayedLoggedInText!=null)
		{
			
			isDisplayedLoggedInTextCorrect=
					StringContent.isString1EqualToString2(
							expectedLoggedInText,
							displayedLoggedInText);
			
		}
		
		
		
		return isDisplayedLoggedInTextCorrect;
    	
    }
    
    
    
	private String assembleExpectedLoggedOutMessage()
	{
		
		return LogoutPageAssertData.ExpectedLoggedOutMessage;
		
	}
	
    private boolean isDisplayedLoggedOutMessageCorrect(
    		String expectedLoggedOutMessage,
    		String displayedLoggedOutMessage)
    {
    	
    	boolean isDisplayedLoggedOutMessageCorrect=
    			false;
    	
    	
		
		if(displayedLoggedOutMessage!=null)
		{
			
			isDisplayedLoggedOutMessageCorrect=
					StringContent.isString1EqualToString2(
							expectedLoggedOutMessage,
							displayedLoggedOutMessage);
			
		}
		
		
		
		return isDisplayedLoggedOutMessageCorrect;
    	
    }
	
}
