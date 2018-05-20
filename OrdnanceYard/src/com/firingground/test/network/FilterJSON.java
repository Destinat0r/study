package com.firingground.test.network;

public class FilterJSON
{
	public void Main( String[] args ) throws Throwable
	{	
		int filterFrom = 0;
		int filterTo = 0;
		if( args.length > 0 )
		{
			filterFrom = Integer.parseInt( args[ 0 ] );
			filterTo = Integer.parseInt( args[ 1 ] );
		}
		HTMLgetter jsonGetter = new HTMLgetter( "jsonplaceholder.typicode.com" );
		jsonGetter.sendRequest();
		jsonGetter.getResponceToAfile();
		JSONParser parser = new JSONParser( filterFrom, filterTo );
		parser.parseArrFrom( jsonGetter.getFileName() );
		
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Throwable
	{
		new FilterJSON().Main( args );
	}

}
