/**
 * EtlHandlerImpl.java
 */
package com.exp.piot.handler.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Timer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.exp.piot.handler.BaseHandler;
import com.exp.piot.scheduler.EtlScheduler;
import com.exp.piot.utils.ProjectConstants;
import com.exp.piot.utils.PropertiesHelper;
import com.exp.piot.utils.ServiceSettings;

/**
 *
 * ETL-piot-csv : com.exp.piot
 *
 * @author vishnu.g
 *
 * 12-Dec-2017
 */
public class EtlHandlerImpl implements BaseHandler{


	private static final Logger logger = Logger.getLogger(EtlHandlerImpl.class);
	private Timer timer;
	private static final long INITIAL_DELAY = 600;
	private EtlScheduler scheduler;
	
	public void start() 
	{
		configLogger();
		scheduler = new EtlScheduler();

		long scheduleInterval = getScheduledInterval();
		if (scheduleInterval == -1)
			return;

		logger.info("Starting schedular with interval - " + scheduleInterval);
		timer = new Timer();
		timer.schedule(scheduler, INITIAL_DELAY, scheduleInterval);
	}
	
	/**
	 * Enable logging configuration.
	 */
	private void configLogger() 
	{
		final String LOG_FILE = ProjectConstants.LOG4J_PROPERTIES_FILE;
		Properties logProp = new Properties();
		try 
		{
			logProp.load(ClassLoader.getSystemResourceAsStream(LOG_FILE));
			PropertyConfigurator.configure(logProp);
			logger.info("Configuring logger");
		} catch (Exception exc) 
		{
			System.out.println("Logger not configured (or log4j properties file is missing), " + exc.getMessage());
		}
	}

	public void stop() 
	{
		logger.warn("Shutting down application");
	}

	private static long getScheduledInterval()
	{
		PropertiesHelper propertiesHelper = null;
		try {
			propertiesHelper = new PropertiesHelper(ProjectConstants.APPLICATION_PROPERTY);
		} catch (FileNotFoundException e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return ServiceSettings.getInstance().getScheduledInterval(propertiesHelper);
	}
	
}
