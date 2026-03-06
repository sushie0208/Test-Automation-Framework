package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

	//Singleton Design Pattern
	
	
	private LoggerUtility(){
	
	}
	
	public static Logger getLogger (Class<?>clazz) //That’s why Class<?> clazz is used — so logger knows which class it belongs to.
	{
		Logger logger=null;
		if(logger==null)
		{
			logger=LogManager.getLogger(clazz);
		}
		return logger;
		/*“Give me a logger for the class I pass.
		If logger doesn’t exist yet, create it.
		Otherwise, reuse the existing one.”*/
	}

}
