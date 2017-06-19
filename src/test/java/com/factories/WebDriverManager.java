package com.factories;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager
{
	
	protected WebDriver _WebDriver;
	
	
	
	protected abstract void createWebDriverInstance();
	

	
	public WebDriver createWebDriver()
	{
		
		if(_WebDriver==null)
		{
			
			createWebDriverInstance();
			
		}
		
		
		
		return _WebDriver;
		
	}
	
	
	
	public void quitWebDriver()
	{
		
		if(_WebDriver!=null)
		{

			_WebDriver.quit();
			
			_WebDriver=
					null;
			
		}
		
	}
	
}
