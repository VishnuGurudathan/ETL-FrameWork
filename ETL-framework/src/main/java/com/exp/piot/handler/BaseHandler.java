/**
 * BaseHandler.java
 */
package com.exp.piot.handler;

/**
 *
 * ETL-piot-csv : com.exp.piot.handler
 *
 * @author vishnu.g
 *
 * 12-Dec-2017
 */
public interface BaseHandler {

	/**
	 * Start the handler.
	 */
	public void start();
	
	/**
	 * Stop the handler.
	 */
	public void stop();

}
