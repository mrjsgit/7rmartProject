package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageLocation;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base

{
  @Test
  public void addNewLocation() throws IOException 
  {
	  //String username = "admin";
	 // String password="admin";
	    String username = ExcelUtility.getStringData(1,0,"ManageLocation"); //1,0: data index,loginpage pg name
	    String password = ExcelUtility.getStringData(1,1,"ManageLocation");
	    String location = ExcelUtility.getStringData(1,2,"ManageLocation");
	    String charge = ExcelUtility.getIntegerData(1,3,"ManageLocation");

	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  ManageLocation managelocation = new ManageLocation(driver);
	  managelocation.manageLocationTileClick();
	  managelocation.newButtonClick();
	  managelocation.countryDropDownField(1);
	  managelocation.stateDropDownField(2);
	  managelocation.passingTextToLocationField(location);
	  managelocation.passingTextToDeliveryChargeField(charge);
	  managelocation.saveButtonClick();
	  boolean issavedalertdisplayed = managelocation.isAlertDisplayed();
	  Assert.assertTrue(issavedalertdisplayed, "Alert is not shown on saving");
	  
  }
}
