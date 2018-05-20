package com.firingground.test.network;

public class ServerThread extends Thread
{
	// -----------------------------------------------------------------------------------------------------------------
	public ServerThread( String threadName )
	{
		this.setName( threadName );
	}

	// -----------------------------------------------------------------------------------------------------------------
	public void run()
	{	
		for( int clientNum = 1; clientNum < 100; clientNum++ )
		{
			System.out.println( this.getName() + " sent data to client " + clientNum );
			try
			{
				Thread.sleep( 50 );
			}
			catch( InterruptedException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
