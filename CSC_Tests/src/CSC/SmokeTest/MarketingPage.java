/* This class will allow to add closer and greeter in Marketing Page.
 * @author Sumita Rai
 * May 11, 2018
 * 
 * Last modified: 07/02/2018 
 */

package SmokeTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import UtilityLib.ReadExcelFile;

public class MarketingPage {
	//ReadExcelFile mrktInfo = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\SetupExcel.xlsx");
	
	// This method allow to add closer only in Marketing Page
			public static ChromeDriver closerOnly(ChromeDriver driver) throws InterruptedException {
				Logger logger = Logger.getLogger("MarketingPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");
				//Assert if it open Marketing page after clicking Continue button.
				
				   try {					   	
					   	String expectedRslt = "Closer / Greeter Details";
						String actualmrktPage = driver.findElement(By.id("tabOrder_mktgData_contentTab_lblTitle")).getText();
						if (expectedRslt.equals(actualmrktPage)) {
							System.out.println("MarketingPage.closerOnly - Marketing page loaded successfully!");								
							Thread.sleep(2000);
							
							ReadExcelFile mrktInfo = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\SetupExcel.xlsx");												
							WebElement enterCloser = driver.findElement(By.xpath(".//*[@id='mktgData_Closer1_sapQuery_TextBox_Edit']")); // closer webelement
							String strCloser = mrktInfo.getCloser(2,1,0);  // Fetch Closer info
							enterCloser.sendKeys(strCloser);						
																					
							WebElement purTypeSelection = driver.findElement(By.id("mktgData_PurType_contentDropDownList_Edit")); //Select Purchase Type from dropdown
							Select purTypeSelect = new Select(purTypeSelection); 
							purTypeSelect.selectByIndex(1); 						
							String actualpurType = purTypeSelect.getOptions().get(1).getText(); //verify the purchase type
							System.out.println("MarketingPage.closerOnly - purchase type selected: " + actualpurType);
							Thread.sleep(2000);
						/*	
							WebElement radioStation = driver.findElement(By.id("mktgData_RadioStation_contentDropDownList_Edit"));  // Select types of Radio station from dropdown
							Select radioTypeSelect = new Select(radioStation);
							radioTypeSelect.selectByIndex(2); 
							String actualradioType = radioTypeSelect.getOptions().get(2).getText();
							System.out.println("MarketingPage.closerOnly - Radio station selected: " + actualradioType);
							Thread.sleep(2000);
							
							WebElement radioBtn = driver.findElement(By.id("mktgData_WebInit_contentRadioBoxList_Edit_0")); // Click Radio button to Yes or No or Don't Know
							radioBtn.click();
							System.out.println("MarketingPage.closerOnly - You clicked 'Yes' radio button");
							Thread.sleep(2000);
						*/
							// New change in Marketing page (Release 18.2)
							WebElement referredBySelection = driver.findElement(By.id("mktgData_ReferredBy_contentDropDownList_Edit"));  // Select types Referred by from dropdown
							Select refTypeSelect = new Select(referredBySelection);
							refTypeSelect.selectByIndex(1); 
							String actualrefType = refTypeSelect.getOptions().get(1).getText();
							System.out.println("MarketingPage.closerOnly - Referral selected: " + actualrefType);
							Thread.sleep(2000);
							
							WebElement radioStationSelection = driver.findElement(By.id("mktgData_RadioStation_contentDropDownList_Edit"));  // Select types of Radio station from dropdown
							Select radioTypeSelect = new Select(radioStationSelection);
							radioTypeSelect.selectByIndex(3); 
							String actualradioType = radioTypeSelect.getOptions().get(3).getText();
							System.out.println("MarketingPage.closerOnly - Radio station selected: " + actualradioType);
							Thread.sleep(2000);	
							
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue button on Marketing page to proceed to Item Processing Page
							System.out.println("MarketingPage.closerOnly - You clicked Continue to proceed to Item Processing Page");
							Thread.sleep(2000);
							
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();
							Thread.sleep(2000);
							
							/* This section is for SJ order														
							if (driver.findElement(By.xpath(".//*[@id='ui-id-2']")).getText().equals("Please Confirm...")) {
								WebElement clickYes = driver.findElement(By.xpath("/html/body/div[8]/div[3]/div/button[2]/span"));
								clickYes.click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue button on Marketing page to proceed to Item Processing Page
								Thread.sleep(2000);								
							}else {
								System.out.println("MarketingPage.closerOnly - Failed to confirm SJ label print.");
							}*/
												
							
						}
						else {
							
							System.out.println("MarketingPage.closerOnly - Failed marketing page.");
							logger.info("MarketingPage.closerOnly - Failed marketing page");
							return null;
						}						
					} catch (Exception e) {
						System.out.println("MarketingPage.closerOnly - Error encountered: " +e.getMessage());
						logger.info("MarketingPage.closerOnly - Error encountered");
						return null;
					}				
				return driver;
			}	
					
