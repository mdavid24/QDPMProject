package Test.QDPM;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest1 {
	@Test
public void dockerTest2() throws MalformedURLException{
	String brname = "chrome";
	DesiredCapabilities capba = new DesiredCapabilities();
	capba.setBrowserName(brname);
	//capba.setPlatform(Platform.LINUX);
	
	RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capba);
		driver.get("https://www.flipkart.com/");
		System.out.println(driver.getTitle());
		
	}
}
