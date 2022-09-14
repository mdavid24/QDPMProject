package testBase;

import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.MyCustomActions;
import utilities.PropertiesReader;

public class TestBase extends MyCustomActions {

	BrowserIntialization brinit = new BrowserIntialization();
	
	@BeforeMethod
	public void LaunchApplication() throws Exception
	{
		
		String browser = PropertiesReader.getPropertyValueByKey("browser");
		String url = PropertiesReader.getPropertyValueByKey("url");
		String head_headless = PropertiesReader.getPropertyValueByKey("head_headless");
		
	//WebDriver driverinst =	brinit.openBrowser(browser);
	
	DriverThreadsafe.getinstance().setdriver(brinit.openBrowser(browser,head_headless));
	
	//WebDriver driver = DriverThreadsafe.getinstance().getdriver();
	
		
	DriverThreadsafe.getinstance().getdriver().manage().window().maximize();
	DriverThreadsafe.getinstance().getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	DriverThreadsafe.getinstance().getdriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	DriverThreadsafe.getinstance().getdriver().navigate().to(url);
		
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		DriverThreadsafe.getinstance().closedriver();
	}
}
