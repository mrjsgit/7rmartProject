package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base {
  @Test
  public void verifingDeliveryBoyDetailsFoundinListDeliveryBoyPage() //search elements present in table or not
  {
	    String username ="admin";
	    String password="admin";
	    String name = "test";
		LoginPage loginpage1 = new LoginPage(driver);
		loginpage1.enterUserNameOnUserNameField(username);
		loginpage1.enterPasswordOnPasswordField(password);
		loginpage1.submitButtonClick();
		
		ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.deliveryBoyTileClick();
		managedeliveryboypage.mainSearchButtonClick();
		managedeliveryboypage.passingTextToNameField(name);
		managedeliveryboypage.searchbuttonclick();
//	boolean tabledisplay =	managedeliveryboypage.checkTableDisplayed();
//	Assert.assertTrue(tabledisplay, "table not displayed");
	boolean datacheckresult = managedeliveryboypage.columnDataCheck(name);
	Assert.assertTrue(datacheckresult, "table contains value other than given data");
  }
}
