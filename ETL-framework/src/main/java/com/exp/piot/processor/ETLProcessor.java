/**
 * ETLProcessor.java
 */
package com.exp.piot.processor;

/**
 *
 * ETL-piot-csv : com.exp.piot.processor
 *
 * @author vishnu.g
 *
 * 12-Dec-2017
 */
public interface ETLProcessor {
	
	public void downloadFile();

	public void processFile();

}