	// This method allow to add closer and 1 greeter in Marketing Page
			public static ChromeDriver closerGreeter1 (ChromeDriver driver) throws InterruptedException {
				Logger logger = Logger.getLogger("MarketingPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");
				//Assert if it open Marketing page after clicking Continue button.							
				try {							   	
					String expectedRslt = "Closer / Greeter Details";
					String actualmrktPage = driver.findElement(By.id("tabOrder_mktgData_contentTab_lblTitle")).getText();
					if (expectedRslt.equals(actualmrktPage)) {
						System.out.println("MarketingPage.closerGreeter1 - Marketing page loaded successfully!");						
						Thread.sleep(2000);
						
						ReadExcelFile mrktInfo = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\SetupExcel.xlsx");															
						WebElement enterCloser = driver.findElement(By.xpath(".//*[@id='mktgData_Closer1_sapQuery_TextBox_Edit']")); // closer webelement
						String strCloser = mrktInfo.getCloser(2,1,0);  // Fetch Closer info
						enterCloser.sendKeys(strCloser);						
																
						WebElement enterGreeter1 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter1_sapQuery_TextBox_Edit']")); // greeter webelemnt
						String strGreeter1 = mrktInfo.getGreeter(2,1,1);
						enterGreeter1.sendKeys(strGreeter1); // Fetch Greeter1 info										
										
						WebElement purTypeSelection = driver.findElement(By.id("mktgData_PurType_contentDropDownList_Edit")); //Select Purchase Type from dropdown
						Select purTypeSelect = new Select(purTypeSelection); 
						purTypeSelect.selectByIndex(3); 						
						String actualpurType = purTypeSelect.getOptions().get(3).getText(); //verify the purchase type
						System.out.println("MarketingPage.closerGreeter1 - purchase type selected: " + actualpurType);
						Thread.sleep(2000);
										
						WebElement referredBySelection = driver.findElement(By.id("mktgData_ReferredBy_contentDropDownList_Edit"));  // Select types Referred by from dropdown
						Select refTypeSelect = new Select(referredBySelection);
						refTypeSelect.selectByIndex(1); 
						String actualrefType = refTypeSelect.getOptions().get(1).getText();
						System.out.println("MarketingPage.closerOnly - Referral selected: " + actualrefType);
						Thread.sleep(2000);
						
						WebElement radioStationSelection = driver.findElement(By.id("mktgData_RadioStation_contentDropDownList_Edit"));  // Select types of Radio station from dropdown
						Select radioTypeSelect = new Select(radioStationSelection);
						radioTypeSelect.selectByIndex(2); 
						String actualradioType = radioTypeSelect.getOptions().get(2).getText();
						System.out.println("MarketingPage.closerOnly - Radio station selected: " + actualradioType);
						Thread.sleep(2000);	
																
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue button on Marketing page to proceed to Item Processing Page
						System.out.println("MarketingPage.closerGreeter1 - It is loading Item Processing Page");
						Thread.sleep(2000);
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();
						Thread.sleep(2000);
						
						}
						else {
						System.out.println("MarketingPage.closerGreeter1 - Failed marketing page.");
						logger.info("MarketingPage.closerGreeter1 - Failed marketing page");
						return null;
									}						
					} catch (Exception e) {
						System.out.println("MarketingPage.closerGreeter1 - Error encountered: " +e.getMessage());
						logger.info("MarketingPage.closerGreeter1 - Error encountered");
						return null;
					}				
				return driver;
			}	
						
