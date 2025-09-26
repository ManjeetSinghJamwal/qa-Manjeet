package testngPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(day0909.ExtentReportManager.class)
public class ParmaTest {
	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser" })
	void setup(String br) {
		switch (br.toLowerCase()) {
		case "chrome":
			// Auto-downloads correct version
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "edge":
			// Setup Edge driver automatically
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;
		case "firefox":
			// Automatically download and setup GeckoDriver
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;
		default:
			System.out.println("Enter Valid Browser Name:");
			return;
		}
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 1)
	void testLogo() {
		WebElement logo = driver.findElement(By.xpath("//div[@class=\"orangehrm-login-branding\"]"));
		if (logo.isDisplayed()) {
			System.out.println("Displayed Company Logo");
			Assert.assertTrue(logo.isDisplayed());
		} else {
			System.out.println("Not Displayed");
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 2)
	void testAppUrl() {
		String actUrl = driver.getCurrentUrl();
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(actUrl, expUrl);

	}

	@Test(priority = 3)
	void testHomePageTitle() {
		String actTitle = driver.getTitle();
		String expTitle = "OrangeHRM";
		Assert.assertEquals(actTitle, expTitle);

	}

	@AfterClass
	void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
