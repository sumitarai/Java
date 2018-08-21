
import java.text.SimpleDateFormat;
import java.util.Date;


import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class Utility {	
	
	//Utility.createFile();	
	//Utility.writeLog("This is my test");
	
//Create a File
	public static void createFile(){
			
		Logger logger = Logger.getLogger("Utility");   // logger specify class name in string
		
		try{	
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
			Date date = new Date();  			  
			String currentDateTime = formatter.format(date);
			// This block configure the logger with handler 
			FileHandler fh = new FileHandler("C:/Work/Automation/TestLogRslt/TestRsltFile_"+ currentDateTime+".log");
			logger.addHandler(fh);
												
			SimpleFormatter format = new SimpleFormatter();
			fh.setFormatter(format);			
			}catch (Exception e){
				System.out.println("Error encountered: " + e);
		}
		
	}	
	
//writeLog method to write into file		
	public static void writeLog(String strLog){
		Logger logger = Logger.getLogger("SmokeCSCTestRsltFile_16042018225129");   // logger class provides methods for logging process
		
		try{	
			
			FileHandler fh = new FileHandler("C:/Work/Automation/TestLogRslt/TestRsltFile_16042018225129.log");
			logger.addHandler(fh);
			logger.info(strLog);
			}catch (Exception e){
				System.out.println("Error encountered: " + e);
			}		
		}
}
