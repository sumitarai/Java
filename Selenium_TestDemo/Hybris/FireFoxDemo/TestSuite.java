package FireFoxDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSuite {

	public static void main(String[] args) {
		
			// TODO Auto-generated method stub
			   System.setProperty("webdriver.gecko.driver","C:\\Work\\Automation\\Firefox_Driver\\geckodriver.exe");
			   	 
			   	 //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			   	 //capabilities.setCapability("moz:firefoxOptions", capabilities);
			   	// FirefoxOption options = new FirefoxOption();
			   	 WebDriver Fdriver = new FirefoxDriver();
			   	 Fdriver.get("https://q1.shaneco.com"); //open given url in Firefox
			   	 
			   	 //Fdriver.manage().window().maximize();
			   	 Fdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			   	 
			   	 
			   	 
			   	 System.out.print("Open the QA Shaneco site in Firefox");
			   	// Thread.sleep(5000);
			   	 Fdriver.close();
			   	 Fdriver.quit();		

	}

}
