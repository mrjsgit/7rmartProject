package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManagePage 
{

WebDriver driver;

public ManagePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

@FindBy(xpath="//p[text()='Manage Pages']" )private WebElement managepagetile;
@FindBy(xpath="//a[contains(@onclick,'return confirm')]") private WebElement deleteicon;
@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertpopup;

public void managePageTileClick()
{
	//JavascriptExecutor executor = (JavascriptExecutor)driver;
	//executor.executeScript("arguments[0].click();",managepagetile);
	PageUtility pageutility = new PageUtility();
	pageutility.javaSriptClick(driver, managepagetile);
}

public void deleteButtonClick()
{
	deleteicon.click();
	driver.switchTo().alert().accept();
  
}

public boolean isAlertmsgDisplayed()
{
	return alertpopup.isDisplayed();
}

}
