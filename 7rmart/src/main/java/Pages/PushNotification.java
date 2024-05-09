package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotification 
{
WebDriver driver;
public PushNotification(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver , this);
}
@FindBy(xpath="//p[text()='Push Notifications']")private WebElement pushnotificationbutton ;
@FindBy(xpath="//input[@id='title']")private WebElement titlefield;
@FindBy(xpath="//input[@name='description']")private WebElement descriptionfield;
@FindBy(xpath="//button[@type='submit']")private WebElement sendbutton;
@FindBy(xpath="//div[contains(@class,'alert-success')]")private WebElement alertdisplay;

public void pushNotificationButtonClick()
{
	pushnotificationbutton.click();
}

public void passingDataToTitleField(String txt)
{
	titlefield.sendKeys(txt);
}

public void passingDataToDescriptionField(String desc)
{
	descriptionfield.sendKeys(desc);
}

public void sendButtonClick()
{
 sendbutton.click();	
}

public boolean isAlertDisplayed()
{
	return alertdisplay.isDisplayed();
}

}

