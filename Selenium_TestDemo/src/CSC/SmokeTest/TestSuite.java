/*
 * This class will have main method to run all Test cases
 * @author Sumita Rai
 * November 30, 2017
 * 
 * Last modified: 4/13/2018 
 */

package SmokeTest;

import org.json.JSONException;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestSuite {
	public static void main(String[] args) throws InterruptedException, JSONException {		
		
		try {
			
			//LogIn_LogOut class methods
			ChromeDriver driver = LogIn_LogOut.openUrl();
			if (driver != null) { // if driver is null then do not run next steps
			driver = LogIn_LogOut.logIn(driver);
			//if (driver != null) { // if driver is null then do not run next steps

			//Store class methods
			driver = Store.storeLoc(driver);
			driver = Store.openStore(driver);
			//driver = Store.openFund(driver);   //Functional. Comment for now
			
			//Customer class methods
			//String custSAPNumber = Customer.createNewCustomer(driver);    
			String custSAPNumber = "4000815082";    //Pass Customer number when no need to create a Customer
			driver = Customer.findCustomer(driver, custSAPNumber);
			//System.out.println("Driver after findCustomer="+driver);
			
			//InitiateOrder class methods
			driver = InitiateOrder.saleItem(driver);
	
			//Run TestCase1 class methods
			driver = TestCase1.addItemPage(driver);
			driver = TestCase1.mrktPage(driver);
			driver = TestCase1.itmProcessPage(driver);
			driver = TestCase1.ordSummaryPage(driver);
			driver = TestCase1.pymtPage(driver);				
			
			
			//Run TestCase2 
			driver = Customer.findCustomer(driver, custSAPNumber);
			driver = InitiateOrder.saleItem(driver);
			driver = TestCase2.addItemPage(driver);
			driver = TestCase1.mrktPage(driver);
			driver = TestCase2.itmProcessPage(driver);
			driver = TestCase1.ordSummaryPage(driver);
			driver = TestCase2.pymtPage(driver);	
				
	
			//Run TestCase3 
			driver = Customer.findCustomer(driver, custSAPNumber);
			driver = InitiateOrder.saleItem(driver);
			driver = TestCase3.addItemPage(driver);
			driver = TestCase1.mrktPage(driver);
			driver = TestCase3.itmProcessPage(driver);
			driver = TestCase1.ordSummaryPage(driver);
			driver = TestCase3.pymtPage(driver);	
			
			
			//System.out.println("Driver after saleItem="+driver);
			
			
			//LogIn_LogOut.logOut(driver);  // logOut method do not have return driver because there is no usage for driver after logout
			//close the web browser and terminate the program
			//driver.close();
			//System.exit(0);
					
			}else {
			System.out.println("TestCase1-LogIn_LogOut.logIn- URL not open");
			}
		}				
		catch (InterruptedException e) {
		System.out.println("Error encountered: " + e.getMessage());
		}	
			
		Thread.sleep(5000);

	}

}
		
