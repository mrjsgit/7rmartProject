package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManagePage;
import utilities.ExcelUtility;

public class ManagePageTest extends Base
{
  @Test(retryAnalyzer=retry.Retry.class, groups = {"reggression"})
  public void listPageDeletebButtonClick() throws IOException 
  {
	  //login to site using login credentials and click on submit button
	 // String username = "admin";
	 // String password = "admin";
	  String username = ExcelUtility.getStringData(1,0,"ManagePage"); //1,0: data index,loginpage pg name
	  String password = ExcelUtility.getStringData(1,1,"ManagePage");
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
