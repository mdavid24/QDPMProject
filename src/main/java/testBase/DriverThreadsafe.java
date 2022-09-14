package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverThreadsafe {

	
	
	//singleton design pattern--only one instance exist ever and providing global access to that instance by creting getinstance method
	//private constructor -- no one else create object for this class
	private DriverThreadsafe()
	{
		
	}
	
	private static DriverThreadsafe instance = new DriverThreadsafe();
	
	public static DriverThreadsafe getinstance()
	{
		return instance;
	}
	
	
	
	
	//factory desing pattern -- define seperate factory methods for creating objects and create objects by calling that methods
	//ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public WebDriver getdriver()
	{
		return driver.get();
	
	}
	public void setdriver(WebDriver driverpara)
	{
		driver.set(driverpara);
	}
	public void closedriver()
	{
		driver.get().close();
		driver.remove();
	}
	
}
