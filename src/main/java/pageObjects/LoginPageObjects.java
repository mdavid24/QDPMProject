package pageObjects;

import org.openqa.selenium.By;
import testBase.DriverThreadsafe;
import testBase.TestBase;

public class LoginPageObjects extends TestBase{

	
	
	By EMAIL = By.name("login[email]");
	By PASSWORD = By.name("login[password]");
	By LOGIN_BTN = By.xpath("//button[@type='submit' and text()='Login ']");
	
	//constructor
	
	
	public void login(String email,String password)
	{
		sendKeys_custom(DriverThreadsafe.getinstance().getdriver().findElement(EMAIL), "LoginEmailFIeld", email);
		sendKeys_custom(DriverThreadsafe.getinstance().getdriver().findElement(PASSWORD), "LoginPasswordFIeld", password);

		click_custom(DriverThreadsafe.getinstance().getdriver().findElement(LOGIN_BTN), "LoginButton");

		
	}
	
	
}
