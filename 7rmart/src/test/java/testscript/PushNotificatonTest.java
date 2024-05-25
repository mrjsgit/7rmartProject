package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.PushNotification;
import utilities.ExcelUtility;

public class PushNotificatonTest extends Base {
  @Test
  public void pushNotificationClick() throws IOException 
  {
	  //String username = "admin";
	  //String password= "admin";
	  String username = ExcelUtility.getStringData(1,0,"PushNotification"); //1,0: data index,loginpage pg name
	  String password = ExcelUtility.getStringData(1,1,"PushNotification");
	  String title = ExcelUtility.getStringData(1,1,"PushNotification");
	  String description = ExcelUtility.getStringData(1,1,"PushNotification");


	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUserNameOnUserNameField(username);
	  loginpage.enterPasswordOnPasswordField(password);
	  loginpage.submitButtonClick();
	  
	//  String title = "test";
	//String description = "test";
	  PushNotification pushnotification = new PushNotification(driver);
	  pushnotification.pushNotificationButtonClick();
	  pushnotification.passingDataToTitleField(title);
	  pushnotification.passingDataToDescriptionField(description);
	  pushnotification.sendButtonClick();
	  boolean isalertpopdisplayed = pushnotification.isAlertDisplayed();
	  Assert.assertTrue(isalertpopdisplayed,"alert Pop not displayed on clicking Send button");
	  
	  
  }
}
