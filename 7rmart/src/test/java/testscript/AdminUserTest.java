package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUser;
import Pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
  @Test
  public void AddNewAdminUser() throws IOException 
  {
	 // String username = "admin";
	 //String password = "admin";
	  String Loginusername = ExcelUtility.getStringData(1, 0, "LoginPage");
	  String Loginpassword = ExcelUtility.getStringData(1, 1, "LoginPage");
      LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(Loginusername);
	  loginpage.enterPasswordOnPasswordField(Loginpassword);
	  loginpage.submitButtonClick();
	  
	  
	  //Admin user page
	  AdminUser adminuser = new AdminUser(driver);
	  adminuser.adminUserTileClick();
	  adminuser.newButtonClick();
	 // adminuser.passingUsername("automationtestmaria");
	 //adminuser.passingPassword("autotestmaria1234");
	 //adminuser.dropdownFieldSelection(3);
	  
	  String usernamefield = ExcelUtility.getStringData(1, 0,"AdminUser");
	  String passwordfield = ExcelUtility.getStringData(1, 1,"AdminUser");
      int dropdown = 1;
      adminuser.passingUsername(usernamefield);
      adminuser.passingPassword(passwordfield);
      adminuser.dropdownFieldSelection(dropdown);
	  adminuser.saveButtonClick();
	  boolean isAlertDisplayed = adminuser.isAlertPopupDisplayed();
      Assert.assertTrue(isAlertDisplayed,"Alert is not displayed on clicking save button");	  
	  
  }
}
