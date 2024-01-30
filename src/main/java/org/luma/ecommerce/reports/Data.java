package org.luma.ecommerce.reports;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Data 
{
  
   
	public ExtentSparkReporter reporter;
	public  ExtentReports extent;
 
  @BeforeTest
  public void reports()
  {
	  String path = System.getProperty("user.dir")+"\\reports\\index.html";
	  reporter = new ExtentSparkReporter(path);
	  reporter.config().setReportName("Automation Results");
	  reporter.config().setDocumentTitle("Test results");
	  
	  extent = new ExtentReports();
	  extent.attachReporter(reporter);
	  extent.setSystemInfo("QA", "Asha Fazis");
<<<<<<< HEAD
	  System.out.println("Add");
=======
	  System.out.println("Sub");
>>>>>>> 2845f98ead92a95ba279044aad7a44df4867477b
  }
	
  

   @Test
  public void driver()
  {
	  extent.createTest("Launch URL");
	  WebDriverManager.chromedriver().setup();
	  ChromeDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.com/");
	  System.out.println(driver.getTitle());
	  extent.flush();
  }
}
