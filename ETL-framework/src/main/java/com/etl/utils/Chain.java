/**
 * Chain.java
 */
package com.etl.utils;

/**
 *
 * etl-framework : com.etl.utils
 *
 * @author vishnu.g
 *
 *         22-Feb-2018
 */
public interface Chain {

	/**
	 * Set the handler for next chain.
	 * 
	 * @param nextChain
	 */
	public abstract void setNext(Chain nextChain);

	/**
	 * Process the request.
	 * 
	 * @param fileName
	 * @param request
	 */
	public abstract void process(String fileName, Object request) throws Exception;

}