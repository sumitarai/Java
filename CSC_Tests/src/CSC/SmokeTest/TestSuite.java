/*
 * This class will have main method to run all Test Cases
 * 
 * @author Sumita Rai
 * November 30, 2017
 * Last Mod: 04/13/2018
 * 
 * JSONObject class represents an object, builds an object from a string, and then retrieves values by providing the keys. *   
 */

package SmokeTest;


import org.openqa.selenium.chrome.ChromeDriver;
import org.json.*;

public class TestSuite {	
	public static void main(String[] args) throws InterruptedException, JSONException {			
			try {
					//LogIn_LogOut class methods
					ChromeDriver driver = LogIn_LogOut.openUrl();
					if (driver != null) {     		// if driver is null then do not run next steps
					driver = LogIn_LogOut.logIn(driver);
					if (driver != null) { 			
		
					//Store class methods
					driver = Store.storeLoc10(driver);
					driver = Store.openStore(driver);
					driver = Store.openFund(driver);     // Functional
					
					//Customer class methods
					//String custSAPNumber = Customer.createNewCustomer(driver); 
					String custSAPNumber = "4001256546";  	// When no need to create new customer, pass Customer number (DEV: 4000815147 & 4000815155 & Emp: 4000815439; QA: 4001256546 & 4001257006)
					driver = Customer.findCustomer(driver, custSAPNumber);				
					
					//Run TestCase1 - Standard Sale 
					driver = InitiateOrder.saleItem(driver);  		
					driver = AddItemPage.testCase1(driver); 
					driver = MarketingPage.closerOnly(driver);      
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.corpUsePymt(driver);					
			
					//Run TestCase2 - Standard Sale using Cash
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase2(driver);
					driver = MarketingPage.closerGreeter1(driver);
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.cashPymt(driver);	
		
					//Run TestCase3 - Multiple items using Check 
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase3(driver);
					driver = MarketingPage.closerGreeter2(driver);
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.checkPymt(driver);				
								
					//Run TestCase4 - Standard Sale with Discount using EFT Check
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);  		
					driver = AddItemPage.testCase4(driver);
					driver = MarketingPage.closerGreeter3(driver);      
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.eftPymt(driver);
										
					//Run TestCase5 - Standard Sale using Cashier Check
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase5(driver);
					driver = MarketingPage.closerGreeter3(driver);
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.cashierPymt(driver);	
					
					//Run TestCase6 - Standard Sale using Money Order
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase6(driver);
					driver = MarketingPage.closerOnly(driver);
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.moneyOrderPymt(driver);
					
					//Run TestCase7 - Standard Sale using Travelers Check
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase7(driver);
					driver = MarketingPage.closerGreeter3(driver);
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.travelersChkPymt(driver);
	/*				
					//Run TestCase8 - Standard Sale using Bank Draft
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase8(driver);
					driver = MarketingPage.closerGreeter2(driver);
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.bankDraftPymt(driver);
					
					//Run TestCase9 - Standard Sale using Corp Use
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase9(driver);
					driver = MarketingPage.closerGreeter1(driver);
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.corpUsePymt(driver);
				
					//Run TestCase10 - Standard Sale with Discount amount using Corp Use
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase10(driver);
					driver = MarketingPage.closerGreeter1(driver);
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.corpUsePymt(driver);
				
					//Run TestCase11 - Standard Sale with Discount percent using Corp Use
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase11(driver);
					driver = MarketingPage.closerOnly(driver);
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.corpUsePymt(driver);
					
					//Run TestCase12 - Standard Sale with Discount percent using Corp Use
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase12(driver);
					driver = MarketingPage.closerOnly(driver);
					driver = ItmProcessPage.stndItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.corpUsePymt(driver);
					
					
					//Run TestCase14 - Service item Sale (Add item page will continue to Order summary page)
					driver = InitiateOrder.saleItem(driver);  		
					driver = AddItemPage.testCase14(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.corpUsePymt(driver);
					
										
					//Run TestCase20 - Hold Order/ No payment
					driver = Customer.rtrnCustomer(driver);
					driver = InitiateOrder.saleItem(driver);
					driver = AddItemPage.testCase20(driver);
					driver = MarketingPage.closerGreeter1(driver);
					driver = ItmProcessPage.holdItmOption(driver);
					driver = OrdSummaryPage.orderSum(driver);
					driver = PaymentPage.holdPymt(driver);	
	*/
		
					//LogIn_LogOut.logOut(driver);  // logOut method do not have return driver because there is no usage for driver after logout
					//close the web browser and terminate the program
					//driver.close();
					//System.exit(0);
							
					}else {
					System.out.println("TestSuite - failed launched CSC application");
					}
				}else {
				System.out.println("TestSuite - Failed CSC login");	
				}
			}				
			catch (InterruptedException e) {
			System.out.println("Error encountered: " + e.getMessage());
			}
		 Thread.sleep(5000);		
	}

}


