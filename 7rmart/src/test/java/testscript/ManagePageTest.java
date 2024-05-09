package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManagePage;

public class ManagePageTest extends Base
{
  @Test
  public void listPageDeletebButtonClick() 
  {
	  //login to site using login credentials and click on submit button
	  String username = "admin";
	  String password = "admin";
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  //managepage
	  
	  ManagePage managepage = new ManagePage(driver);
	  managepage.managePageTileClick();
	  managepage.deleteButtonClick();
	  boolean alertmessagedisplay = managepage.isAlertmsgDisplayed();
	  Assert.assertTrue(alertmessagedisplay, "Alert message is not showing on clicking delete button");
	    
  }
}
