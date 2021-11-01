package ACCESSCODE;

public class TestStubForIDialog implements IDialog{
	
	@Override
	public int show() {
		
		// Give a Time Zone between 0-23 randomly.
		int randomTimeZone= -1;
		randomTimeZone = (int)(Math.random()*(24))+0;
		
		return randomTimeZone;
		
	}
	
	
}
