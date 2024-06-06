package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@DataProvider(name= "credentials")
	public Object[][] testData(){          //login credentials provided using data provider
	Object[][] input = new Object[2][2];
	//input[0][0]= "admin";
	//input[0][1]="admin1234";
	input[1][0]="admin";
	input[1][1]="admin";
	return input;
	}
  @Test(dataProvider="credentials")  //testcase takes value from 'dataprovider 'credentials'
 public void verifyTheUserIsAbleToLoginWithValidCredentials(String username,String password) throws IOException 
  {
	 //String username ="admin";
	 //String password="admin";
	//String username = ExcelUtility.getStringData(1,0,"LoginPage"); //1,0: data index,loginpage pg name
    //String password = ExcelUtility.getStringData(1,1,"LoginPage");
	  	  
	LoginPage loginpage1 = new LoginPage(driver);
	loginpage1.enterUserNameOnUserNameField(username);
	loginpage1.enterPasswordOnPasswordField(password);
	loginpage1.submitButtonClick();
	boolean ishomepageloaded = loginpage1.isDashBoardLoaded();
	Assert.assertTrue(ishomepageloaded,"Home page is not loaded when user is entering valid credentials");
	
  }
@Test(retryAnalyzer=retry.Retry.class , groups = {"reggression"},description = "verifying user able to login with invalid username") // just desc of method
public void verifyUserIsAbleToLoginWithInvalidUserNameValidPassword() throws IOException
{
	//String username="test";
	//String password="admin";
	String username = ExcelUtility.getStringData(2, 0, "LoginPage");
	String password = ExcelUtility.getStringData(2, 1, "LoginPage");

	LoginPage loginpage2 = new LoginPage(driver);
	loginpage2.enterUserNameOnUserNameField(username);
	loginpage2.enterPasswordOnPasswordField(password);
	loginpage2.submitButtonClick();
	boolean isalertdisplayed = loginpage2.alertDisplay(); //
	Assert.assertTrue(isalertdisplayed,"Home page is  loaded when user entered invalid username and valid password");
}
@Test
public void verifyUserIsAbleToLoginWithValidUserNameInvalidPassword() throws IOException
{
	//String username="admin";
	//String password="test";
	String username = ExcelUtility.getStringData(3, 0, "LoginPage");
	String password = ExcelUtility.getStringData(3, 1, "LoginPage");

	LoginPage loginpage3 = new LoginPage(driver);
	loginpage3.enterUserNameOnUserNameField(username);
	loginpage3.enterPasswordOnPasswordField(password);
	loginpage3.submitButtonClick();
	boolean isalertdisplayed = loginpage3.alertDisplay();
	Assert.assertTrue(isalertdisplayed,"Home page is  loaded when user entered valid username and invalid password");
}
@Test
public void verifyUserIsAbleToLoginWithWithInvalidCredentials() throws IOException
{
	//String username="test";
	//String password="test123";
	String username = ExcelUtility.getStringData(4, 0, "LoginPage");
	String password = ExcelUtility.getStringData(4, 1, "LoginPage");

	LoginPage loginpage4 = new LoginPage(driver);
	loginpage4.enterUserNameOnUserNameField(username);
	loginpage4.enterPasswordOnPasswordField(password);
	loginpage4.submitButtonClick();
	boolean isalertdisplayed = loginpage4.alertDisplay();
	Assert.assertTrue(isalertdisplayed,"Home page is  loaded when user entered invalid credentials");
}




}