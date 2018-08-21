/*@author Sumita Rai
 * Feb 20, 2018
 * 
 * Last modified: 4/25/2018 
 */

package SmokeTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import UtilityLib.ReadExcelFile;


public class TestCase1 {
	public static String strBatch;
	public static double dblPrice;
	public static double dblTaxRate;
	public static double dblTax;
	public static double dblTotalPrice;
		
	
		
	// This method to Add item batch/articles in Add Item Page from spreadsheet
		public static ChromeDriver addItemPage(ChromeDriver driver) throws InterruptedException {			
			
			Logger logger = Logger.getLogger("TestCase1");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
				
				WebElement addStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
				addStndItem.click();  						// Click Standard item button in Add Item page
				Thread.sleep(2000);
				
				//Assert if it opens the add standard item window
				try {
					String expectedRslt = "Add Standard Item";
					String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
					if (expectedRslt.equals(actualRslt)) {
						System.out.println("TestCase1.addItemPage - 'Add Standard Item' window opened successfully!");
						
						   ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\Selenium_TestDemo\\Resource\\Batches.xlsx");
					      					       
					       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
					       String strBatch = batch.getBatch(1, 1, 2);  // Single batch
					       System.out.println("TestCase1.addItemPage - Got the batch = " + strBatch); 		       
					       enterBatch.sendKeys(strBatch);   // feeding the strBatch value
						   System.out.println("TestCase1.addItemPage - " + strBatch + " passed from spreadsheet");
						   logger.info("Batch from spreasheet: " + strBatch);
						   Thread.sleep(2000);
						 
						   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
						   Thread.sleep(10000);	
						   
						   driver.findElement(By.xpath(".//div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion
						   System.out.println("TestCase1.addItemPage - Item is added under Add Items sections");
						   Thread.sleep(10000);
						   String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();
						   logger.info("Batch: " + actualItem);
						 
						   //Assert if item is added under Add Items section
						   	   String expecteditmRslt = "Order Items";
							   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
							   if (expecteditmRslt.equals(actualitmRslt)) {
								System.out.println("TestCase1.addItemPage - Item added under Add Items section successfully!");								
								
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
								System.out.println("TestCase1.addItemPage - You clicked Continue to proceed to Marketing page");
								Thread.sleep(5000);
								
							   }else {
								System.out.println("TestCase1.addItemPage - Failed to add an item!");
								return null;
							   }						   					   
						
					}else {
						System.out.println("TestCase1.addItemPage - Failed to open 'Add Standard Item' window!");
						return null; 
					}					
				}catch (Exception e) {
					System.out.println("TestCase1.addItemPage - Error encountered: " + e.getMessage());
					return null;
				}				   		   
			return driver;
		}	
		
	// This method allow to add closer and greeter in Marketing Page
		public static ChromeDriver mrktPage(ChromeDriver driver) throws InterruptedException {
			//Assert if it open Marketing page after clicking Continue button.
			   try {
				   	
				   	String expectedRslt = "Closer / Greeter Details";
					String actualmrktPage = driver.findElement(By.id("tabOrder_mktgData_contentTab_lblTitle")).getText();
					if (expectedRslt.equals(actualmrktPage)) {
						System.out.println("TestCase1.mrktPage - Marketing page loaded successfully!");
						Thread.sleep(2000);
							
						ReadExcelFile mrktInfo = new ReadExcelFile("C:\\Work\\Java\\Selenium_TestDemo\\Resource\\SetupExcel.xlsx");
						
							WebElement enterCloser = driver.findElement(By.xpath(".//*[@id='mktgData_Closer1_sapQuery_TextBox_Edit']")); // closer webelement
							String strCloser = mrktInfo.getCloser(2,1,0);  // Fetch Closer info
							enterCloser.sendKeys(strCloser);						
												
							WebElement enterGreeter1 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter1_sapQuery_TextBox_Edit']")); // greeter webelemnt
							String strGreeter1 = mrktInfo.getGreeter(2,1,1);
							enterGreeter1.sendKeys(strGreeter1); // Fetch Greeter1 info
						
							WebElement enterGreeter2 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter2_sapQuery_TextBox_Edit']"));
							String strGreeter2 = mrktInfo.getGreeter(2,2,1); // Fetch Greeter2 info
							enterGreeter2.sendKeys(strGreeter2);												
						
							driver.findElement(By.xpath(".//*[@id='mktgData_Greeter3_sapQuery_TextBox_Edit']")).sendKeys("200361"); //Enter Greeter3 info
							Thread.sleep(2000);
									
						WebElement purTypeSelection = driver.findElement(By.id("mktgData_PurType_contentDropDownList_Edit")); //Select Purchase Type from dropdown
						Select purTypeSelect = new Select(purTypeSelection); 
						purTypeSelect.selectByIndex(1); // Index 1 will allow to select from the dropdown option						
							String actualpurType = purTypeSelect.getOptions().get(1).getText(); //verify the purchase type
							System.out.println("TestCase1.mrktPage - purchase type selected: " + actualpurType);
							Thread.sleep(2000);
						
						WebElement radioStation = driver.findElement(By.id("mktgData_RadioStation_contentDropDownList_Edit"));  // Select types of Radio station from dropdown
						Select radioTypeSelect = new Select(radioStation);
						radioTypeSelect.selectByIndex(2); // Index 2 allow to select radio station from dropdown
							String actualradioType = radioTypeSelect.getOptions().get(2).getText();
							System.out.println("TestCase1.mrktPage - Radio station selected: " + actualradioType);
							Thread.sleep(2000);
						
						WebElement radioBtn = driver.findElement(By.id("mktgData_WebInit_contentRadioBoxList_Edit_0")); // Click Radio button to Yes or No or Don't Know
						radioBtn.click();
						System.out.println("TestCase1.mrktPage - You clicked 'Yes' radio button");
						Thread.sleep(2000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue button on Marketing page to proceed to Item Processing Page
						System.out.println("TestCase1.mrktage - It is loading Item Processing Page");
						Thread.sleep(5000);
					}
					else {
						System.out.println("TestCase1.mrktPage - Failed marketing page.");
						return null;
					}						
				} catch (Exception e) {
					System.out.println("TestCase1.mrktPage - Error encountered: " +e.getMessage());
					return null;
				}				
			return driver;
		}	
				
	// Item Processing Page
		public static ChromeDriver itmProcessPage(ChromeDriver driver) throws InterruptedException{
			Logger logger = Logger.getLogger("TestCase1");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
			
				// Assert if it loaded the Item Processing Page
					try {
						String expectedRslt = "Item Processing";
						String actualitmProcessPage = driver.findElement(By.id("tabOrder_ItemProc_contentTab_lblTitle")).getText();
						if (expectedRslt.equals(actualitmProcessPage)) {
							System.out.println("TestCase1.itmProcessPage - 'Item Processing' Page loaded successfully!");	
							
							//allow to select "Standard" option from Item Options dropdown in Item Processing Page
							WebElement itmOptions = driver.findElement(By.xpath(".//*[@id='ctrl0_grdProcTable_ddlOption_0']"));
							Select itmOptionsSelect = new Select(itmOptions);
							itmOptionsSelect.selectByIndex(0);   //Standard, Hold, and Layaway item options
								String actualitmProcess = itmOptionsSelect.getOptions().get(0).getText();
								System.out.println("TestCase1.itmProcessPage - "+ actualitmProcess);
								logger.info("Sale Type: " + actualitmProcess);
								Thread.sleep(2000);				
							
							
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue button on Item Processing Page to proceed to Order Summary Page
							System.out.println("TestCase1.itmProcessPage - It is loading 'Order Summary' Page");
							Thread.sleep(5000);
							
							}
						else{
							System.out.println("TestCase1.itmProcessPage - Failed loading 'Item Procesing' Page");
							return null;
							}		
					}catch (Exception e) {
						System.out.println("TestCase1.itmProcessPage - Error encounter: "+ e.getMessage());
						return null;
						}					
				return driver;
			}
							
	// Order Summary Page
		public static ChromeDriver ordSummaryPage(ChromeDriver driver)  throws InterruptedException{		   		  	
				
				//Assert Order Summary Page
					try {
						dblTax = Utility.getTax(dblPrice, dblTaxRate);
						
						String expectedRslt = "Order Summary";
						String actualordSummPage = driver.findElement(By.xpath(".//*[@id='tabOrder_Summary_contentTab_lblTitle']")).getText();
						if (expectedRslt.equals(actualordSummPage)) {
							System.out.println("TestCase1.ordSummaryPage - 'Order Summary' page loaded successfully!");
							
									//04/05/2018: According to Pat, does not require to calculate Tax to assert correct Tax calculation
							
							String actualTax = driver.findElement(By.xpath(".//*[@id='ordItems_TotTax']")).getText(); 
							String strActualTax = actualTax.replace("$","");
							System.out.println("TestCase1.ordSummaryPage - Tax displayed " + strActualTax + " successfully!");	
							Thread.sleep(2000);
							
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click 'Continue' button on Order Summary Page to proceed to Payment Page
							System.out.println("TestCase1.ordSummaryPage - It is loading 'Payment' Page");
							Thread.sleep(5000);												
								
						}else {
							System.out.println("TestCase1.ordSummaryPage - Failed loading 'Order Summary' Page");
							return null; 
						}						
					} catch (Exception e) {
						System.out.println("Error encountered: " + e.getMessage());
						return null;
					}
			return driver;				
		}	
				
					
	//This method allow to select tender type in Payment Page
		public static ChromeDriver pymtPage(ChromeDriver driver) throws InterruptedException{
			Logger logger = Logger.getLogger("TestCase1");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
				
				//Assert if Payment Page is loaded 
					try {
						String expectedPymtRslt = "Payment Options";
						String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
						if (expectedPymtRslt.equals(actualPymtRslt)) {
							System.out.println("TestCase1.pymtPage - Payment Page loaded successfully!");
							Thread.sleep(10000);						
							
							//Select 'Corp Use' Tender Type  
							WebElement tenderSelect = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_New_contentDropDownList_Edit']"));
							Select tenderTypeSelect= new Select(tenderSelect);							
							tenderTypeSelect.selectByVisibleText("Corporate Use"); 
							System.out.println("TestCase1.pymtPage - You have selected tender type: " + tenderTypeSelect.getOptions().get(4).getText());   //If Fund is open 'Corporate Use' is in Index 8 else use Index 4
							Thread.sleep(2000);
														
							// assert if the tender type section is selected correctly																
							String expectedTenderType = "Tender Type"; 
							String actualTenderType = driver.findElement(By.xpath(".//*[@id='divPayOption_Std']/div[1]/span[1]")).getText();
								if (expectedTenderType.equals(actualTenderType)) {
									System.out.println("TestCase1.pymtPage - Tender type selected successfully!");
									Thread.sleep(2000);
									
									String actualTotalPrice = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
									String actualPrice = actualTotalPrice.replace("$","");
									WebElement totalPrice = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendAmount_Std_0000_contentTextBox_Edit']"));   
									totalPrice.sendKeys(actualPrice); // Pass the totalPrice value in Amount field
									logger.info("Total Price: " + actualTotalPrice);
									Thread.sleep(1000);
									driver.findElement(By.xpath(".//*[@id='payOpt_TendNotes0000']")).sendKeys("Test");   //Entering txt in Notes field
									Thread.sleep(1000);
									driver.findElement(By.xpath(".//*[@id='payOpt_TendApply_Std_slideBtnLink']")).click();  // Clicking 'Apply Payment' btn
									Thread.sleep(1000);
									driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order
									Thread.sleep(1000);
									System.out.println("TestCase1.pymtPage - You clicked Continue to submit an order");
									Thread.sleep(20000);									
										
									//assert for order submission page																													
									//WebDriverWait wait = new WebDriverWait(driver,10);
									//WebElement ordWait = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")));
																		
									String expectedSubmit = "Order Has Been Submitted"; 
									String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header")).getText();
									System.out.println("Submit header" + actualSubmit);
									Thread.sleep(5000);	
									
										if (actualSubmit.equals(expectedSubmit)) {	
											System.out.println("TestCase1.pymtPage - Order submitted successfully!");
											Thread.sleep(10000);	
											String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
											System.out.println("Order submitted: " + ordNumber);
											logger.info(ordNumber);
										}else {
											System.out.println("TestCase1.pymtPage - Failed submitting an order. TC failed.");											
											return null;
										}		
										
									}else {
										System.out.println("TestCase1.pymtPage - Assertion Tender type failed!");	
										return null;
									}						
							}else {
								System.out.println("TestCase1.pymtPage - Failed loading Payment Page");
								return null;
							}							
					} catch (Exception e) {
						System.out.println("TestCase1.pymtPage - Error encountered:" + e.getMessage());
						return null;
					}	
			return driver;				
		}		
		
}
