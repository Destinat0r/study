package innerclasses;

public class App2
{
	private int id;
	
	// -----------------------------------------------------------------------------------------------------------------
	App2( int id )
	{
		this.id = id;
	}
	
	public void f()
	{
		System.out.println( "App2.f()" );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public int getId()
	{
		return id;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Aop.main( args );
	}

}

class Aop
{
	public App2 getApp( int id )
	{
		return new App2( id )
				{
					
				};
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Aop aop = new Aop();
		App2 app = aop.getApp( 12 );
		System.out.println( app.getId() );
	}

}