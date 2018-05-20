package innerclasses;

public class App4
{
	public static class Closs1
	{
		int i = 1;
		
		static class Closs2
		{
			void get()
			{
				System.out.println( "Go home!" );
			}
		}
		
		// -----------------------------------------------------------------------------------------------------------------
		public static void main( String[] args )
		{
			Closs2 c2 = new Closs2();
			c2.get();
		}

	}
	
}
