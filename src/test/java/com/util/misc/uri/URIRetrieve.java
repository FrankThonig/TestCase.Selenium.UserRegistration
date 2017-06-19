package com.util.misc.uri;

import java.net.URI;
import java.net.URL;

public class URIRetrieve
{

	public static URI retrieveURIFromURL(
			URL url)
	{
		
		URI uri=
				null;
		
		
		
		if(url!=null)
		{
			
			try
			{
				uri=
						url.toURI();
				
			}
			catch(
					Exception exception)
			{
				
				exception.printStackTrace();
				
			}
			
		};
		
		
		
		return uri;

	}

}
