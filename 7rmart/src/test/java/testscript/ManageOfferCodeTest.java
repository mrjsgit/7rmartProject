package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageOfferCode;
import utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base
{
  @Test(retryAnalyzer=retry.Retry.class)
  public void addOfferCode() throws IOException, AWTException
  {
	 // String username = "admin";
	  //String password = "admin";
	  String username = ExcelUtility.getStringData(1,0,"ManageOfferCode"); //1,0: data index,loginpage pg name
	  String password = ExcelUtility.getStringData(1,1,"ManageOfferCode");
	  String textfield = ExcelUtility.getStringData(1,2,"ManageOfferCode");
	  String percentage = ExcelUtility.getIntegerData(1,3,"ManageOfferCode");
	  String amount = ExcelUtility.getIntegerData(1,4,"ManageOfferCode");
	  String description = ExcelUtility.getStringData(1,5,"ManageOfferCode");

	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  
	  ManageOfferCode manageoffercode = new ManageOfferCode(driver);
	  manageoffercode.manageOfferCodeTileClick();
	  manageoffercode.newbuttonClick();
	  manageoffercode.passingValueToOfferCodeTextField(textfield);
	  manageoffercode.radioButtonClick();
	  manageoffercode.passingValueToPercentageTextField(percentage);
	  manageoffercode.passingValueToAmountField(amount);
	  manageoffercode.passingValueToDescriptionField(description);
	  manageoffercode.ChooseFileButtonClick();
	  manageoffercode.saveButtonClick();
	  boolean isSavedAlertDisplayed = manageoffercode.isAlertDisplayed();
	  Assert.assertTrue(isSavedAlertDisplayed, "Alert is not displayed on clicking save button");
	  manageoffercode.dashBoardClick();
	//  manageoffercode.manageOfferCodeTileClick();
	  //manageoffercode.deleteButtonClick();

  }
}
 