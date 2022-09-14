package testBase;

import com.aventstack.extentreports.ExtentTest;

public class  ExtentThreadsafe {

	//singleton design pattern--only one instance exist ever and providing global access to that instance by creting getinstance method
	//private constructor -- no one else create object for this class
	private ExtentThreadsafe()
	{
		
	}
	
	private static ExtentThreadsafe instance = new ExtentThreadsafe();
	
	public static ExtentThreadsafe getinstance()
	{
		return instance;
	}
	
	
	
	
	//factory desing pattern -- define seperate factory methods for creating objects and create objects by calling that methods
	ThreadLocal<ExtentTest> extentthr = new ThreadLocal<ExtentTest>();
	
	public ExtentTest getextent()
	{
	ExtentTest	test = extentthr.get();
		return test;
		
	
	}
	public void setextent(ExtentTest extentobj)
	{
		extentthr.set(extentobj);
	}
	public void removeExtent()
	{
		
		extentthr.remove();
	}
}
