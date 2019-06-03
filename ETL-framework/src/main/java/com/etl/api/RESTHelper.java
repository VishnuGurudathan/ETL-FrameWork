/**
 * RESTHelper.java
 */
package com.etl.api;

import java.net.URL;

/**
 *
 * etl-framework : com.etl.api
 *
 * @author vishnu.g
 *
 *         22-Feb-2018
 */
public interface RESTHelper<T> {
	
	/**
	 * 
	 * @param url
	 * @param requestVariable
	 * @return
	 */
	public T getObject(URL url, Object requestVariable);
	
	/**
	 * 
	 * @param url
	 * @param t
	 */
	public void putObject(URL url, T t);

}
