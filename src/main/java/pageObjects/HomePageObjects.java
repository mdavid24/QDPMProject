package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import testBase.DriverThreadsafe;
import testBase.TestBase;

public class HomePageObjects extends TestBase {

	WebDriver driver= null;
	
	
	By sideMenuDashboard = By.xpath("//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Tasks']");
	
	
	
	
	public void clickOnSideMenu(String menu )
	{
		String menuxpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
		
		DriverThreadsafe.getinstance().getdriver().findElement(By.xpath(menuxpath)).click();
		
		
	}
	
	
	public void clickOnSideSubMenu(String menu,String submenu )
	{
		String menuxpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
		
		DriverThreadsafe.getinstance().getdriver().findElement(By.xpath(menuxpath)).click();
		
		String submenuxpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']/parent::a//following-sibling::ul//span[text()='"+submenu+"']";
	
		DriverThreadsafe.getinstance().getdriver().findElement(By.xpath(submenuxpath)).click();
	}
	
	public void checkDashboardPresent()
	{
		Assert.assertTrue(isElementPresent_custom(DriverThreadsafe.getinstance().getdriver().findElement(sideMenuDashboard), "DashBoard Field is:"));
				
	}
	
	
}
