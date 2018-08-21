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
import org.openqa.selenium.chrome.ChromeDriver;

public class OrdSummaryPage {
	
// Order Summary Page
	public static ChromeDriver orderSum(ChromeDriver driver)  throws InterruptedException{		   		  	
		Logger logger = Logger.getLogger("OrdSummaryPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");
			//Assert Order Summary Page
				try {
							
					String expectedRslt = "Order Summary";
					String actualordSummPage = driver.findElement(By.xpath(".//*[@id='tabOrder_Summary_contentTab_lblTitle']")).getText();
					if (expectedRslt.equals(actualordSummPage)) {
						System.out.println("OrdSummaryPage.orderSum - 'Order Summary' page loaded successfully!");
						Thread.sleep(2000);
						//04/05/2018: According to Pat, does not require to calculate Tax to assert correct Tax calculation
						String actualTax = driver.findElement(By.xpath(".//*[@id='ordItems_TotTax']")).getText();   //get Tax element in Ord summary page
						System.out.println("OrdSummaryPage.orderSum - Tax displayed " + actualTax + " successfully!");	
						logger.info("Tax: " + actualTax);						
						String totalOrder = driver.findElement(By.xpath(".//*[@id='ordItems_TotOrd']")).getText();
						System.out.println("OrdSummaryPage.orderSum - Order Total: " + totalOrder);
						logger.info("Order Total: " + totalOrder);						
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click 'Continue' button on Order Summary Page to proceed to Payment Page
						System.out.println("OrdSummaryPage.orderSum - Continue button is clicked to load 'Payment' Page");
						Thread.sleep(5000);
											
					}else {
						System.out.println("OrdSummaryPage.orderSum - Failed loading 'Order Summary' Page");
						logger.info("OrdSummaryPage.orderSum - Failed loading 'Order Summary' Page");
						return null;
					}						
				} catch (Exception e) {
					System.out.println("OrdSummaryPage.orderSum - Error encountered: " + e.getMessage());
					logger.info("OrdSummaryPage.orderSum - Error encountered");
					return null;
				}
		return driver;				
	}	
		
	
}
