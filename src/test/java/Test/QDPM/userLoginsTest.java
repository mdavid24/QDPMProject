package Test.QDPM;

import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import testBase.TestBase;

public class userLoginsTest extends TestBase 
{
	LoginPageObjects loginpage = new LoginPageObjects();
	@Test
 public void clientLoginTest()
 {
	loginpage.login("davidboon@client.com", "davidboon"); 
 }
	@Test
 public void managerLoginTest()
 {
	 loginpage.login("davidboon@manager.com", "davidboon"); 
 }
	@Test
 public void developerLoginTest() throws Throwable
 {
	 loginpage.login("davidboon@developer.com", "davidboon"); 
	 assertEqualsString_custom("expected", "Actual", "DeveloperLogin Page");
 }
}
