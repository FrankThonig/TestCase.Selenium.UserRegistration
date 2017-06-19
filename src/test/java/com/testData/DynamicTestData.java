package com.testData;

import org.testng.annotations.DataProvider;

public class DynamicTestData
{
	
    @DataProvider(
    		name=
    			"testData",
    		parallel=
    			true)
    public static Object[][] createTestData()
    {
    	
    	return new Object[][]
    			{
		    		
		    		{
		    			
		    			DynamicTestDataHelper.generateRandomUserIDTestData()
		    			
		    		}
		    		
    			};
				
	}
	
}
