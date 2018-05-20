package innerclasses;

public class App1
{

	public Tunnable get()
	{
		return new Tunnable()
				{
					public void tune()
					{
						System.out.println( "get.Tunnable.tune()" );
					}
				};
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Test.main( args );
	}

}

class Test
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		App1 app = new App1();
		app.get().tune();
	}

}
