package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import net.rcarz.jiraclient.JiraException;
import testBase.DriverThreadsafe;
import testBase.ExtentReportTS;
import testBase.ExtentThreadsafe;

public class Listenersimplement implements ITestListener 
{
	//JiraOperations jiraOps = new JiraOperations();
	 static ExtentReports report;
      ExtentTest test;
     // private static ThreadLocal<ExtentTest> extenttest  = new ThreadLocal<ExtentTest>();
	public synchronized void onTestStart(ITestResult result) 
	{
	test = report.createTest(result.getMethod().getMethodName());
	//extenttest.set(test);
	ExtentThreadsafe.getinstance().setextent(test);
	}


	public void onTestSuccess(ITestResult result) 
	{
		
	//	extenttest.get().log(Status.PASS, "Test case : "+result.getMethod().getMethodName()+" is Passed");
		ExtentThreadsafe.getinstance().getextent().log(Status.PASS, "Test case : "+result.getMethod().getMethodName()+" is Passed");
	ExtentThreadsafe.getinstance().removeExtent();
	}

	

	public synchronized void onTestFailure(ITestResult result) 
	{
		ExtentThreadsafe.getinstance().getextent().log(Status.FAIL, "Test case : "+result.getMethod().getMethodName()+" is Failed");
		//extenttest.get().log(Status.FAIL, "Test case : "+result.getMethod().getMethodName()+" is Failed");
		ExtentThreadsafe.getinstance().getextent().fail(result.getThrowable());
		//ExtentThreadsafe.getinstance().getextent().log(Status.FAIL,result.getThrowable());
		//extenttest.get().log(Status.FAIL,result.getThrowable());
		
		
		
		TakesScreenshot	ts = (TakesScreenshot) DriverThreadsafe.getinstance().getdriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		
//			 try {
//				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//			} catch (IllegalArgumentException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IllegalAccessException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (NoSuchFieldException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (SecurityException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
	
		String timestamp = new SimpleDateFormat("dd.MM.yy.HH.mm.ss").format(new Date());
		
		
		
		String testcasename = result.getMethod().getMethodName();
		String screenshotpath = System.getProperty("user.dir")+"//Reports//ScreenShots//"+testcasename+"_"+timestamp+".png";
		
		try {
			FileUtils.copyFile(source,new File(screenshotpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//	String screenshotpath = getScreenShotOnFail(testcasename,driver);
			
			ExtentThreadsafe.getinstance().getextent().addScreenCaptureFromPath(screenshotpath, testcasename);
			
		
			ExtentThreadsafe.getinstance().removeExtent();
		
		///////JIRA defect creation part
			String automaticJIRAcreation = null;
			try {
				 automaticJIRAcreation = PropertiesReader.getPropertyValueByKey("automatic_Issue_Creation_In_JIRA");
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(automaticJIRAcreation.trim().equalsIgnoreCase("ON")) 
				
			{
			HashMap<String, String>	testdatamap = (HashMap<String, String>) result.getTestContext().getAttribute("testmapdata");
				
				JiraClientService JService = new JiraClientService("https://davidseleniumauto.atlassian.net/", 
						"boon4.david@gmail.com", "6VTrJatL9MC2MbGajckd438B", "QDPM");
			String issuesummary =	result.getMethod().getConstructorOrMethod().getMethod().getName()+"  got Failed due to "+result.getThrowable().getMessage();
				
				
			
			String exceptiondetails = "Exception Details : "+ ExceptionUtils.getFullStackTrace(result.getThrowable());
			
			String issuedescription = "Test Data used : "+testdatamap +"\n"+ exceptiondetails;
		try {
			JService.createJiraTicket("Bug", issuesummary, issuedescription,"High", "david",new File(screenshotpath));
		} catch (JiraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
				
				
				
				
				
				
				
				
				
				
				/*String issueS = "Automation Test Failed - "+result.getMethod().getMethodName();
				String issueD = "Test Data to be passed here.";
				String issueNumber = null;
				try {
					issueNumber = jiraOps.createJiraIssue("QDPM", issueS, issueD, "10000", "5", "QDPM", "SIT", "5cf112d31552030f1e3a5905");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					jiraOps.addAttachmentToJiraIssue(issueNumber, screenshotpath);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				
				
				
				
			}

	
	}

	
	public void onTestSkipped(ITestResult result) {
		ExtentThreadsafe.getinstance().getextent().log(Status.SKIP, "Test case : "+result.getMethod().getMethodName()+" is Skipped");
		ExtentThreadsafe.getinstance().removeExtent();
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}


	public void onStart(ITestContext context) {
	try {
		report =	ExtentReportTS.setupExtentReport();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	
	
	

}
