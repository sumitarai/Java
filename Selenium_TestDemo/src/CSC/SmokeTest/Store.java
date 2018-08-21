/*
 * This class will allow to select the store location, Open store and Issue opening funds
 *  
 * @author Sumita Rai
 * December 10, 2017
 * Last Mod: 04/18/2018
 */

package SmokeTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Store {
	
//This method will allow to select the store location
	public static ChromeDriver storeLoc(ChromeDriver driver) throws InterruptedException	{
			/*	String arrStore[] = { "0001 - Western Stone and Metal",
						  "0002 - Shane Co. Englewood",
						  "0007 - Shane Co. San Mateo",
						  "0008 - Shane Co. Lynnwood",
						  "0010 - Shane Co. Portland",
						  "0011 - Shane Co. Walnut Creek",
						  "0012 - Shane Co. Cupertino",
						  "0014 - Shane Co. Salt Lake",
						  "0015 - Shane Co. Duluth",
						  "0016 - Shane Co. Indianapolis",
						  "0017 - Shane Co. Louisville",
						  "0018 - Shane Co. Minneapolis",
						  "0019 - Shane Co. St. Paul",
						  "0020 - Shane Co. Westminster",
						  "0021 - Shane Co. St. Louis",
						  "0023 - Shane Co. Kennesaw",
						  "0024 - Shane Co. Phoenix",
						  "0025 - Shane Co. Alpharetta",
						  "0027 - Shane Co. Roseville",
						  "0028 - Shane Co. E-Store",
						  "0030 - Shane Co. Nashville",
						  "0031 - Shane Co. Kansas City"		};
				*/	
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); // Create a select object that will allow to select from the dropdown list
				stSelect.selectByIndex(3); // Index 1 will allow to select Store 8
				
				//System.out.println(stSelect.getOptions().get(3).getText());
				Thread.sleep(2000);				
				

				//WebDriverWait wait = new WebDriverWait(driver, 2000);
				//wait.until(ExpectedConditions.stalenessOf(stSelection));
				
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); // Get the WebElement and text after selecting the ST in order to verify
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0008 - Shane Co. Lynnwood";
						String actualStoreVerify = stSelect1.getOptions().get(3).getText();
						
						System.out.println("Store.storeLoc - Actual store: "+ actualStoreVerify);
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc - You have selected ST 2 successfully!");
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc - Failed to find store");
								logger.info("Failed to find Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
		
// This method will allow to open store
	public static ChromeDriver openStore(ChromeDriver driver) throws InterruptedException	{				         
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				WebElement mainMenu;    // This will reset to main menu page from where all the links can be accessed
				mainMenu = driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_btnMainMenu']/img"));
				mainMenu.click();
				
				WebElement Stores;
				Stores = driver.findElement(By.xpath("html/body/form/div[3]/div/div[4]/div[4]/div/div/div[3]/div[1]/div[2]/div/div/div[1]/a"));
				Stores.click();
				Thread.sleep(2000);  // manage time out. It allows to load 'open the store selection' page
				
				WebElement openBtn = driver.findElement(By.xpath("html/body/div[7]/div[3]/div/button[2]"));
				openBtn.click();
				System.out.println("Store.openStore - Open Store link is clicked");
				Thread.sleep(2000);
				
					// Assert if Store is open
					try {
						String expectedStoreStatus = "Store is Currently Open";
						String actualStoreStatus = driver.findElement(By.xpath(".//*[@id='divStoreStatusBanner']")).getText();
						if(expectedStoreStatus.equals(actualStoreStatus))
						{
							System.out.println("Store.openStore - Store opened successfully!");
						}
						else {
							System.out.println("Store.openStore - Failed to open store");
							logger.info("Failed to open Store");
							return null;
						}
					} catch (Exception e) {
						System.out.println("Store.openStore - Error encountered: "+ e.getMessage());
						return null;
					}
					Thread.sleep(2000);
				return driver;
	}
				
	
//This method will allow to Open Funds	
	public static ChromeDriver openFund(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");			
				WebElement openFund;
				openFund = driver.findElement(By.xpath(".//*[@id='lnktabCashierFunctionsIssue_Opening_Funds']"));
				openFund.click();
				driver.findElement(By.xpath(".//*[@id='tbOpeningFunds']")).sendKeys("200");		
				driver.findElement(By.xpath(".//*[@id='btn-accept']")).click();
				System.out.println("Enter amount first time");
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='tbOpeningFundsReEnter']")).sendKeys("200");;
				driver.findElement(By.xpath(".//*[@id='btn-accept2']")).click();
				System.out.println("Open fund: $200");
				Thread.sleep(2000);		
					//Assert if the Funds issued
					try {
						String expectedFundIssued = "Issue Opening Funds";
						String actualFundIssued = driver.findElement(By.xpath(".//*[@id='lnktabCashierFunctionsIssue_Opening_Funds']")).getText();
						if (expectedFundIssued.equals(actualFundIssued)) {
							System.out.println("Store.openFund - Funds Issue verification Successful!");
						}else {
							System.out.println("Store.openFund - Funds Issue verification Failed!");
							logger.info("Failed to issue Fund");
							return null;
						}
						
					} catch (Exception e) {
						System.out.println("Store.manageStore - Error encountered: " + e.getMessage());
						return null;
					}
					 		
			return driver;
		}
			

}
