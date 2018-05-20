package com.firingground.test.network;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Iterator;
import org.json.*;

public class JSONParser
{
	String[] args;
	int filterFrom;
	int filterTo;
	
	// -----------------------------------------------------------------------------------------------------------------
	JSONParser( int filterFrom, int filterTo )
	{
		this.filterFrom = filterFrom;
		this.filterTo = filterTo;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	JSONParser(){}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void Main( String[] args ) throws Throwable
	{
		parseArrFrom("D:\\!!Learn Java\\Projects\\Study\\OrdnanceYard\\saved.json");
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void parseArrFrom( String filePath ) throws Throwable
	{
		String jsonText = readFileToStr( filePath );
		JSONArray jsonArr = new JSONArray( jsonText );
		Iterator<Object> iter = jsonArr.iterator();
		System.out.println( "\nРезультаты:\n" );
		
		while( iter.hasNext() )
		{
			JSONObject currObj = (JSONObject)iter.next();
			int currId = (int)currObj.get("userId");
			if( (filterFrom == 0 && filterTo == 0) || (currId >= filterFrom && currId <= filterTo) )
			{
				System.out.println( "UserId: " + currId );
				System.out.println( "Title: " + currObj.get( "title" ) );
				System.out.println( "Body: " + currObj.get( "body" ) + "\n" );
			}
		}
	}

	// -----------------------------------------------------------------------------------------------------------------
	public String readFileToStr( String fileName ) throws Throwable
	{
		Path path = FileSystems.getDefault().getPath( fileName );
		BufferedReader reader = Files.newBufferedReader( path, StandardCharsets.UTF_8 );
		StringBuilder textToParse = new StringBuilder();
		String line;
		while( (line = reader.readLine()) != null )
		{
			textToParse.append( line );
		}
		
		return textToParse.toString();
	}

	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Throwable
	{
		new JSONParser().Main( args );
	}
}
