package com.firingground.test;

public class Threads
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Bombadil tom = new Bombadil( "Tom" );
		Thread thread = new Thread( tom, "Tom's Server" );
		thread.start();
		Bombadil bob = new Bombadil( "Bob" );
		Thread thread2 = new Thread( bob, "Bob's Server" );
		thread2.start();
	}

}
        