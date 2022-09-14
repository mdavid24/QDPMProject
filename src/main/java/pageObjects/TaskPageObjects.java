package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import testBase.DriverThreadsafe;
import testBase.TestBase;

public class TaskPageObjects extends TestBase {

	By btn_addTask = By.xpath("//button[text()='Add Task']");
	By field_Search = By.id("search_menu");
	By txt_Search = By.xpath("//*[@id='search_menu']//input[@name='search[keywords]']");
	By btn_Search = By.xpath("//*[@id='search_menu']//input[@type='submit']");
	By dd_projectNewTask = By.id("form_projects_id");
	By dd_taskType = By.id("tasks_tasks_type_id");
	By txt_taskName = By.id("tasks_name");
	By dd_taskStatus = By.id("tasks_tasks_status_id");
	By dd_taskPriority = By.id("tasks_tasks_priority_id");
	By dd_taskLabel = By.id("tasks_tasks_label_id");
	By dd_taskCreatedBy = By.id("tasks_created_by");
	By btn_save = By.xpath("//button[@type='submit' and text()='Save']");
	
	
	public void createTask(HashMap<String,String> testdata) throws Throwable
	{
selectDropDownByVisibleText_custom(DriverThreadsafe.getinstance().getdriver().findElement(dd_projectNewTask), "Project New Task DropDown:", testdata.get("ProjectToCreateTaskUnder"));
	
selectDropDownByVisibleText_custom(DriverThreadsafe.getinstance().getdriver().findElement(dd_taskType), "NewTaskType", testdata.get("TaskType"));
sendKeys_custom(DriverThreadsafe.getinstance().getdriver().findElement(txt_taskName), "newTaskName", testdata.get("TaskName"));
selectDropDownByVisibleText_custom(DriverThreadsafe.getinstance().getdriver().findElement(dd_taskStatus), "NewTaskStatus",  testdata.get("TaskStatus"));
selectDropDownByVisibleText_custom(DriverThreadsafe.getinstance().getdriver().findElement(dd_taskPriority), "NewTaskPriority",  testdata.get("TaskPriority"));
selectDropDownByVisibleText_custom(DriverThreadsafe.getinstance().getdriver().findElement(dd_taskLabel), "NewTaskLabel",  testdata.get("Label"));
click_custom(DriverThreadsafe.getinstance().getdriver().findElement(btn_save), "NewTaskSaveButton");
	
	
	}
	
	public void search_verify_Taskcreation(HashMap<String,String> testdata) throws Throwable
	{
		moveToElement_custom(DriverThreadsafe.getinstance().getdriver().findElement(field_Search), "TaskSearchOption");
		sendKeys_custom(DriverThreadsafe.getinstance().getdriver().findElement(txt_Search), "TaskSearchBox", testdata.get("TaskName"));
		click_custom(DriverThreadsafe.getinstance().getdriver().findElement(btn_Search), "SearchButton");
		
		//table verification
		assertEqualsString_custom(testdata.get("TaskName"), getTaskTableCellValueByColumnName("Name"), "TaskNameInTable");
	}
	
private String getTaskTableCellValueByColumnName(String columnName)
{
		
		String valueXpath = "//table[starts-with(@id, 'itmes_listing')]/tbody/tr/td[count(//table[starts-with(@id, 'itmes_listing')]/thead/tr/th/div[text()='"+columnName+"']/parent::th/preceding-sibling::th)+1]";
		String value = DriverThreadsafe.getinstance().getdriver().findElement(By.xpath(valueXpath)).getText();
		return value;
	}
}
