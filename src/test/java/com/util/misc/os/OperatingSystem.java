package com.util.misc.os;

public class OperatingSystem
{

	public static boolean is64bitOS()
	{
		 
		 boolean is64bitOS=
				 false;
		 
		 
		 
		 if(System.getProperty(
				 "os.name").contains(
						 "Windows"))
		 {
			 
			 is64bitOS=
					 System.getenv(
							 "ProgramFiles(x86)")!=null;
			 
		 }
		 else
		 {
			 
			 is64bitOS=
					 System.getProperty(
							 "os.arch").indexOf(
									 "64")!=-1;
			 
		 }
		 
		 
		 
		 return is64bitOS;
		
	}
	
}
