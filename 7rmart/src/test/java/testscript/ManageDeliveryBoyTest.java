package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {
  @Test
  public void verifingDeliveryBoyDetailsFoundinListDeliveryBoyPage() throws IOException //search elements present in table or not
  {
	    //String username ="admin";
	   // String password="admin";
	    //String name = "test";

	    String username = ExcelUtility.getStringData(1,0,"ManageDeliveryBoy"); //1,0: data index,loginpage pg name
	    String password = ExcelUtility.getStringData(1,1,"ManageDeliveryBoy");
	    String name = ExcelUtility.getStringData(1,2,"ManageDeliveryBoy");

		LoginPage loginpage1 = new LoginPage(driver);
		loginpage1.enterUserNameOnUserNameField(username);
		loginpage1.enterPasswordOnPasswordField(password);
		loginpage1.submitButtonClick();
		
		ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.deliveryBoyTileClick();
		managedeliveryboypage.mainSearchButtonClick();
		managedeliveryboypage.passingTextToNameField(name);
		managedeliveryboypage.searchbuttonclick();
    boolean tabledisplay =	managedeliveryboypage.checkTableDisplayed();
   Assert.assertTrue(tabledisplay, "table not displayed");
	//boolean contentcheck= managedeliveryboypage.tableDataCheck(name);
	//Assert.assertTrue(contentcheck, "displaying values other than search result in the table");
  }
}
