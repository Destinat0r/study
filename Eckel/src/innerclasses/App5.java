package innerclasses;

public class App5
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		B b = new B( 3 );
		
		b.pushU( a1 );
		b.pushU( a2 );
		b.pushU( a3 );
		
		b.dropU( 1 );
		
		b.callU();
	}

}

// -----------------------------------------------------------------------------------------------------------------
interface U
{
	void method1();
	void method2();
	void method3();
}

// -----------------------------------------------------------------------------------------------------------------
class A 
{	
	public U getU( final int id )
	{
		return new U()
				{
					
					public void method1()
					{
						System.out.println( id + ".method1()" );
						
					}
					
					// -----------------------------------------------------------------------------------------------------------------
					public void method2()
					{
						System.out.println( id + ".method2()" );
					}

					// -----------------------------------------------------------------------------------------------------------------
					public void method3()
					{
						System.out.println( id + ".method3()" );					}
				};
	}
}

class B
{
	private int len;
	private int current = 0;
	U[] arrU;
	
	// -----------------------------------------------------------------------------------------------------------------
	B( int len )
	{
		this.len = len;
		arrU = new U[ len ];
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void pushU( A a )
	{
		arrU[ current ] = a.getU( current++ );
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void dropU( int i )
	{
		if( i >= 0 && i < arrU.length - 1 )
			arrU[ i ] = null;
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public void callU()
	{
		for( int i = 0; i < len; i++ )
		{
			U curr = arrU[ i ];
			if( curr != null )
			{
				curr.method1();
				curr.method2();
				curr.method3();
			}
		}
	}
}
