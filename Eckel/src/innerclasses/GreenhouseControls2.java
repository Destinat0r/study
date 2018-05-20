package innerclasses;

public class GreenhouseControls2 extends GreenhouseControls
{
	private boolean moistening = false;
	
	// -----------------------------------------------------------------------------------------------------------------
	public class MoisteningOn extends Event
	{
		//-----------------------------------------------------------------------------------------------------------------
		public MoisteningOn( long delayTime )
		{
			super( delayTime );
		}
		
		// -----------------------------------------------------------------------------------------------------------------
		public void action()
		{
			//code to control moistening hardware
			setMoistening( true );
		}
		
		// -----------------------------------------------------------------------------------------------------------------
		public String toString()
		{
			return "Moistening is on.";
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	public class MoisteningOff extends Event
	{
		//-----------------------------------------------------------------------------------------------------------------
		public MoisteningOff( long delayTime )
		{
			super( delayTime );
		}
		
		// -----------------------------------------------------------------------------------------------------------------
		public void action()
		{
			//code to control moistening hardware
			setMoistening( false );
		}
		
		// ---------------------------------------------------------------------fal--------------------------------------------
		public String toString()
		{
			return "Moistening is off.";
		}
	}

	public boolean isMoistening()
	{
		return moistening;
	}

	public void setMoistening( boolean moistening )
	{
		this.moistening = moistening;
	}
}
