package com.firingground.test.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ThreadForClient extends Thread
{
	private Socket socket = null;
	
	// -----------------------------------------------------------------------------------------------------------------
	public ThreadForClient( Socket socket )
	{
		this.socket = socket;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void run(  )
	{
		try
		{
			PrintWriter out = new PrintWriter( socket.getOutputStream(), true );
			out.println( "Hello, client!" );
			BufferedReader input = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			String clientInput = input.readLine();
			System.out.println( clientInput );
			
			input.close();
			out.close();
			socket.close();
		}
		catch( IOException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