	// This method allow to add closer and 2 greeter in Marketing Page
			public static ChromeDriver closerGreeter2 (ChromeDriver driver) throws InterruptedException {
				Logger logger = Logger.getLogger("MarketingPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");
				//Assert if it open Marketing page after clicking Continue button.							
				try {							   	
					String expectedRslt = "Closer / Greeter Details";
					String actualmrktPage = driver.findElement(By.id("tabOrder_mktgData_contentTab_lblTitle")).getText();
					if (expectedRslt.equals(actualmrktPage)) {
						System.out.println("MarketingPage.closerGreeter2 - Marketing page loaded successfully!");						
						Thread.sleep(2000);	
						
						ReadExcelFile mrktInfo = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\SetupExcel.xlsx");																		
						WebElement enterCloser = driver.findElement(By.xpath(".//*[@id='mktgData_Closer1_sapQuery_TextBox_Edit']")); // closer webelement
						String strCloser = mrktInfo.getCloser(2,1,0);  // Fetch Closer info
						enterCloser.sendKeys(strCloser);						
																			
						WebElement enterGreeter1 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter1_sapQuery_TextBox_Edit']")); // greeter webelemnt
						String strGreeter1 = mrktInfo.getGreeter(2,1,1);
						enterGreeter1.sendKeys(strGreeter1); // Fetch Greeter1 info
													
						WebElement enterGreeter2 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter2_sapQuery_TextBox_Edit']"));
						String strGreeter2 = mrktInfo.getGreeter(2,2,1); // Fetch Greeter2 info
						enterGreeter2.sendKeys(strGreeter2);												
																							
						WebElement purTypeSelection = driver.findElement(By.id("mktgData_PurType_contentDropDownList_Edit")); //Select Purchase Type from dropdown
						Select purTypeSelect = new Select(purTypeSelection); 
						purTypeSelect.selectByIndex(1); // Index 1 will allow to select from the dropdown option						
						String actualpurType = purTypeSelect.getOptions().get(1).getText(); //verify the purchase type
						System.out.println("MarketingPage.closerGreeter2 - purchase type selected: " + actualpurType);
						Thread.sleep(2000);
													
						WebElement referredBySelection = driver.findElement(By.id("mktgData_ReferredBy_contentDropDownList_Edit"));  // Select types Referred by from dropdown
						Select refTypeSelect = new Select(referredBySelection);
						refTypeSelect.selectByIndex(4); 
						String actualrefType = refTypeSelect.getOptions().get(4).getText();
						System.out.println("MarketingPage.closerOnly - Referral selected: " + actualrefType);
						Thread.sleep(2000);
						
						WebElement radioStationSelection = driver.findElement(By.id("mktgData_RadioStation_contentDropDownList_Edit"));  // Select types of Radio station from dropdown
						Select radioTypeSelect = new Select(radioStationSelection);
						radioTypeSelect.selectByIndex(1); 
						String actualradioType = radioTypeSelect.getOptions().get(1).getText();
						System.out.println("MarketingPage.closerOnly - Radio station selected: " + actualradioType);
						Thread.sleep(2000);	
													
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue button on Marketing page to proceed to Item Processing Page
						System.out.println("MarketingPage.closerGreeter2 - It is loading Item Processing Page");
						Thread.sleep(2000);
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();
						Thread.sleep(2000);
						
						}
						else {
						System.out.println("MarketingPage.closerGreeter2 - Failed marketing page.");
						logger.info("MarketingPage.closerGreeter1 - Failed marketing page");
						return null;
						}						
					} catch (Exception e) {
						System.out.println("MarketingPage.closerGreeter1 - Error encountered: " +e.getMessage());
						logger.info("MarketingPage.closerGreeter2 - Error encountered");
						return null;
					}				
				return driver;	
			}
	
