package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
