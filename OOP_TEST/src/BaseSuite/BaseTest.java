/*
 * This BaseTest class will collect only the common in classes.
 * @BeforeClass and @AfterClass will execute only once before and after each class
 */
package BaseSuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {

	@BeforeClass
	public void beforeClass() {
		System.out.println("BaseTest: before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("BaseTest: after class");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BaseTest: before Suite");
		
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("BaseTest: after suite");
	}

}
