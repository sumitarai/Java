package firsttestngpackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseSuite.BaseTest;
import testcode.Calculator;

public class TestNGDemo extends BaseTest{

	@BeforeMethod // 4 Before method and After method pair always created and
	// repeated with all Test cases
	public void enterURL() {
		System.out.println("TestNGDemo: Before method");
	}

	// Test annotation contains all TCs
	@Test // 5
	public void addTitleTest() {
		Calculator obj = new Calculator();
		int result = obj.add(10, 20);
		Assert.assertEquals(result, 30);
		System.out.println(result);
		System.out.println("TestNGDemo: This is Test method 1");
	}

	@Test // 5
	public void stringTitleTest() {
		Calculator obj = new Calculator();
		String actlRslt = obj.addString("Sumita", "Rai");
		System.out.println(actlRslt);
		String exptdRslt = "Sumita Rai";
		Assert.assertEquals(actlRslt, exptdRslt);
		System.out.println("TestNGDemo: This is Test Method 2");
	}

	@Test
	public void subTitleTest() {
		Calculator obj = new Calculator();
		int actlRslt = obj.sub(50, 25);
		System.out.println(actlRslt);
		int exptdRslt = 25;
		Assert.assertEquals(actlRslt, exptdRslt);
		System.out.println("TestNGDemo: This is Test Method 3");
	}

	@Test
	public void arrayTitleTest() {
		Calculator obj = new Calculator();
		int[] actlRslt = obj.getArray();
		int[] exptdRslt = { 1, 2, 3 };
		System.out.println(actlRslt);
		Assert.assertEquals(actlRslt, exptdRslt);
		System.out.println("TestNGDemo: This is Test Method 4");
	}

	// This are post condition starting with after annotation
	@AfterMethod
	public void logOut() {
		System.out.println("TestNGDemo: After Method");
	}
}
