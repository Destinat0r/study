package innerclasses;

public class App3
{
	public static class Inner
	{
		void pp()
		{
			System.out.println( "Fallout 2 is the best game ever made!" );
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		Inner in = new Inner();
		in.pp();
	}
	
	

}
