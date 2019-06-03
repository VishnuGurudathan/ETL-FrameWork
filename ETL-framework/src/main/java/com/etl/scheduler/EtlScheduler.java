/**
 * EtlScheduler.java
 */
package com.etl.scheduler;

import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.etl.session.SessionService;
import com.etl.session.SessionServiceImpl;


/**
 *
 * etl-framework : com.etl.scheduler
 *
 * @author vishnu.g
 *
 *         22-Jan-2018
 */
public class EtlScheduler extends TimerTask {

	private static final Logger logger = Logger.getLogger(EtlScheduler.class);
	private AtomicInteger counter = new AtomicInteger(0);

	@Override
	public void run() 
	{
		Long startTime = System.currentTimeMillis();
		logger.info("\n******Start******\n");
		logger.info("Starting new session [with Job ID: " + counter.incrementAndGet() + "] at," + startTime);
		
		SessionService etlSession = new SessionServiceImpl();
		etlSession.execute();
		
		logger.info("Session completed [with Job ID: " + counter.get() + "], time taken :"
				+ ((System.currentTimeMillis() - startTime) / 1000)
				+ " seconds");
		logger.info("\n******End******\n");
	}

}
