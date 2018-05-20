package geekbrains;

import java.util.Scanner;

public class App
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args ) throws InstantiationException, IllegalAccessException
	{
		App app = new App();
		app.f();
		Scanner scan = new Scanner( System.in );
		int pp = scan.nextInt();
		System.out.println( pp );
		scan.close();
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void f() throws InstantiationException, IllegalAccessException
	{
		Class<? extends App> clazz = this.getClass();
		System.out.println( "clazz.newInstance()" );
		System.out.println( clazz.newInstance() );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void g()
	{
		
	}
}
