package com.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private Properties config;

	/** 
	 * Load config properties file
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void loadConfigProperties()  
	{
		try {
			config = new Properties();
			config.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getConfig(String configKey){
		return config.getProperty(configKey).trim();
	}

	public int getConfigIntegerValue(String configKey){ 
		return Integer.parseInt(config.getProperty(configKey).trim());
	}

	public boolean getConfigBooleanValue(String configKey){
		return Boolean.parseBoolean(config.getProperty(configKey).trim());
	}

	public Properties getConfigProperties(){
		return config;
	} 
}
