package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUser;
import Pages.LoginPage;

public class AdminUserTest extends Base {
  @Test
  public void AddNewAdminUser() 
  {
	  String username = "admin";
	  String password = "admin";
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  AdminUser adminuser = new AdminUser(driver);
	  adminuser.adminUserTileClick();
	  adminuser.newButtonClick();
	  adminuser.passingUsername("automationtestmaria");
	  adminuser.passingPassword("autotestmaria1234");
	  adminuser.dropdownFieldSelection(3);
	  adminuser.saveButtonClick();
	  boolean isAlertDisplayed = adminuser.isAlertPopupDisplayed();
      Assert.assertTrue(isAlertDisplayed,"Alert is not displayed on clicking save button");	  
	  
  }
}
