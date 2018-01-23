/**
 * ETLHandler.java
 */
package com.exp.piot;

import com.exp.piot.handler.BaseHandler;
import com.exp.piot.handler.impl.EtlHandlerImpl;


/**
 *
 * ETL-piot-csv : com.exp.piot
 *
 * @author vishnu.g
 *
 * 12-Dec-2017
 */
public class ETLHandler {
	
	private BaseHandler baseHandler;
	
	/**
	 * Start Etl
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO: Pass argument start and stop to handle start and stop functions of ETL.
		new ETLHandler().start();
		/*
			switch (args[0].toString().toUpperCase())
			{
			case "START":
				new ETLHandler().start();
				break;
			case "STOP":
				new ETLHandler().stop();
				break;
			default:
				System.out.println("Invalid argument. Start/Stop the application by providing arguments START/STOP");
			}
		*/
	}
	
	private void start()
	{
		baseHandler = new EtlHandlerImpl();
		baseHandler.start();
	}
	
	private void stop()
	{
		baseHandler.stop();
	}

}
