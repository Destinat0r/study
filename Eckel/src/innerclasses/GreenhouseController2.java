package innerclasses;

public class GreenhouseController2
{
	// -----------------------------------------------------------------------------------------------------------------
	public static void main( String[] args )
	{
		GreenhouseControls2 gc = new GreenhouseControls2();
		// Instead of hard-wiring, you could parse
		// configuration information from a text file here:
		gc.addEvent( gc.new Bell( 900 ) );
		Event[] eventList = { gc.new ThermostatNight( 0 ), gc.new LightOn( 10000 ),
				gc.new LightOff( 20000 ), gc.new VentilationOn( 30000 ),
				gc.new VentilationOff( 42000 ), gc.new ThermostatDay( 54000 ), gc.new MoisteningOn( 64000 ), 
				gc.new MoisteningOff( 70000 )};
		gc.addEvent( gc.new Restart( 90000, eventList ) );
		if( args.length == 1 )

			gc.addEvent( new GreenhouseControls2.Terminate( new Integer( args[ 0 ] ) ) );
		gc.run();
		
	}

}
