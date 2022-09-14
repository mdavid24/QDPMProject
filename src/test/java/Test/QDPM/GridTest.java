package Test.QDPM;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GridTest {
	

	@Test
	public void dockerTest1() throws MalformedURLException {
		String brname = "firefox";
		DesiredCapabilities capba = new DesiredCapabilities();
		capba.setBrowserName(brname);
		//capba.setPlatform(Platform.LINUX);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capba);
		driver.get("https://www.amazon.in");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
}

