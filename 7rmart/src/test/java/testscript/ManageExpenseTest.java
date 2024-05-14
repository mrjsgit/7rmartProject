package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageExpense;

public class ManageExpenseTest extends Base {
  @Test
  public void addExpense () 
  {
	      String username = "admin";
		  String password = "admin";
		  LoginPage loginpage = new LoginPage(driver);
		  loginpage.enterUserNameOnUserNameField(username);
		  loginpage.enterPasswordOnPasswordField(password);
		  loginpage.submitButtonClick();
		  
		  ManageExpense manageexpense = new ManageExpense(driver);
		  manageexpense.manageExpenseTileClick();
		  manageexpense.newButtonClick();
		  manageexpense.userDropDownField(2);
		  manageexpense.dateField();
		  manageexpense.categorydropDown(2);
		  manageexpense.orderIddropDown(2);
		  manageexpense.purchaseIddropDown(3);
		  manageexpense.expenseTypedropDown(2);
		  manageexpense.passingValueToAmountField("2500");
		  manageexpense.passingValueToRemarkField("Testautomation");
		  //manageexpense .chooseFileButtonClick();
		  manageexpense.saveButtonClick();
		  boolean isSavedAlertDisplayed = manageexpense.isAlertDisplayed();
		  Assert.assertTrue(isSavedAlertDisplayed, "Alert is not displayed on clicking save button"); 
  }
}
