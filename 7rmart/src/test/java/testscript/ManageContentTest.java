package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageContent;
import utilities.ExcelUtility;

public class ManageContentTest extends Base {
  @Test
  public void editingManageContactUs() throws IOException
  {
	  //String username= "admin";
	  //String password="admin";
	  //String phonenum = "1234";
	  String username = ExcelUtility.getStringData(1, 0, "ManageContent");
	  String password = ExcelUtility.getStringData(1, 1,"ManageContent" );
	  String phonenum = ExcelUtility.getIntegerData(1, 2, "ManageContent");
	  LoginPage loginpage = new LoginPage(driver); 
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  
	  ManageContent managecontent = new ManageContent(driver);
	  managecontent.managecontentButtonClick();
	  managecontent.managecontactButtonClick();
	  managecontent.editButtonClick();
	  managecontent.updatingPhoneField(phonenum);
	  managecontent.updateButtonClick();
	  boolean isAlertDisplayed = managecontent.isAlertPopupDisplayed();
      Assert.assertTrue(isAlertDisplayed,"Alert is not displayed on clicking save button");	 
  }
}
