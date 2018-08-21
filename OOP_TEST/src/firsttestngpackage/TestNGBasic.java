package firsttestngpackage;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testcode.Calculator;

public class TestNGBasic {
	// Pre condition starting with before annotation
	@BeforeSuite // 1
	public void SetUp() {
		System.out.println(" TestNGBasic: Setup system property for Chrome");
	}

	@BeforeTest // 2
	public void launchBrowser() {
		System.out.println("TestNGBasic: Launch Chrome browser");
	}

	@BeforeClass // 3
	public void logIn() {
		System.out.println("TestNGBasic: Login to app");
	}

	@BeforeMethod // 4 Before method and After method pair always created and
					// repeated with all Test cases
	public void enterURL() {
		System.out.println("TestNGBasic: Before method");
	}

	// Test annotation contains all TCs
	@Test // 5
	public void addTitleTest() {
		Calculator obj = new Calculator();
		int result = obj.add(10, 20);
		Assert.assertEquals(result, 30);
		System.out.println(result);
		System.out.println("TestNGBasic: This is Test method 1");
	}

	@Test // 5
	public void stringTitleTest() {
		Calculator obj = new Calculator();
		String actlRslt = obj.addString("Sumita", "Rai");
		System.out.println(actlRslt);
		String exptdRslt = "Sumita Rai";
		Assert.assertEquals(actlRslt, exptdRslt);
		System.out.println("TestNGBasic: This is Test Method 2");
	}

	@Test
	public void subTitleTest() {
		Calculator obj = new Calculator();
		int actlRslt = obj.sub(50, 25);
		System.out.println(actlRslt);
		int exptdRslt = 25;
		Assert.assertEquals(actlRslt, exptdRslt);
		System.out.println("TestNGBasic: This is Test Method 3");
	}

	@Test
	public void arrayTitleTest() {
		Calculator obj = new Calculator();
		int[] actlRslt = obj.getArray();
		int[] exptdRslt = { 1, 2, 3 };
		System.out.println(actlRslt);
		Assert.assertEquals(actlRslt, exptdRslt);
		System.out.println("TestNGBasic: This is Test Method 4");
	}

	// This are post condition starting with after annotation
	@AfterMethod
	public void logOut() {
		System.out.println("TestNGBasic: After Method");
	}

	@AfterTest
	public void deleteAllCookies() {
		System.out.println("Delete all cookies");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("Close browser");
	}

	@AfterSuite
	public void generateTestReport() {
		System.out.println("Generate test report");
	}

}
