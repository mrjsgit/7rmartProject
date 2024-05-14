package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageLocation;

public class ManageLocationTest extends Base

{
  @Test
  public void addNewLocation() 
  {
	  String username = "admin";
	  String password="admin";
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  ManageLocation managelocation = new ManageLocation(driver);
	  managelocation.manageLocationTileClick();
	  managelocation.newButtonClick();
	  managelocation.countryDropDownField(1);
	  managelocation.stateDropDownField(5);
	  managelocation.passingTextToLocationField("Thykkatusshery");
	  managelocation.passingTextToDeliveryChargeField("5000");
	  managelocation.saveButtonClick();
	  boolean issavedalertdisplayed = managelocation.isAlertDisplayed();
	  Assert.assertTrue(issavedalertdisplayed, "Alert is not shown on saving");
	  
  }
}
