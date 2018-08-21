/*
 * This class collect all methods that will allow to add items in Add item Page for each TC

* @author Sumita Rai
* June 08, 2018
* Last Mod: 04/19/2018

*/

package SmokeTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import UtilityLib.ReadExcelFile;


public class AddItemPage {
//TC1: Standard Sale: Method to Add single item batch/articles in Add Item Page
public static ChromeDriver testCase1(ChromeDriver driver) throws InterruptedException {						
				Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");
				
					WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
					clickStndItem.click();  						// Click Standard item button in Add Item page
					Thread.sleep(2000);
					
					//Assert if it opens the add standard item window
					try {
						String expectedRslt = "Add Standard Item";
						String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
						if (expectedRslt.equals(actualRslt)) {
							System.out.println("AddItemPage.testCase1 - 'Add Standard Item' window opened successfully!");						
							   
							ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
						    WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
						    String strBatch = batch.getBatch(3, 2, 1);  // Single batch
						    System.out.println("AddItemPage.testCase1 - Got the batch = " + strBatch); 		       
						    enterBatch.sendKeys(strBatch);   // feeding strBatch value
						    System.out.println("AddItemPage.testCase1 - Batch from spreadsheet: " + strBatch);
							driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
							Thread.sleep(5000);							   
							driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
							Thread.sleep(5000);							   
							 
							   //Assert if item is added under Add Items section
							   	   String expecteditmRslt = "Order Items";
								   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
								   if (expecteditmRslt.equals(actualitmRslt)) {
									System.out.println("AddItemPage.testCase1 - Item added under Add Items section successfully!");								
									
									// Check Batch and Price elements that was added under Add items section
									String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
									logger.info("Batch entered: " + actualItem);
									String actualPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();
									logger.info("Retail Price item 1 : "+ actualPrice1);
									String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
									logger.info("Sub Total: " + ordSubtotal);
									Thread.sleep(5000);
									
									driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
									System.out.println("AddItemPage.testCase1 - You clicked Continue to proceed to Marketing page");
									Thread.sleep(2000);
									
								   }else {
									System.out.println("AddItemPage.testCase1 - Failed to add an item");
									logger.info("AddItemPage.testCase1 - Failed to add an item");
									return null;
								   }					  					
						}else {
							System.out.println("AddItemPage.testCase1 - Failed to open 'Add Standard Item' window");
							logger.info("AddItemPage.testCase1 - Failed to open 'Add Standard Item' window");
							return null; 
						}					
					}catch (Exception e) {
					 System.out.println("AddItemPage.testCase1 - Error encountered: " + e.getMessage());
					 logger.info("AddItemPage.testCase1 - Error encountered");
					 return null;
					}				   		   
				return driver;
			}	
			
//TC2: Standard Sale: Method to Add single item batch/articles in Add Item Page
public static ChromeDriver testCase2(ChromeDriver driver) throws InterruptedException {						
				Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");
				
					WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
					clickStndItem.click();  						// Click Standard item button in Add Item page
					Thread.sleep(2000);
					
					//Assert if it opens the add standard item window
					try {
						String expectedRslt = "Add Standard Item";
						String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
						if (expectedRslt.equals(actualRslt)) {
							System.out.println("AddItemPage.testCase2 - 'Add Standard Item' window opened successfully!");						
							   
							ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
						       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
						       String strBatch = batch.getBatch(3, 3, 1);  // Single batch
						       System.out.println("AddItemPage.testCase2 - Got the batch = " + strBatch); 		       
						       enterBatch.sendKeys(strBatch);   // feeding strBatch value
						       System.out.println("AddItemPage.testCase2 - Batch from spreadsheet: " + strBatch);
							   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
							   Thread.sleep(5000);							   
							   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
							   Thread.sleep(5000);
							   
							 
							   //Assert if item is added under Add Items section
							   	   String expecteditmRslt = "Order Items";
								   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
								   if (expecteditmRslt.equals(actualitmRslt)) {
									System.out.println("AddItemPage.testCase2 - Item added under Add Items section successfully!");								
									
									// Check Batch and Price elements that was added under Add items section
									String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
									logger.info("Batch entered: " + actualItem);
									String actualPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();
									logger.info("Retail Price item 1 : "+ actualPrice1);
									String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
									logger.info("Sub Total: " + ordSubtotal);
									Thread.sleep(5000);
									
									driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
									System.out.println("AddItemPage.testCase2 - You clicked Continue to proceed to Marketing page");
									Thread.sleep(2000);
									
								   }else {
									System.out.println("AddItemPage.testCase1 - Failed to add an item");
									logger.info("AddItemPage.testCase2 - Failed to add an item");
									return null;
								   }					  					
						}else {
							System.out.println("AddItemPage.testCase2 - Failed to open 'Add Standard Item' window");
							logger.info("AddItemPage.testCase2 - Failed to open 'Add Standard Item' window");
							return null; 
						}					
					}catch (Exception e) {
						System.out.println("AddItemPage.testCase2 - Error encountered: " + e.getMessage());
						logger.info("AddItemPage.testCase2 - Error encountered");
						return null;
					}				   		   
				return driver;
			}	
			
//TC3: Standard Sale: Method to Add Multiple items batches in Add Item Page	
public static ChromeDriver testCase3(ChromeDriver driver) throws InterruptedException {			
		Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");
			
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
			
			//Assert if it opens the add standard item window
			try {
				String expectedRslt = "Add Standard Item";
				String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
				if (expectedRslt.equals(actualRslt)) {
					System.out.println("AddItemPage.testCase3 - 'Add Standard Item' window opened successfully!");
					
					  ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");						       				        					       				       
				      for(int row = 4; row <=5; row++){
				    	 WebElement enterBatch = driver.findElement(By.xpath("html/body/div[8]/div[2]/div/div[2]/input"));     //.//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']
				    	 String strBatch = batch.getBatch(3,row,1);  // Loop for multiple batches
				    	 enterBatch.sendKeys(strBatch); 
				    	 driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
				    	 System.out.println("Batch from spreadsheet row " + row + ": " + strBatch);							   
				    	 Thread.sleep(5000);					      
				       }	
				       driver.findElement(By.xpath(".//div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion
					   Thread.sleep(5000);						  
				
					   //Assert if item is added under Add Items section
					   	   String expecteditmRslt = "Order Items";
						   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
						   if (expecteditmRslt.equals(actualitmRslt)) {
							System.out.println("AddItemPage.testCase3 - Item added under Add Items section");														
							
							   //Check Batch and Price elements that was added under Add items section
							   String actualItem1 = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
							   logger.info("Entered first Batch: " + actualItem1); 
							   String actualPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();  
							   logger.info("Retail Price item 1 : "+ actualPrice1);
							   String actualItem2 = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0002']/div[4]")).getText();  
							   logger.info("Entered second Batch: " + actualItem2); 
							   String actualPrice2 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[5]/div[6]/span")).getText();  
							   logger.info("Retail Price item 2 : "+ actualPrice2);
							   String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
							   logger.info("Sub Total: " + ordSubtotal);
							   Thread.sleep(5000);
							
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
							System.out.println("AddItemPage.testCase3 - You clicked Continue to proceed to Marketing page");
							Thread.sleep(2000);
							
						   }else {
							System.out.println("AddItemPage.testCase3 - Failed to add an item!");
							return null;
						   }					
				}else {
					System.out.println("AddItemPage.testCase3 - Failed to open 'Add Standard Item' window!");
					return null; 
				}					
			}catch (Exception e) {
				System.out.println("AddItemPage.testCase3 - Error encountered: " + e.getMessage());
				return null;
			}				   		   
		return driver;
	}					

//TC4: Standard Sale: Method to Add single item batch/articles in Add Item Page
public static ChromeDriver testCase4(ChromeDriver driver) throws InterruptedException {						
				Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");
				
					WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
					clickStndItem.click();  						// Click Standard item button in Add Item page
					Thread.sleep(2000);
					
					//Assert if it opens the add standard item window
					try {
						String expectedRslt = "Add Standard Item";
						String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
						if (expectedRslt.equals(actualRslt)) {
							System.out.println("AddItemPage.testCase4 - 'Add Standard Item' window opened successfully!");						
							   
							ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
						       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
						       String strBatch = batch.getBatch(3, 6, 1);  // Single batch
						       System.out.println("AddItemPage.testCase4 - Got the batch = " + strBatch); 		       
						       enterBatch.sendKeys(strBatch);   // feeding strBatch value
						       System.out.println("AddItemPage.testCase4 - Batch from spreadsheet: " + strBatch);
							   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
							   Thread.sleep(5000);							   
							   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
							   Thread.sleep(5000);
							   
							 
							   //Assert if item is added under Add Items section
							   	   String expecteditmRslt = "Order Items";
								   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
								   if (expecteditmRslt.equals(actualitmRslt)) {
									System.out.println("AddItemPage.testCase4 - Item added under Add Items section successfully!");								
									
									// Check Batch and Price elements that was added under Add items section
									String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
									logger.info("Batch entered: " + actualItem);
									String actualPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();
									logger.info("Retail Price item 1 : "+ actualPrice1);
									String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
									logger.info("Sub Total: " + ordSubtotal);
									Thread.sleep(5000);
									
									driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
									System.out.println("AddItemPage.testCase4 - You clicked Continue to proceed to Marketing page");
									Thread.sleep(2000);
									
								   }else {
									System.out.println("AddItemPage.testCase4 - Failed to add an item");
									logger.info("AddItemPage.testCase4 - Failed to add an item");
									return null;
								   }					  					
						}else {
							System.out.println("AddItemPage.testCase4 - Failed to open 'Add Standard Item' window");
							logger.info("AddItemPage.testCase4 - Failed to open 'Add Standard Item' window");
							return null; 
						}					
					}catch (Exception e) {
						System.out.println("AddItemPage.testCase4 - Error encountered: " + e.getMessage());
						logger.info("AddItemPage.testCase4 - Error encountered");
						return null;
					}				   		   
				return driver;
			}	
			
//TC5: Standard Sale: Method to Add single item batch/articles in Add Item Page
public static ChromeDriver testCase5(ChromeDriver driver) throws InterruptedException {						
	Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
	PropertyConfigurator.configure("Log4j.properties");
	
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
		
		//Assert if it opens the add standard item window
		try {
			String expectedRslt = "Add Standard Item";
			String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
			if (expectedRslt.equals(actualRslt)) {
				System.out.println("AddItemPage.testCase5 - 'Add Standard Item' window opened successfully!");						
				   
				ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
			       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
			       String strBatch = batch.getBatch(3, 7, 1);  // Single batch
			       System.out.println("AddItemPage.testCase5 - Got the batch = " + strBatch); 		       
			       enterBatch.sendKeys(strBatch);   // feeding strBatch value
			       System.out.println("AddItemPage.testCase5 - Batch from spreadsheet: " + strBatch);
				   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
				   Thread.sleep(5000);							   
				   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
				   Thread.sleep(5000);
				   
				 
				   //Assert if item is added under Add Items section
				   	   String expecteditmRslt = "Order Items";
					   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
					   if (expecteditmRslt.equals(actualitmRslt)) {
						System.out.println("AddItemPage.testCase5 - Item added under Add Items section successfully!");								
						
						// Check Batch and Price elements that was added under Add items section
						String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
						logger.info("Batch entered: " + actualItem);
						String actualPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();
						logger.info("Retail Price item 1 : "+ actualPrice1);
						String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
						logger.info("Sub Total: " + ordSubtotal);
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
						System.out.println("AddItemPage.testCase5 - You clicked Continue to proceed to Marketing page");
						Thread.sleep(2000);
						
					   }else {
						System.out.println("AddItemPage.testCase5 - Failed to add an item");
						logger.info("AddItemPage.testCase5 - Failed to add an item");
						return null;
					   }					  					
			}else {
				System.out.println("AddItemPage.testCase5 - Failed to open 'Add Standard Item' window");
				logger.info("AddItemPage.testCase5 - Failed to open 'Add Standard Item' window");
				return null; 
			}					
		}catch (Exception e) {
			System.out.println("AddItemPage.testCase5 - Error encountered: " + e.getMessage());
			logger.info("AddItemPage.testCase5 - Error encountered");
			return null;
		}				   		   
	return driver;
}	

//TC6: Standard Sale: Method to Add single item batch/articles in Add Item Page
public static ChromeDriver testCase6(ChromeDriver driver) throws InterruptedException {						
	Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
	PropertyConfigurator.configure("Log4j.properties");
	
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
		
		//Assert if it opens the add standard item window
		try {
			String expectedRslt = "Add Standard Item";
			String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
			if (expectedRslt.equals(actualRslt)) {
				System.out.println("AddItemPage.testCase6 - 'Add Standard Item' window opened successfully!");						
				   
				ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
			       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
			       String strBatch = batch.getBatch(3, 8, 1);  // Single batch
			       System.out.println("AddItemPage.testCase6 - Got the batch = " + strBatch); 		       
			       enterBatch.sendKeys(strBatch);   // feeding strBatch value
			       System.out.println("AddItemPage.testCase6 - Batch from spreadsheet: " + strBatch);
				   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
				   Thread.sleep(5000);							   
				   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
				   Thread.sleep(5000);
				   
				 
				   //Assert if item is added under Add Items section
				   	   String expecteditmRslt = "Order Items";
					   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
					   if (expecteditmRslt.equals(actualitmRslt)) {
						System.out.println("AddItemPage.testCase6 - Item added under Add Items section successfully!");								
						
						// Check Batch and Price elements that was added under Add items section
						String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
						logger.info("Batch entered: " + actualItem);
						String actualPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();
						logger.info("Retail Price item 1 : "+ actualPrice1);
						String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
						logger.info("Sub Total: " + ordSubtotal);
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
						System.out.println("AddItemPage.testCase6 - You clicked Continue to proceed to Marketing page");
						Thread.sleep(2000);
						
					   }else {
						System.out.println("AddItemPage.testCase6 - Failed to add an item");
						logger.info("AddItemPage.testCase6 - Failed to add an item");
						return null;
					   }					  					
			}else {
				System.out.println("AddItemPage.testCase6 - Failed to open 'Add Standard Item' window");
				logger.info("AddItemPage.testCase6 - Failed to open 'Add Standard Item' window");
				return null; 
			}					
		}catch (Exception e) {
			System.out.println("AddItemPage.testCase6 - Error encountered: " + e.getMessage());
			logger.info("AddItemPage.testCase6 - Error encountered");
			return null;
		}				   		   
	return driver;
}	

//TC7: Standard Sale: Method to Add single item batch/articles in Add Item Page
public static ChromeDriver testCase7(ChromeDriver driver) throws InterruptedException {						
	Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
	PropertyConfigurator.configure("Log4j.properties");
	
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
		
		//Assert if it opens the add standard item window
		try {
			String expectedRslt = "Add Standard Item";
			String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
			if (expectedRslt.equals(actualRslt)) {
				System.out.println("AddItemPage.testCase7 - 'Add Standard Item' window opened successfully!");						
				   
				ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
			       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
			       String strBatch = batch.getBatch(3, 9, 1);  // Single batch
			       System.out.println("AddItemPage.testCase7 - Got the batch = " + strBatch); 		       
			       enterBatch.sendKeys(strBatch);   // feeding strBatch value
			       System.out.println("AddItemPage.testCase7 - Batch from spreadsheet: " + strBatch);
				   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
				   Thread.sleep(5000);							   
				   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
				   Thread.sleep(5000);
				   
				 
				   //Assert if item is added under Add Items section
				   	   String expecteditmRslt = "Order Items";
					   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
					   if (expecteditmRslt.equals(actualitmRslt)) {
						System.out.println("AddItemPage.testCase7 - Item added under Add Items section successfully!");								
						
						// Check Batch and Price elements that was added under Add items section
						String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
						logger.info("Batch entered: " + actualItem);
						String actualPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();
						logger.info("Retail Price item 1 : "+ actualPrice1);
						String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
						logger.info("Sub Total: " + ordSubtotal);
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
						System.out.println("AddItemPage.testCase7 - You clicked Continue to proceed to Marketing page");
						Thread.sleep(2000);
						
					   }else {
						System.out.println("AddItemPage.testCase7 - Failed to add an item");
						logger.info("AddItemPage.testCase7 - Failed to add an item");
						return null;
					   }					  					
			}else {
				System.out.println("AddItemPage.testCase7 - Failed to open 'Add Standard Item' window");
				logger.info("AddItemPage.testCase7 - Failed to open 'Add Standard Item' window");
				return null; 
			}					
		}catch (Exception e) {
			System.out.println("AddItemPage.testCase7 - Error encountered: " + e.getMessage());
			logger.info("AddItemPage.testCase7 - Error encountered");
			return null;
		}				   		   
	return driver;
}	

//TC8: Standard Sale: Method to Add single item batch/articles in Add Item Page
public static ChromeDriver testCase8(ChromeDriver driver) throws InterruptedException {						
	Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
	PropertyConfigurator.configure("Log4j.properties");
	
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
		
		//Assert if it opens the add standard item window
		try {
			String expectedRslt = "Add Standard Item";
			String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
			if (expectedRslt.equals(actualRslt)) {
				System.out.println("AddItemPage.testCase8 - 'Add Standard Item' window opened successfully!");						
				   
				ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
			       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
			       String strBatch = batch.getBatch(3, 10, 1);  // Single batch
			       System.out.println("AddItemPage.testCase8 - Got the batch = " + strBatch); 		       
			       enterBatch.sendKeys(strBatch);   // feeding strBatch value
			       System.out.println("AddItemPage.testCase8 - Batch from spreadsheet: " + strBatch);
				   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
				   Thread.sleep(5000);							   
				   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
				   Thread.sleep(5000);
				   
				 
				   //Assert if item is added under Add Items section
				   	   String expecteditmRslt = "Order Items";
					   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
					   if (expecteditmRslt.equals(actualitmRslt)) {
						System.out.println("AddItemPage.testCase8 - Item added under Add Items section successfully!");								
						
						// Check Batch and Price elements that was added under Add items section
						String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
						logger.info("Batch entered: " + actualItem);
						String actualPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();
						logger.info("Retail Price item 1 : "+ actualPrice1);
						String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
						logger.info("Sub Total: " + ordSubtotal);
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
						System.out.println("AddItemPage.testCase8 - You clicked Continue to proceed to Marketing page");
						Thread.sleep(2000);
						
					   }else {
						System.out.println("AddItemPage.testCase8 - Failed to add an item");
						logger.info("AddItemPage.testCase8 - Failed to add an item");
						return null;
					   }					  					
			}else {
				System.out.println("AddItemPage.testCase8 - Failed to open 'Add Standard Item' window");
				logger.info("AddItemPage.testCase8 - Failed to open 'Add Standard Item' window");
				return null; 
			}					
		}catch (Exception e) {
			System.out.println("AddItemPage.testCase8 - Error encountered: " + e.getMessage());
			logger.info("AddItemPage.testCase8 - Error encountered");
			return null;
		}				   		   
	return driver;
}	

//TC9: Standard Sale: Method to Add single item batch/articles in Add Item Page
public static ChromeDriver testCase9(ChromeDriver driver) throws InterruptedException {						
	Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
	PropertyConfigurator.configure("Log4j.properties");
	
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
		
		//Assert if it opens the add standard item window
		try {
			String expectedRslt = "Add Standard Item";
			String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
			if (expectedRslt.equals(actualRslt)) {
				System.out.println("AddItemPage.testCase9 - 'Add Standard Item' window opened successfully!");						
				   
				ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
			       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
			       String strBatch = batch.getBatch(3, 11, 1);  // Single batch
			       System.out.println("AddItemPage.testCase9 - Got the batch = " + strBatch); 		       
			       enterBatch.sendKeys(strBatch);   // feeding strBatch value
			       System.out.println("AddItemPage.testCase9 - Batch from spreadsheet: " + strBatch);
				   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
				   Thread.sleep(5000);							   
				   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
				   Thread.sleep(5000);				   
				 
				   //Assert if item is added under Add Items section
				   	   String expecteditmRslt = "Order Items";
					   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
					   if (expecteditmRslt.equals(actualitmRslt)) {
						System.out.println("AddItemPage.testCase9 - Item added under Add Items section successfully!");								
						
						// Check Batch and Price elements that was added under Add items section
						String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
						logger.info("Batch entered: " + actualItem);
						String actualPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();
						logger.info("Retail Price item 1 : "+ actualPrice1);
						String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
						logger.info("Sub Total: " + ordSubtotal);
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
						System.out.println("AddItemPage.testCase9 - You clicked Continue to proceed to Marketing page");
						Thread.sleep(2000);
						
					   }else {
						System.out.println("AddItemPage.testCase9 - Failed to add an item");
						logger.info("AddItemPage.testCase9 - Failed to add an item");
						return null;
					   }					  					
			}else {
				System.out.println("AddItemPage.testCase9 - Failed to open 'Add Standard Item' window");
				logger.info("AddItemPage.testCase9 - Failed to open 'Add Standard Item' window");
				return null; 
			}					
		}catch (Exception e) {
			System.out.println("AddItemPage.testCase9 - Error encountered: " + e.getMessage());
			logger.info("AddItemPage.testCase9 - Error encountered");
			return null;
		}				   		   
	return driver;
}	


//Edit Items 
//TC10: Standard Sale: Method to Add single item with Discount Amount
public static ChromeDriver testCase10(ChromeDriver driver) throws InterruptedException {		
	Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
	PropertyConfigurator.configure("Log4j.properties");
	
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
		
		//Assert if it opens the add standard item window
		try {
			String expectedRslt = "Add Standard Item";
			String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
			if (expectedRslt.equals(actualRslt)) {
				System.out.println("AddItemPage.testCase10 - 'Add Standard Item' window opened successfully!");						
				   
				ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
			       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
			       String strBatch = batch.getBatch(3, 12, 1);  // Single batch
			       System.out.println("AddItemPage.testCase10 - Got the batch = " + strBatch); 		       
			       enterBatch.sendKeys(strBatch);   // feeding strBatch value
			       System.out.println("AddItemPage.testCase10 - Batch from spreadsheet: " + strBatch);
				   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
				   Thread.sleep(5000);							   
				   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
				   Thread.sleep(5000);
				   
				 
				   //Assert if item is added under Add Items section
				   	String expecteditmRslt = "Order Items";
					String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
					if (expecteditmRslt.equals(actualitmRslt)) {
					System.out.println("AddItemPage.testCase10 - Item added under Add Items section successfully!");	
					Thread.sleep(7000);
						// click '+' btn to add discount   
						WebElement moreBtn = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[9]/img[2]"));  
						moreBtn.click();
						Thread.sleep(1000);
						WebElement applyDis = driver.findElement(By.xpath("html/body/div[8]/div[2]/div/div/div[3]/img"));
						applyDis.click();
						Thread.sleep(2000);
						WebElement discType = driver.findElement(By.xpath(".//*[@id='grdItems_dscType']"));
						Select discTypeSelect= new Select(discType);							
						discTypeSelect.selectByVisibleText("Competitive Item");  // select Discount type
						WebElement discAmount = driver.findElement(By.xpath(".//*[@id='grdItems_dscAmount']"));
						discAmount.sendKeys("20.5");  // Discount Amount entered
						Thread.sleep(1000);
						WebElement discNote = driver.findElement(By.xpath(".//*[@id='grdItems_dscNote']"));
						discNote.sendKeys("Test discount");
						driver.findElement(By.xpath("html/body/div[10]/div[3]/div/button")).click();
						Thread.sleep(5000);								
						
						// Check Batch and Price elements that was added in CSC under Add items section
						String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
						logger.info("Batch entered: " + actualItem);
						String retailPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();
						logger.info("Retail Price item 1 : "+ retailPrice1);
						String discPrice = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[7]/span")).getText();
						logger.info("Discount price: " + discPrice);
						String netPrice = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[8]/span")).getText();
						logger.info("Net Price: " + netPrice);
						String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
						logger.info("Sub Total: " + ordSubtotal);
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
						System.out.println("AddItemPage.testCase10 - You clicked Continue to proceed to Marketing page");
						Thread.sleep(2000);
						
					   }else {
						System.out.println("AddItemPage.testCase10 - Failed to add an item");
						logger.info("AddItemPage.testCase10 - Failed to add an item");
						return null;
					   }					  					
			}else {
				System.out.println("AddItemPage.testCase10 - Failed to open 'Add Standard Item' window");
				logger.info("AddItemPage.testCase10 - Failed to open 'Add Standard Item' window");
				return null; 
			}					
		}catch (Exception e) {
			System.out.println("AddItemPage.testCase10 - Error encountered: " + e.getMessage());
			logger.info("AddItemPage.testCase10 - Error encountered");
			return null;
		}				   		   
	return driver;
}	

//TC11: Standard Sale: Method to Add single item with Discount Percentage
public static ChromeDriver testCase11(ChromeDriver driver) throws InterruptedException {		
	Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
	PropertyConfigurator.configure("Log4j.properties");
	
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
		
		//Assert if it opens the add standard item window
		try {
			String expectedRslt = "Add Standard Item";
			String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
			if (expectedRslt.equals(actualRslt)) {
				System.out.println("AddItemPage.testCase11 - 'Add Standard Item' window opened successfully!");						
				   
				ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
			       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
			       String strBatch = batch.getBatch(3, 13, 1);  // Single batch
			       System.out.println("AddItemPage.testCase11 - Got the batch = " + strBatch); 		       
			       enterBatch.sendKeys(strBatch);   // feeding strBatch value
			       System.out.println("AddItemPage.testCase11 - Batch from spreadsheet: " + strBatch);
				   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
				   Thread.sleep(5000);							   
				   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
				   Thread.sleep(5000);
				   
				 
				   //Assert if item is added under Add Items section
				   	String expecteditmRslt = "Order Items";
					String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
					if (expecteditmRslt.equals(actualitmRslt)) {
					System.out.println("AddItemPage.testCase11 - Item added under Add Items section successfully!");	
					Thread.sleep(7000);
						// click '+' btn to add discount   
						WebElement moreBtn = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[9]/img[2]"));  
						moreBtn.click();
						Thread.sleep(1000);
						WebElement applyDis = driver.findElement(By.xpath("html/body/div[8]/div[2]/div/div/div[3]/img"));
						applyDis.click();
						Thread.sleep(2000);
						WebElement discType = driver.findElement(By.xpath(".//*[@id='grdItems_dscType']"));
						Select discTypeSelect= new Select(discType);							
						discTypeSelect.selectByVisibleText("Family Of Tom Shane");  // select Discount type
						WebElement discPercent = driver.findElement(By.xpath(".//*[@id='grdItems_dscPercent']"));
						discPercent.sendKeys("25");  // Discount Percent entered
						Thread.sleep(1000);
						WebElement discNote = driver.findElement(By.xpath(".//*[@id='grdItems_dscNote']"));
						discNote.sendKeys("Test discount");
						driver.findElement(By.xpath("html/body/div[10]/div[3]/div/button")).click();
						Thread.sleep(5000);								
						
						// Check Batch and Price elements that was added in CSC under Add items section
						String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
						logger.info("Batch entered: " + actualItem);
						String retailPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();
						logger.info("Retail Price item 1 : "+ retailPrice1);
						String discPrice = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[7]/span")).getText();
						logger.info("Discount price: " + discPrice);
						String netPrice = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[8]/span")).getText();
						logger.info("Net Price: " + netPrice);
						String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
						logger.info("Sub Total: " + ordSubtotal);
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
						System.out.println("AddItemPage.testCase11 - You clicked Continue to proceed to Marketing page");
						Thread.sleep(2000);
						
					   }else {
						System.out.println("AddItemPage.testCase11 - Failed to add an item");
						logger.info("AddItemPage.testCase11 - Failed to add an item");
						return null;
					   }					  					
			}else {
				System.out.println("AddItemPage.testCase11 - Failed to open 'Add Standard Item' window");
				logger.info("AddItemPage.testCase11 - Failed to open 'Add Standard Item' window");
				return null; 
			}					
		}catch (Exception e) {
			System.out.println("AddItemPage.testCase11 - Error encountered: " + e.getMessage());
			logger.info("AddItemPage.testCase11 - Error encountered");
			return null;
		}				   		   
	return driver;
}	

//TC12: Standard Sale: Method to Add single item with Price Override
public static ChromeDriver testCase12(ChromeDriver driver) throws InterruptedException {		
	Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
	PropertyConfigurator.configure("Log4j.properties");
	
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
		
		//Assert if it opens the add standard item window
		try {
			String expectedRslt = "Add Standard Item";
			String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
			if (expectedRslt.equals(actualRslt)) {
				System.out.println("AddItemPage.testCase12 - 'Add Standard Item' window opened successfully!");						
				   
				ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
			       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
			       String strBatch = batch.getBatch(3, 14, 1);  // Single batch
			       System.out.println("AddItemPage.testCase12 - Got the batch = " + strBatch); 		       
			       enterBatch.sendKeys(strBatch);   // feeding strBatch value
			       System.out.println("AddItemPage.testCase12 - Batch from spreadsheet: " + strBatch);
				   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
				   Thread.sleep(5000);							   
				   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
				   Thread.sleep(5000);
				   //*[@id="cart_AddItem_Article_sapQuery_TextBox_Edit"]
				 
				   //Assert if item is added under Add Items section
				   	String expecteditmRslt = "Order Items";
					String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
					if (expecteditmRslt.equals(actualitmRslt)) {
					System.out.println("AddItemPage.testCase12 - Item added under Add Items section successfully!");	
					Thread.sleep(7000);
						// click '+' btn to add discount   
						WebElement moreBtn = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[9]/img[2]"));  
						moreBtn.click();
						Thread.sleep(1000);
						WebElement applyPO = driver.findElement(By.xpath(".//*[@id='btnItemOptions_More_moreCenter_Button0']"));
						applyPO.click();		// Click Price Override
						Thread.sleep(2000);
						WebElement reasonPO = driver.findElement(By.xpath(".//*[@id='grdItems_ovrReason']"));
						Select reasonSelect= new Select(reasonPO);							
						reasonSelect.selectByVisibleText("Merchandise Issue");  // select Price Override reason
						Thread.sleep(1000);
						WebElement newRetailPrice = driver.findElement(By.xpath(".//*[@id='grdItems_ovrAmount']"));
						newRetailPrice.clear();  
						newRetailPrice.sendKeys("250");  // PO New retail Price entered
						Thread.sleep(1000);
						WebElement poNote = driver.findElement(By.xpath("//*[@id='grdItems_ovrNote']"));
						poNote.sendKeys("Test price override");
						driver.findElement(By.xpath("html/body/div[10]/div[3]/div/button")).click();   // Click OK button
						Thread.sleep(5000);								
						
						// Check Batch and Price elements that was added in CSC under Add items section
						String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
						logger.info("Batch entered: " + actualItem);
						String retailAmt = driver.findElement(By.xpath(".//*[@id='grdItemOvrde_OvrdeRow_0']/div[3]/span")).getText();
						logger.info("Retail Price item 1 : "+ retailAmt);
						String overrideAmt = driver.findElement(By.xpath(".//*[@id='grdItemOvrde_OvrdeRow_0']/div[4]/span")).getText();
						logger.info("Price Override new price: " + overrideAmt);
						String netPrice = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[8]/span")).getText();
						logger.info("Net Price: " + netPrice);
						String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
						logger.info("Sub Total: " + ordSubtotal);
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
						System.out.println("AddItemPage.testCase12 - You clicked Continue to proceed to Marketing page");
						Thread.sleep(2000);
						
					   }else {
						System.out.println("AddItemPage.testCase12 - Failed to add an item");
						logger.info("AddItemPage.testCase12 - Failed to add an item");
						return null;
					   }					  					
			}else {
				System.out.println("AddItemPage.testCase12 - Failed to open 'Add Standard Item' window");
				logger.info("AddItemPage.testCase12 - Failed to open 'Add Standard Item' window");
				return null; 
			}					
		}catch (Exception e) {
			System.out.println("AddItemPage.testCase12 - Error encountered: " + e.getMessage());
			logger.info("AddItemPage.testCase12 - Error encountered");
			return null;
		}				   		   
	return driver;
}	



//TC13: Standard Sale: Method to Add single item with SJ  -- Need to work on this method
public static ChromeDriver testCase13(ChromeDriver driver) throws InterruptedException {		
	Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
	PropertyConfigurator.configure("Log4j.properties");
	
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
		
		//Assert if it opens the add standard item window
		try {
			String expectedRslt = "Add Standard Item";
			String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
			if (expectedRslt.equals(actualRslt)) {
				System.out.println("AddItemPage.testCase12 - 'Add Standard Item' window opened successfully!");						
				   
				ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
			       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
			       String strBatch = batch.getBatch(3, 15, 10);  // Single batch
			       System.out.println("AddItemPage.testCase12 - Got the batch = " + strBatch); 		       
			       enterBatch.sendKeys(strBatch);   // feeding strBatch value
			       System.out.println("AddItemPage.testCase12 - Batch from spreadsheet: " + strBatch);
				   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
				   Thread.sleep(10000);							   
				   driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion 
				   Thread.sleep(2000);
				   
				 
				   //Assert if item is added under Add Items section
				   	String expecteditmRslt = "Order Items";
					String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
					if (expecteditmRslt.equals(actualitmRslt)) {
					System.out.println("AddItemPage.testCase12 - Item added under Add Items section successfully!");	
					Thread.sleep(7000);
						// click '+' btn to add discount   
						WebElement moreBtn = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[9]/img[2]"));  
						moreBtn.click();
						Thread.sleep(1000);
						WebElement applyPO = driver.findElement(By.xpath(".//*[@id='btnItemOptions_More_moreCenter_Button0']"));
						applyPO.click();		// Click Price Override
						Thread.sleep(2000);
						WebElement reasonPO = driver.findElement(By.xpath(".//*[@id='grdItems_ovrReason']"));
						Select reasonSelect= new Select(reasonPO);							
						reasonSelect.selectByVisibleText("Merchandise Issue");  // select Price Override reason
						Thread.sleep(1000);
						WebElement newRetailPrice = driver.findElement(By.xpath(".//*[@id='grdItems_ovrAmount']"));
						newRetailPrice.clear();  
						newRetailPrice.sendKeys("250");  // PO New retail Price entered
						Thread.sleep(1000);
						WebElement poNote = driver.findElement(By.xpath("//*[@id='grdItems_ovrNote']"));
						poNote.sendKeys("Test price override");
						driver.findElement(By.xpath("html/body/div[10]/div[3]/div/button")).click();   // Click OK button
						Thread.sleep(5000);								
						
						// Check Batch and Price elements that was added in CSC under Add items section
						String actualItem = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
						logger.info("Batch entered: " + actualItem);
						String retailAmt = driver.findElement(By.xpath(".//*[@id='grdItemOvrde_OvrdeRow_0']/div[3]/span")).getText();
						logger.info("Retail Price item 1 : "+ retailAmt);
						String overrideAmt = driver.findElement(By.xpath(".//*[@id='grdItemOvrde_OvrdeRow_0']/div[4]/span")).getText();
						logger.info("Price Override new price: " + overrideAmt);
						String netPrice = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[8]/span")).getText();
						logger.info("Net Price: " + netPrice);
						String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
						logger.info("Sub Total: " + ordSubtotal);
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
						System.out.println("AddItemPage.testCase12 - You clicked Continue to proceed to Marketing page");
						Thread.sleep(2000);
						
					   }else {
						System.out.println("AddItemPage.testCase12 - Failed to add an item");
						logger.info("AddItemPage.testCase12 - Failed to add an item");
						return null;
					   }					  					
			}else {
				System.out.println("AddItemPage.testCase12 - Failed to open 'Add Standard Item' window");
				logger.info("AddItemPage.testCase12 - Failed to open 'Add Standard Item' window");
				return null; 
			}					
		}catch (Exception e) {
			System.out.println("AddItemPage.testCase12 - Error encountered: " + e.getMessage());
			logger.info("AddItemPage.testCase12 - Error encountered");
			return null;
		}				   		   
	return driver;
}	


//Service Items (Stand alone Services: TC14 and TC15)
//TC14: Service item sale: Mail Fee
public static ChromeDriver testCase14(ChromeDriver driver) throws InterruptedException {						
				Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");
				
				WebElement services = driver.findElement(By.xpath(".//*[@id='btnServiceItem_CSSBtnLink']"));  
				services.click();
				Thread.sleep(2000);
					
				//Assert if it opens Services item window
				try {
					String expectedRslt = "Services";
					String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-2']")).getText();
					if (expectedRslt.equals(actualRslt)) {
						System.out.println("AddItemPage.testCase14 - 'Services' window opened successfully!");								      
						Thread.sleep(2000);
						//Click Mail Fee
						WebElement mailFee = driver.findElement(By.xpath(".//*[@id='btnServiceItems_More_moreCenter_Button1']"));
						mailFee.click();
						Thread.sleep(1000);
						WebElement mailPrice = driver.findElement(By.xpath(".//*[@id='svcItem_Prc']"));
						mailPrice.sendKeys("10");
						Thread.sleep(1000);
						driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/button/span")).click();
						Thread.sleep(5000);	 
							//Assert if item is added under Add Items section
							 String expecteditmRslt = "Service Items";
							 String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable_Srv']/div[1]")).getText();							 
							 if (expecteditmRslt.equals(actualitmRslt)) {
							 System.out.println("AddItemPage.testCase14 - Service Item added under Add Items section successfully!");								
							 Thread.sleep(5000);	
									// Check Batch and Price elements that was added under Add items section
									String serviceItem = driver.findElement(By.xpath(".//*[@id='grdItems_Article_0001']")).getText();  // Mail Fee article
									logger.info("Mail Fee article: " + serviceItem);
									String servicePrice = driver.findElement(By.xpath(".//*[@id='grdItems_Retail_0001']")).getText();  // Mail Fee Price
									logger.info("Mail Fee Retail Price: "+ servicePrice);
									String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
									logger.info("Sub Total: " + ordSubtotal);  
									Thread.sleep(5000);
									
									driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
									System.out.println("AddItemPage.testCase1 - You clicked Continue to proceed to Marketing page");
									Thread.sleep(2000);
									
								   }else {
									System.out.println("AddItemPage.testCase1 - Failed to add an item");
									logger.info("AddItemPage.testCase1 - Failed to add an item");
									return null;
								   }					  					
						}else {
							System.out.println("AddItemPage.testCase1 - Failed to open 'Add Standard Item' window");
							logger.info("AddItemPage.testCase1 - Failed to open 'Add Standard Item' window");
							return null; 
						}					
					}catch (Exception e) {
						System.out.println("AddItemPage.testCase1 - Error encountered: " + e.getMessage());
						logger.info("AddItemPage.testCase1 - Error encountered");
						return null;
					}				   		   
				return driver;
			}	
			
//TC15: Service item sale: Shop Job
public static ChromeDriver testCase15(ChromeDriver driver) throws InterruptedException {						
				Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");
				
				WebElement services = driver.findElement(By.xpath(".//*[@id='btnServiceItem_CSSBtnLink']"));  
				services.click();
				Thread.sleep(2000);
					
				//Assert if it opens Services item window
				try {
					String expectedRslt = "Services";
					String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-2']")).getText();
					if (expectedRslt.equals(actualRslt)) {
						System.out.println("AddItemPage.testCase15 - 'Shop Job' window opened successfully!");								      
						Thread.sleep(5000);
						//Click Shop Job
						WebElement shopJob = driver.findElement(By.xpath(".//*[@id='btnServiceItems_More_moreCenter_Button0']"));
						shopJob.click();
						Thread.sleep(1000);					
						
						WebElement sjMainType = driver.findElement(By.id("shopMainItmTypSC"));  // Select ShaneCo item radio button
						sjMainType.click();
						System.out.println("AddItemPage.testCase15 - You clicked 'Shane Co Item' radio button");
						Thread.sleep(2000);										
								   
						ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
						WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='shopMainItmTypDiv_sapQuery_TextBox_Edit']"));
						String strBatch = batch.getBatch(3, 16, 1);  // Single batch
						System.out.println("AddItemPage.testCase15 - Got the batch = " + strBatch); 		       
						enterBatch.sendKeys(strBatch);   // feeding strBatch value
						System.out.println("AddItemPage.testCase15 - Batch from spreadsheet: " + strBatch);						
						driver.findElement(By.id("shopMainItmTypDiv_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in SJ Main page
						Thread.sleep(5000);							
								   
						// Choose Types of Jobs	and Details
						driver.findElement(By.xpath(".//*[@id='shopJobType_15']")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id='shopJobDetailNoteText0004']")).sendKeys("test");		// Enter in txt field for Jobs details.
						WebElement sjPrice = driver.findElement(By.xpath(".//*[@id='shopJobCost0004']"));
						sjPrice.clear();
						sjPrice.sendKeys("10");
						driver.findElement(By.xpath("//*[@id='button-okay']/span")).click();   // Click OK button
						Thread.sleep(5000);
						
							//Assert if item is added under Add Items section
							 String expecteditmRslt = "Service Items";
							 String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable_Srv']/div[1]")).getText();							 
							 if (expecteditmRslt.equals(actualitmRslt)) {
							 System.out.println("AddItemPage.testCase15 - Service Item added under Add Items section successfully!");								
							 Thread.sleep(5000);	
									// Check Batch and Price elements that was added under Add items section
									String serviceItem = driver.findElement(By.xpath(".//*[@id='grdItems_Article_0001']")).getText();  // SJ article
									logger.info("Shop Job article: " + serviceItem);
									String servicePrice = driver.findElement(By.xpath(".//*[@id='grdItems_Retail_0001']")).getText();  // SJ Price
									logger.info("Shop Job Price: "+ servicePrice);
									String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
									logger.info("Sub Total: " + ordSubtotal);  
									Thread.sleep(5000);
									
									driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
									System.out.println("AddItemPage.testCase15 - You clicked Continue to proceed to Marketing page");
									Thread.sleep(2000);
									
								   }else {
									System.out.println("AddItemPage.testCase15 - Failed to add an item");
									logger.info("AddItemPage.testCase15 - Failed to add an item");
									return null;
								   }					  					
						}else {
							System.out.println("AddItemPage.testCase15 - Failed to open 'Add Standard Item' window");
							logger.info("AddItemPage.testCase15 - Failed to open 'Add Standard Item' window");
							return null; 
						}					
					}catch (Exception e) {
						System.out.println("AddItemPage.testCase15 - Error encountered: " + e.getMessage());
						logger.info("AddItemPage.testCase15 - Error encountered");
						return null;
					}				   		   
				return driver;
			}	
			





	
//TC20: Hold Sale: Method to Add single item batch/articles in Add Item Page from spreadsheet			
public static ChromeDriver testCase20(ChromeDriver driver) throws InterruptedException {			
		Logger logger = Logger.getLogger("AddItemPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");
		
		WebElement clickStndItem = driver.findElement(By.xpath(".//*[@id='btnStdItem_CSSBtnLink']"));  
		clickStndItem.click();  						// Click Standard item button in Add Item page
		Thread.sleep(2000);
			
			//Assert if it opens the add standard item window
			try {
				String expectedRslt = "Add Standard Item";
				String actualRslt = driver.findElement(By.xpath(".//*[@id='ui-id-3']")).getText();
				if (expectedRslt.equals(actualRslt)) {
					System.out.println("AddItemPage.testCase20 - 'Add Standard Item' window opened successfully!");						
					
					ReadExcelFile batch = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\Batches.xlsx");					       
				       WebElement enterBatch = driver.findElement(By.xpath(".//*[@id='cart_AddItem_Article_sapQuery_TextBox_Edit']"));
				       String strBatch = batch.getBatch(3, 20, 10);  // Single batch
				       System.out.println("AddItemPage.testCase20 - Got the batch = " + strBatch); 		       
				       enterBatch.sendKeys(strBatch);   // feeding strBatch value
				       System.out.println("AddItemPage.testCase20 - Batch from spreadsheet: " + strBatch);
					   driver.findElement(By.id("cart_AddItem_Article_sapQuery_ImageButton")).click(); // Hit Enter to add item batch in Add Item page
					   Thread.sleep(10000);							   
					   driver.findElement(By.xpath(".//div[8]/div[3]/div/button")).click(); // Click 'Close' button to quit window before assertion
					   Thread.sleep(2000);
					   
					   //Assert if item is added under Add Items section
					   	   String expecteditmRslt = "Order Items";
						   String actualitmRslt = driver.findElement(By.xpath(".//*[@id='grdItemsTable']/div[1]")).getText();
						   if (expecteditmRslt.equals(actualitmRslt)) {
							System.out.println("AddItemPage.testCase20 - Item added under Add Items section successfully!");								
							
							// Check Batch and Price elements that was added under Add items section
							String actualItem1 = driver.findElement(By.xpath(".//*[@id='grdItems_ItemRow_0001']/div[4]")).getText();  
							logger.info("Entered first Batch: " + actualItem1); 
							String actualPrice1 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div[4]/div[2]/div/div/div[2]/div[1]/div[3]/div[6]/span")).getText();  
							logger.info("Retail Price item 1 : "+ actualPrice1);
							String ordSubtotal = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
							logger.info("Sub Total: " + ordSubtotal);
							Thread.sleep(5000);
							   
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click(); // Click Continue button on Add Item page to proceed to Marketing Page
							System.out.println("AddItemPage.testCase20 - You clicked Continue to proceed to Marketing page");
							Thread.sleep(2000);
							
						   }else {
							System.out.println("AddItemPage.testCase20 - Failed to add an item!");
							return null;
						   }							
				}else {
					System.out.println("AddItemPage.testCase20 - Failed to open 'Add Standard Item' window!");
					return null; 
				}					
			}catch (Exception e) {
				System.out.println("AddItemPage.testCase20 - Error encountered: " + e.getMessage());
				return null;
			}				   		   
		return driver;
	}
	




	

	

}
