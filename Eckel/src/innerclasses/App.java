package innerclasses;

public class App
{
	// -----------------------------------------------------------------------------------------------------------------
	class Programm
	{

	}
	
	public TheOne get()
	{
		return new TheOne()
				{
					public void method1()
					{
						System.out.println( "TheOne.method1()" );	
					}	
				};
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		App app = new App();
		TheOne to = app.get();
		to.method1();
	}

}

interface TheOne
{
	void method1();
}


