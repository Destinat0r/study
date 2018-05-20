package polymorph;
import static utils.Print.*;

public class Starship
{
	AlertStatus status = new NormalStatus();
	
	public void hitAsteroid()
	{
		status = new BadStatus();
	}
	
	public void repair()
	{
		status = new GoodStatus();
	}
	
	public static void main( String[] args )
	{
		Starship myShip = new Starship();
		myShip.status.alert();
		myShip.hitAsteroid();
		myShip.status.alert();
		myShip.repair();
		myShip.status.alert();
		
	}
}

class AlertStatus
{
	public void alert()
	{
		
	}
}

class BadStatus extends AlertStatus
{
	public void alert()
	{
		print( "Status: Bad" );
	}
}

class GoodStatus extends AlertStatus
{
	public void alert()
	{
		print( "Status: Good" );
	}
}

class NormalStatus extends AlertStatus
{
	public void alert()
	{
		print( "Status: Normal" );
	}
}