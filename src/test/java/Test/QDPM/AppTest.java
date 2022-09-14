package Test.QDPM;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.TaskPageObjects;
import testBase.ExtentThreadsafe;
import testBase.TestBase;
import utilities.DB_Operations;
import utilities.Excel_Operations;
import utilities.MyLogger;

public class AppTest extends TestBase 
{
    LoginPageObjects loginpage = new LoginPageObjects();
    HomePageObjects homepage = new HomePageObjects();
    TaskPageObjects taskpage = new TaskPageObjects();
    DB_Operations dbops = new DB_Operations();
    Excel_Operations excel = new Excel_Operations("TaskCreationData");

	@Test(dataProvider ="taskCreationData" )
	public void TaskCreationTest(Object obj1,ITestContext context) throws Throwable 
	{
		//Thread.sleep(3000);
		HashMap<String, String> testdata = (HashMap<String, String>) obj1;
		ExtentThreadsafe.getinstance().getextent().info("Test Data for this execution run is: "+ testdata);
		
		context.setAttribute("testmapdata", testdata);
		
		loginpage.login(testdata.get("UserName"),testdata.get("Password"));
		homepage.checkDashboardPresent();
//		homepage.clickOnSideSubMenu("Tasks", "Add Task");
//		Thread.sleep(3000);
//		taskpage.createTask(testdata);
//		taskpage.search_verify_Taskcreation(testdata);
//		
//		
//		String query = "SELECT * FROM `tasks` WHERE name='"+testdata.get("TaskName")+"'";
//		HashMap<String, String> dbdata = dbops.getSQLResultInMap(query);
		
		//String taskname = dbdata.get("name");
		
		//assertEqualsString_custom(testdata.get("TaskName"), "taskname", "DB_Task_Name");
//		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
//		MyLogger.info("Test1 logged");
	}
//	@Test
//	public void viewTasksTest() throws Throwable
//	{
//		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
//		MyLogger.info("Test2 logged");
		
//		loginpage.login("davidboon@admin.com", "davidboon");
		
//	homepage.checkDashboardPresent();
	
//		homepage.clickOnSideSubMenu("Tasks", "View All");
//		taskpage.createTask();
//		taskpage.search_verify_Taskcreation();
//		String query = "SELECT * FROM `tasks` WHERE name='deshtest'";
//		HashMap<String, String> dbdata = dbops.getSQLResultInMap(query);
//		
//		String taskname = dbdata.get("name");
//		
//		assertEqualsString_custom("destest", taskname, "DB_Task_Name");
//	}
	
	@DataProvider (name = "taskCreationData")
	public Object[][] testDataSupplier() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i-1][0] = testData;
		}
		return obj;
		
	}
}
