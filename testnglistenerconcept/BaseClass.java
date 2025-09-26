package testnglistenerconcept;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jodd.io.FileUtil;

public class BaseClass {
	public static WebDriver driver;

	public static void initialization() {
		driver = new ChromeDriver();
		//driver.get("https://www.google.com");

	}

	public void failed(String testMethodName) {
		String path = "D:\\NacroPractice\\practice1\\Batch12" + "\\Screenshot\\";
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtil.copy(source, new File(path + testMethodName + "_" + ".jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
