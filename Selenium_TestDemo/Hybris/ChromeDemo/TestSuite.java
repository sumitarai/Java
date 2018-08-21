package ChromeDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class TestSuite {

	public static void main(String[] args) throws InterruptedException {
		   //Open Chrome Browser 
		   System.setProperty("webdriver.chrome.driver","C:\\Work\\Automation\\Chrome_Driver\\chromedriver.exe");
		  	   			   	
		   	ChromeOptions options = new ChromeOptions();
		   	options.addArguments("disable-infobars"); /*It will disable the "Chrome is controlled by 
		   	                                               automated test software" notification bar on the webpage */
		   	WebDriver Cdriver = new ChromeDriver(options);
		   	Cdriver.manage().window().maximize();  // max window
		   	Cdriver.get("https://q1.shaneco.com"); 		   	 
		   	System.out.println("Open qshaneco in Chrome");
		   	Thread.sleep(5000);
		   	 
		   	
		   	 //Customer logIn session
		   	 WebElement loglink;
		   	 loglink = Cdriver.findElement(By.linkText("Log In"));
		   	 loglink.click();
		   	 Thread.sleep(5000);
		   	 
		   	 Cdriver.findElement(By.xpath(".//*[@id='header']/div[3]/div/article[1]/article[1]/div/div/article/form/div[2]/article/input")).sendKeys("sumiretest@testcheckout.com");
		   	 Cdriver.findElement(By.xpath(".//*[@id='header']/div[3]/div/article[1]/article[1]/div/div/article/form/div[2]/button")).click();  //click() method for radio/check button or link
		   	 System.out.println("This will enter email id in the email address field");
		   	 Thread.sleep(5000);
		   	
		   	 Cdriver.findElement(By.xpath(".//*[@id='pass_e']")).sendKeys("Testing1"); 
		   	 Cdriver.findElement(By.xpath(".//*[@id='header']/div[3]/div/article[1]/article[4]/div/div/article/article/div/div[2]/form/div[3]/button")).click(); //click login
		   	 System.out.println("Password entered and Customer is logged in now");
		   	 Thread.sleep(5000);
		   	 
		   	 
		   	 //Customer logout session
		   	 Actions a1 = new Actions(Cdriver);
		   	 WebElement myAcct = Cdriver.findElement(By.linkText("My Account"));
		   	 a1.moveToElement(myAcct).build().perform();
		   	 Cdriver.findElement(By.cssSelector("a[href='/logout']")).click();
		   	 System.out.println("Customer is logged out");
		   	 Thread.sleep(2000);
		   	 
		   	 
		   	
		   	 //Item select Session from PCAT		   	 
		   	Actions a2 = new Actions(Cdriver); //Import Action class to use perform action for mouse hover action
		   	 WebElement topNav = Cdriver.findElement(By.linkText("Jewelry"));
		   	 a2.moveToElement(topNav).build().perform();
		   	 //topNav.findElement(By.linkText("Necklaces")).findElement(By.cssSelector("a[href='/necklaces/c/pearl']")).click();
		   	 Cdriver.findElement(By.linkText("Necklaces")).click(); 
		   	
		   	 //Cdriver.findElement(By.linkText("Pearl")).click();
		   	 System.out.println("It is showing the sub-menu");
		   	 Thread.sleep(2000);
		   	 
		   	 /*
		   	 Actions a2 = new Actions(Cdriver);
		   	 WebElement MenuNav = Cdriver.findElement(By.linkText("Jewelry"));
		   	 WebElement subMenuNav = Cdriver.findElement(By.linkText("Necklaces"));
		   	 WebElement subNav = Cdriver.findElement(By.linkText("Pearl"));
		   	 
		   	 MenuNav.click();
		   	 subMenuNav.click();
		   	 subNav.click();
		   	 
		   	 a2.moveToElement(MenuNav).perform();
		   	 Thread.sleep(2000);
		   	 a2.moveToElement(subMenuNav).build().perform();
		   	 Thread.sleep(2000);
		   	 Cdriver.findElement(By.linkText("Pearl")).click();
		   	 
		   	 
		   	 
		   	 
		   	 //Add to Cart
		   	 
		   	 
		   	 //Cdriver.findElement(By.cssSelector("a[href='/necklaces/c/pearl']")).click();
		   	 
				
		   	 
		   	
		   	
		   	
		   	
		   	 /* another way to write
		   	  * WebElement topNav = Cdriver.findElement(By.linkText("Jewelry"));
		   	  * WebElement subMenu = Cdriver.findElement(By.linkText("Necklaces"));
		   	 a.moveToElement(topNav).moveToElement(Cdriver.findElement(By.cssSelector("a[href='/necklaces/c/pearl']")).click();
		   	 Thread.sleep(5000);	 
		   	 */
		 

		   	 /*
		   	 Cdriver.navigate().back(); // Go back to Home page
		   	 Cdriver.close(); //close browser
		   	 System.out.print("Now brower is closed");
		   	 */
	}
}
