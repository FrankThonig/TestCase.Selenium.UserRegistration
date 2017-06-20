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
		
		
		
		String actualRegistrationValidationMessage=
				validatePage.getValidationMessage();
		
		String expectedRegistrationValidationMessage=
				assembleExpectedRegistrationValidationMessage(
						userIDTestData);
		
		Assert.assertTrue(
				isActualRegistrationValidationMessageCorrect(
						expectedRegistrationValidationMessage,
						actualRegistrationValidationMessage),
				"\n" +
				"Actual registration validation message is not correct.\n" +
				"Expected registration validation message:\n" +
				expectedRegistrationValidationMessage +
				"\n" +
				"Actual registration validation message:\n" +
				actualRegistrationValidationMessage +
				"\n");
		
		
		
		LogoutPage logoutPage=
				validatePage.logout();
		
		String actualLoggedOutMessage=
				logoutPage.getLoggedOutMessage();
		
		String expectedLoggedOutMessage=
				assembleExpectedLoggedOutMessage();
		
		Assert.assertTrue(
				isActualLoggedOutMessageCorrect(
						expectedLoggedOutMessage,
						actualLoggedOutMessage),
				"\n" +
				"Logout after new user registration.\n" +
				"Actual logged out message is not correct.\n" +
				"Expected logged out message:\n" +
				expectedLoggedOutMessage +
				"\n" +
				"Actual logged out message:\n" +
				actualLoggedOutMessage +
				"\n");
		
		
		
		WebDriverNavigate.navigateToURL(
				_WebDriver,
				ConstantPageTestData.StartPageURL);
		
		MyAnonymizedPage myAnonymizedPage=
				new StartPage(
						_WebDriver).navigateToLoginPage().login(
								userIDTestData);
		
		String actualLoggedInText=
				myAnonymizedPage.getUserLoggedInHoverFieldText();
		
		String expectedLoggedInText=
				assembleExpectedLoggedInText(
						userIDTestData);
		
		Assert.assertTrue(
				isActualLoggedInTextCorrect(
						expectedLoggedInText,
						actualLoggedInText),
				"\n" +
				"Actual logged in text is not correct.\n" +
				"Expected logged in text:\n" +
				expectedLoggedInText +
				"\n" +
				"Actual logged in text:\n" +
				actualLoggedInText +
				"\n");
		
		
		
		logoutPage=
				myAnonymizedPage.logout();
		
		actualLoggedOutMessage=
				logoutPage.getLoggedOutMessage();
		
		expectedLoggedOutMessage=
				assembleExpectedLoggedOutMessage();
		
		Assert.assertTrue(
				isActualLoggedOutMessageCorrect(
						expectedLoggedOutMessage,
						actualLoggedOutMessage),
				"\n" +
				"Logout after new user login.\n" +
				"Actual logged out message is not correct.\n" +
				"Expected logged out message:\n" +
				expectedLoggedOutMessage +
				"\n" +
				"Actual logged out message:\n" +
				actualLoggedOutMessage +
				"\n");
		
	}
	
	
	
	private String assembleExpectedRegistrationValidationMessage(
    		UserIDTestData userIDTestData)
	{
		
		return ValidatePageAssertData.ExpectedRegistrationValidationMessagePart1 +
				userIDTestData.EMailAddress +
				ValidatePageAssertData.ExpectedRegistrationValidationMessagePart2;
		
	}
	
    private boolean isActualRegistrationValidationMessageCorrect(
    		String expectedRegistrationValidationMessage,
    		String actualRegistrationValidationMessage)
    {
    	
    	boolean isActualRegistrationValidationMessageCorrect=
    			false;
    	
    	
		
		if(actualRegistrationValidationMessage!=null)
		{
			
			isActualRegistrationValidationMessageCorrect=
					StringContent.isString1EqualToString2(
							expectedRegistrationValidationMessage,
							actualRegistrationValidationMessage);
			
		}
		
		
		
		return isActualRegistrationValidationMessageCorrect;
    	
    }
    
    
    
	private String assembleExpectedLoggedInText(
    		UserIDTestData userIDTestData)
	{
		
		return MyAnonymizedPageAssertData.ExpectedLoggedInMessagePart1 +
				userIDTestData.Username;
		
	}
	
    private boolean isActualLoggedInTextCorrect(
    		String expectedLoggedInText,
    		String actualLoggedInText)
    {
    	
    	boolean isActualLoggedInTextCorrect=
    			false;
    	
    	
		
		if(actualLoggedInText!=null)
		{
			
			isActualLoggedInTextCorrect=
					StringContent.isString1EqualToString2(
							expectedLoggedInText,
							actualLoggedInText);
			
		}
		
		
		
		return isActualLoggedInTextCorrect;
    	
    }
    
    
    
	private String assembleExpectedLoggedOutMessage()
	{
		
		return LogoutPageAssertData.ExpectedLoggedOutMessage;
		
	}
	
    private boolean isActualLoggedOutMessageCorrect(
    		String expectedLoggedOutMessage,
    		String actualLoggedOutMessage)
    {
    	
    	boolean isActualLoggedOutMessageCorrect=
    			false;
    	
    	
		
		if(actualLoggedOutMessage!=null)
		{
			
			isActualLoggedOutMessageCorrect=
					StringContent.isString1EqualToString2(
							expectedLoggedOutMessage,
							actualLoggedOutMessage);
			
		}
		
		
		
		return isActualLoggedOutMessageCorrect;
    	
    }
	
}
