/*
 * This class will allow to open CSC application and User login/logout 
 * 
 * @author Sumita Rai
 * July, 13, 2018
 * Last Mod: 07/15/2018
 */
package TestNG;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import UtilityLib.Utility;

public class LogIn_LogOut {
	WebDriver driver;
	//Lets declare a constant URL to maintain the website name in one place and access from diff. classes if needed
	public static final String URL = Utility.getCredential("URL");    //it will get the URL value from credential.json file   

	@Test
	public void OpenBrowser() {	
		Logger logger = Logger.getLogger("LogIn_LogOut");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");
		System.out.println("This will execute first (Open Browser)");
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Automation\\Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver(); // launch browser
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		System.out.println("LogIn_LogOut: URL opened");
		
		//Assert if it open the right application URL. Expected result is same as actual result and print the result
				String expectedTitle = "Shane Co. Customer Service Center";		
				String actualTitle = driver.getTitle();// fetch the current title of the web page 
				if (expectedTitle.equals(actualTitle)){
					String strURL = Utility.getCredential("URL");
					logger.info("CSC URL: "+ strURL);
					System.out.println("LogIn_LogOut.logIn - Verification successful! Title page is displayed correctly");
					
				}else {
					System.out.println("LogIn_LogOut.logIn - Title page verification failed!");
					logger.info("Failed to launch CSC Application");					
				}
	}
	

	@Test(dependsOnMethods = { "OpenBrowser" })
	public void LogIn() {
		System.out.println("This will execute second (LogIn)");
		Logger logger = Logger.getLogger("LogIn_LogOut");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");
		try{
			//Instantiate the webelement reference with xpath locator
			WebElement userName = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div/div[2]/div/div/center/div/div/div/table/tbody/tr/td/div[1]/input"));
			String strUsername = Utility.getCredential("Username");
			userName.sendKeys(strUsername); // Enter the specified value in the textbox
			System.out.println("LogIn_LogOut.logIn - " + strUsername);
			//Thread.sleep(2000);
			
			// Read Password from CSC_Login Excel by calling ReadExcel.getCSCPassword() method
			WebElement passWord = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div/div[2]/div/div/center/div/div/div/table/tbody/tr/td/div[2]/input"));
			String strPassword = Utility.getCredential("Password");
			passWord.sendKeys(strPassword);
			System.out.println("LogIn_LogOut.logIn - " + strPassword);
			//Thread.sleep(2000);
			
			//Click Submit button to Signin
			WebElement submitButton = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div/div[2]/div/div/center/div/div/div/table/tbody/tr/td/div[4]/input"));
			submitButton.click();
			System.out.println("LogIn_LogOut.logIn-Submit button is clicked");	
			Thread.sleep(2000);
			
						
			//Assert if User loged-In correctly
				Thread.sleep(2000);
				String expectedStatus = "RAIS";
				String actualLoginStatus = driver.findElement(By.xpath(".//*[@id='lblGlobalUserName']")).getText();  // absolute path		
				if (expectedStatus.equals(actualLoginStatus)){
					System.out.println("LogIn_LogOut.logIn - Login successful! You are logged in as manager "+ actualLoginStatus);
					logger.info("Login Status : " + actualLoginStatus);
				}else{
					System.out.println("LogIn_LogOut.logIn - Verification Failed! Incorrect login");
					logger.info("Failed Log In");
					
					}		
				}
			catch(Exception e){
					System.out.println("LogIn_LogOut.logIn - Encountered Error. "+ e.getMessage());
										
				}	
	}
	

	@Test(enabled=false)
	public void LogOut() {
		System.out.println("This will execute third (Log Out)");
		Logger logger = Logger.getLogger("LogIn_LogOut");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");
		
		WebElement logOff = driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_btnLogoff']"));
		logOff.click();
		System.out.println("LogIn_LogOut.logOut - Log Off link is clicked");			
					
		WebElement yesConfirmation = driver.findElement(By.xpath("//button[.='Yes']"));
		yesConfirmation.click();
		System.out.println("LogIn_LogOut.logOut - Logoff confirmed yes");
		
		//assert if logout successfully
		try {					
			String expectedLogStatus = "Username";
			String actualLogStatus = driver.findElement(By.xpath(".//*[@id='UserNameLabel']")).getText();
			System.out.println(actualLogStatus);
			
				if(expectedLogStatus.equals(actualLogStatus)){
					System.out.println("LogIn_LogOut.logOut - Logout verification successful!");
					logger.info("You are logged out successfully!");
				}else {
					System.out.println("LogIn_LogOut.logOut - Logout verification Failed!");
					logger.info("Failed log Out");
				}
			} 
		catch (Exception e) {
			System.out.println("Error encountered: " + e.getMessage());
		}	
	}	



}