	// This method allow to add closer and 3 greeter in Marketing Page
			public static ChromeDriver closerGreeter3 (ChromeDriver driver) throws InterruptedException {
				Logger logger = Logger.getLogger("MarketingPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");
				//Assert if it open Marketing page after clicking Continue button.							
				try {							   	
					String expectedRslt = "Closer / Greeter Details";
					String actualmrktPage = driver.findElement(By.id("tabOrder_mktgData_contentTab_lblTitle")).getText();
					if (expectedRslt.equals(actualmrktPage)) {
						System.out.println("MarketingPage.closerGreeter3 - Marketing page loaded successfully!");						
						Thread.sleep(2000);
						
						ReadExcelFile mrktInfo = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\SetupExcel.xlsx");																		
						WebElement enterCloser = driver.findElement(By.xpath(".//*[@id='mktgData_Closer1_sapQuery_TextBox_Edit']")); // closer webelement
						String strCloser = mrktInfo.getCloser(2,1,0);  // Fetch Closer info getCloser(2,1,0);
						enterCloser.sendKeys(strCloser);						
																			
						WebElement enterGreeter1 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter1_sapQuery_TextBox_Edit']")); // greeter webelemnt
						String strGreeter1 = mrktInfo.getGreeter(2,1,1);
						enterGreeter1.sendKeys(strGreeter1); // Fetch Greeter1 info
													
						WebElement enterGreeter2 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter2_sapQuery_TextBox_Edit']"));
						String strGreeter2 = mrktInfo.getGreeter(2,2,1); // Fetch Greeter2 info
						enterGreeter2.sendKeys(strGreeter2);
						
						WebElement enterGreeter3 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter3_sapQuery_TextBox_Edit']"));
						String strGreeter3 = mrktInfo.getGreeter(2,3,1); // Fetch Greeter3 info
						enterGreeter3.sendKeys(strGreeter3);		
																													
						WebElement purTypeSelection = driver.findElement(By.id("mktgData_PurType_contentDropDownList_Edit")); //Select Purchase Type from dropdown
						Select purTypeSelect = new Select(purTypeSelection); 
						purTypeSelect.selectByIndex(2); 						
						String actualpurType = purTypeSelect.getOptions().get(2).getText(); //verify the purchase type
						System.out.println("MarketingPage.closerGreeter3 - purchase type selected: " + actualpurType);
						Thread.sleep(2000);
													
						WebElement referredBySelection = driver.findElement(By.id("mktgData_ReferredBy_contentDropDownList_Edit"));  // Select types Referred by from dropdown
						Select refTypeSelect = new Select(referredBySelection);
						refTypeSelect.selectByIndex(2); 
						String actualrefType = refTypeSelect.getOptions().get(2).getText();
						System.out.println("MarketingPage.closerOnly - Referral selected: " + actualrefType);
						Thread.sleep(2000);
						
						WebElement radioStationSelection = driver.findElement(By.id("mktgData_RadioStation_contentDropDownList_Edit"));  // Select types of Radio station from dropdown
						Select radioTypeSelect = new Select(radioStationSelection);
						radioTypeSelect.selectByIndex(2); 
						String actualradioType = radioTypeSelect.getOptions().get(2).getText();
						System.out.println("MarketingPage.closerOnly - Radio station selected: " + actualradioType);
						Thread.sleep(2000);	
													
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue button on Marketing page to proceed to Item Processing Page
						System.out.println("MarketingPage.closerGreeter3 - It is loading Item Processing Page");
						Thread.sleep(2000);
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();
						Thread.sleep(2000);
						
						}
						else {
						System.out.println("MarketingPage.closerGreeter3 - Failed marketing page.");
						logger.info("MarketingPage.closerGreeter3 - Failed marketing page");
						return null;
						}						
					} catch (Exception e) {
						System.out.println("MarketingPage.closerGreeter1 - Error encountered: " +e.getMessage());
						logger.info("MarketingPage.closerGreeter3 - Error encountered");
						return null;
					}				
				return driver;	
				}
	
