package ACCESSCODE;

import java.text.SimpleDateFormat;


class TestStubForOoooSmartClock extends OoooSmartClock{
	
	public String currentDate;
	public int zoneIndex = -1;
	public TestStubForOoooSmartClock(String date, boolean isZone) {
		
		super();
		currentDate = date;
		
		// if dialog is not null, meaning user choosed "Timezone", give a flag "isZone = true" for next step
		setTimeZoneInTest(isZone);
		setCurrentTimeStampInTest();
		
	}
	
	public void setTimeZoneInTest(boolean isZone) {
		try {
			// if flag is true, it means that user choosed the time zone
			if (isZone != false) {
				TestStubForIDialog dialog = new TestStubForIDialog();
				setUpDialog(dialog);
				setTimeZone(dialog.show());
			}
			else {
				setTimeZone();
			}
			
		} catch (Exception e) {
			// if dialog == null return Exception
			
			System.out.println(e.getMessage());
		}
	}
	
	public void setCurrentTimeStampInTest() {
		try {
			
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			setCurrentTime(dateformat.parse(currentDate));
			
		} catch (Exception e) {
			// if current == null return Exception
			System.out.println(e.getMessage());
			
		}
	}
	
	 
}


