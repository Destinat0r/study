package innerclasses;

public class App6
{
	// -----------------------------------------------------------------------------------------------------------------
	class Inner
	{
		@SuppressWarnings("unused")
		private int i;
		
		Inner( int i )
		{
			System.out.println( "Inside App6.Inner constructor" );
			this.i = i;
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
	}

}

class ExtInner extends App6.Inner
{

	ExtInner( App6 app6, int i )
	{
		app6.super( i );
	}
	
}
