/**
 * ETLProcessor.java
 */
package com.etl.job;

/**
 *
 * etl-framework : com.etl.processor
 *
 * @author vishnu.g
 *
 *         22-Feb-2018
 */
public interface ETLJobLauncher {
	
	public void itemReader();

	public void itemProcessor();
	
	public void itemWriter();

}
