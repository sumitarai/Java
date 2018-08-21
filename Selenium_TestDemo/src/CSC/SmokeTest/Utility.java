/*
 * This class will have only Static methods and provide functionality that can be reused in different class when necessary
 * utility class store credentials file, getTax and writeLog methods
 *  
 * @author Sumita Rai
 * December 26, 2017
 * Last Mod: 04/17/2018
 */

package SmokeTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {	
	
	private static final String FILENAME = "C:\\Users\\sumita.rai\\CSC_Credentials\\Credential.json";  	
	
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
}
