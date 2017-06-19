package com.testData;

import com.util.misc.thread.ThreadRandomNumber;

public class DynamicTestDataHelper
{
	
	public static UserIDTestData generateRandomUserIDTestData()
	{
		
		String randomUserIDNumberPart=
				generateRandomUserIDNumberPartAsString();
		
		
		
		return new UserIDTestData(
				generateFirstName(),
				generateLastName(
						randomUserIDNumberPart),
				generateUsername(
						randomUserIDNumberPart),
				generateEMailAddress(
						randomUserIDNumberPart),
				generatePassword());
		
	}
	
	
	
	private static String generateRandomUserIDNumberPartAsString()
	{
		
		return ((Long)generateRandomUserIDNumberPart()).toString();
		
	}
	
	private static long generateRandomUserIDNumberPart()
	{
		
		return ThreadRandomNumber.generateRandomNumber(
				ConstantUserTestData.MinimumValidUserIDNumberPart,
				ConstantUserTestData.MaximumValidUserIDNumberPart + 1);
		
	}
	

	
	private static String generateFirstName()
	{
		
		return ConstantUserTestData.FirstName;
		
	}
	

	
	private static String generateLastName(
			String randomUserIDNumberPart)
	{
		
		return randomUserIDNumberPart;
		
	}
	

	
	private static String generateUsername(
			String randomUserIDNumberPart)
	{
		
		return ConstantUserTestData.UsernamePrefix +
				randomUserIDNumberPart;
		
	}
	
	
	
	private static String generateEMailAddress(
			String randomUserIDNumberPart)
	{
		
		return ConstantUserTestData.EMailAddressPrefix +
				randomUserIDNumberPart +
				ConstantUserTestData.EMailAddressSuffix;
		
	}
	

	
	private static String generatePassword()
	{
		
		return ConstantUserTestData.Password;
		
	}
	
}
