package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends Base
{
  @Test
  public void verifyTheUserIsAbleToLoginWithValidCredentials() 
  {
	 String username ="admin";
	 String password="admin";
	LoginPage loginpage1 = new LoginPage(driver);
	loginpage1.enterUserNameOnUserNameField(username);
	loginpage1.enterPasswordOnPasswordField(password);
	loginpage1.submitButtonClick();
	boolean ishomepageloaded = loginpage1.isDashBoardLoaded();
	Assert.assertTrue(ishomepageloaded,"Home page is not loaded when user is entering valid credentials");
	
  }
@Test
public void verifyUserIsAbleToLoginWithInvalidUserNameValidPassword()
{
	String username="test";
	String password="admin";
	LoginPage loginpage2 = new LoginPage(driver);
	loginpage2.enterUserNameOnUserNameField(username);
	loginpage2.enterPasswordOnPasswordField(password);
	loginpage2.submitButtonClick();
	boolean isalertdisplayed = loginpage2.alertDisplay(); //
	Assert.assertTrue(isalertdisplayed,"Home page is  loaded when user entered invalid username and valid password");
}
@Test
public void verifyUserIsAbleToLoginWithValidUserNameInvalidPassword()
{
	String username="admin";
	String password="test";
	LoginPage loginpage3 = new LoginPage(driver);
	loginpage3.enterUserNameOnUserNameField(username);
	loginpage3.enterPasswordOnPasswordField(password);
	loginpage3.submitButtonClick();
	boolean isalertdisplayed = loginpage3.alertDisplay();
	Assert.assertTrue(isalertdisplayed,"Home page is  loaded when user entered valid username and invalid password");
}
@Test
public void verifyUserIsAbleToLoginWithWithInvalidCredentials()
{
	String username="test";
	String password="test123";
	LoginPage loginpage4 = new LoginPage(driver);
	loginpage4.enterUserNameOnUserNameField(username);
	loginpage4.enterPasswordOnPasswordField(password);
	loginpage4.submitButtonClick();
	boolean isalertdisplayed = loginpage4.alertDisplay();
	Assert.assertTrue(isalertdisplayed,"Home page is  loaded when user entered invalid credentials");
}




}