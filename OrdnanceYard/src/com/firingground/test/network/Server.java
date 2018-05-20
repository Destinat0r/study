package com.firingground.test.network;

import java.io.*;
import java.net.*;

public class Server
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Exception
	{
		ServerSocket serverSocket = new ServerSocket( 9090 );
		System.out.println( "Waiting for clients..." );
		
		boolean stop = false;
		while( !stop )
		{
			Socket socket = serverSocket.accept();
			PrintWriter out = new PrintWriter( socket.getOutputStream(), true );
			out.println( "Hello, client!" );
			BufferedReader input = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
			String clientInput = input.readLine();
			System.out.println( clientInput );
			
			if( clientInput.equals( "stop" ) )
			{
				stop = true;
			}
			
			input.close();
			out.close();
			socket.close();
		}
		serverSocket.close();
	}

}
