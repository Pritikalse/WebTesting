package com.aut.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aut.qa.utils.TestUtils;

public class testBase {

	public static WebDriver driver;
	
	public static Properties prop; // to access the config properties 
	
	public testBase() {
		prop  = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\AutomationTestingFramework\\src\\main\\java\\com\\aut\\qa\\config\\confing.properties");
			prop .load(fis);
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void initilization() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Microsoft Edge")) {
			driver = new EdgeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}
		driver.get(prop.getProperty("ApplicationURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.Implicite_wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.Page_Load_Timeout));
		
		
		
	}
	
	//Utility method to take a screenshot 

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\ExtentReports\\" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "\\ExtentReports\\" + testCaseName + ".png";
	
	
}
    }

