/**
 * ETLHandler.java
 */
package com.etl;

import com.etl.handler.BaseHandler;
import com.etl.handler.impl.EtlHandlerImpl;

/**
 *
 * etl-framework : com.etl
 *
 * @author vishnu.g
 *
 *         22-Feb-2018
 */
public class ETLHandler {

	private BaseHandler baseHandler;

	/**
	 * Start Etl
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO: Pass argument start and stop to handle start and stop functions
		// of ETL.
		new ETLHandler().start();
		/*
		 * switch (args[0].toString().toUpperCase()) { case "START": new
		 * ETLHandler().start(); break; case "STOP": new ETLHandler().stop();
		 * break; default: System.out.println(
		 * "Invalid argument. Start/Stop the application by providing arguments START/STOP"
		 * ); }
		 */
	}

	private void start() {
		baseHandler = new EtlHandlerImpl();
		baseHandler.start();
	}

	private void stop() {
		baseHandler.stop();
	}

}
