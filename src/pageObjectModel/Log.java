package pageObjectModel;

import org.apache.log4j.Logger;

public class Log {
private static Logger Log = Logger.getLogger(Log.class.getName());
	public static void startTestcase (String tcName){
		Log.info("*********************************************************");
		Log.info("*********************************************************");
		Log.info("*********************************************************");
		Log.info("++++++++++++++++"+tcName+"+++++++++++++++++++++++++++++++");
		Log.info("*********************************************************");
		Log.info("*********************************************************");
	}
	
	public static void endTestcase (){
		Log.info("*********************************************************");
		Log.info("*********************************************************");
		Log.info("*********************************************************");
		Log.info("++++++++++++++++     End Test Case     +++++++++++++++++++++++++++++++");
		Log.info("*********************************************************");
		Log.info("*********************************************************");
	}
	public static void info(String message){
		Log.info(message);		
	}
	public static void warn(String message){
		Log.warn(message);		
	}
	public static void error(String message){
		Log.error(message);		
	}
	public static void fatal(String message){
		Log.fatal(message);		
	}
	public static void degbu(String message){
		Log.debug(message);		
	}
}
