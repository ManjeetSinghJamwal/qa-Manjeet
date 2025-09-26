package testnglistenerconcept;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends BaseClass implements ITestListener {
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		failed(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}
}
