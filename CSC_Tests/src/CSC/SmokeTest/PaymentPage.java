/*
 * This class collect all methods that will allow to add items in Add item Page for each TC

* @author Sumita Rai
* May 24, 2018
* Last Mod: 06/20/2018

*/

package SmokeTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {
	
//This method allow to select tender type in Payment Page
	public static ChromeDriver corpUsePymt(ChromeDriver driver) throws InterruptedException{
		Logger logger = Logger.getLogger("PaymentPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
			//Assert if Payment Page is loaded 
			try {
				String expectedPymtRslt = "Payment Options";
				String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
				if (expectedPymtRslt.equals(actualPymtRslt)) {
					System.out.println("PaymentPage.corpUsePymt - Payment Page loaded successfully!");
					Thread.sleep(5000);						
						
					//Select 'Corp Use' Tender Type  
					WebElement tenderSelect = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_New_contentDropDownList_Edit']"));
					Select tenderTypeSelect= new Select(tenderSelect);							
					tenderTypeSelect.selectByVisibleText("Corporate Use"); 
					Thread.sleep(2000);
					 																		
						//assert if the tender type section is selected correctly																
						String expectedTenderType = "Corporate Use";  
						String actualTenderType = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_Std_0000_contentDropDownList_UpperDiv']")).getText();
						if (expectedTenderType.equals(actualTenderType)) {
							System.out.println("PaymentPage.corpUsePymt - " + actualTenderType + " tender type selected successfully!");
							//System.out.println("PaymentPage.corpUsePymt - You have selected tender type: " + tenderTypeSelect.getOptions().get(8).getText()); //when Fund is open 'Corporate Use' is in Index 8 else use Index 4
							Thread.sleep(5000);
																	
							String dueAmt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
							String paidDueAmt = dueAmt.replace("$","");	
							logger.info("Due Paid using Corporate Use: " + dueAmt);
							Thread.sleep(5000);	
							WebElement amtField = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendAmount_Std_0000_contentTextBox_Edit']"));   
							amtField.sendKeys(paidDueAmt); // Pass the dueamount value in Amount field																		
							Thread.sleep(2000);
							driver.findElement(By.xpath(".//*[@id='payOpt_TendNotes0000']")).sendKeys("Test");   //Entering txt in Notes field
							Thread.sleep(1000);
							driver.findElement(By.xpath(".//*[@id='payOpt_TendApply_Std_slideBtnLink']")).click();  // Clicking 'Apply Payment' btn
							Thread.sleep(20000);
							driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order										
							System.out.println("PaymentPage.corpUsePymt - You clicked Continue to submit an order");
							Thread.sleep(30000);											
										
								//assert for order submission page	
								String expectedSubmit = "Order Has Been Submitted"; 
								String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")).getText();
								if (actualSubmit.equals(expectedSubmit)) {												
									System.out.println("PaymentPage.corpUsePymt - " + actualSubmit +" successfully!");
									Thread.sleep(5000);
									String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
									System.out.println("Order submitted: " + ordNumber);  
									logger.info(ordNumber);
									System.out.println("");
																					
								}else {
									Thread.sleep(5000);
									String ordStatus = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_lblTitle']")).getText();
									System.out.println("PaymentPage.corpUsePymt - " + ordStatus);											
									return null;
									}										
							}else {
								System.out.println("PaymentPage.corpUsePymt - Assertion Tender type failed!");	
								return null;
							}						
						}else {
							System.out.println("PaymentPage.corpUsePymt - Failed loading Payment Page");
							return null;
						}							
				} catch (Exception e) {
					System.out.println("PaymentPage.corpUsePymt - Error encountered:" + e.getMessage());
					return null;
				}	
		return driver;				
	}	
	
	public static ChromeDriver cashPymt(ChromeDriver driver) throws InterruptedException{
		Logger logger = Logger.getLogger("PaymentPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
			//Assert if Payment Page is loaded 
				try {
					String expectedPymtRslt = "Payment Options";
					String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
					if (expectedPymtRslt.equals(actualPymtRslt)) {
						System.out.println("PaymentPage.cashPymt - Payment Page loaded successfully!");
						Thread.sleep(5000);						
						
						//Select 'Cash' Tender Type  
						WebElement tenderSelect = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_New_contentDropDownList_Edit']"));
						Select tenderTypeSelect= new Select(tenderSelect);							
						tenderTypeSelect.selectByVisibleText("Cash");    
						Thread.sleep(2000);
													
							// assert if the tender type section is selected correctly																
							String expectedTenderType = "Cash"; 
							String actualTenderType = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_Std_0000_contentDropDownList_UpperDiv']")).getText();
							if (expectedTenderType.equals(actualTenderType)) {
								System.out.println("PaymentPage.cashPymt - Tender type " + actualTenderType + " selected successfully!");
								Thread.sleep(5000);
																	
								String dueAmt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
								String paidDueAmt = dueAmt.replace("$","");	
								logger.info("Due Paid using Cash: " + dueAmt);
								Thread.sleep(5000);	
								WebElement amtField = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendAmount_Std_0000_contentTextBox_Edit']"));   
								amtField.sendKeys(paidDueAmt); // Pass the dueamout value in Amount field																		
								Thread.sleep(2000);
								driver.findElement(By.xpath(".//*[@id='payOpt_TendCount1000000_contentTextBox_Edit']")).sendKeys("0");   //Entering 0 in Count of $100 Bills field
								Thread.sleep(1000);
								driver.findElement(By.xpath(".//*[@id='payOpt_TendApply_Std_slideBtnLink']")).click();  // Clicking 'Apply Payment' btn
								Thread.sleep(25000);
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order										
								System.out.println("PaymentPage.cashPymt - You clicked Continue to submit an order");
								Thread.sleep(30000);											
										
									//assert for order submission page	
									String expectedSubmit = "Order Has Been Submitted"; 
									String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")).getText();
									
									if (actualSubmit.equals(expectedSubmit)) {												
										System.out.println("PaymentPage.cashPymt - Order submitted successfully!");
										Thread.sleep(5000);
										String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
										System.out.println("Order submitted: " + ordNumber);
										logger.info(ordNumber);
										System.out.println("");
																					
									}else {
										System.out.println("PaymentPage.cashPymt - CSC delayed submitting an order d/t slowness. TC failed.");											
										return null;
									}										
								}else {
									System.out.println("PaymentPage.cashPymt - Assertion Tender type failed!");	
									return null;
								}						
						}else {
							System.out.println("PaymentPage.cashPymt - Failed loading Payment Page");
							return null;
						}							
				} catch (Exception e) {
					System.out.println("PaymentPage.cashPymt - Error encountered:" + e.getMessage());
					return null;
				}	
		return driver;				
	}		

	public static ChromeDriver checkPymt(ChromeDriver driver) throws InterruptedException{
		Logger logger = Logger.getLogger("PaymentPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
			//Assert if Payment Page is loaded 
				try {
					String expectedPymtRslt = "Payment Options";
					String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
					if (expectedPymtRslt.equals(actualPymtRslt)) {
						System.out.println("PaymentPage.checkPymt - Payment Page loaded successfully!");
						Thread.sleep(5000);						
						
						//Select 'Check' Tender Type  
						WebElement tenderSelect = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_New_contentDropDownList_Edit']"));
						Select tenderTypeSelect= new Select(tenderSelect);							
						tenderTypeSelect.selectByVisibleText("Check for Deposit");    
						Thread.sleep(2000);
													
							// assert if the tender type section is selected correctly																
							String expectedTenderType = "Check for Deposit"; 
							String actualTenderType = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_Std_0000_contentDropDownList_UpperDiv']")).getText();
							if (expectedTenderType.equals(actualTenderType)) {
								System.out.println("PaymentPage.checkPymt - Tender type " + actualTenderType + " selected successfully!");
								Thread.sleep(5000);
																	
								String dueAmt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
								String paidDueAmt = dueAmt.replace("$","");	
								logger.info("Due Paid using Check: " + dueAmt);
								Thread.sleep(5000);	
								WebElement amtField = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendAmount_Std_0000_contentTextBox_Edit']"));   
								amtField.sendKeys(paidDueAmt); // Pass the dueamout value in Amount field																		
								Thread.sleep(2000);
								
								String chkNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
								driver.findElement(By.xpath("//*[@id='payOpt_TendPymtNum0000_contentTextBox_Edit']")).sendKeys("47" + chkNumber);   //Entering check number
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@id='payOpt_TendAuthNum0000_contentTextBox_Edit']")).sendKeys("123456");   //Entering Auth number
								Thread.sleep(1000);
								
								
								driver.findElement(By.xpath(".//*[@id='payOpt_TendApply_Std_slideBtnLink']")).click();  // Clicking 'Apply Payment' btn
								Thread.sleep(25000);
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order										
								System.out.println("PaymentPage.cashPymt - You clicked Continue to submit an order");
								Thread.sleep(30000);											
										
									//assert for order submission page	
									String expectedSubmit = "Order Has Been Submitted"; 
									String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")).getText();
									//*[@id="payOpt_TendPymtNum0000_contentTextBox_Edit"]
									
									if (actualSubmit.equals(expectedSubmit)) {												
										System.out.println("PaymentPage.cashPymt - Order submitted successfully!");
										Thread.sleep(5000);
										String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
										System.out.println("Order submitted: " + ordNumber);
										logger.info(ordNumber);
										System.out.println("");
																					
									}else {
										System.out.println("PaymentPage.cashPymt - CSC delayed submitting an order d/t slowness. TC failed.");											
										return null;
									}										
								}else {
									System.out.println("PaymentPage.cashPymt - Assertion Tender type failed!");	
									return null;
								}						
						}else {
							System.out.println("PaymentPage.cashPymt - Failed loading Payment Page");
							return null;
						}							
				} catch (Exception e) {
					System.out.println("PaymentPage.cashPymt - Error encountered:" + e.getMessage());
					return null;
				}	
		return driver;				
	}		

	public static ChromeDriver eftPymt(ChromeDriver driver) throws InterruptedException{
		Logger logger = Logger.getLogger("PaymentPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
			//Assert if Payment Page is loaded 
				try {
					String expectedPymtRslt = "Payment Options";
					String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
					if (expectedPymtRslt.equals(actualPymtRslt)) {
						System.out.println("PaymentPage.eftPymt - Payment Page loaded successfully!");
						Thread.sleep(5000);						
						
						//Select 'Check' Tender Type  
						WebElement tenderSelect = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_New_contentDropDownList_Edit']"));
						Select tenderTypeSelect= new Select(tenderSelect);							
						tenderTypeSelect.selectByVisibleText("EFT Check");    
						Thread.sleep(2000);
													
							// assert if the tender type section is selected correctly																
							String expectedTenderType = "EFT Check"; 
							String actualTenderType = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_Std_0000_contentDropDownList_UpperDiv']")).getText();
							if (expectedTenderType.equals(actualTenderType)) {
								System.out.println("PaymentPage.eftPymt - Tender type " + actualTenderType + " selected successfully!");
								Thread.sleep(5000);
																	
								String dueAmt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
								String paidDueAmt = dueAmt.replace("$","");	
								logger.info("Due paid using EFT Check: " + dueAmt);
								Thread.sleep(5000);	
								WebElement amtField = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendAmount_Std_0000_contentTextBox_Edit']"));   
								amtField.sendKeys(paidDueAmt); // Pass the dueamout value in Amount field																		
								Thread.sleep(2000);
								
								String chkNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
								driver.findElement(By.xpath("//*[@id='payOpt_TendPymtNum0000_contentTextBox_Edit']")).sendKeys("47" + chkNumber);   //Entering check number
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@id='payOpt_TendAuthNum0000_contentTextBox_Edit']")).sendKeys("123456");   //Entering Auth number
								Thread.sleep(1000);
								
								
								driver.findElement(By.xpath(".//*[@id='payOpt_TendApply_Std_slideBtnLink']")).click();  // Clicking 'Apply Payment' btn
								Thread.sleep(25000);
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order										
								System.out.println("PaymentPage.eftPymt - You clicked Continue to submit an order");
								Thread.sleep(30000);											
										
									//assert for order submission page	
									String expectedSubmit = "Order Has Been Submitted"; 
									String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")).getText();
									//*[@id="payOpt_TendPymtNum0000_contentTextBox_Edit"]
									
									if (actualSubmit.equals(expectedSubmit)) {												
										System.out.println("PaymentPage.eftPymt - Order submitted successfully!");
										Thread.sleep(5000);
										String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
										System.out.println("Order submitted: " + ordNumber);
										logger.info(ordNumber);
										System.out.println("");
																					
									}else {
										System.out.println("PaymentPage.eftPymt - CSC delayed submitting an order d/t slowness. TC failed.");											
										return null;
									}										
								}else {
									System.out.println("PaymentPage.eftPymt - Assertion Tender type failed!");	
									return null;
								}						
						}else {
							System.out.println("PaymentPage.eftPymt - Failed loading Payment Page");
							return null;
						}							
				} catch (Exception e) {
					System.out.println("PaymentPage.eftPymt - Error encountered:" + e.getMessage());
					return null;
				}	
		return driver;				
	}		

	//Bank Issue Check Types
	public static ChromeDriver cashierPymt(ChromeDriver driver) throws InterruptedException{
		Logger logger = Logger.getLogger("PaymentPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
			//Assert if Payment Page is loaded 
				try {
					String expectedPymtRslt = "Payment Options";
					String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
					if (expectedPymtRslt.equals(actualPymtRslt)) {
						System.out.println("PaymentPage.cashierPymt - Payment Page loaded successfully!");
						Thread.sleep(5000);						
						
						//Select 'Bank Issue' Tender Type  
						WebElement tenderSelect = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_New_contentDropDownList_Edit']"));
						Select tenderTypeSelect= new Select(tenderSelect);							
						tenderTypeSelect.selectByVisibleText("Bank Issue");    
						Thread.sleep(2000);
													
							// assert if the tender type section is selected correctly																
							String expectedTenderType = "Bank Issue"; 
							String actualTenderType = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_Std_0000_contentDropDownList_UpperDiv']")).getText();
							if (expectedTenderType.equals(actualTenderType)) {
								System.out.println("PaymentPage.cashierPymt - " + actualTenderType + " tender type selected successfully!");
								Thread.sleep(5000);
																	
								String dueAmt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
								String paidDueAmt = dueAmt.replace("$","");	
								logger.info("Due paid using Cashiers Check: " + dueAmt);
								Thread.sleep(5000);	
								WebElement amtField = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendAmount_Std_0000_contentTextBox_Edit']"));   
								amtField.sendKeys(paidDueAmt); // Pass the dueamout value in Amount field																		
								Thread.sleep(2000);
								
								//select Cashiers Check Type
								WebElement bankIssueType = driver.findElement(By.xpath("//*[@id='payOpt_TendPymtType0000_contentDropDownList_Edit']"));
								Select checkTypeSelect = new Select(bankIssueType);   // select bank issue check type
								checkTypeSelect.selectByVisibleText("Cashiers Check");
								Thread.sleep(2000);								
								String chkNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText(); 
								driver.findElement(By.xpath("//*[@id='payOpt_TendPymtNum0000_contentTextBox_Edit']")).sendKeys("47" + chkNumber);   //Entering check number
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@id='payOpt_TendIssuer0000_contentTextBox_Edit']")).sendKeys("Chase");   //Entering Bank/Institution Name								
								Thread.sleep(1000);
								
								
								driver.findElement(By.xpath(".//*[@id='payOpt_TendApply_Std_slideBtnLink']")).click();  // Clicking 'Apply Payment' btn
								Thread.sleep(20000);
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order										
								System.out.println("PaymentPage.cashierPymt - You clicked Continue to submit an order");
								Thread.sleep(30000);											
										
									//assert for order submission page	
									String expectedSubmit = "Order Has Been Submitted"; 
									String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")).getText();
									//*[@id="payOpt_TendPymtNum0000_contentTextBox_Edit"]
									
									if (actualSubmit.equals(expectedSubmit)) {												
										System.out.println("PaymentPage.cashierPymt - Order submitted successfully!");
										Thread.sleep(5000); 
										String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
										System.out.println("Order submitted: " + ordNumber);
										logger.info(ordNumber);
										System.out.println("");
																					
									}else {
										System.out.println("PaymentPage.cashierPymt - CSC delayed submitting an order d/t slowness. TC failed.");											
										return null;
									}										
								}else {
									System.out.println("PaymentPage.cashierPymt - Assertion Tender type failed!");	
									return null;
								}						
						}else {
							System.out.println("PaymentPage.cashierPymt - Failed loading Payment Page");
							return null;
						}							
				} catch (Exception e) {
					System.out.println("PaymentPage.cashierPymt - Error encountered:" + e.getMessage());
					return null;
				}	
		return driver;				
	}		

	public static ChromeDriver moneyOrderPymt(ChromeDriver driver) throws InterruptedException{
		Logger logger = Logger.getLogger("PaymentPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
			//Assert if Payment Page is loaded 
				try {
					String expectedPymtRslt = "Payment Options";
					String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
					if (expectedPymtRslt.equals(actualPymtRslt)) {
						System.out.println("PaymentPage.moneyOrderPymt - Payment Page loaded successfully!");
						Thread.sleep(5000);						
						
						//Select 'Bank Issue' Tender Type  
						WebElement tenderSelect = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_New_contentDropDownList_Edit']"));
						Select tenderTypeSelect= new Select(tenderSelect);							
						tenderTypeSelect.selectByVisibleText("Bank Issue");    
						Thread.sleep(2000);
													
							// assert if the tender type section is selected correctly																
							String expectedTenderType = "Bank Issue"; 
							String actualTenderType = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_Std_0000_contentDropDownList_UpperDiv']")).getText();
							if (expectedTenderType.equals(actualTenderType)) {
								System.out.println("PaymentPage.moneyOrderPymt - " + actualTenderType + " tender type selected successfully!");
								Thread.sleep(5000);
																	
								String dueAmt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
								String paidDueAmt = dueAmt.replace("$","");	
								logger.info("Due paid using Money Order: " + dueAmt);
								Thread.sleep(5000);	
								WebElement amtField = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendAmount_Std_0000_contentTextBox_Edit']"));   
								amtField.sendKeys(paidDueAmt); // Pass the dueamout value in Amount field																		
								Thread.sleep(2000);
								
								//select Money Order Check Type
								WebElement bankIssueType = driver.findElement(By.xpath("//*[@id='payOpt_TendPymtType0000_contentDropDownList_Edit']"));
								Select checkTypeSelect = new Select(bankIssueType);   // select bank issue check type
								checkTypeSelect.selectByVisibleText("Money Order");
								Thread.sleep(2000);								
								String chkNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText(); 
								driver.findElement(By.xpath("//*[@id='payOpt_TendPymtNum0000_contentTextBox_Edit']")).sendKeys("47" + chkNumber);   //Entering check number
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@id='payOpt_TendIssuer0000_contentTextBox_Edit']")).sendKeys("Chase");   //Entering Bank/Institution Name								
								Thread.sleep(1000);
																
								driver.findElement(By.xpath(".//*[@id='payOpt_TendApply_Std_slideBtnLink']")).click();  // Clicking 'Apply Payment' btn
								Thread.sleep(20000);
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order										
								System.out.println("PaymentPage.moneyOrderPymt - You clicked Continue to submit an order");
								Thread.sleep(30000);											
										
									//assert for order submission page	
									String expectedSubmit = "Order Has Been Submitted"; 
									String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")).getText();
									//*[@id="payOpt_TendPymtNum0000_contentTextBox_Edit"]
									
									if (actualSubmit.equals(expectedSubmit)) {												
										System.out.println("PaymentPage.moneyOrderPymt - Order submitted successfully!");
										Thread.sleep(5000); 
										String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
										System.out.println("Order submitted: " + ordNumber);
										logger.info(ordNumber);
										System.out.println("");
																					
									}else {
										System.out.println("PaymentPage.moneyOrderPymt - CSC delayed submitting an order d/t slowness. TC failed.");											
										return null;
									}										
								}else {
									System.out.println("PaymentPage.moneyOrderPymt - Assertion Tender type failed!");	
									return null;
								}						
						}else {
							System.out.println("PaymentPage.moneyOrderPymt - Failed loading Payment Page");
							return null;
						}							
				} catch (Exception e) {
					System.out.println("PaymentPage.moneyOrderPymt - Error encountered:" + e.getMessage());
					return null;
				}	
		return driver;				
	}		

	public static ChromeDriver travelersChkPymt(ChromeDriver driver) throws InterruptedException{
		Logger logger = Logger.getLogger("PaymentPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
			//Assert if Payment Page is loaded 
				try {
					String expectedPymtRslt = "Payment Options";
					String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
					if (expectedPymtRslt.equals(actualPymtRslt)) {
						System.out.println("PaymentPage.travelersChkPymt - Payment Page loaded successfully!");
						Thread.sleep(5000);						
						
						//Select 'Bank Issue' Tender Type  
						WebElement tenderSelect = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_New_contentDropDownList_Edit']"));
						Select tenderTypeSelect= new Select(tenderSelect);							
						tenderTypeSelect.selectByVisibleText("Bank Issue");    
						Thread.sleep(2000);
													
							// assert if the tender type section is selected correctly																
							String expectedTenderType = "Bank Issue"; 
							String actualTenderType = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_Std_0000_contentDropDownList_UpperDiv']")).getText();
							if (expectedTenderType.equals(actualTenderType)) {
								System.out.println("PaymentPage.travelersChkPymt - " + actualTenderType + " tender type selected successfully!");
								Thread.sleep(5000);
																	
								String dueAmt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
								String paidDueAmt = dueAmt.replace("$","");	
								logger.info("Due paid using Travelers Check: " + dueAmt);
								Thread.sleep(5000);	
								WebElement amtField = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendAmount_Std_0000_contentTextBox_Edit']"));   
								amtField.sendKeys(paidDueAmt); // Pass the dueamout value in Amount field																		
								Thread.sleep(2000);
								
								//select Travelers Check Type
								WebElement bankIssueType = driver.findElement(By.xpath("//*[@id='payOpt_TendPymtType0000_contentDropDownList_Edit']"));
								Select checkTypeSelect = new Select(bankIssueType);   // select bank issue check type
								checkTypeSelect.selectByVisibleText("Travelers Check");
								Thread.sleep(2000);								
								String chkNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText(); 
								driver.findElement(By.xpath("//*[@id='payOpt_TendPymtNum0000_contentTextBox_Edit']")).sendKeys("47" + chkNumber);   //Entering check number
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@id='payOpt_TendIssuer0000_contentTextBox_Edit']")).sendKeys("Chase");   //Entering Bank/Institution Name								
								Thread.sleep(1000);
																
								driver.findElement(By.xpath(".//*[@id='payOpt_TendApply_Std_slideBtnLink']")).click();  // Clicking 'Apply Payment' btn
								Thread.sleep(20000);
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order										
								System.out.println("PaymentPage.travelersChkPymt - You clicked Continue to submit an order");
								Thread.sleep(30000);											
										
									//assert for order submission page	
									String expectedSubmit = "Order Has Been Submitted"; 
									String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")).getText();
									//*[@id="payOpt_TendPymtNum0000_contentTextBox_Edit"]
									
									if (actualSubmit.equals(expectedSubmit)) {												
										System.out.println("PaymentPage.travelersChkPymt - Order submitted successfully!");
										Thread.sleep(5000); 
										String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
										System.out.println("Order submitted: " + ordNumber);
										logger.info(ordNumber);
										System.out.println("");
																					
									}else {
										System.out.println("PaymentPage.travelersChkPymt - CSC delayed submitting an order d/t slowness. TC failed.");											
										return null;
									}										
								}else {
									System.out.println("PaymentPage.travelersChkPymt - Assertion Tender type failed!");	
									return null;
								}						
						}else {
							System.out.println("PaymentPage.travelersChkPymt - Failed loading Payment Page");
							return null;
						}							
				} catch (Exception e) {
					System.out.println("PaymentPage.travelersChkPymt - Error encountered:" + e.getMessage());
					return null;
				}	
		return driver;				
	}		

	public static ChromeDriver bankDraftPymt(ChromeDriver driver) throws InterruptedException{
		Logger logger = Logger.getLogger("PaymentPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");	
			//Assert if Payment Page is loaded 
				try {
					String expectedPymtRslt = "Payment Options";
					String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
					if (expectedPymtRslt.equals(actualPymtRslt)) {
						System.out.println("PaymentPage.bankDraftPymt - Payment Page loaded successfully!");
						Thread.sleep(5000);						
						
						//Select 'Bank Issue' Tender Type  
						WebElement tenderSelect = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_New_contentDropDownList_Edit']"));
						Select tenderTypeSelect= new Select(tenderSelect);							
						tenderTypeSelect.selectByVisibleText("Bank Issue");    
						Thread.sleep(2000);
													
							// assert if the tender type section is selected correctly																
							String expectedTenderType = "Bank Issue"; 
							String actualTenderType = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendType_Std_0000_contentDropDownList_UpperDiv']")).getText();
							if (expectedTenderType.equals(actualTenderType)) {
								System.out.println("PaymentPage.bankDraftPymt - " + actualTenderType + " tender type selected successfully!");
								Thread.sleep(5000);
																	
								String dueAmt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
								String paidDueAmt = dueAmt.replace("$","");	
								logger.info("Due paid using Bank Draft: " + dueAmt);
								Thread.sleep(5000);	
								WebElement amtField = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_TendAmount_Std_0000_contentTextBox_Edit']"));   
								amtField.sendKeys(paidDueAmt); // Pass the dueamout value in Amount field																		
								Thread.sleep(2000);
								
								//select Bank Draft Check Type
								WebElement bankIssueType = driver.findElement(By.xpath("//*[@id='payOpt_TendPymtType0000_contentDropDownList_Edit']"));
								Select checkTypeSelect = new Select(bankIssueType);   // select bank issue check type
								checkTypeSelect.selectByVisibleText("Bank Draft");
								Thread.sleep(2000);								
								String chkNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText(); 
								driver.findElement(By.xpath("//*[@id='payOpt_TendPymtNum0000_contentTextBox_Edit']")).sendKeys("47" + chkNumber);   //Entering check number
								Thread.sleep(1000);
								driver.findElement(By.xpath("//*[@id='payOpt_TendIssuer0000_contentTextBox_Edit']")).sendKeys("Chase");   //Entering Bank/Institution Name								
								Thread.sleep(1000);
																
								driver.findElement(By.xpath(".//*[@id='payOpt_TendApply_Std_slideBtnLink']")).click();  // Clicking 'Apply Payment' btn
								Thread.sleep(20000);
								driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order										
								System.out.println("PaymentPage.bankDraftPymt - You clicked Continue to submit an order");
								Thread.sleep(30000);											
										
									//assert for order submission page	
									String expectedSubmit = "Order Has Been Submitted"; 
									String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")).getText();
									//*[@id="payOpt_TendPymtNum0000_contentTextBox_Edit"]
									
									if (actualSubmit.equals(expectedSubmit)) {												
										System.out.println("PaymentPage.bankDraftPymt - Order submitted successfully!");
										Thread.sleep(5000); 
										String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
										System.out.println("Order submitted: " + ordNumber);
										logger.info(ordNumber);
										System.out.println("");
																					
									}else {
										System.out.println("PaymentPage.bankDraftPymt - CSC delayed submitting an order d/t slowness. TC failed.");											
										return null;
									}										
								}else {
									System.out.println("PaymentPage.bankDraftPymt - Assertion Tender type failed!");	
									return null;
								}						
						}else {
							System.out.println("PaymentPage.bankDraftPymt - Failed loading Payment Page");
							return null;
						}							
				} catch (Exception e) {
					System.out.println("PaymentPage.bankDraftPymt - Error encountered:" + e.getMessage());
					return null;
				}	
		return driver;				
	}		

	
	
	public static ChromeDriver holdPymt(ChromeDriver driver) throws InterruptedException{
		Logger logger = Logger.getLogger("PaymentPage");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");
			//Assert if Payment Page is loaded 
				try {
					String expectedPymtRslt = "Payment Options";
					String actualPymtRslt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_contentTab_lblTitle']")).getText();
					if (expectedPymtRslt.equals(actualPymtRslt)) {
						System.out.println("PaymentPage.holdPymt - Payment Page loaded successfully!");
						Thread.sleep(5000);							
													
						String dueAmt = driver.findElement(By.xpath(".//*[@id='tabStdPayments_payOpt_PayTypeDue_Std']")).getText(); //Due Today webelement
						System.out.println("PaymentPage.holdPymt - Due paid :" + dueAmt);
						logger.info("Due Paid amount: " + dueAmt);				
						Thread.sleep(2000);							
						driver.findElement(By.xpath(".//*[@id='btnContinueOrd_slideBtnLink']")).click();   // Click Continue button to submit an order
						Thread.sleep(2000);
						System.out.println("PaymentPage.holdPymt - You clicked Continue to submit an order");
						Thread.sleep(30000);											
										
							//assert for order submission page	
							String expectedSubmit = "Order Has Been Submitted"; 
							String actualSubmit = driver.findElement(By.xpath(".//*[@id='tabOrder_Submit_contentTab_Header']")).getText();
							if (actualSubmit.equals(expectedSubmit)) {												
								System.out.println("PaymentPage.holdPymt - Order submitted successfully!");
								Thread.sleep(5000);
								String ordNumber = driver.findElement(By.xpath(".//*[@id='txnCrumb_breadcrumb']/span[1]")).getText();
								System.out.println(ordNumber);
								logger.info(ordNumber);
								System.out.println("");
									
							}else {
									System.out.println("PaymentPage.holdPymt - Failed submitting an order. TC failed.");											
									return null;											
							}														
						}else {
						System.out.println("PaymentPage.holdPymt - Failed loading Payment Page");
						return null;
						}							
				} catch (Exception e) {
					System.out.println("PaymentPage.holdPymt - Error encountered:" + e.getMessage());
					return null;
				}	
		return driver;				
	}	
	

}



