/* This class will initiate an order.
 * @author Sumita Rai
 * May 10, 2018
 * 
 * Last modified: 05/11/2018 
 */

package SmokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import UtilityLib.Utility;

public class InitiateOrder {
	// This method to Initiate sale from the Customer Data page
			public static ChromeDriver saleItem(ChromeDriver driver) throws InterruptedException{			
				WebElement saleBtn = driver.findElement(By.xpath(".//*[@id='btnTxnSale']"));   //click sale button
				saleBtn.click();  
				System.out.println("InitiateOrder.saleItem - You clicked Sale button");	
				Thread.sleep(10000);
						
				//WebElement passWord = driver.findElement(By.xpath(".//*[@id='ui-id-2']/input"));   
				WebElement passWord = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
				String strPassword = Utility.getCredential("Password");
				passWord.sendKeys(strPassword);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();   //click ok button closes password window and open Add Item Page
				Thread.sleep(2000);						
					//assert if it opens the Add Item page after entering password
					try {
						String expectedRslt = "Add Items";
						String actualRslt = driver.findElement(By.xpath(".//*[@id='tabOrderSummary_contentTab_lblTitle']")).getText();
						if (expectedRslt.equals(actualRslt)) {
							System.out.println("InitiateOrder.saleItem - You entered password and 'Add Item' page loaded successfully!");
							
						}else {
							System.out.println("InitiateOrder.saleItem - Failed to open Add Item page!");
							return null;
						}					
					} catch (Exception e) {
						System.out.println("InitiateOrder.saleItem - Error encountered: " + e.getMessage());
						return null;
					}
			return driver;
			}
			
	
	// This method to Initiate Return (Stand Alone) from the Customer Data page
			public static ChromeDriver returnItem(ChromeDriver driver) throws InterruptedException{			
				WebElement returnBtn = driver.findElement(By.xpath(".//*[@id='btnTxnReturn']"));   //click return button
				returnBtn.click();
				System.out.println("InitiateOrder.returnItem - You clicked Return button");	
				Thread.sleep(2000);
									
				//WebElement passWord = driver.findElement(By.xpath(".//*[@id='ui-id-4']/input")); 
				WebElement passWord = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
				String strPassword = Utility.getCredential("Password");
				passWord.sendKeys(strPassword);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();   //click ok button closes password window and open Add Item Page
												
				//assert if it opens the Add Item page after entering password
					try {
						String expectedRslt = "Add Items"; 
						String actualRslt = driver.findElement(By.xpath(".//*[@id='tabOrderSummary_contentTab_lblTitle']")).getText();
						if (expectedRslt.equals(actualRslt)) {
							System.out.println("InitiateOrder.returnItem - You entered password and 'Add Item' page loaded successfully!");
										
						}else {
							System.out.println("InitiateOrder.returnItem - Failed to open Add Item page!");
							return null;
							}					
					} catch (Exception e) {
							System.out.println("InitiateOrder.returnItem - Error encountered: " + e.getMessage());
							return null;
						}
							Thread.sleep(2000);
							return driver;
					}
			
			
	// This method to Initiate Warranty Exchange (Stand Alone) from the Customer Data page
			public static ChromeDriver warrantyExItem(ChromeDriver driver) throws InterruptedException{		
				WebElement warrexBtn = driver.findElement(By.xpath(".//*[@id='btnTxnReturn']"));   //click return button
				warrexBtn.click();
				System.out.println("InitiateOrder.returnItem - You clicked Return button");	
				Thread.sleep(2000);
												
				//WebElement passWord = driver.findElement(By.xpath(".//*[@id='ui-id-4']/input")); 
				WebElement passWord = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
				String strPassword = Utility.getCredential("Password");
				passWord.sendKeys(strPassword);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();   //click ok button closes password window 
															
				//assert if it opens the Add Item page after entering password
				try {
					String expectedRslt = "Choose Warranty Exchange Option"; 
					String actualRslt = driver.findElement(By.xpath("html/body/div[8]/div[1]/span")).getText();
					if (expectedRslt.equals(actualRslt)) {
						driver.findElement(By.xpath("html/body/div[8]/div[3]/div/button[2]")).click();
						System.out.println("InitiateOrder.returnItem - You selected 'Complete' option and 'Add Item' page loaded successfully!");	
						
						String expectedRslt1 = "Add Items"; 
						String actualRslt1 = driver.findElement(By.xpath(".//*[@id='tabOrderSummary_contentTab_lblTitle']")).getText();
						if (expectedRslt1.equals(actualRslt1)) {
							System.out.println("InitiateOrder.returnItem - You entered password and 'Add Item' page loaded successfully!");
										
						}else {
							System.out.println("InitiateOrder.returnItem - Failed to open Add Item page!");
							return null;
							}																		
					}else {
						System.out.println("InitiateOrder.returnItem - Failed to open Add Item page!");
						return null;
						}					
					} catch (Exception e) {
						System.out.println("InitiateOrder.returnItem - Error encountered: " + e.getMessage());
						return null;
						}
						Thread.sleep(2000);
						return driver;
					}
								
			
			
}
