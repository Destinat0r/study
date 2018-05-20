package innerclasses;

public interface Prog
{
	void hehe();
	
	static class Inner implements Prog
	{
		public void hehe()
		{
			System.out.println( "He-he-he" );
		}
		
		// -----------------------------------------------------------------------------------------------------------------
		public static void main( String[] args )
		{
			Inner in = new Inner();
			in.hehe();
		}

	}
}
