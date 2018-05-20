package com.firingground.test;

import java.util.concurrent.TimeUnit;

public class App extends Thread
{
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws Throwable
	{
		App thread = new App();
		thread.start();
		OtherApp other = new OtherApp();
		Thread thread1 = new Thread( other );
		thread1.start();
	}
	
	public void run()
	{
		
		try
		{
			Thread.sleep( 2000 );
			System.out.println( "Hello there!" );
		}
		catch( InterruptedException e )
		{
			e.printStackTrace();
		}
	}
}

class OtherApp implements Runnable
{

	@Override
	public void run()
	{
		try
		{
			TimeUnit.SECONDS.sleep( 4 );
		}
		catch( InterruptedException e )
		{
			e.printStackTrace();
		}
		System.out.println( "OtherApp" );
	}
	
}












