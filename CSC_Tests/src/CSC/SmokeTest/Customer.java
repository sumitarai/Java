/*
 * This class will allow to create a new Customer  and lookup for Customer if customer exist already
 *  
 * @author Sumita Rai
 * December 16, 2017
 * Last Mod: 04/19/2018
 */

package SmokeTest;

import java.util.Random;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import UtilityLib.ReadExcelFile;

public class Customer {
		
//This method will create a customer
		public static String createNewCustomer(ChromeDriver driver) throws InterruptedException{
		
			Logger logger = Logger.getLogger("Customer");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
			
			String custSAPNumber = "";
			try {
			//Customer Lookup 
			driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_btnMainMenu']/img")).click();   // Clicked to reset to Main menu
			WebElement custLookup = driver.findElement(By.linkText("Customer Lookup"));  // Click the customer lookup link
			custLookup.click();
			System.out.println("Customer.createNewCustomer - This opens the Customer search page");
			Thread.sleep(2000); 	
				
				//verify if opens the Customer Lookup page	
				String custLookupPage = driver.findElement(By.xpath(".//*[@id='tabSearchCriteria_contentTab_lblTitle']")).getText();
				if(custLookupPage.equals("Customer Lookup")){
				System.out.println("Customer.createNewCustomer - You are in Customer Lookup search page!");
							
				//Create new Acct		
				WebElement newAcct = driver.findElement(By.xpath("html/body/form/div[3]/div/div[2]/div[2]/div[1]/div[1]/input"));   //Click New from Customer Lookup page
				newAcct.click();
				System.out.println("Customer.createNewCustomer - It opens 'General Customer Data' page. Allows to pass Customer info.");	
				Thread.sleep(5000);	
	
				// to create a unique Customer, use random number method every time when it is created	
				Random r = new Random();		
				driver.findElement(By.id("txtFirstName_contentTextBox_Edit")).sendKeys("AutoTest" + r.nextInt(100));      		//Use random for first name
				
				ReadExcelFile custNameandAdd = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\SetupExcel.xlsx");
				
				WebElement custLN = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/div[2]/input")); 			//Feed LN from spreadsheet
				String custLastName = custNameandAdd.getNameInfo(1, 1, 1);  // sheet, row, col
				custLN.sendKeys(custLastName);						
				
				WebElement custStreetAddress = driver.findElement(By.xpath(".//*[@id='txtAddress1_contentTextBox_Edit']"));	//Feed street address from spreadsheet
				String custNewAddress = custNameandAdd.getStreetInfo(1, 1, 2);
				custStreetAddress.sendKeys(custNewAddress);	
				
				WebElement postalCode = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[7]/div[2]/input"));  	//Feed postal code
				String postalAddress = custNameandAdd.getPostalInfo(1, 1, 3);
				postalCode.sendKeys(postalAddress);		
								
				driver.findElement(By.xpath(".//*[@id='txtMobilePhone_contentTextBox_Edit']")).sendKeys("7208959801");		// Enter phone number		
				driver.findElement(By.xpath(".//*[@id='txtEmail_contentTextBox_Edit']")).sendKeys("AutoTest" + r.nextInt(100) + "@checkouttest.com");
	
				WebElement genSelection = driver.findElement(By.xpath(".//*[@id='lstGender_contentDropDownList_Edit']"));
				Select gender = new Select(genSelection);
				gender.selectByIndex(2);
	
				driver.findElement(By.xpath(".//*[@id='contentTab_Save_slideBtnLink']")).click();     	// Click Create Account button to save
				driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button[2]")).click();   		// Click Yes option in Please Confirm window		
				System.out.println("Customer.createNewCustomer - You saved a New Customer account and loading Customer Data Page");			
				Thread.sleep(10000);
				
				//assert if this opens new customer account page					
					String expectedDataStatus = "General Customer Data";
					String actualDataStatus = driver.findElement(By.xpath(".//*[@id='tabMasterData_contentTab_lblTitle']")).getText();
					if (expectedDataStatus.equals(actualDataStatus)){
						System.out.println("Customer.createNewCustomer - New Customer data page loaded successfully!");
						
						Thread.sleep(10000);
						custSAPNumber = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/span")).getText();
						System.out.println("Customer.createNewCustomer - Customer Number: " + custSAPNumber);        //(.//*[@id='txtSAPCustomerNumber_contentTextBox_Display'])
						logger.info("Customer: " + custSAPNumber);
						Thread.sleep(2000);
						driver.findElement(By.xpath("html/body/form/div[3]/div/div[2]/div[2]/div[2]/div[2]/a/img")).click();  // [Clicked Main menu to reset after creating new customer = .//*[@id='ctl00_ctl00_btnMainMenu']/img]
					}else{
						System.out.println("Customer.createNewCustomer - Failed to create an account");				
					}
			}else{
				System.out.println("Customer.createNewCustomer - Failed to load Customer Lookup search page");
				return null;	
			}
			}catch (Exception e) {
					System.out.println("Error encounter message: " + e.getMessage());	
			}		
		return custSAPNumber;		
	}	
	
	
//This method will allow to lookup Customer 
	 public static ChromeDriver findCustomer(ChromeDriver driver, String custSAPNumber) throws InterruptedException{
			
		Logger logger = Logger.getLogger("Customer");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");
		
		WebElement custLookup = driver.findElement(By.linkText("Customer Lookup"));  // Click the customer lookup link
		custLookup.click();
		System.out.println("Customer.findCustomer - This opens the Customer search page");
		Thread.sleep(2000); 
			
		//verify if opens the Customer Lookup page
		try {
			String custLookupPage = driver.findElement(By.xpath(".//*[@id='tabSearchCriteria_contentTab_lblTitle']")).getText();
			if(custLookupPage.equals("Customer Lookup")){
			System.out.println("Customer.findCustomer - You are in Customer Lookup search page!");
		
			// Search for Customer and enter values
			driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_btnClear']")).click();   // clear the search criteria before entering the values
			Thread.sleep(2000);
			//Customer search criteria input field
			WebElement custNumber =	driver.findElement(By.xpath(".//*[@id='txtSAPCustomerNumber']"));
			custNumber.sendKeys(custSAPNumber); // pass customer SAP number		
			logger.info("Customer: " + custSAPNumber);
			driver.findElement(By.xpath(".//*[@id='submitSearch_slideBtnLink']")).click();  // Click search button
			System.out.println("Customer.findCustomer - It is displaying Customer Lookup results");
			Thread.sleep(2000);
		
			driver.findElement(By.xpath(".//*[@id='divSearchResults']/div/div[2]")).click();  // clicking the search result 
			System.out.println("Customer.findCustomer - Loading customer data page"); 
			Thread.sleep(2000);
			
				// assert if this is the Customer Data Page			
				String genData = driver.findElement(By.xpath(".//*[@id='tabMasterData_contentTab_BodyWrapper']/div[1]/div[1]/div[1]")).getText();
				if (genData.equals("General Data")){
					System.out.println("Customer.findCustomer - General Customer Data page loaded successfully!");
					Thread.sleep(2000);
					}
				else {
					System.out.println("Customer.findCustomer - Failed loading Customer data page");
					logger.info("Customer.findCustomer - Failed loading Customer data page");
					return null;
				}
			}else {
				System.out.println("Customer.findCustomer - Failed search page");
				logger.info("Customer.findCustomer - Failed search page");
				return null;	
			} 				 
				
		} catch (Exception e) {
				System.out.println("Customer.findCustomer - Error encountered: " + e.getMessage());
				logger.info("Customer.findCustomer - Error encountered");
		}			
	return driver;
			
	}
	 
//This method will allow to return to Customer data page 
	public static ChromeDriver rtrnCustomer(ChromeDriver driver) throws InterruptedException{
		Logger logger = Logger.getLogger("Customer");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
		WebElement custRtrn = driver.findElement(By.xpath(".//*[@id='btnCustHistory_slideBtnLink']"));
		custRtrn.click();
		Thread.sleep(5000);
		// assert if this is the Customer Data Page			
		String genData = driver.findElement(By.xpath(".//*[@id='tabMasterData_contentTab_BodyWrapper']/div[1]/div[1]/div[1]")).getText();
		if (genData.equals("General Data")){
			System.out.println("Customer.rtrnCustomer - General Customer Data page loaded successfully!");
			}
		else {
			System.out.println("Customer.rtrnCustomer - Failed loading Customer data page");
			logger.info("Customer.rtrnCustomer - Failed loading Customer data page");
			return null;
		}
		 
		return driver; 
	}
}
