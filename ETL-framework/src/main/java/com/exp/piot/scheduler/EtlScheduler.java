/**
 * EtlScheduler.java
 */
package com.exp.piot.scheduler;

import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.exp.piot.session.SessionServiceImpl;
import com.exp.piot.session.SessionService;



/**
 *
 * ETL-piot-csv : com.exp.piot.scheduler
 *
 * @author vishnu.g
 *
 * 12-Dec-2017
 */
public class EtlScheduler extends TimerTask {

	private static final Logger logger = Logger.getLogger(EtlScheduler.class);

	@Override
	public void run() {
		Long startTime = System.currentTimeMillis();
		logger.info("\n******Start******\n");
		logger.info("Starting new session : " + startTime);
		
		SessionService etlSession = new SessionServiceImpl();
		etlSession.execute();
		
		logger.info("Session completed : "
				+ ((System.currentTimeMillis() - startTime) / 1000)
				+ " seconds");
		logger.info("\n******End******\n");
	}

}
