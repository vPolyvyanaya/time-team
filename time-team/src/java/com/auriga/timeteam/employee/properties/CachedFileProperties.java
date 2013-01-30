package com.auriga.timeteam.employee.properties;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CachedFileProperties extends AbstractPropertiesBase {
	private static volatile CachedFileProperties instance;
	private Map properties = new Properties();
	
	private CachedFileProperties(){			
		loadDefaultProperties();
		overridePropertiesByTopical();			
	}	
	
	public static CachedFileProperties getInstance(){
		if(instance == null){
			synchronized (CachedFileProperties.class){
				if(instance == null){
					instance = new CachedFileProperties();
				}
			}
		}
		return instance;
	}
	
	
	public String getProperty(String key){
		if(properties != null){
			Object value = properties.get(key);
			if(value != null){
				return value.toString();
		    }
		}
		return "";
	}
	
	private void loadDefaultProperties(){
		File currentDir = new File(".");
		String sFilePath;
		try {
			sFilePath = currentDir.getCanonicalPath() + "/resources/time-team.properties";
			PropertyReader propertyReader = new PropertyReader(sFilePath);
			properties = propertyReader.getProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void overridePropertiesByTopical(){
		PropertyReader propertyReader = new PropertyReader("/opt/time-team/etc/time-team.properties");
		Map topicalProperties = propertyReader.getProperties();
		Set<Map.Entry> propertySet = topicalProperties.entrySet();	
		for(Map.Entry entry : propertySet){
			properties.put(entry.getKey(), entry.getValue());
		}		
	}

}
