/*
 * This class will allow to process single item Hold order and process through payment page
 *  
 * @author Sumita Rai
 * Feb 20, 2018
 * 
 * Last modified: 4/13/2018
 */

package SmokeTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TestCase2 {
	public static String strBatch;
					
	// This method to Add item batch/articles in Add Item Page from spreadsheet
		public static ChromeDriver addItemPage(ChromeDriver driver) throws InterruptedException {			
				
			Logger logger = Logger.getLogger("TestCase2");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
			
				WebElement addStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
				addStndItem.click();  						// Click Standard item button in Add Item page
				Thread.sleep(2000);
				
				//Assert if it opens the add standard item window
				try {
					String expectedRslt = "Add Standard Item";
					String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
					if (expectedRslt.equals(actualRslt)) {
						System.out.println("TestCase2.addItemPage - 'Add Standard Item' window opened successfully!");
						
						   ReadExcel batch = new ReadExcel();
					       batch.setInputFile("C:\\Work\\Java\\Selenium_TestDemo\\Resource\\Batches.xls"); 
					       
					       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']")); 
					       
					       strBatch = batch.getBatch(9);  //***Need a loop function to read next line if the batch is used already
					       enterBatch.sendKeys(strBatch);  
					       System.out.println("TestCase2.addItemPage - Get batch = " + strBatch + " from spreadsheet");
						   Thread.sleep(2000);
						   logger.info("Batch: " + strBatch);
						   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
						   Thread.sleep(20000);	
						   
						   driver.findElement(By.xpath(".//div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion
						   System.out.println("TestCase2.addItemPage - Item is added under Add Items sections");
						   Thread.sleep(10000);
						 
						   //Assert if item is added under Add Items section
						   	   String expecteditmRslt = "Order Items";
							   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
							   if (expecteditmRslt.equals(actualitmRslt)) {
								System.out.println("TestCase2.addItemPage - Item added under Add Items section successfully!");								
								
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
								System.out.println("TestCase2.addItemPage - You clicked Continue to proceed to Marketing page");
								Thread.sleep(5000);
								
							   }else {
								System.out.println("TestCase2.addItemPage - Failed to add an item!");
								return null;
							   }	 
						   
						
					}else {
						System.out.println("TestCase2.addItemPage - Failed to open 'Add Standard Item' window!");
						return null; 
					}					
				}catch (Exception e) {
					System.out.println("TestCase2.addItemPage - Error encountered: " + e.getMessage());
					return null;
				}				   		   
			return driver;
		}	
				
	// Item Processing Page
		public static ChromeDriver itmProcessPage(ChromeDriver driver) throws InterruptedException{
			Logger logger = Logger.getLogger("TestCase2");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
			
				// Assert if it loaded the Item Processing Page
					try {
						String expectedRslt = "Item Processing";
						String actualitmProcessPage = driver.findElement(By.id("tabOrder_ItemProc_contentTab_lblTitle")).getText();
						if (expectedRslt.equals(actualitmProcessPage)) {
							System.out.println("TestCase2.itmProcessPage - 'Item Processing' Page loaded successfully!");	
							
							//allow to select "Standard" option from Item Options dropdown in Item Processing Page
							WebElement itmOptions = driver.findElement(By.xpath(".//*[@id='ctrl0_grdProcTable_ddlOption_0']"));
							Select itmOptionsSelect = new Select(itmOptions);
							itmOptionsSelect.selectByIndex(1);   //Standard, Hold, and Layaway item options
								String actualitmProcess = itmOptionsSelect.getOptions().get(1).getText();
								System.out.println("TestCase2.itmProcessPage - "+ actualitmProcess);
								logger.info("Sale Type: " + actualitmProcess);
								Thread.sleep(2000);								
							
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue button on Item Processing Page to proceed to Order Summary Page
							System.out.println("TestCase2.itmProcessPage - It is loading 'Order Summary' Page");
							Thread.sleep(5000);
							
							}
						else{
							System.out.println("TestCase2.itmProcessPage - Failed loading 'Item Procesing' Page");
							return null;
							}		
					}catch (Exception e) {
						System.out.println("TestCase2.itmProcessPage - Error encounter: "+ e.getMessage());
						return null;
						}					
				return driver;
			}
							
						
	//This method allow to select tender type in Payment Page
		public static ChromeDriver pymtPage(ChromeDriver driver) throws InterruptedException{
			Logger logger = Logger.getLogger("TestCase2");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
				//Assert if Payment Page is loaded 
					try {
						String expectedPymtRslt = "Payment Options";
						String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
						if (expectedPymtRslt.equals(actualPymtRslt)) {
							System.out.println("TestCase2.pymtPage - Payment Page loaded successfully!");
							Thread.sleep(2000);
							String actualTotalPrice = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
							String actualPrice = actualTotalPrice.replace("$","");
							System.out.println("TestCase2.pymtPage - Amount Due : " + actualPrice);
							logger.info("Total Price: " + actualPrice);
							Thread.sleep(2000);
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order
								Thread.sleep(1000);
								System.out.println("TestCase2.pymtPage - You clicked Continue to submit an order");
								Thread.sleep(20000);											
											
								//assert for order submission page	
								String expectedSubmit = "Order Has Been Submitted"; 
								String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")).getText();
								Thread.sleep(5000);											
								
									if (actualSubmit.equalsIgnoreCase(expectedSubmit)) {												
										System.out.println("TestCase2.pymtPage - Order submitted successfully!");
										Thread.sleep(10000);
										String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
										System.out.println("Order submitted: " + ordNumber);
										logger.info(ordNumber);
									}else {
										System.out.println("TestCase2.pymtPage - Failed submitting an order. TC failed.");											
										return null;											
									}														
							}else {
							System.out.println("TestCase2.pymtPage - Failed loading Payment Page");
							return null;
							}							
					} catch (Exception e) {
						System.out.println("TestCase2.pymtPage - Error encountered:" + e.getMessage());
						return null;
					}	
			return driver;				
		}	

}
