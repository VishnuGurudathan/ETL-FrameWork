/**
 * RawDatapH.java
 */
package com.exp.piot.dto;

import java.io.Serializable;

/**
 *
 * ETL-piot-csv : com.exp.piot.dto
 *
 * @author vishnu.g
 *
 * 12-Dec-2017
 */
public class RawData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8720609863372879608L;

	private long timeStamp;
	private double rawDataValue;

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getRawDataValue() {
		return rawDataValue;
	}

	public void setRawDataValue(double rawDataValue) {
		this.rawDataValue = rawDataValue;
	}

}
