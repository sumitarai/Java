/*
 * IE Driver: Release 15063
 */

package IEDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestSuite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		   	 	 
		System.setProperty("webdriver.ie.driver","C:\\Work\\Automation\\IE_Driver\\MicrosoftWebDriver.exe");   
		//WebDriver Edriver = new WebDriver(capabilities);
		 WebDriver Edriver = new InternetExplorerDriver();
		   		 
		  Edriver.get("https://q1.shaneco.com"); //open given url
		  Edriver.manage().window().maximize();

	}
}
