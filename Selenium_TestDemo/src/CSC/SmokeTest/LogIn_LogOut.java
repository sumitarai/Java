/*
 * This class will allow to open CSC URL and User login/logout 
 * 
 * @author Sumita Rai
 * December 02, 2017
 */

package SmokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogIn_LogOut {
	//Lets declare a constant URL to maintain the website name in one place and access from diff. classes if needed
		public static final String URL = Utility.getCredential("URL");    //it will get the URL value from credential.json file    
		
	//This method will allow to open given URL in Chrome browser
		public static ChromeDriver openUrl() throws InterruptedException {
	    // LogIn_LogOut class has the Chrome driver object in order to login to CSC
			System.setProperty("webdriver.chrome.driver", "C:\\Work\\Automation\\Chrome_Driver\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-infobars");	
			
			ChromeDriver driver = new ChromeDriver(option);
			driver.manage().window().maximize();  // max browser window
			
			//Launch the Chrome browser and open the application url 
			driver.get(URL);
			Thread.sleep(2000);
			
			//Assert if it open the right application URL. Expected result is same as actual result and print the result
			String expectedTitle = "Shane Co. Customer Service Center";		
			String actualTitle = driver.getTitle();// fetch the current title of the web page 
			if (expectedTitle.equals(actualTitle)){
				System.out.println("LogIn_LogOut.logIn - Verification successful! Title page is displayed correctly");
			}else {
				System.out.println("LogIn_LogOut.logIn - Title page verification failed!");
				return null;         // To stops from subsequent steps
			}
			Thread.sleep(2000);
			return driver;
		}
					
			
			
	//This method will allow to login to CSC using credentials from CSC_Login Excel by calling ReadExcel.getCSCUsername() method
			public static ChromeDriver logIn(ChromeDriver driver) throws InterruptedException{
			
				try{
				//Instantiate the webelement reference with xpath locator
				WebElement userName = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div/div[2]/div/div/center/div/div/div/table/tbody/tr/td/div[1]/input"));
				String strUsername = Utility.getCredential("Username");
				userName.sendKeys(strUsername); // Enter the specified value in the textbox
				System.out.println("LogIn_LogOut.logIn - " + strUsername);
				Thread.sleep(2000);
				
				// Read Password from CSC_Login Excel by calling ReadExcel.getCSCPassword() method
				WebElement passWord = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div/div[2]/div/div/center/div/div/div/table/tbody/tr/td/div[2]/input"));
				String strPassword = Utility.getCredential("Password");
				passWord.sendKeys(strPassword);
				System.out.println("LogIn_LogOut.logIn - " + strPassword);
				Thread.sleep(2000);
				
				//Click Submit button to Signin
				WebElement submitButton = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div/div[2]/div/div/center/div/div/div/table/tbody/tr/td/div[4]/input"));
				submitButton.click();
				System.out.println("LogIn_LogOut.logIn-Submit button is clicked");	
				Thread.sleep(2000);				
							
				//Assert if User loged-In correctly
					String expectedStatus = "RAIS";
					String actualLoginStatus = driver.findElement(By.xpath(".//*[@id='lblGlobalUserName']")).getText();  // absolute path		
					if (expectedStatus.equals(actualLoginStatus)){
						System.out.println("LogIn_LogOut.logIn - Login successful! You are logged in as manager "+ actualLoginStatus);
					}else{
						System.out.println("LogIn_LogOut.logIn - Verification Failed! Incorrect login");
						return null;
						}		
					}
				catch(Exception e){
						System.out.println("LogIn_LogOut.logIn - Encountered Error. "+ e.getMessage());
						return null;					
					}
				Thread.sleep(2000);
				return driver;
		}	

		
	//This method will allow user to logoff from CSC 
			public static void logOut(ChromeDriver driver) throws InterruptedException{   // void will return null
				Thread.sleep(5000);
				WebElement logOff = driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_btnLogoff']"));
				logOff.click();
				System.out.println("LogIn_LogOut.logOut - Log Off link is clicked");			
							
				Thread.sleep(10000);
				WebElement yesConfirmation = driver.findElement(By.xpath("//button[.='Yes']"));
				yesConfirmation.click();
				System.out.println("LogIn_LogOut.logOut - Logoff confirmed yes");
				
				//assert if logout successfully
				Thread.sleep(2000);
					try {					
					String expectedLogStatus = "http://csctest.wsmcorp.com/Default.aspx";
					String actualLogStatus = driver.getCurrentUrl();
					
						if(expectedLogStatus.equals(actualLogStatus)){
							System.out.println("LogIn_LogOut.logOut - Logout verification successful!");
						}else {
							System.out.println("LogIn_LogOut.logOut - Logout verification Failed!");
						}
					} 
				catch (Exception e) {
					System.out.println("Error encountered: " + e.getMessage());
				}	
			}	
		

}
