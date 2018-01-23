/**
 * ServiceSettings.java
 */
package com.exp.piot.utils;

import org.apache.log4j.Logger;

/**
 *
 * ETL-piot-csv : com.exp.piot.utils
 *
 * @author vishnu.g
 *
 * 12-Dec-2017
 */
public class ServiceSettings {
	
	private static ServiceSettings serviceSettings;
	private static final Logger logger = Logger.getLogger(ServiceSettings.class);
	

	/**
	 * 
	 */
	private  ServiceSettings() {}
	
	public static ServiceSettings getInstance(){
		
		if ( serviceSettings == null ){
			
			serviceSettings = new ServiceSettings();
		}
		
		return serviceSettings;
	}
	
	/**
	 * Get Scheduled Interval
	 * 
	 * @param propertiesHelper
	 * @return
	 */
	public long getScheduledInterval(PropertiesHelper propertiesHelper)
	{
		String propertyName = "application.schedule.interval";
		Long scheduledInterval = propertiesHelper.getLongPropertyValue(propertyName);
		
		if (scheduledInterval == null || scheduledInterval.equals("[CHANGE THIS]"))
    	{
    		printPropertyError(propertyName);
    		return -1;
    	}
		return scheduledInterval;
		
	}
	
	public String getDownloadFolder(PropertiesHelper propertiesHelper)
	{
		String propertyName = "local.download.folder";
		String downloadFolder = propertiesHelper.getStringPropertyValue(propertyName);
		
		if (downloadFolder == null || downloadFolder.equals("[CHANGE THIS]"))
    	{
    		printPropertyError(propertyName);
    		return null;
    	}
		return downloadFolder;
		
	}
	
	/**
     * Print property error message
     */
    private void printPropertyError(String property)
    {
        logger.error("could not fetch property, or error therein:, '" + property + "'");
    }
	
	
}
