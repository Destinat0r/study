package innerclasses;

public class GreenhouseControls extends Controller
{
	private boolean light = false;

	public class LightOn extends Event
	{
		public LightOn( long delayTime )
		{
			super( delayTime );
		}

		public void action()
		{
			// Put hardware control code here to
			// physically turn on the light.
			setLight( true );
		}

		public String toString()
		{
			return "Light is on";
		}
	}

	public class LightOff extends Event
	{
		public LightOff( long delayTime )
		{
			super( delayTime );
		}

		public void action()
		{
			// Put hardware control code here to
			// physically turn off the light.
			setLight( false );
		}

		public String toString()
		{
			return "Light is off";
		}
	}

	private boolean water = false;

	public class WaterOn extends Event
	{
		public WaterOn( long delayTime )
		{
			super( delayTime );
		}

		public void action()
		{
			// Put hardware control code here.
			setWater( true );
		}

		public String toString()
		{
			return "Greenhouse water is on";
		}
	}
	
	private boolean ventilate = false;
	// -----------------------------------------------------------------------------------------------------------------
	public class VentilationOn extends Event
	{
		// -----------------------------------------------------------------------------------------------------------------
		public VentilationOn( long delayTime )
		{
			super( delayTime );
		}
		
		// -----------------------------------------------------------------------------------------------------------------
		public void action()
		{
			//код управления вентиляцией
			setVentilate( true );
		}
		
		// -----------------------------------------------------------------------------------------------------------------
		public String toString()
		{
			return "Ventilation is on.";
		}
		
	}
	public class VentilationOff extends Event
	{
		// -----------------------------------------------------------------------------------------------------------------
		public VentilationOff( long delayTime )
		{
			super( delayTime );
		}
		
		// -----------------------------------------------------------------------------------------------------------------
		public void action()
		{
			//код управления вентиляцией
			setVentilate( false );
		}
		
		// -----------------------------------------------------------------------------------------------------------------
		public String toString()
		{
			return "Ventilation is off.";
		}
		
	}
	
	public class WaterOff extends Event
	{
		public WaterOff( long delayTime )
		{
			super( delayTime );
		}

		public void action()
		{
			// Put hardware control code here.
			setWater( false );
		}

		public String toString()
		{
			return "Greenhouse water is off";
		}
	}

	private String thermostat = "Day";

	public class ThermostatNight extends Event
	{
		public ThermostatNight( long delayTime )
		{
			super( delayTime );
		}

		public void action()
		{
			// Put hardware control code here.
			setThermostat( "Night" );
		}

		public String toString()
		{
			return "Thermostat on night setting";
		}
	}

	public class ThermostatDay extends Event
	{
		public ThermostatDay( long delayTime )
		{
			super( delayTime );
		}

		public void action()
		{
			// Put hardware control code here.
			setThermostat( "Day" );
		}

		public String toString()
		{
			return "Thermostat on day setting";
		}
	}

	// An example of an action() that inserts a
	// new one of itself into the event list:
	public class Bell extends Event
	{
		public Bell( long delayTime )
		{
			super( delayTime );
		}

		public void action()
		{
			addEvent( new Bell( delayTime ) );
		}

		public String toString()
		{
			return "Bing!";
		}
	}

	public class Restart extends Event
	{
		private Event[] eventList;

		public Restart( long delayTime, Event[] eventList )
		{
			super( delayTime );
			this.eventList = eventList;
			for( Event e : eventList )
				addEvent( e );
		}

		public void action()
		{
			for( Event e : eventList )
			{
				e.start(); // Rerun each event
				addEvent( e );
			}
			start(); // Rerun this Event
			addEvent( this );
		}

		public String toString()
		{
			return "Restarting system";
		}
	}

	public static class Terminate extends Event
	{
		public Terminate( long delayTime )
		{
			super( delayTime );
		}

		public void action()
		{
			System.exit( 0 );
		}

		public String toString()
		{
			return "Terminating";
		}
	}

	public boolean isWater()
	{
		return water;
	}

	public void setWater( boolean water )
	{
		this.water = water;
	}

	public boolean isVentilate()
	{
		return ventilate;
	}

	public void setVentilate( boolean ventilate )
	{
		this.ventilate = ventilate;
	}

	public String getThermostat()
	{
		return thermostat;
	}

	public void setThermostat( String thermostat )
	{
		this.thermostat = thermostat;
	}

	public boolean isLight()
	{
		return light;
	}

	public void setLight( boolean light )
	{
		this.light = light;
	}
}