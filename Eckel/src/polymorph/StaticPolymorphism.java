package polymorph;
import static utils.Print.*;

class StaticSuper
{
	public static String staticGet()
	{
		return "Base staticGet()";
	}

	public String dynamicGet()
	{
		return "Base dynamicGet()";
	}
}

class StaticSub extends StaticSuper
{
	public static String staticGet()
	{
		return "Derived staticGet()";
	}

	public String dynamicGet()
	{
		return "Derived dynamicGet()";
	}
}

public class StaticPolymorphism
{
	public static void main( String[] args )
	{
		StaticSuper sup = new StaticSub(); // Upcast
		System.out.println( sup.staticGet() );
		System.out.println( sup.dynamicGet() );
		print();
		Parent papa = new Child();
		print( papa.method1() );
		print( papa.method2() );
		
		Child kid = new Child();
		print( kid.method1() );
		print( kid.method2() );
		
	}
}

class Parent
{
	public static String method1()
	{
		return "Parent method1";
	}
	
	public static String method2()
	{
		return "Parent method2";
	}
}

class Child extends Parent
{
	public static String method1()
	{
		return "Child method1";
	}
	
	public static String method2()
	{
		return "Child method2";
	}
}