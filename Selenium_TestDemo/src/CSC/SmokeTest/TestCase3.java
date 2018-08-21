/*
 * This class will allow to process multiple item using Corp Use
 *  
 * @author Sumita Rai
 * May 01, 2018
 * 
 * Last modified: 5/09/2018
 */

package SmokeTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import UtilityLib.ReadExcelFile;



public class TestCase3 {
	public static String strBatch;
					
	// This method to Add item batch/articles in Add Item Page from spreadsheet
		public static ChromeDriver addItemPage(ChromeDriver driver) throws InterruptedException {			
				
			Logger logger = Logger.getLogger("TestCase3");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
			
				WebElement addStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
				addStndItem.click();  						// Click Standard item button in Add Item page
				Thread.sleep(2000);
				
				//Assert if it opens the add standard item window
				try {
					String expectedRslt = "Add Standard Item";
					String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
					if (expectedRslt.equals(actualRslt)) {
						System.out.println("TestCase3.addItemPage - 'Add Standard Item' window opened successfully!");
						
						   ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\Selenium_TestDemo\\Resource\\Batches.xlsx");					       
					       				        					       				       
					       for(int row = 7; row <=8; row++){
					    	   WebElement enterBatch = driver.findElement(By.xpath("html/body/div[8]/div[2]/div/div[2]/input"));     //.//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']
					    	   String strBatch = batch.getBatch(2,row,10);  // Loop for mulfunction to read next line if the batch is used already
					    	   enterBatch.sendKeys(strBatch); 
					    	   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
					    	   Thread.sleep(2000);
							   logger.info("Batch from spreadsheet: " + strBatch);							   
					    	   Thread.sleep(2000);					      
					       }	

					       
						   driver.findElement(By.xpath(".//div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion
						   Thread.sleep(10000);
						   System.out.println("TestCase2.addItemPage - Item is added under Add Items sections");
						   Thread.sleep(10000);
						   String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  // Batch element checked that was added under Add items section
						   logger.info("Batch: " + actualItem); 
						   String actualPrice = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[8]/span")).getText();  // Price element in Add Item page
						   logger.info("Price: "+ actualPrice);
						 
						   //Assert if item is added under Add Items section
						   	   String expecteditmRslt = "Order Items";
							   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
							   if (expecteditmRslt.equals(actualitmRslt)) {
								System.out.println("TestCase3.addItemPage - Item added under Add Items section");								
								
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
								System.out.println("TestCase3.addItemPage - You clicked Continue to proceed to Marketing page");
								Thread.sleep(5000);
								
							   }else {
								System.out.println("TestCase3.addItemPage - Failed to add an item!");
								return null;
							   }	 
						   
						
					}else {
						System.out.println("TestCase3.addItemPage - Failed to open 'Add Standard Item' window!");
						return null; 
					}					
				}catch (Exception e) {
					System.out.println("TestCase3.addItemPage - Error encountered: " + e.getMessage());
					return null;
				}				   		   
			return driver;
		}	
				
	// Item Processing Page
		public static ChromeDriver itmProcessPage(ChromeDriver driver) throws InterruptedException{
			Logger logger = Logger.getLogger("TestCase3");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
			
				// Assert if it loaded the Item Processing Page
					try {
						String expectedRslt = "Item Processing";
						String actualitmProcessPage = driver.findElement(By.id("tabOrder_ItemProc_contentTab_lblTitle")).getText();
						if (expectedRslt.equals(actualitmProcessPage)) {
							System.out.println("TestCase3.itmProcessPage - 'Item Processing' Page loaded successfully!");	
							
							//allow to select "Standard" option from Item Options dropdown in Item Processing Page
							WebElement itmOptions = driver.findElement(By.xpath(".//*[@id='ctrl0_grdProcTable_ddlOption_0']"));
							Select itmOptionsSelect = new Select(itmOptions);
							itmOptionsSelect.selectByIndex(0);   //Standard, Hold, and Layaway item options
								String actualitmProcess = itmOptionsSelect.getOptions().get(0).getText();
								System.out.println("TestCase3.itmProcessPage - "+ actualitmProcess);
								logger.info("Sale Type: " + actualitmProcess);
								Thread.sleep(2000);								
							
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue button on Item Processing Page to proceed to Order Summary Page
							System.out.println("TestCase3.itmProcessPage - It is loading 'Order Summary' Page");
							Thread.sleep(5000);
							
							}
						else{
							System.out.println("TestCase3.itmProcessPage - Failed loading 'Item Procesing' Page");
							return null;
							}		
					}catch (Exception e) {
						System.out.println("TestCase3.itmProcessPage - Error encounter: "+ e.getMessage());
						return null;
						}					
				return driver;
			}
							
						
	//This method allow to select tender type in Payment Page
		public static ChromeDriver pymtPage(ChromeDriver driver) throws InterruptedException{
			Logger logger = Logger.getLogger("TestCase3");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
				//Assert if Payment Page is loaded 
					try {
						String expectedPymtRslt = "Payment Options";
						String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
						if (expectedPymtRslt.equals(actualPymtRslt)) {
							System.out.println("TestCase3.pymtPage - Payment Page loaded successfully!");
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
																		
									String expectedSubmit = "Return To Customer Search"; 
									String actualSubmit = driver.findElement(By.xpath(".//*[@id='btnReturnSearch_slideBtnLink']")).getText();
									Thread.sleep(5000);	
									
										if (actualSubmit.equals(expectedSubmit)) {	
											System.out.println("TestCase1.pymtPage - Order submitted successfully!");
											Thread.sleep(10000);	
											String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
											System.out.println("Order submitted: " + ordNumber);
											logger.info(ordNumber);
										}else {
											System.out.println("TestCase3.pymtPage - Failed submitting an order. TC failed.");											
											return null;
										}		
										
									}else {
										System.out.println("TestCase3.pymtPage - Assertion Tender type failed!");	
										return null;
									}																			
							}else {
							System.out.println("TestCase3.pymtPage - Failed loading Payment Page");
							return null;
							}							
					} catch (Exception e) {
						System.out.println("TestCase3.pymtPage - Error encountered:" + e.getMessage());
						return null;
					}	
			return driver;				
		}	

}
