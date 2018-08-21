/*
 * This class will have only Static methods and provide functionality that can be reused in different class when necessary
 * utility class store credentials file, getTax and writeLog methods
 *  
 * @author Sumita Rai
 * December 26, 2017
 * Last Mod: 04/13/2018
 */

package UtilityLib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
	//private static final String FILENAME = "C:\\Users\\sumita.rai\\CSC_Credentials\\Credential.json";        // QA URL
	private static final String FILENAME = "C:\\Users\\sumita.rai\\CSC_Credentials\\Dev_Credential.json";  	   // DEV URL
		
	public static String getCredential(String key){
	String value="";
	BufferedReader bReader = null;
	FileReader fReader = null;		
	try{			
		fReader = new FileReader(FILENAME);
		bReader = new BufferedReader(fReader);
		
		String readFile;
		String payload="";
		while((readFile = bReader.readLine()) != null)
		{	
			payload = readFile;     //payload read credential json file
			
		}			
			//payload will pass the Credential.json txt. 			
			JSONObject obj= new JSONObject(payload);
			if (key.equals("URL")) {			// Pass the key to get URL value 
				value = obj.getString("URL");
			}else if (key.equals("Username")) {
				value = obj.getString("Username");
			}else {
				value = obj.getString("Password");
			}						
		}catch(IOException e){
			System.out.println("Error encountered:" + e.getMessage());
			value="";
		}catch(JSONException j){
			System.out.println("Error encountered:" + j.getMessage());
			value="";
		}
	return value;
	}	

//getTax static method
	public static double getTax(double itmPrice, double storeTaxRate){   		
		return (itmPrice * storeTaxRate/100); 		
	} 
	
	

	
//writeLog method to write into file		
	public static void writeLog(String strLog){
		Logger logger = Logger.getLogger("SmokeCSCTestLog");   // logger class provides methods for logging process
		
		try{			
			// This block configure the logger with handler and formatter
			FileHandler fh = new FileHandler("C:/Work/Automation/TestLog/SmokeCSCTestLogFile.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.info(strLog);
			}catch (Exception e){
				System.out.println("Error encountered: " + e);
			}		
		}

}
