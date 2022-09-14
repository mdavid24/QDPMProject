package testBase;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserIntialization {

	
	public  WebDriver openBrowser(String brname,String head_headless) throws MalformedURLException
	{
		
		WebDriver driver=null;
		
	
		if(brname.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");


			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
		if(head_headless.equalsIgnoreCase("head"))
				
			driver = new ChromeDriver(options);
		else
			
		{
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		}

		} 
		if (brname.equalsIgnoreCase("firefox")) 
		{

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("-private");
			if(head_headless.equalsIgnoreCase("head"))				        
		
			driver = new FirefoxDriver(foptions);
			else
			{
				foptions.addArguments("headless");
				driver = new FirefoxDriver(foptions);
			}
		}
		if (brname.equalsIgnoreCase("msedge")) 
		{

			WebDriverManager.edgedriver().setup();
			EdgeOptions eoptions = new EdgeOptions();
			eoptions.addArguments("inprivate");
							        
			if(head_headless.equalsIgnoreCase("head"))	
			driver = new EdgeDriver(eoptions);
			else {
				eoptions.addArguments("headless");
				driver = new EdgeDriver(eoptions);
			}

		}
		return driver;
		
		
			
		
		
	}

}
