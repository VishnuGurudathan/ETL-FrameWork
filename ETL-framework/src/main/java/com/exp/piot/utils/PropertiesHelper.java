/**
 * PropertyHelper.java
 */
package com.exp.piot.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * ETL-piot-csv : com.exp.piot.utils
 *
 * @author vishnu.g
 *
 * 12-Dec-2017
 */
/**
 * Properties helper. Enables typed extraction of data from a properties file.
 */
public class PropertiesHelper
{
    private Properties properties;
    
    /**
     * Constructor
     * 
     * @param properties
     */
    public PropertiesHelper(Properties properties)
    {
    	this.properties = properties;
    }
    /**
     * Constructor
     * 
     * @param file
     * @throws IOException 
     */
    public PropertiesHelper(File file) 
    		throws FileNotFoundException, IOException
    {
    	Properties properties 			= null;
    	FileInputStream fileInputStream = new FileInputStream(file);
    	properties 						= new Properties();
    	
    	properties.load(fileInputStream);
    	fileInputStream.close();
    	this.properties = properties;
    }
    /**
     * Constructor
     * 
     * @param fileName
     * @throws FileNotFoundException
     * @throws IOException
     */
    public PropertiesHelper(String fileName) 
    		throws FileNotFoundException, IOException
    {
    	Properties properties  			= null;
    	FileInputStream fileInputStream = new FileInputStream(fileName);
    	properties 						= new Properties();
    	
    	properties.load(fileInputStream);
    	fileInputStream.close();
    	this.properties = properties;
    }
    
    /**
     * Set Properties
     * @param properties
     */
    public void setProperties(Properties properties)
    {
    	this.properties = properties;
    }
    
    /**
     * Get String value.
     * 
     * @param key
     * @return
     */
    public String getStringPropertyValue(String key)
    {
    	String value = (String) properties.getProperty(key);
    	if (value == null)
    		return null;
    	
    	return value.trim();
    }
    
    /**
     * Get double value property
     */
    public Long getLongPropertyValue(String key)
    {
        try
        {
            String value = (String) properties.get(key);
            
            if(value == null)
                return null;
            
            value        = value.trim();
            Long longobj = Long.valueOf(value);
            
            // Check that contained text represents a proper number
            Long.valueOf(value).longValue();
     
            return longobj;
        }
        catch(NumberFormatException exc)
        {
            return null;
        }
    }
    
}
