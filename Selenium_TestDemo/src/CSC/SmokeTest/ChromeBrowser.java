package SmokeTest;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		Logger logger = Logger.getLogger("ChromeBrowser");  // logger get the class name
		PropertyConfigurator.configure("Log4j.properties");		
	
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\Automation\\Chrome_Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();  // max browser window
		
		driver.get("http://csctest1.wsmcorp.com/");
		logger.info("Application launched successfully");
		//System.out.println("URL launch successfully!");
		Thread.sleep(2000);
		
		// CSC login as CSA2
		WebElement user2 = driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div/div[2]/div/div/center/div/div/div/table/tbody/tr/td/div[1]/input"));
		user2.sendKeys("rais2");
		driver.findElement(By.xpath("html/body/form/div[3]/div/div[3]/div[4]/div/div/div/div[2]/div/div/center/div/div/div/table/tbody/tr/td/div[2]/input")).sendKeys("456123");
		driver.findElement(By.xpath(".//*[@id='LoginButton']")).click();
		logger.info("Login successful!");
		//System.out.println("Login successful!");
		Thread.sleep(5000);
	}

}
