package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.PushNotification;

public class PushNotificatonTest extends Base {
  @Test
  public void pushNotificationClick() 
  {
	  String username = "admin";
	  String password= "admin";
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	  String title = "test";
	  String description = "test";
	  PushNotification pushnotification = new PushNotification(driver);
	  pushnotification.pushNotificationButtonClick();
	  pushnotification.passingDataToTitleField(title);
	  pushnotification.passingDataToDescriptionField(description);
	  pushnotification.sendButtonClick();
	  boolean isalertpopdisplayed = pushnotification.isAlertDisplayed();
	  Assert.assertTrue(isalertpopdisplayed,"alert Pop not displayed on clicking Send button");
	  
	  
  }
}
