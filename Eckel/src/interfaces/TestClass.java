package interfaces;
import static utils.Print.*;

public class TestClass implements ThreeMethods
{
	public void method1()
	{
		print( "method1()" );
	}
	
	public void method2()
	{
		print( "method2()" );
	}
	
	public void method3()
	{
		print( "method3()" );
	}
	
	public static void main( String[] args )
	{
		TestClass tc = new TestClass();
		tc.method1();
	}
}
