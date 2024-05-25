package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageSlider;
import utilities.ExcelUtility;

public class ManageSliderTest extends Base {
  @Test
  public void AddSlider() throws IOException, AWTException
  
  {
	  // String username = "admin";
	 // String password = "admin";
	  String username = ExcelUtility.getStringData(1,0,"ManageSlider"); //1,0: data index,loginpage pg name
	  String password = ExcelUtility.getStringData(1,1,"ManageSlider");
	  String link = ExcelUtility.getStringData(1,2,"ManageSlider");

	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  
	  ManageSlider manageslider = new ManageSlider(driver);
	  manageslider.manageSliderTileClick();
	  manageslider.newButtonClick();
	  manageslider.chooseFileButtonClick();
	  manageslider.passingValueTolinkTextField(link);
	  manageslider.saveButtonClick();
	  boolean isalertdisplayed = manageslider.isAlertDisplayed();
	  Assert.assertTrue(isalertdisplayed,"Alert is not displayed on saving");
	 // manageslider.manageSliderTileClick();
     // manageslider.deleteButtonClick();

  }
}
