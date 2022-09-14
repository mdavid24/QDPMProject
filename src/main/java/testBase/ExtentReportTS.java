package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.PropertiesReader;

public class ExtentReportTS {

	
	 static ExtentReports extent;
	public static ExtentReports setupExtentReport() throws Exception
	
	{
	
	
	String timestamp = new SimpleDateFormat("dd.MM.yy.HH.mm.ss").format(new Date());
	
	String	reportpath = System.getProperty("user.dir")+"//Reports//ExecReport_"+timestamp+".html";
			
	ExtentSparkReporter  reporter = new ExtentSparkReporter(reportpath);
	
	extent = new ExtentReports();
    
    extent.attachReporter(reporter);
    
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	reporter.config().setTheme(Theme.DARK);
	     
	           
	           
	           extent.setSystemInfo("Tested By: ","David");
	           
	           extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
	           extent.setSystemInfo("Executed on user: ", System.getProperty("user.name"));
	           extent.setSystemInfo("Executed on Browser : ", PropertiesReader.getPropertyValueByKey("browser"));
	           extent.setSystemInfo("Executed on Environment : ", PropertiesReader.getPropertyValueByKey("url"));
	           return extent;
	}

}
