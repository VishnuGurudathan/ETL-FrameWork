/**
 * TimeHelper.java
 */
package com.etl.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * ETL-ph-csv : com.exp.piot.utils
 *
 * @author vishnu.g
 *
 * 		   22-Jan-2018
 * </br><p>Convenience class for time related tasks</p>
 */
public class TimeHelper {
	
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * Pause thread execution for a while.
	 */
	public static void pauseForAWhile(long milliseconds) throws InterruptedException 
	{
		try 
		{
			Thread.sleep(milliseconds);
		} 
		catch (InterruptedException exc) 
		{
			throw exc;
		}
	}

	/**
	 * Method to convert date string to epoch timestamp.
	 * @param dateTime
	 * @param timeZone
	 * @return {@link Long}
	 * @throws ParseException
	 */
	public static Long toEpochTimeStamp(String dateTime, String timeZone) throws ParseException
	{
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		Date startDate = null;

		dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		startDate = dateFormat.parse(dateTime);
		
		return startDate.getTime();
	}
	
	/**
	 * Method to convert date string to epoch timestamp.
	 * @param dateTime
	 * @return {@link Long}
	 * @throws ParseException
	 */
	public static Long toEpochTimeStamp(String dateTime) throws ParseException
	{
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		Date startDate = null;
		startDate = dateFormat.parse(dateTime);
		return startDate.getTime();
	}
	
	/**
	 * Find the time stamp before {@link numDays} from current day.
	 * @param numDays
	 * @return {@link Long} Epoch TimeStamp
	 */
	public static Long findPreviousDay(int numDays) 
	{
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getDefault());
		cal.setTime(currentDate);
		
		cal.add(Calendar.DAY_OF_MONTH,-numDays);
	    return cal.getTimeInMillis();
	    
		
	}
	

}
