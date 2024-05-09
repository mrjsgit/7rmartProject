package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageLocation 
{
WebDriver driver;

public ManageLocation(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//p[text()='Manage Location']") private WebElement  managelocationtile ;
@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newbutton  ;
@FindBy(xpath="//select[@id='country_id']") private WebElement countrydropdown ;
@FindBy(xpath="//select[@id='st_id']") private WebElement statedropdown ;
@FindBy(xpath="//input[@id='location']") private WebElement locationfield ;
@FindBy(xpath="//input[@id='delivery']") private WebElement  deliverycharge;
@FindBy(xpath="//button[@name='create']") private WebElement savebutton ;
@FindBy(xpath="//button[@data-dismiss='alert']") private WebElement alertdisplay ;

public void manageLocationTileClick()
{
	managelocationtile.click();
}

public void newButtonClick()
{
	newbutton.click();
}
public void countryDropDownField(int num)
{
	Select select = new Select(countrydropdown);
	select.selectByIndex(num);
}
public void stateDropDownField(int num)
{
	Select select = new Select(statedropdown);
	select.selectByIndex(num);
}

public void passingTextToLocationField(String txt)
{
	locationfield.sendKeys(txt);
}
public void passingTextToDeliveryChargeField(String charge)
{
	deliverycharge.sendKeys(charge);
}

public void saveButtonClick()
{
	savebutton.click();
}

public boolean isAlertDisplayed()
{
	return alertdisplay.isDisplayed();
}
}
