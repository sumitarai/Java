package firsttestngpackage;

import org.testng.annotations.Test;

import BaseSuite.BaseTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class SmokeTest extends BaseTest{
	WebDriver driver;

	@Test
	public void testCase1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Automation\\Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver(); // launch browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://csctest.wsmcorp.com/Default.aspx");
		System.out.println("SmokeTest: URL opened");

	}

	@Test
	public void testCase2() {
		String title = driver.getTitle();
		System.out.println(" Title: " + title);
		//boolean b = driver.findElement(By.xpath(".//*[@id='UserName']")).isDisplayed();
		WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));  
		userName.sendKeys("rais");
		WebElement passWrd = driver.findElement(By.xpath("//*[@id='Password']"));
		passWrd.sendKeys("456789");
		driver.findElement(By.xpath(".//*[@id='LoginButton']")).click();
		
		//Assert.assertEquals(actual, expected);
		System.out.println("SmokeTest: Login successful");

	}


//	@AfterMethod
	//public void testDemo() {
		// driver.quit();
	//}

}
