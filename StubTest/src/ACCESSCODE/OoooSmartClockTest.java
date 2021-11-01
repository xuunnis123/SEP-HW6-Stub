package ACCESSCODE;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


	public class OoooSmartClockTest {
		
		@Test
		public void setTimeZone_noZoneTime_true_byStub() {
			
			/*  
			 *  Test if user didn't choose time zone
			 *  zoneIndex doesn't change and console shows NODATA_CHOOSED
			 */
			
			// given
			int zoneIndex = -1;
			// "isZone = false" means user did not choose time zone.
			boolean isZone = false;
			String dateString = null ;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(dateString,isZone);
			
			//  when
			
			int expected = smartClock.getTimeZone();
			
			// then 
			int result = zoneIndex;
			
			assertEquals(expected, result);		
			// And There is a "NODATA_CHOOSED" message showing on the Console;
			
		}
		
		@Test
		public void setCurrentTime_dateNull_true_byStub() {
			
			/*  
			 * Test user doesn't input any date
			 * currentDate is still null and return null from getCurrentTimeStamp
			 */
			
			// given
			
			// Assume user did not input any date
			String dateString = null;
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(dateString,isZone);
							
			// when
			String expected = null;
						
			// then
			String result = null;
			
			try {
				result = smartClock.getCurrentTimeStamp();
			}
			catch (Exception e) {
				// And There is a "null" message showing on the Console;
				System.out.println(e.getMessage());
			}
			
			assertEquals(expected, result);			
			
			
		}
		
		@Test
		public void getCurrentTimeStamp_nowTime_true_byStub() {
			
			/*  Test getCurrentTimeStamp works well and fits our standard format.  */
			 
			// given
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
		    
			Date date = new Date();
		    String dateString = dateFormat.format(date);
			
		    OoooSmartClock smartClock = new TestStubForOoooSmartClock(dateString,isZone);
			
			
			// when
			String expected = dateString;
			
			// then
			String result = smartClock.getCurrentTimeStamp();
			
			assertEquals(expected, result);
		}
		
		
		@Test 
		public void getLocalTimeStamp_10311200_true_byStub() {
			
			/*  
			 * Test getLocalTimeStamp and give timeInfo is "2021-10-31 12:00:00" 
			 * to check "12:00:00" whether it transfers to "NOON".
			 */
			
			// given 
			String timeInfo = "2021-10-31 12:00:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-10-31 NOON";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		@Test 
		public void getLocalTimeStamp_1031120001_true_byStub() {
			
			/* 
			 * To Check that Second works well.
			 * Test getLocalTimeStamp and give timeInfo is "2021-10-31 12:00:01" 
			 * to check "12:00:01" whether it transfers to "NOON".
			 */
			
			// given 
			String timeInfo = "2021-10-31 12:00:01";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-10-31 NOON";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		
		@Test 
		public void getLocalTimeStamp_10311201_true_byStub() {
			
			/*
			 *  Test getLocalTimeStamp and give timeInfo is "2021-10-31 12:01:00" 
			 *  to check "12:01:00" whether it transfers to "NOON".
			 */
			
			// given 
			String timeInfo = "2021-10-31 12:01:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-10-31 NOON";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		@Test 
		public void getLocalTimeStamp_1031120101_true_byStub() {
			
			/* 
			 *  To Check that Second works well.
			 *  Test getLocalTimeStamp and give timeInfo is "2021-10-31 12:01:01" 
			 *  to check "12:01:01" whether it not transfers to "NOON".
			 */
			
			// given 
			String timeInfo = "2021-10-31 12:01:01";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-10-31 12:01:01";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}

		@Test 
		public void getLocalTimeStamp_10311202_true_byStub() {
			
			 /*  
			  * Test getLocalTimeStamp and give timeInfo is "2021-10-31 12:02:00" 
			  * to check "12:02:00" whether it not transfers to "NOON".
			  */
			
			// given 
			String timeInfo = "2021-10-31 12:02:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-10-31 12:02:00";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		
		@Test 
		public void getLocalTimeStamp_10310000_true_byStub() {
			
			 /*  
			  *  Test getLocalTimeStamp and give timeInfo is "2021-10-31 00:00:00" 
			  *  to check "00:00:00" whether it transfers to "MIDNIGHT". 
			  */
			
			// given 
			String timeInfo = "2021-10-31 00:00:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-10-31 MIDNIGHT";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		
		@Test 
		public void getLocalTimeStamp_10310001_true_byStub() {
			
			/*  
			 * Test getLocalTimeStamp and give timeInfo is "2021-10-31 00:01:00" 
			 * to check "00:01:00" whether it transfers to "MIDNIGHT".
			 */
			
			// given 
			String timeInfo = "2021-10-31 00:01:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo, isZone);
			
			// when
			String expected = "2021-10-31 MIDNIGHT";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		
		@Test 
		public void getLocalTimeStamp_1031000200_true_byStub() {
			
			/*  
			 * Test getLocalTimeStamp and give timeInfo is "2021-10-31 00:02:00" 
			 * to check "00:02:00" whether it not transfers to "MIDNIGHT".
			 */
			
			// given 
			String timeInfo = "2021-10-31 00:02:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-10-31 00:02:00";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		
		@Test 
		public void getLocalTimeStamp_10100800_true_byStub() {
			
			/*  
			 * Test getLocalTimeStamp and give timeInfo is ""2021-10-10 08:00:00" 
			 *  to check "10-10" whether it transfers to "DOUBLE-TEN".
			 */
			 
			// given 
			String timeInfo = "2021-10-10 08:00:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-10-10 DOUBLE-TEN 08:00:00";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		
		@Test 
		public void getLocalTimeStamp_08080800_true_byStub() {
			
			/*  
			 * Test getLocalTimeStamp and give timeInfo is ""2021-08-08 08:00:00" 
			 * to check "08-08" whether it transfers to "FATHER'S DAY".
			 */
			 
			
			// given 
			String timeInfo = "2021-08-08 08:00:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-08-08 FATHER'S DAY 08:00:00";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		
		@Test 
		public void getLocalTimeStamp_12250800_true_byStub() {
			
			/*
			 *  Test getLocalTimeStamp and give timeInfo is ""2021-12-25 08:00:00" 
			 * to check "12-25" whether it transfers to "X'MAS".
			 */
			
			// given 
			String timeInfo = "2021-12-25 08:00:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-12-25 X'MAS 08:00:00";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		
		@Test 
		public void getLocalTimeStamp_12251200_true_byStub() {
			
			/*  
			 * Test getLocalTimeStamp and give timeInfo is ""2021-12-25 12:00:00" 
			 * to check "12-25" and "12:00:00" whether it transfers to "X'MAS NOON".
			 */
			
			// given 
			String timeInfo = "2021-12-25 12:00:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-12-25 X'MAS NOON";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		
		@Test 
		public void getLocalTimeStamp_10100000_true_byStub() {
			
			/*  
			 * Test getLocalTimeStamp and give timeInfo is ""2021-10-10 00:00:00" 
			 * to check "10-10" and "00:00:00" whether it transfers to "DOUBLE-TEN MIDNIGHT".
			 */
		
			// given 
			String timeInfo = "2021-10-10 00:00:00";
			// "isZone = true" means user choosed time zone.
			boolean isZone = true;
			
			OoooSmartClock smartClock = new TestStubForOoooSmartClock(timeInfo,isZone);
			
			// when
			String expected = "2021-10-10 DOUBLE-TEN MIDNIGHT";
			
			// then 
			String result = smartClock.getLocalCurrentTimeStamp();
			assertEquals(expected, result);
		}
		
		
}