	// This method allow to add closer and 4 greeter in Marketing Page			
			public static ChromeDriver closerGreeter4 (ChromeDriver driver) throws InterruptedException {
				Logger logger = Logger.getLogger("MarketingPage");  // logger get the class name
				PropertyConfigurator.configure("Log4j.properties");
				//Assert if it open Marketing page after clicking Continue button.							
				try {							   	
					String expectedRslt = "Closer / Greeter Details";
					String actualmrktPage = driver.findElement(By.id("tabOrder_mktgData_contentTab_lblTitle")).getText();
					if (expectedRslt.equals(actualmrktPage)) {
						System.out.println("MarketingPage.closerGreeter4 - Marketing page loaded successfully!");						
						Thread.sleep(2000);
						
						ReadExcelFile mrktInfo = new ReadExcelFile("C:\\Work\\Java\\CSC_Tests\\Resources\\SetupExcel.xlsx");																		
						WebElement enterCloser = driver.findElement(By.xpath(".//*[@id='mktgData_Closer1_sapQuery_TextBox_Edit']")); // closer webelement
						String strCloser = mrktInfo.getCloser(2,1,0);  // Fetch Closer info
						enterCloser.sendKeys(strCloser);						
																			
						WebElement enterGreeter1 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter1_sapQuery_TextBox_Edit']")); // greeter webelemnt
						String strGreeter1 = mrktInfo.getGreeter(2,1,1);
						enterGreeter1.sendKeys(strGreeter1); // Fetch Greeter1 info
													
						WebElement enterGreeter2 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter2_sapQuery_TextBox_Edit']"));
						String strGreeter2 = mrktInfo.getGreeter(2,2,1); // Fetch Greeter2 info
						enterGreeter2.sendKeys(strGreeter2);
						
						WebElement enterGreeter3 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter3_sapQuery_TextBox_Edit']"));
						String strGreeter3 = mrktInfo.getGreeter(2,3,1); // Fetch Greeter3 info
						enterGreeter3.sendKeys(strGreeter3);
						
						WebElement enterGreeter4 = driver.findElement(By.xpath(".//*[@id='mktgData_Greeter4_sapQuery_TextBox_Edit']"));
						String strGreeter4 = mrktInfo.getGreeter(2,4,1); // Fetch Greeter4 info
						enterGreeter4.sendKeys(strGreeter4);
																													
						WebElement purTypeSelection = driver.findElement(By.id("mktgData_PurType_contentDropDownList_Edit")); //Select Purchase Type from dropdown
						Select purTypeSelect = new Select(purTypeSelection); 
						purTypeSelect.selectByIndex(3); 						
						String actualpurType = purTypeSelect.getOptions().get(3).getText(); //verify the purchase type
						System.out.println("MarketingPage.closerGreeter4 - purchase type selected: " + actualpurType);
						Thread.sleep(2000);
													
						WebElement referredBySelection = driver.findElement(By.id("mktgData_ReferredBy_contentDropDownList_Edit"));  // Select types Referred by from dropdown
						Select refTypeSelect = new Select(referredBySelection);
						refTypeSelect.selectByIndex(2); 
						String actualrefType = refTypeSelect.getOptions().get(2).getText();
						System.out.println("MarketingPage.closerOnly - Referral selected: " + actualrefType);
						Thread.sleep(2000);
						
						WebElement radioStationSelection = driver.findElement(By.id("mktgData_RadioStation_contentDropDownList_Edit"));  // Select types of Radio station from dropdown
						Select radioTypeSelect = new Select(radioStationSelection);
						radioTypeSelect.selectByIndex(5); 
						String actualradioType = radioTypeSelect.getOptions().get(5).getText();
						System.out.println("MarketingPage.closerOnly - Radio station selected: " + actualradioType);
						Thread.sleep(2000);	
													
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();  // Click Continue button on Marketing page to proceed to Item Processing Page
						System.out.println("MarketingPage.closerGreeter4 - It is loading Item Processing Page");
						Thread.sleep(2000);
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();
						Thread.sleep(2000);
						
						}
						else {
						System.out.println("MarketingPage.closerGreeter1 - Failed marketing page.");
						logger.info("MarketingPage.closerGreeter4 - Failed marketing page");
						return null;
						}						
					} catch (Exception e) {
						System.out.println("MarketingPage.closerGreeter1 - Error encountered: " +e.getMessage());
						logger.info("MarketingPage.closerGreeter4 - Error encountered");
						return null;
					}				
				return driver;	
				}
	
			
}
