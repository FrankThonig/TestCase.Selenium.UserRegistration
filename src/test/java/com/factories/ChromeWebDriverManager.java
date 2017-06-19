package com.factories;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.util.misc.os.OperatingSystem;
import com.util.misc.path.PathRetrieve;

class ChromeWebDriverManager

extends WebDriverManager
{
	
	private ChromeOptions _ChromeOptions;
	
	
	
	@Override
	protected void createWebDriverInstance()
	{
		
		System.setProperty(
				"webdriver.chrome.driver",
				PathRetrieve.retrieveAbsolutePathStringFromRelativePathString(
						this,
						"/ext/bin/selenium/driver/chrome/chromedriver.exe"));
		
		
		
		_ChromeOptions=
				new ChromeOptions();
		
		if(OperatingSystem.is64bitOS())
		{
			
			_ChromeOptions.setBinary(
					new File(
							createPathToChromeBinary(
									"64")));
			
		}
		else
		{
			
			_ChromeOptions.setBinary(
					new File(
							createPathToChromeBinary(
									"32")));
			
		}
		
		
		
		_WebDriver=
				new ChromeDriver(
						_ChromeOptions);
		
	}
	
	
	
	private String createPathToChromeBinary(
			String bitArchitecture)
	{
		
		return PathRetrieve.retrieveAbsolutePathStringFromRelativePathString(
				this,
				"/ext/bin/browser/chrome/" +
				bitArchitecture +
				" bit/chrome.exe");
		
	}
	
}
