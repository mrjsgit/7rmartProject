package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageNews;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
  @Test(retryAnalyzer=retry.Retry.class,groups = {"reggression"})
  public void addNewTextInmanageNews() throws IOException 
  {
	 // String username = "admin";
	  //String password="admin";
	  String username = ExcelUtility.getStringData(1,0,"ManageNews"); //1,0: data index,loginpage pg name
	  String password = ExcelUtility.getStringData(1,1,"ManageNews");
	  String text = ExcelUtility.getStringData(1,2,"ManageNews");
	  String update = ExcelUtility.getStringData(1,3,"ManageNews");

	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  ManageNews managenews = new ManageNews(driver);
	  managenews.manageNewsTileClick();
	  managenews.newbuttonClick();
	  managenews.passingNewsText(text);
	  managenews.savebuttonClick();
	  boolean isSaveAlertDisplayed = managenews.isAlertDisplayed();
	  Assert.assertTrue(isSaveAlertDisplayed, "Alert is not displayed on clicking save button");
      managenews.manageNewsTileClick();
      managenews.editButtonclick();
	  managenews.passingNewsText(update);
	  managenews.updateButtonClick();
	
	  }
	  
  }

