package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pageObjectData.ConstantPageData;
import com.util.webElement.WebElementSafeActions;

abstract class PageObject
{
	
	protected WebDriver _WebDriver;
	
	
	
	protected PageObject(
			WebDriver webDriver)
	{
		
		if(webDriver==null)
		{
			
			throw new RuntimeException(
					"WebDriver instance is NULL");
			
		}
		
		
		
		_WebDriver=
				webDriver;
		
		
		
		PageFactory.initElements(
				_WebDriver,
				this);
		
	}
	

	
	protected PageObject moveToElement(
			WebElement webElement)
	{
		
		WebElementSafeActions.safeMoveToElement(
	    		_WebDriver,
	    		webElement,
	    		ConstantPageData.MaxWaitingTimeForLoadingWebElementInSeconds);
		
		
		
		return this;
		
	}
	
	protected PageObject clearTextFieldAndEnterText(
			WebElement webElement,
			String text)
	{
		
		return clearTextField(
				webElement).enterTextInTextField(
						webElement,
						text);
		
	}
	
	private PageObject clearTextField(
			WebElement webElement)
	{
		
		WebElementSafeActions.safeClear(
	    		_WebDriver,
	    		webElement,
	    		ConstantPageData.MaxWaitingTimeForLoadingWebElementInSeconds);
		
		
		
		return this;
		
	}
	
	private PageObject enterTextInTextField(
			WebElement webElement,
			String text)
	{
		
		WebElementSafeActions.safeSendKeys(
	    		_WebDriver,
	    		webElement,
	    		ConstantPageData.MaxWaitingTimeForLoadingWebElementInSeconds,
	    		text);
		
		
		
		return this;
		
	}
	
	protected PageObject click(
			WebElement webElement)
	{
		
		WebElementSafeActions.safeClick(
				_WebDriver,
				webElement,
				ConstantPageData.MaxWaitingTimeForLoadingWebElementInSeconds);
		
		
		
		return this;
		
	}
	
	protected PageObject pressReturnKey(
			WebElement webElement)
	{
		
		WebElementSafeActions.safeSendReturnKey(
				_WebDriver,
				webElement,
	    		ConstantPageData.MaxWaitingTimeForLoadingWebElementInSeconds);
		
		
		
		return this;
		
	}
	
	protected PageObject setElementToStateSelected(
			WebElement webElement)
	{
		
		WebElementSafeActions.safeSetElementToStateSelected(
	    		_WebDriver,
	    		webElement,
	    		ConstantPageData.MaxWaitingTimeForLoadingWebElementInSeconds);
		
		
		
		return this;
		
	}
	
	public String getText(
			WebElement webElement)
	{
		
		return WebElementSafeActions.safeGetText(
				_WebDriver,
				webElement,
	    		ConstantPageData.MaxWaitingTimeForLoadingWebElementInSeconds);
		
	}
	
}
