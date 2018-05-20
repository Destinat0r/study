package com.firingground.test.network;

import java.net.*;

public class InetAdressTest
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		try
		{
			InetAddress address = InetAddress.getLocalHost();
			System.out.println( address.getHostName() );
			System.out.println( address.getLoopbackAddress() );
			InetAddress address2 = InetAddress.getByName( "rsload.net" );
			System.out.println( address2.getHostAddress() );
			System.out.println( address2.getCanonicalHostName() );
		}
		catch( Throwable ex )
		{
			// TODO: handle exception
		}
	}

}
