/**
 * PhSessionService.java
 */
package com.exp.piot.session;

import com.exp.piot.processor.DataValueProcessor;

/**
 *
 * ETL-ph-csv : com.exp.piot.session
 *
 * @author vishnu.g
 *
 * 02-Jan-2018
 */
public class SessionServiceImpl implements SessionService {
	
	private DataValueProcessor processr;
	
	@Override
	public void execute() {
	
		try{
		
			processr.downloadFile();
			
			processr.processFile();
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
