package testnglistenerconcept;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testnglistenerconcept.CustomListener.class)
public class ScreenshotTest extends BaseClass {
	@BeforeMethod
	void setUp() {
		initialization();

	}

	@AfterMethod
	void tearDown() {
		driver.quit();

	}

	@Test
	void takeScreenshotTest1() {
		driver.get("https://www.google.com");

		Assert.assertEquals(false, true);

	}

	@Test
	void takeScreenshotTest2() {
		driver.get("https://www.google.com/search?q=facebook");

		Assert.assertEquals(false, true);

	}

	@Test
	void takeScreenshotTest3() {
		driver.get("https://www.google.com/search?gs_ssp=eJzj4tLP1TfIyDMsS05XYDRgdGDwYi8pzywpSS0CAFnOB00&q=twitter");

		Assert.assertEquals(false, true);

	}

}
