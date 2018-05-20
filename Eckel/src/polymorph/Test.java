package polymorph;

import static utils.Print.*;

public class Test
{
	public static void test1( Dog dg )
	{
		( (Sobak)dg ).bark();
	}

	public static void test2( Cat ct )
	{
		ct.meuw();
	}
	
	public static void main( String[] args )
	{
		Dog dg = new Sobak();
		test1( dg );
		
		Cat ct = new Murzik();
		test2( ct );
		
		Sobak pes = new Sobak();
		pes.i = 4;
		print( pes.i );
		print( Dog.i );
	}
}

abstract class Dog
{
	public static int i = 1;
}

class Sobak extends Dog
{
	public void bark()
	{
		print( "√ав-гав-гав!" );
	}
}

abstract class Cat
{
	abstract void meuw();
}

class Murzik extends Cat
{
	public void meuw()
	{
		print( "Meuw-meuw" );
	}
}











