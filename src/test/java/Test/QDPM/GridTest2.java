package Test.QDPM;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest2 {
	@Test
public void dockerTest3() throws MalformedURLException {
	String brname = "MicrosoftEdge";
	DesiredCapabilities capba = new DesiredCapabilities();
	capba.setBrowserName(brname);
	//capba.setPlatform(Platform.LINUX);
	
	RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capba);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
	}
}
