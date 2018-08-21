/*
 * This class will allow to select the store location, Open store and Issue opening funds
 *  
 * @author Sumita Rai
 * December 10, 2017
 * Last Mod: 05/10/2018
 */

package SmokeTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Store {	
	
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
					driver.findElement(By.xpath(".//*[@id='tbOpeningFunds']")).sendKeys("0");		
					driver.findElement(By.xpath(".//*[@id='btn-accept']")).click();
					System.out.println("Entered Opening Funds");
					Thread.sleep(1000);
					driver.findElement(By.xpath(".//*[@id='tbOpeningFundsReEnter']")).sendKeys("0");;
					driver.findElement(By.xpath(".//*[@id='btn-accept2']")).click();
					System.out.println("Re-entered Opening Funds");
					Thread.sleep(2000);		
						//Assert if the Funds issued
						try {
							String expectedFundIssued = "Issue Opening Funds";
							String actualFundIssued = driver.findElement(By.xpath(".//*[@id='lnktabCashierFunctionsIssue_Opening_Funds']")).getText();
							if (expectedFundIssued.equals(actualFundIssued)) {
								System.out.println("Store.openFund - Funds Issued Successfully!");
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
				
	
//This method will allow to select the store location
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
	
	public static ChromeDriver storeLoc01(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); // Create a select object that will allow to select from the dropdown list
				stSelect.selectByIndex(0); // Index 0 will allow to select Store 1				
				//System.out.println(stSelect.getOptions().get(0).getText());
				Thread.sleep(2000);	
				//WebDriverWait wait = new WebDriverWait(driver, 2000);
				//wait.until(ExpectedConditions.stalenessOf(stSelection));
				
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0001 - Western Stone and Metal";
						String actualStoreVerify = stSelect1.getOptions().get(0).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc01 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc01 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc01 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc02(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(1); // Index 1 will allow to select Store 2			
				Thread.sleep(2000);	
				
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0002 - Shane Co. Englewood";
						String actualStoreVerify = stSelect1.getOptions().get(1).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc02 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc02 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc02 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc07(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(2); // Index 2 will allow to select Store 7
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0007 - Shane Co. San Mateo";
						String actualStoreVerify = stSelect1.getOptions().get(2).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc07 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc07 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc07 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
		
	public static ChromeDriver storeLoc08(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); // Create a select object that will allow to select from the dropdown list
				stSelect.selectByIndex(3); // Index 3 will allow to select Store 8
				Thread.sleep(2000);								

					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); // Get the WebElement and text after selecting the ST in order to verify
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0008 - Shane Co. Lynnwood";
						String actualStoreVerify = stSelect1.getOptions().get(3).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc08 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc08 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc08 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
		
	public static ChromeDriver storeLoc10(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(4); // Index 4 will allow to select Store 10
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0010 - Shane Co. Portland";
						String actualStoreVerify = stSelect1.getOptions().get(4).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc10 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc10 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc10 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc11(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(5); // Index 5 will allow to select Store 11
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0011 - Shane Co. Walnut Creek";
						String actualStoreVerify = stSelect1.getOptions().get(5).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc11 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc11 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc11 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
		
	public static ChromeDriver storeLoc12(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(6); // Index 6 will allow to select Store 12
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0012 - Shane Co. Cupertino";
						String actualStoreVerify = stSelect1.getOptions().get(6).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc12 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc12 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc12 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
		
	public static ChromeDriver storeLoc14(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(7); // Index 7 will allow to select Store 14
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0014 - Shane Co. Salt Lake";
						String actualStoreVerify = stSelect1.getOptions().get(7).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc14 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc14 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc14 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
		
	public static ChromeDriver storeLoc15(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(8); // Index 8 will allow to select Store 15
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0015 - Shane Co. Duluth";
						String actualStoreVerify = stSelect1.getOptions().get(8).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc15 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc15 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc15 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc16(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(9); // Index 9 will allow to select Store 16
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0016 - Shane Co. Indianapolis";
						String actualStoreVerify = stSelect1.getOptions().get(9).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc16 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc16 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc16 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc17(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(10); // Index 10 will allow to select Store 17
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0017 - Shane Co. Louisville";
						String actualStoreVerify = stSelect1.getOptions().get(10).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc17 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc17 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc17 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc18(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(11); // Index 11 will allow to select Store 18
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0018 - Shane Co. Minneapolis";
						String actualStoreVerify = stSelect1.getOptions().get(11).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc18 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc18 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc18 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc19(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(12); // Index 12 will allow to select Store 19
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0019 - Shane Co. St. Paul";
						String actualStoreVerify = stSelect1.getOptions().get(12).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc19 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc19 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc19 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc20(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(13); // Index 13 will allow to select Store 20
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0020 - Shane Co. Westminster";
						String actualStoreVerify = stSelect1.getOptions().get(13).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc20 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc20 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc20 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc21(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(14); // Index 14 will allow to select Store 21
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0021 - Shane Co. St. Louis";
						String actualStoreVerify = stSelect1.getOptions().get(14).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc21 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc21 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc21 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc23(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(15); // Index 15 will allow to select Store 23
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0023 - Shane Co. Kennesaw";
						String actualStoreVerify = stSelect1.getOptions().get(15).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc23 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc23 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc23 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc24(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(16); // Index 16 will allow to select Store 24
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0024 - Shane Co. Phoenix";
						String actualStoreVerify = stSelect1.getOptions().get(16).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc24 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc24 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc24 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc25(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(17); // Index 17 will allow to select Store 25
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0025 - Shane Co. Alpharetta";
						String actualStoreVerify = stSelect1.getOptions().get(17).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc25 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc25 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc25 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc27(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(18); // Index 18 will allow to select Store 27
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0027 - Shane Co. Roseville";
						String actualStoreVerify = stSelect1.getOptions().get(18).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc27 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc27 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc27 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc28(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(19); // Index 19 will allow to select Store 28
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0028 - Shane Co. E-Store";
						String actualStoreVerify = stSelect1.getOptions().get(19).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc28 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc28 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc28 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc30(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(20); // Index 20 will allow to select Store 30
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0030 - Shane Co. Nashville";
						String actualStoreVerify = stSelect1.getOptions().get(20).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc30 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc30 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc30 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
	
	public static ChromeDriver storeLoc31(ChromeDriver driver) throws InterruptedException	{
		Logger logger = Logger.getLogger("Store");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
				
				WebElement stSelection = driver.findElement(By.id("ddlGlobalStoreNumber"));	
				Select stSelect = new Select(stSelection); 
				stSelect.selectByIndex(21); // Index 21 will allow to select Store 31
				Thread.sleep(2000);				
								
					//Assert if the store location is correct 
				    try{		
				    	WebElement stSelectionVerify = driver.findElement(By.id("ddlGlobalStoreNumber")); 
						Select stSelect1 = new Select(stSelectionVerify);
				    	
				    	String expectedStore = "0031 - Shane Co. Kansas City";
						String actualStoreVerify = stSelect1.getOptions().get(21).getText();
						Thread.sleep(2000);					
							if (expectedStore.equals(actualStoreVerify)){
								System.out.println("Store.storeLoc31 - You have selected: " + actualStoreVerify);
								logger.info("Store: " + actualStoreVerify);
								}
							else{
								System.out.println("Store.storeLoc31 - Failed to find store");
								logger.info("Failed to select Store");
								return null;
								}
						}	 
					catch (Exception e) {			
						System.out.println("Store.storeLoc31 - Encountered an error: " + e.getMessage());
						return null;
						}
				    Thread.sleep(5000);
				  return driver;				    
			}
}
