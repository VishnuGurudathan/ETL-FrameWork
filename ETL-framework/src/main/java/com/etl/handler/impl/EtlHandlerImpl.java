/**
 * EtlHandlerImpl.java
 */
package com.etl.handler.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Timer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.etl.handler.BaseHandler;
import com.etl.scheduler.EtlScheduler;
import com.etl.utils.ProjectConstants;
import com.etl.utils.PropertiesHelper;
import com.etl.utils.ServiceSettings;

/**
 *
 * etl-framework : com.etl
 *
 * @author vishnu.g
 *
 *         22-Feb-2018
 */
public class EtlHandlerImpl implements BaseHandler {

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
		} 
		catch (Exception exc) 
		{
			System.out.println("Logger not configured (or log4j properties file is missing), " + exc.getMessage());
		}
	}

	public void stop() {
		logger.warn("Shutting down application");
	}

	private static long getScheduledInterval() 
	{
		PropertiesHelper propertiesHelper = null;
		try 
		{
			propertiesHelper = new PropertiesHelper(ProjectConstants.APPLICATION_PROPERTY);
		} 
		catch (FileNotFoundException exc) 
		{
			logger.error(exc.getMessage());
		} 
		catch (IOException ioe) 
		{
			logger.error(ioe.getMessage());
		}

		return ServiceSettings.getInstance().getScheduledInterval(propertiesHelper);
	}

}
