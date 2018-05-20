package com.firingground.test.network;

import java.io.IOException;
import java.net.*;

public class LocalPortScanner
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		
		for( int port = 1; port < 65535; port++ )
		{
			try
			{
				ServerSocket server = new ServerSocket( port );
				server.close();
			}
			catch( IOException e )
			{
				System.out.println( "Port " + port + " is occupied!" );
			}
		}
	}

}
