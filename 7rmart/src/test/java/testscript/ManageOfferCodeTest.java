package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageOfferCode;

public class ManageOfferCodeTest extends Base
{
  @Test
  public void addOfferCode()
  {
	  String username = "admin";
	  String password = "admin";
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  
	  ManageOfferCode manageoffercode = new ManageOfferCode(driver);
	  manageoffercode.manageOfferCodeTileClick();
	  manageoffercode.newbuttonClick();
	  manageoffercode.passingValueToOfferCodeTextField("qwerty");
	  manageoffercode.radioButtonClick();
	  manageoffercode.passingValueToPercentageTextField("25.5");
	  manageoffercode.passingValueToAmountField("56.5");
	  manageoffercode.passingValueToDescriptionField("This is a Test");
	  //manageoffercode.ChooseFileButtonClick();
	  manageoffercode.saveButtonClick();
	  boolean isSavedAlertDisplayed = manageoffercode.isAlertDisplayed();
	  Assert.assertTrue(isSavedAlertDisplayed, "Alert is not displayed on clicking save button");
	  manageoffercode.dashBoardClick();
	  manageoffercode.manageOfferCodeTileClick();
	  manageoffercode.deleteButtonClick();

  }
}
 