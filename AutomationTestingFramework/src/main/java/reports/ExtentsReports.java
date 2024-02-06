package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReports {
	
	
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir") + "\\ExtentReports\\index.html";
		System.out.println("the Path is--------> " + path);
		ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
		reporter.config().setReportName("web Test Automation results - sauce labs application");
		reporter.config().setDocumentTitle("Test Results - AS");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "priti kalse");
		return extent;
		
		
		
		
	}
	
	// created this method to check the path
	
	public static void main(String[] args) {
		 getReportObject();
	}

}
