package com.util.misc.thread;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadRandomNumber
{
	
	public static long generateRandomNumber(
			long minimumValidNumber,
			long maximumValidNumber)
	{
		
		return ThreadLocalRandom.current().nextLong(
				minimumValidNumber,
				maximumValidNumber + 1);
		
	}
	
}
