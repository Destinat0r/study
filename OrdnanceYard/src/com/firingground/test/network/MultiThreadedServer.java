package com.firingground.test.network;

import java.net.*;

public class MultiThreadedServer
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Throwable
	{
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket( 9090 );
		
		boolean stoped = false;
		while(!stoped)
		{
			System.out.println( "Waiting for clients..." );
			Socket clientSocket = serverSocket.accept();
			System.out.println( "Client is connected." );
			ThreadForClient clientThread = new ThreadForClient( clientSocket );
			clientThread.start();
		}
	}

}
