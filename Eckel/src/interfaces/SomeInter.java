package interfaces;
import static utils.Print.*;

interface SomeInter
{
	void f();
}

interface AnotherInterface extends SomeInter
{
	void f();
}

interface AndYetAnother extends SomeInter 
{
	void f();
}

interface CombinedInter extends AnotherInterface, AndYetAnother
{
	void f();
}

class CombinedImpl implements CombinedInter
{
	@Override
	public void f()
	{
		print( "CombinedImpl.f()" );
	}
}
