package com.factories;

public class WebDriverManagerFactory
{	
	
	public WebDriverManager createWebDriverManager()
	{
		
		return new ChromeWebDriverManager();
		
	}
	
}
