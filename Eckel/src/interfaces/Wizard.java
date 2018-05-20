package interfaces;

public class Wizard extends Mage implements AcademyOfMagic
{

	@Override
	public void throwFireBall()
	{	
		
	}

	@Override
	public void rizeFireWall()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void letitate()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void throwLightning()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void throwIceBolt()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rizeIceGolem()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void learnAncientSecrets()
	{
		// TODO Auto-generated method stub
		
	}

	public static void f( FireMagic fm )
	{
		
	}
	
	public static void w( WindMagic wm )
	{
		
	}
	
	public static void wt( WaterMagic wm )
	{
		
	}
	
	public static void aom( AcademyOfMagic aom )
	{
		
	}
	
	public static void main( String[] args )
	{
		f( new Wizard() );
		w( new Wizard() );
		wt( new Wizard() );
		aom( new Wizard() );
	}
}


interface FireMagic
{
	void throwFireBall();
	void rizeFireWall();
}

interface WindMagic
{
	void letitate();
	void throwLightning();
}

interface WaterMagic
{
	void throwIceBolt();
	void rizeIceGolem();
}

interface AcademyOfMagic extends FireMagic, WindMagic, WaterMagic
{
	void learnAncientSecrets();
}

abstract class Mage
{
	void astralKick()
	{
		
	}
}












