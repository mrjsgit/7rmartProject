package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageNews;

public class ManageNewsTest extends Base {
  @Test
  public void addNewTextInmanageNews() 
  {
	  String username = "admin";
	  String password="admin";
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  ManageNews managenews = new ManageNews(driver);
	  managenews.manageNewsTileClick();
	  managenews.newbuttonClick();
	  managenews.passingNewsText("Kothamangalam News");
	  managenews.savebuttonClick();
	  boolean isSaveAlertDisplayed = managenews.isAlertDisplayed();
	  Assert.assertTrue(isSaveAlertDisplayed, "Alert is not displayed on clicking save button");
      managenews.manageNewsTileClick();
      managenews.editButtonclick();
	  managenews.passingNewsText(" Nothing special:)");
	  managenews.updateButtonClick();
	
	  }
	  
  }

