package com.util.misc.string;

import org.apache.commons.lang3.StringUtils;

public class StringContent
{
	
	public static boolean isString1EqualToString2(
			String string1,
			String string2)
	{
		
		return StringUtils.equals(
				string2,
				string1);
		
	}
	
}
