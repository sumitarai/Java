/* This class will allow to add closer and greeter in Marketing Page.
 * @author Sumita Rai
 * May 11, 2018
 * 
 * Last modified: 05/11/2018 
 */

package SmokeTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ItmProcessPage {
	// Standard Sale Item Processing Page
		public static ChromeDriver stndItmOption(ChromeDriver driver) throws InterruptedException{
				Logger logger = Logger.getLogger("ItmProcessPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");				
					// Assert if it loaded the Item Processing Page
						try {
							String expectedRslt = "Item Processing";
							String actualitmProcessPage = driver.findElement(By.xpath(".//*[@id='tabOrder_ItemProc_contentTab_lblTitle']")).getText();
							if (expectedRslt.equals(actualitmProcessPage)) {
								System.out.println("ItmProcessPage.stndItmOption - 'Item Processing' Page loaded successfully!");	
								Thread.sleep(2000);
								WebElement itmOptions = driver.findElement(By.xpath(".//*[@id='ctrl0_grdProcTable_ddlOption_0']"));
								Select itmOptionsSelect = new Select(itmOptions);  		// Item options displays Standard, Hold, and Layaway
								itmOptionsSelect.selectByIndex(0);    				
								String actualitmProcess = itmOptionsSelect.getOptions().get(0).getText();  
								System.out.println("ItmProcessPage.stndItmOption - "+ actualitmProcess);
								logger.info("Sale Type: " + actualitmProcess);
								Thread.sleep(2000);								
								
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue btn on Item Processing Page to proceed to Order Summary Page
								System.out.println("ItmProcessPage.stndItmOption - You clicked Continue to proceed to 'Order Summary' Page");
								Thread.sleep(5000);								
								}
							else{
								System.out.println("ItmProcessPage.itmProcessPage - Failed loading 'Item Procesing' Page");
								logger.info("ItmProcessPage.stndItmOption - Failed loading 'Item Procesing' Page");
								return null;
								}		
						}catch (Exception e) {
							System.out.println("ItmProcessPage.itmProcessPage - Error encounter: "+ e.getMessage());
							logger.info("ItmProcessPage.stndItmOption - Error encountered");
							return null;
						}					
					return driver;
				}

	// Hold Item Processing Page
		public static ChromeDriver holdItmOption(ChromeDriver driver) throws InterruptedException{
			Logger logger = Logger.getLogger("ItmProcessPage");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
			
				// Assert if it loaded the Item Processing Page
					try {
						String expectedRslt = "Item Processing";
						String actualitmProcessPage = driver.findElement(By.id("tabOrder_ItemProc_contentTab_lblTitle")).getText();
						if (expectedRslt.equals(actualitmProcessPage)) {
							System.out.println("ItmProcessPage.holdItmOption - 'Item Processing' Page loaded successfully!");	
							Thread.sleep(2000);
							WebElement itmOptions = driver.findElement(By.xpath(".//*[@id='ctrl0_grdProcTable_ddlOption_0']"));
							Select itmOptionsSelect = new Select(itmOptions);
							itmOptionsSelect.selectByIndex(1);   //Standard, Hold, and Layaway item options
							
							String actualitmProcess = itmOptionsSelect.getOptions().get(1).getText();
							System.out.println("ItmProcessPage.holdItmOption - Sale Type: "+ actualitmProcess);
							logger.info("Sale Type: " + actualitmProcess);
							Thread.sleep(2000);								
							
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue btn on Item Processing Page to proceed to Order Summary Page
							System.out.println("ItmProcessPage.holdItmOption - It is loading 'Order Summary' Page");
							Thread.sleep(5000);	
							
							}
						else{
							System.out.println("ItmProcessPage.holdItmOption - Failed loading 'Item Procesing' Page");
							return null;
							}		
					}catch (Exception e) {
						System.out.println("ItmProcessPage.holdItmOption - Error encounter: "+ e.getMessage());
						return null;
					}					
				return driver;
			}
		
	// Layaway Item Processing Page
		public static ChromeDriver lwyItmOption(ChromeDriver driver) throws InterruptedException{
			Logger logger = Logger.getLogger("ItmProcessPage");  // logger get the class name
			PropertyConfigurator.configure("Log4j.properties");
			
				// Assert if it loaded the Item Processing Page
					try {
						String expectedRslt = "Item Processing";
						String actualitmProcessPage = driver.findElement(By.id("tabOrder_ItemProc_contentTab_lblTitle")).getText();
						if (expectedRslt.equals(actualitmProcessPage)) {
							System.out.println("ItmProcessPage.lwyItmOption - 'Item Processing' Page loaded successfully!");	
							Thread.sleep(2000);
							WebElement itmOptions = driver.findElement(By.xpath(".//*[@id='ctrl0_grdProcTable_ddlOption_0']"));
							Select itmOptionsSelect = new Select(itmOptions);
							itmOptionsSelect.selectByIndex(2);   //Standard, Hold, and Layaway item options
							String actualitmProcess = itmOptionsSelect.getOptions().get(2).getText();
							System.out.println("ItmProcessPage.lwyItmOption - Sale Type: "+ actualitmProcess);
							logger.info("Sale Type: " + actualitmProcess);
							Thread.sleep(2000);								
							
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue btn on Item Processing Page to proceed to Order Summary Page
							System.out.println("ItmProcessPage.lwyItmOption - It is loading 'Order Summary' Page");
							Thread.sleep(5000);							
							}
						else{
							System.out.println("ItmProcessPage.lwyItmOption - Failed loading 'Item Procesing' Page");
							return null;
							}		
					}catch (Exception e) {
						System.out.println("ItmProcessPage.lwyItmOption - Error encounter: "+ e.getMessage());
						return null;
					}					
				return driver;
			}		
			
}
