package com.firingground.test;

public class Bombadil implements Runnable
{
	String name;
	
	public Bombadil( String name )
	{
		this.name = name;
	}

	@Override
	// -----------------------------------------------------------------------------------------------------------------
	public void run()
	{
		for( int clientNum = 1; clientNum < 100; clientNum++ )
		{
			System.out.println( this.name + " sent data to client " + clientNum );
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
