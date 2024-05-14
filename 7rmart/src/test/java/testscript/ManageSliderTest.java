package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageSlider;

public class ManageSliderTest extends Base {
  @Test
  public void AddSlider()
  
  {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField("admin");
	  loginpage.enterPasswordOnPasswordField("admin");
	  loginpage.submitButtonClick();
	  
	  
	  ManageSlider manageslider = new ManageSlider(driver);
	  manageslider.manageSliderTileClick();
	  manageslider.newButtonClick();
	  manageslider.chooseFileButtonClick();
	  manageslider.passingValueTolinkTextField("https://groceryapp.uniqassosiates.com/admin/login");
	  manageslider.saveButtonClick();
	  boolean isalertdisplayed = manageslider.isAlertDisplayed();
	  Assert.assertTrue(isalertdisplayed,"Alert is not displayed on saving");
  }
}
