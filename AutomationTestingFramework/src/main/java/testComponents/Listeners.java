package testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aut.qa.base.testBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



import reports.ExtentsReports;

public class Listeners extends testBase implements ITestListener{

	ExtentTest test;
	ExtentReports extent = ExtentsReports.getReportObject();

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed : onTestSuccess[ITestListener]");


	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed : onTestFailure[ITestListener]");

		//test.fail(result.getThrowable());

		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String filepath = null;
		//Screenshot , Attach it to the report try {
		try {
			filepath = getScreenshot(result.getMethod().getMethodName() ,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

		}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

		}

		public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

		}
}

