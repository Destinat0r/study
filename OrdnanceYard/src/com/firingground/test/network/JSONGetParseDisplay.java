package com.firingground.test.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONGetParseDisplay
{
	Socket socket;
	String hostName;
	String responce;
	String cleanJSON;
	int startInterval;
	int endInterval;
	
	public JSONGetParseDisplay( String hostname )
	{
		this.hostName = hostname;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void Main( String[] args ) throws Throwable
	{
		getInterval( args ); 
		getJSON();
		cleanJSON();
		JSONArray filteredJSON = filter( parseJSON() );
		display( filteredJSON );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	private void getInterval( String[] args )
	{
		if( args.length == 2 )
		{
			try
			{
				this.startInterval = Integer.parseInt( args[ 0 ] );
				this.endInterval = Integer.parseInt( args[ 1 ] );
			}
			catch( RuntimeException e )
			{
				System.out.println( "Please, enter two integers next time" );
			}
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void getJSON() throws Throwable
	{	
		sendRequest();
		getResponce();
	}

	// -----------------------------------------------------------------------------------------------------------------
	public void sendRequest() throws Exception
	{
		this.socket = new Socket( hostName, 80 );
		try
		{
			PrintWriter pw = new PrintWriter( socket.getOutputStream() );
			pw.println( "GET /posts HTTP/1.0" );
			pw.println( "Host: " + hostName );
			pw.println( "" );
			pw.flush();
			System.out.println( "Запрос отправлен \n" );
		}
		catch( Exception e )
		{
			socket.close();
			throw new Exception( "Error occured, while sending a request: " + e.getMessage(), e );
		}

		System.out.println( "Waiting for server responce..." );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void getResponce() throws IOException
	{
		String responce = null;
		BufferedInputStream inputFromServer = new BufferedInputStream( socket.getInputStream() );
		StringBuilder builder = new StringBuilder();
		int byteOfInput = 0;
		while( (byteOfInput = inputFromServer.read()) != -1 )
		{
			builder.append( (char)byteOfInput );
		}
		socket.close();
		responce = builder.toString();
		this.responce = responce;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	private void cleanJSON()
	{
		this.cleanJSON = responce.substring( responce.indexOf( "[" ) ).trim();
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public JSONArray parseJSON() throws Throwable
	{
		return new JSONArray( cleanJSON );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	private JSONArray filter( JSONArray jsonArr )
	{
		Iterator<Object> iter = jsonArr.iterator();
		
		JSONArray filteredJSON = new JSONArray();
		
		while( iter.hasNext() )
		{
			JSONObject currObj = (JSONObject)iter.next();
			int currId = (int)currObj.get( "userId" );
			if( ((startInterval == 0) && (endInterval == 0)) || ((currId >= startInterval) && (currId <= endInterval)) )
			{
				filteredJSON.put( currObj );
			}
		}
		return filteredJSON;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void display( JSONArray jsonArr )
	{
		System.out.println( "\nResults:\n" );
		Iterator<Object> iter = jsonArr.iterator();
		while( iter.hasNext() )
		{
			JSONObject currObj = (JSONObject)iter.next();
			System.out.println( "UserId: " + currObj.get( "userId" ));
			System.out.println( "Title: " + currObj.get( "title" ) );
			System.out.println( "Body: " + currObj.get( "body" ) + "\n" );
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Throwable{ new JSONGetParseDisplay( "jsonplaceholder.typicode.com" ).Main( args ); }
}
