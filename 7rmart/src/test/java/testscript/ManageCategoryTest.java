package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageCategory;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
  @Test
  public void addNewCategory() throws IOException
  {
	 // String username = "admin";
	 // String password = "admin";
	 // String categoryvalue = "category test";
	  String username = ExcelUtility.getStringData(1, 0, "ManageCategory");
	  String password = ExcelUtility.getStringData(1, 1, "ManageCategory");
	  String categoryvalue = ExcelUtility.getStringData(1, 2, "ManageCategory");

	 LoginPage loginpage = new LoginPage(driver);
	 loginpage.enterUserNameOnUserNameField(username);
	 loginpage.enterPasswordOnPasswordField(password);
	 loginpage.submitButtonClick();
	 
	 ManageCategory managecategory = new ManageCategory(driver);
	 managecategory.manageCategoryTileClick();
	 managecategory.newbuttonClick();
	 managecategory.passingValueTocategoryTextField(categoryvalue);
	 managecategory.dragAndDrop();
	 managecategory.topMenuRadioButtonClick();
	 managecategory.leftMenuRadioButtonClick();
	 managecategory.saveButtonClick();
	 boolean issavealertdisplayed = managecategory.isAlertPopupDisplayed();
	 Assert.assertTrue(issavealertdisplayed, "alert is not displayed on saving");
			 
  }
  
}
